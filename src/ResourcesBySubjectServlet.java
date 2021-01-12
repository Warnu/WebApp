import Model.Resource;
import Model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/resourcesbysubject")
public class ResourcesBySubjectServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    private Map<String, List<Resource>> loadResources(){
        List<Resource> resources = null;
        try {
            resources = jdbc.loadResources();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, List<Resource>> resourcesBySubject = new HashMap<String, List<Resource>>();

        /*reorganize data by subject in hash map*/
        for(Resource resource : resources) {

            /*if hashmap does not contain a certain subject as its key
             * add a new subject as its key and create a new array list
             * of resources, then add the current resource to that
             * respective key.
             *
             * if it does exist. get that subject key and add the current
             * resource to the array list in the hash map.*/
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
        ServletContext sc = getServletContext();

        Student student = (Student) request.getSession().getAttribute("user");

        String[] resourcesSelected = request.getParameterValues("resource");
        List list = Arrays.asList(resourcesSelected);
        try {
            jdbc.enrollResource(list, student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/studentprofile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null &&request.getSession().getAttribute("loggedIn").equals("student")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/resourcesbysubject.jsp");

            /*send hashmap to DOM.*/
            request.setAttribute("resourcesbysubject", loadResources());

            dispatcher.forward(request, response);
        }else{
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }


}
