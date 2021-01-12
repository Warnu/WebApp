import Model.Curriculums;
import Model.Resource;
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

@WebServlet("/teacherprofile")
public class TeacherProfileServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        //Passes data to the front end
        request.setAttribute("teacherInfo", teacher);

        if(request.getParameter("ResourceType").equals("resources")){
            try {
                request.setAttribute("type","curriculums");
                List<Curriculums> curriculumsCreated =  jdbc.loadTeacherCreatedCurriculums(teacher);
                request.setAttribute("resourcesCreated", curriculumsCreated);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            };
        }else{

            try {
                request.setAttribute("type","resources");
                List<Resource> resourcesCreated =  jdbc.loadTeacherCreatedResources(teacher);
                request.setAttribute("resourcesCreated", resourcesCreated);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        sc.getRequestDispatcher("/teacherprofile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null && request.getSession().getAttribute("loggedIn").equals("teacher")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherprofile.jsp");
            List<Resource> resourcesCreated = new ArrayList<>();
            Teacher teacher = (Teacher) request.getSession().getAttribute("user");

            try {
                resourcesCreated = jdbc.loadTeacherCreatedResources(teacher);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Passes data to the front end
            request.setAttribute("teacherInfo", teacher);
            request.setAttribute("resourcesCreated", resourcesCreated);
            request.setAttribute("type", "resources");

            dispatcher.forward(request, response);
        }
        else {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
