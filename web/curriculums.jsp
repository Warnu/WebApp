<%--
  Created by IntelliJ IDEA.
  User: Tariq
  Date: 11/13/2020
  Time: 1:09 PM
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
    <title>Title</title>
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
        <c:forEach var="curriculum" items="${curriculums}" varStatus="theCount">
            <div class="col">
                <!--Card-->
                <div class="card">
                    <!--Card image-->
                    <div class="view">
                        <img src="https://images.unsplash.com/photo-1503676260728-1c00da094a0b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1909&q=80" class="card-img-top"
                             alt="photo">
                        <a href="#">
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>
                    <!--Card content-->
                    <div class="card-body">
                        <form style="border: none;" class="text-center border border-light" action="<%=request.getContextPath()%>/curriculums" method="post">
                            <h4 class="card-title"><c:out value="${curriculum.getCurriculumName()}"/></h4>
                            <!--Text-->
                            <p class="card-text">Teacher: <c:out value="${curriculum.getTeacher()}"/></p>
                            <button name="curriculumID" value="${curriculum.getCurriculumID()}" id="${curriculum.getCurriculumID()}" type="submit" class="btn btn-primary">Enroll</button>
                        </form>
                        <!--Title-->
                    </div>
                </div>
                <!--/.Card-->
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
