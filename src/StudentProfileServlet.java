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
import java.util.List;

@WebServlet("/studentprofile")
public class StudentProfileServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("user");

        if(request.getParameter("ResourceType").equals("resources")){
            try {
                request.setAttribute("type","curriculums");
                request.setAttribute("enrolledResources", jdbc.loadCurriculum(student));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            };
        }else{
            try {
                request.setAttribute("type","resources");
                request.setAttribute("enrolledResources", jdbc.loadUserResources(student));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(student.getCurriculumID() == 0){
            request.setAttribute("disableCurriculum", true);
            request.setAttribute("curriculumStatus", "Not Registered");
        }
        else{
            try {
                request.setAttribute("disableCurriculum", false);
                request.setAttribute("curriculumStatus", jdbc.getCurriculumNamefromId(student.getCurriculumID()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //Passes data to the front end
        request.setAttribute("studentInfo", student);

        sc.getRequestDispatcher("/studentprofile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null &&request.getSession().getAttribute("loggedIn").equals("student")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/studentprofile.jsp");

            Student student = (Student) request.getSession().getAttribute("user");



            if(student.getCurriculumID() == 0){
                request.setAttribute("disableCurriculum", true);
                request.setAttribute("curriculumStatus", "Not Registered");
            }
            else{
                try {
                    request.setAttribute("disableCurriculum", false);
                    request.setAttribute("curriculumStatus", jdbc.getCurriculumNamefromId(student.getCurriculumID()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            //Passes data to the front end
            request.setAttribute("studentInfo", student);
            try {
                request.setAttribute("enrolledResources", jdbc.loadUserResources(student));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.setAttribute("type", "resources");

            dispatcher.forward(request, response);
        }
        else{
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
