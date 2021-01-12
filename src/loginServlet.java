import Model.Resource;
import Model.Student;
import Model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        try {
            if(!request.getParameter("userUsername").toString().equals("")){
                if(jdbc.validateLogin(request.getParameter("userUsername").toString(),
                        request.getParameter("userPassword").toString(),
                        request.getParameter("userType").toString())
                        && request.getParameter("userType").toString().equals("Student")) {
                    try {
                        Student student = jdbc.getStudent(request.getParameter("userUsername").toString());
                        session.setAttribute("loggedIn","student");
                        session.setAttribute("user", student);
                        response.sendRedirect(request.getContextPath() + "/studentprofile");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                else if(jdbc.validateLogin(request.getParameter("userUsername").toString(),
                        request.getParameter("userPassword").toString(),
                        request.getParameter("userType").toString())
                        && request.getParameter("userType").toString().equals("Teacher")){
                    try {
                        Teacher teacher = jdbc.getTeacher(request.getParameter("userUsername").toString());
                        session.setAttribute("loggedIn","teacher");
                        session.setAttribute("user", teacher);
                        response.sendRedirect(request.getContextPath() + "/teacherprofile");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }else{
                    dispatcher = request.getRequestDispatcher("/login.jsp");
                    request.setAttribute("message","Invalid Username or Password!");
                    request.setAttribute("message1","Please, try again.");
                    dispatcher.forward(request, response);
                }
            }else{
                dispatcher = request.getRequestDispatcher("/login.jsp");
                request.setAttribute("message","Invalid Username or Password!");
                request.setAttribute("message1","Please, try again.");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Redirects the user to their profile if they're already logged in!
        if(request.getSession().getAttribute("loggedIn")!=null) {
            if(request.getSession().getAttribute("loggedIn").equals("student")){
                response.sendRedirect(request.getContextPath() + "/studentprofile");
            }
            else if(request.getSession().getAttribute("loggedIn").equals("teacher"))
                response.sendRedirect(request.getContextPath() + "/teacherprofile");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }


    }
}
