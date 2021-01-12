import Model.Curriculums;
import Model.Resource;
import Model.Student;
import Model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnectivity {

    private static final String username = "eduappuser";
    private static final String pass = "test2025";
    private Connection con;
    public List<Curriculums> loadCurriculums() throws ClassNotFoundException {
        List<Curriculums> curriculums = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);
            Statement statement = con.createStatement();

            int id = 0;

            String sql = "select curriculums.id, curriculums.curriculumname, curriculums.curriculumSubject," +
                    " curriculums.curriculumGrade, teachers.FirstName, teachers.LastName " +
                    "from curriculums " +
                    "Left Join teachers ON teachers.id = curriculums.teacherid";
            String sql2 ="select * from  resources " +
                    "INNER JOIN curriculumResources ON resources.id = curriculumResources.resourcesID " +
                    "WHERE curriculumID = ?";
            ResultSet rs = statement.executeQuery(sql);
            PreparedStatement preparedStatement = con.prepareStatement(sql2);


            while(rs.next()) {
                /*query all curcciulums and then grab each curicculum by resourceID*/
                Curriculums curriculum = new Curriculums();
                List<Resource> resources = new ArrayList<>();
                curriculum.setCurriculumID(Integer.parseInt(rs.getString("id")));
                curriculum.setTeacher(rs.getString("FirstName") + " " + rs.getString("LastName"));
                curriculum.setSubject(rs.getString("curriculumSubject"));
                curriculum.setCurriculumName(rs.getString("curriculumName"));
                curriculum.setCurriculumGrade(rs.getString("curriculumGrade"));
                /*set curriculum resources*/
                id = curriculum.getCurriculumID();
                preparedStatement.setString(1,Integer.toString(curriculum.getCurriculumID()));
                ResultSet rs2 = preparedStatement.executeQuery();
                while (rs2.next()) {
                    Resource resource = new Resource();
                    resource.setResourceName(rs2.getString("ResourceName"));
                    resource.setResourceType(rs2.getString("ResourceType"));
                    resource.setResourceGradeLevel(rs2.getString("GradeLevel"));
                    resource.setResourceLink(rs2.getString("Link"));
                    resources.add(resource);
                }
                curriculum.setCurriculumResources(resources);
                curriculums.add(curriculum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return curriculums;
    }

    public Curriculums loadCurriculum(Student student) throws ClassNotFoundException{
        Curriculums curriculum = new Curriculums();

        Class.forName("com.mysql.jdbc.Driver");

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);
            Statement statement = con.createStatement();

            int id = 0;

            String sql = "select curriculums.id, curriculums.teacherid, curriculums.curriculumname, curriculums.curriculumSubject," +
                    " curriculums.curriculumGrade from curriculums where curriculums.id = "+student.getCurriculumID();
            String sql2 ="select * from  resources " +
                    "INNER JOIN curriculumResources ON resources.id = curriculumResources.resourcesID " +
                    "WHERE curriculumID ="+student.getCurriculumID();
            ResultSet rs = statement.executeQuery(sql);
            PreparedStatement preparedStatement = con.prepareStatement(sql2);


            while(rs.next()) {
                List<Resource> resources = new ArrayList<>();
                curriculum.setCurriculumID(Integer.parseInt(rs.getString("id")));
                curriculum.setSubject(rs.getString("curriculumSubject"));
                curriculum.setCurriculumName(rs.getString("curriculumName"));
                curriculum.setCurriculumGrade(rs.getString("curriculumGrade"));
                /*set curriculum resources*/
                id = curriculum.getCurriculumID();
                ResultSet rs2 = preparedStatement.executeQuery();
                while (rs2.next()) {
                    Resource resource = new Resource();
                    resource.setId(rs2.getInt("id"));
                    resource.setResourceName(rs2.getString("ResourceName"));
                    resource.setResourceType(rs2.getString("ResourceType"));
                    resource.setResourceGradeLevel(rs2.getString("GradeLevel"));
                    resource.setResourceLink(rs2.getString("Link"));
                    resource.setTeacherID(rs2.getInt("TeacherId"));
                    resources.add(resource);
                }
                curriculum.setCurriculumResources(resources);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return curriculum;
    }

    public void enrollCurriculum(String curriculumID, Student student) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");


        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);

            String sql = "UPDATE students SET CurriculumID = ?" +
                    "WHERE ID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, curriculumID);
            preparedStatement.setInt(2, student.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Resource> loadResources() throws ClassNotFoundException {
        List<Resource> resourceList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);
            Statement statement = con.createStatement();


            String sql = "SELECT * FROM RESOURCES";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                Resource resource = new Resource();
                resource.setResourceName(rs.getString("ResourceName"));
                resource.setResourceType(rs.getString("ResourceType"));
                resource.setResourceGradeLevel(rs.getString("GradeLevel"));
                resource.setResourceLink(rs.getString("Link"));
                resourceList.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resourceList;
    }

    public void addResource(Resource resource) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);

            String sql = "INSERT INTO Resources (GradeLevel, ResourceName, ResourceType, ResourceActive, TeacherID, Link) " +
                    "VALUES (?, ?, ?, 1, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,resource.getResourceGradeLevel());
            preparedStatement.setString(2,resource.getResourceName());
            preparedStatement.setString(3,resource.getResourceType());
            preparedStatement.setInt(4,resource.getTeacherID());
            preparedStatement.setString(5,resource.getResourceLink());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void enrollResource(List list, Student student) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);
            for(Object resource : list) {
                String resourceName = resource.toString();

                String sql = "INSERT INTO enrolledResources (userID, resourcesID, completed) " +
                        "VALUES (?, (SELECT ID from resources WHERE ResourceName = ? ), 0)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1,student.getId());
                preparedStatement.setString(2,resourceName);
                preparedStatement.executeUpdate();
            }
            String sql = "";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Resource> loadUserResources(Student student) throws ClassNotFoundException {
        List<Resource> userResourceList = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("select * from enrolledresources " +
                    "RIGHT JOIN resources " +
                    "ON resources.id = enrolledresources.resourcesID " +
                    "WHERE enrolledresources.userID ="+student.getId());

            while(rs.next()) {
                Resource resource = new Resource();
                resource.setResourceName(rs.getString("ResourceName"));
                resource.setResourceType(rs.getString("ResourceType"));
                resource.setResourceGradeLevel(rs.getString("GradeLevel"));
                resource.setResourceLink(rs.getString("Link"));
                userResourceList.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userResourceList;
    }

    public List<Curriculums> loadTeacherCreatedCurriculums(Teacher teacher) throws ClassNotFoundException{
        List<Curriculums> teacherCurriculumList = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("select * from curriculums " +
                    "RIGHT JOIN teachers " +
                    "ON curriculums.teacherId = teachers.id " +
                    "WHERE curriculums.teacherID =" +teacher.getId());

            while(rs.next()) {
                Curriculums curriculum = new Curriculums();
                curriculum.setCurriculumGrade(rs.getString("curriculumgrade"));
                curriculum.setCurriculumSubject(rs.getString("curriculumsubject"));
                curriculum.setTeacherId(rs.getInt("teacherId"));
                curriculum.setCurriculumName(rs.getString("curriculumName"));
                teacherCurriculumList.add(curriculum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teacherCurriculumList;
    }
    public List<Resource> loadTeacherCreatedResources(Teacher teacher) throws ClassNotFoundException{
        List<Resource> teacherResourceList = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("select * from resources " +
                    "RIGHT JOIN teachers " +
                    "ON resources.teacherId = teachers.id " +
                    "WHERE resources.teacherID =" +teacher.getId());

            while(rs.next()) {
                Resource resource = new Resource();
                resource.setResourceName(rs.getString("ResourceName"));
                resource.setResourceType(rs.getString("ResourceType"));
                resource.setResourceGradeLevel(rs.getString("GradeLevel"));
                resource.setResourceLink(rs.getString("Link"));
                teacherResourceList.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return teacherResourceList;
    }

    public int getResourceIdfromName(String id) throws ClassNotFoundException{
        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Resources Where ResourceName = (?) ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                result = rs.getInt("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void createCurriculum(Curriculums curriculum) throws ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?autoReconnect=true", username, pass);
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Curriculums ORDER BY ID DESC LIMIT 1 ");
            int Id=0;
            while(rs.next())
                Id = rs.getInt("Id")+1;

            String sql = "INSERT INTO Curriculums (Id, TeacherID, CurriculumName, CurriculumSubject, CurriculumGrade) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,Id);
            preparedStatement.setInt(2,curriculum.getTeacherId());
            preparedStatement.setString(3,curriculum.getCurriculumName());
            preparedStatement.setString(4,curriculum.getCurriculumSubject());
            preparedStatement.setString(5,curriculum.getCurriculumGrade());
            preparedStatement.executeUpdate();

            for(int i=0;i<curriculum.getResourcesId().length;i++){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?autoReconnect=true", username, pass);
                sql = "INSERT INTO CurriculumResources (curriculumID, ResourcesID) " +
                        "VALUES (?, ?)";
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, Id);
                preparedStatement.setInt(2, getResourceIdfromName(curriculum.getResourcesId()[i]));
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void studentSignup(Student student) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);

            String sql = "INSERT INTO students (FirstName, LastName, UserName, EmailAddress, PasswordHash, StudentGradeLevel) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getUserName());
            preparedStatement.setString(4,student.getEmailAddress());
            preparedStatement.setString(5,student.getPasswordHash());
            preparedStatement.setString(6,student.getGradeLevel());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void teacherSignup(Teacher teacher) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp?useSSL=false", username, pass);

            String sql = "INSERT INTO teachers (FirstName, LastName, UserName, EmailAddress, PasswordHash, Subject) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,teacher.getFirstName());
            preparedStatement.setString(2,teacher.getLastName());
            preparedStatement.setString(3,teacher.getUserName());
            preparedStatement.setString(4,teacher.getEmailAddress());
            preparedStatement.setString(5,teacher.getPasswordHash());
            preparedStatement.setString(6,teacher.getSubject());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkIfUserNameExists(String userName, String scope) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String returnFromDB = "";
        if(scope.equals("Student")){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
                String sql = "SELECT * FROM Students Where UserName = (?) ";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    returnFromDB = rs.getString("userName").toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    con.close();
                    return returnFromDB.equals(userName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if(scope.equals("Teacher")){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
                String sql = "SELECT * FROM Teachers Where UserName = (?) ";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    returnFromDB = rs.getString("userName").toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    con.close();
                    return returnFromDB.equalsIgnoreCase(userName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public boolean validateLogin(String userName, String password, String scope) throws  ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String returnFromDB = "";
        if(scope.equals("Student")){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
                String sql = "SELECT * FROM Students Where UserName = (?) ";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    returnFromDB = rs.getString("passwordHash").toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    con.close();
                    return returnFromDB.equals(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if(scope.equals("Teacher")){
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
                String sql = "SELECT * FROM Teachers Where UserName = (?) ";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    returnFromDB = rs.getString("passwordHash").toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    con.close();
                    return returnFromDB.equals(password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    public Student getStudent(String userName) throws  ClassNotFoundException{
        Student student = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Students Where UserName = (?) ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                student = new Student();
                student.setId(rs.getInt("Id"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setFullName();
                student.setUserName(userName);
                student.setEmailAddress(rs.getString("EmailAddress"));
                student.setPasswordHash(rs.getString("passwordHash"));
                student.setGradeLevel(rs.getString("studentGradeLevel"));
                if(rs.getInt("curriculumID")!=0){
                    student.setCurriculumID(rs.getInt("curriculumID"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return student;
    }
    public Teacher getTeacher(String userName) throws  ClassNotFoundException{
        Teacher teacher = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM Teachers Where UserName = (?) ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                teacher = new Teacher();
                teacher.setId(rs.getInt("Id"));
                teacher.setFirstName(rs.getString("FirstName"));
                teacher.setLastName(rs.getString("LastName"));
                teacher.setFullName();
                teacher.setUserName(userName);
                teacher.setEmailAddress(rs.getString("EmailAddress"));
                teacher.setPasswordHash(rs.getString("passwordHash"));
                teacher.setSubject(rs.getString("subject"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teacher;
    }

    public String getCurriculumNamefromId(int id) throws ClassNotFoundException{
        String name="";
        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/educationapp", username, pass);
            Statement statement = con.createStatement();

            String sql = "SELECT CurriculumName FROM Curriculums Where id = (?) ";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                name = rs.getString("curriculumName").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
