import Model.Curriculums;
import Model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/curriculums")
public class CurriculumsServlet extends HttpServlet {
    JDBCConnectivity jdbc = new JDBCConnectivity();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("user");

        String curriculumSelected = request.getParameter("curriculumID");

        student.setCurriculumID(Integer.parseInt(curriculumSelected));

        request.getSession().setAttribute("user", student);
        try {
            jdbc.enrollCurriculum(curriculumSelected, student);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/studentprofile");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedIn")!=null &&request.getSession().getAttribute("loggedIn").equals("student")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/curriculums.jsp");

            List<Curriculums> curriculumList = null;

            try {
                curriculumList = jdbc.loadCurriculums();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            request.setAttribute("curriculums", curriculumList);
            dispatcher.forward(request, response);
        }else{
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
