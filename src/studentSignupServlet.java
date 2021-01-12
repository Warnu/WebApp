import Model.Curriculums;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/studentSignup")
public class studentSignupServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student(request.getParameter("studentFirstName").toString(),
                request.getParameter("studentLastName").toString(),
                request.getParameter("studentUserName").toString(),
                request.getParameter("studentEmailAddress").toString(),
                request.getParameter("studentPassword").toString(),
                request.getParameter("studentGradeLevel").toString());
        if(request.getParameter("studentPassword").length()>7) {
            try {
                jdbc.studentSignup(student);
                request.getSession().setAttribute("user", jdbc.getStudent(student.getUserName()));
                request.getSession().setAttribute("loggedIn", "student");
                response.sendRedirect(request.getContextPath() + "/studentprofile");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            } else{
                request.setAttribute("message", "Your password must contain 8 characters.");
                request.setAttribute("message2", "Try another one!");
                request.getRequestDispatcher("/studentSignUp.jsp").forward(request, response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")==null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/studentSignUp.jsp");

            dispatcher.forward(request, response);
        }else{
            if(request.getSession().getAttribute("loggedIn").equals("student"))
                response.sendRedirect(request.getContextPath() + "/studentprofile");
            else
                response.sendRedirect(request.getContextPath() + "/teacherprofile");
        }

    }
}
