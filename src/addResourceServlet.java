import Model.Resource;
import Model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addResource")
public class addResourceServlet extends HttpServlet {

    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        //Loads the resource Info!
        Resource resource = new Resource(request.getParameter("resourceName"),
                                request.getParameter("resourceSubject"),
                                request.getParameter("resourceLink"),
                                request.getParameter("resourceLevel"),
                                teacher.getId());
        //Add resource into the DB
        try {
            jdbc.addResource(resource);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/teacherprofile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null &&request.getSession().getAttribute("loggedIn").equals("teacher")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/addResource.jsp");
                dispatcher.forward(request, response);

        }else{
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
