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

@WebServlet("/teacherSignup")
public class teacherSignupServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher  = new Teacher(request.getParameter("teacherFirstName").toString(),
                request.getParameter("teacherLastName").toString(),
                request.getParameter("teacherUserName").toString(),
                request.getParameter("teacherEmailAddress").toString(),
                request.getParameter("teacherPassword").toString(),
                request.getParameter("teacherSubject").toString());
        if(request.getParameter("teacherPassword").length()>7) {
            try {
                if (jdbc.checkIfUserNameExists(request.getParameter("teacherUserName"), "Teacher")) {
                    request.setAttribute("message", "This username already exists.");
                    request.setAttribute("message2", "Try another one!");
                    request.getRequestDispatcher("/teacherSignUp.jsp").forward(request, response);
                } else {
                    jdbc.teacherSignup(teacher);
                    request.getSession().setAttribute("loggedIn", "teacher");
                    request.getSession().setAttribute("user", jdbc.getTeacher(teacher.getUserName()));
                    response.sendRedirect(request.getContextPath() + "/teacherprofile");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            request.setAttribute("message", "Your password must contain 8 characters.");
            request.setAttribute("message2", "Try another one!");
            request.getRequestDispatcher("/teacherSignUp.jsp").forward(request, response);
        }

        //Session info:
        /*HttpSession session = request.getSession();
        if(session != null){
            session.setAttribute("user", teacher);
        }*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")==null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherSignUp.jsp");

            dispatcher.forward(request, response);
        }else{
            if(request.getSession().getAttribute("loggedIn").equals("student"))
                response.sendRedirect(request.getContextPath() + "/studentprofile");
            else
                response.sendRedirect(request.getContextPath() + "/teacherprofile");
        }
    }
}
