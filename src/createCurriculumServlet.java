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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/createCurriculum")
public class createCurriculumServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    private Map<String, List<Resource>> loadResources(){
        List<Resource> resources = null;
        try {
            resources = jdbc.loadResources();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, List<Resource>> resourcesBySubject = new HashMap<String, List<Resource>>();

        for(Resource resource : resources) {
            if(!resourcesBySubject.containsKey(resource.getResourceType())) {
                resourcesBySubject.put(resource.getResourceType(), new ArrayList<Resource>());
                resourcesBySubject.get(resource.getResourceType()).add(resource);
            } else {
                resourcesBySubject.get(resource.getResourceType()).add(resource);
            }

        }
        return resourcesBySubject;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        try {
            Curriculums curriculum = new Curriculums();
            curriculum.setTeacherId(teacher.getId());
            curriculum.setCurriculumName(request.getParameter("curriculumName"));
            curriculum.setCurriculumSubject(request.getParameter("curriculumSubject"));
            curriculum.setCurriculumGrade(request.getParameter("curriculumLevel"));
            curriculum.setResourcesId(request.getParameterValues("resource"));
            jdbc.createCurriculum(curriculum);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/teacherprofile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null &&request.getSession().getAttribute("loggedIn").equals("teacher")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/createCurriculum.jsp");

                request.setAttribute("resourcesbysubject", loadResources());

                dispatcher.forward(request, response);

        } else{
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
