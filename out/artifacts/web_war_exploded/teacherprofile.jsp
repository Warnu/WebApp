<%--
  Created by IntelliJ IDEA.
  User: Tariq
  Date: 11/13/2020
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Education Website || Student Profile</title>
</head>
<body>
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
    <header>
        <%@ include file="includes/navbar.jsp"%>
    </header>
    <br>
    <br>
    <br>

    <div class="container">
        <div class="row">
            <div class="col-sm">
                <ul class="list-group">
                    <li  class="list-group-item active">Name: ${teacherInfo.getFullName()}</li>
                    <li  class="list-group-item">Subject: ${teacherInfo.getSubject()}</li>
                </ul>
            </div>
                <div class="col-lg-6">
                    <div class="container  py-5 z-depth-1" >
                        <c:choose>
                            <c:when test="${type == 'resources'}">
                            <!--Section: Content-->
                            <section class=" dark-grey-text text-center">

                                <h3 class="font-weight-bold pt-4 mb-4 studentResources">Teacher Resources</h3>

                                <h5 class="font-weight-bold font-italic mb-5">All Teacher resources</h5>

                                <div class="col-sm">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th scope="col">Course</th>
                                            <th scope="col">Link</th>
                                            <th scope="col">Subject</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                            <c:forEach var="resource" items="${resourcesCreated}" varStatus="theCount">
                                <tr>
                                    <td>${resource.getResourceName()}</td>
                                    <td>
                                        <a href="${resource.getResourceLink()}" target="_blank">
                                            <span><c:out value="${resource.getResourceLink()}"/></span>
                                        </a>
                                    </td>
                                    <td>${resource.getResourceType()}</td>
                                </tr>
                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </c:when>
                            <c:otherwise>
                                <!--Section: Content-->
                                <section class=" dark-grey-text text-center">

                                    <h3 class="font-weight-bold pt-4 mb-4 studentResources">Teacher Curriculums</h3>

                                    <h5 class="font-weight-bold font-italic mb-5">All Teacher Curriculums</h5>

                                    <div class="col-sm">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Subject</th>
                                                    <th scope="col">Manage</th>
                                                    <th scope="col">Grade</th>
                                                </tr>
                                            </thead>
                                                <tbody>
                                                    <c:forEach var="resource" items="${resourcesCreated}" varStatus="theCount">
                                                        <tr>
                                                            <td>${resource.getCurriculumName()}</td>
                                                            <td>${resource.getCurriculumSubject()}</td>
                                                            <td>
                                                                <a href="#" target="_blank">
                                                                    <span><c:out value="Modify Curriculum"/></span>
                                                                </a>
                                                            </td>
                                                            <td>${resource.getCurriculumGrade()}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                        </table>
                                    </div>
                            </c:otherwise>
                        </c:choose>

                            <div class="col-sm">
                                <form action="teacherprofile"  method="post">

                                    <button type="submit" class="btn btn-info">Switch to Curriculum Resources</button>
                                    <input type="hidden" value="${type}" name="ResourceType">
                                </form>

                            </div>

                        </section>
                        <!--Section: Content-->
                    </div>

            </div>
            <div class="col-sm">
                <ul class="list-group">
                    <li style="text-align:right;" class="list-group-item active"><a style="text-decoration: none; color: white;" href="<%=request.getContextPath()%>/addResource">Create a Resource</a></li>
                    <li style="text-align:right;" class="list-group-item"><a href="<%=request.getContextPath()%>/createCurriculum">Create a Curriculum</a></li>
                </ul>
            </div>

        </div>
    </div>
    <br>
    <br>

    <div class="container">
        <div class="row">
            <div class="col">
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" value="Logout" />
                </form>
            </div>
        </div>
    </div>

    <br>
    <br>
    <br>

</body>
</html>