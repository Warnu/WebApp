<%--
  Created by IntelliJ IDEA.
  User: Tariq
  Date: 11/11/2020
  Time: 11:23 AM
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
    <title>Resources By Subject</title>
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
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-lg-5">
                    <form class="text-center border border-light" action="<%=request.getContextPath()%>/resourcesbysubject" method="post">
                        <c:forEach var="resource" items="${resourcesbysubject}" varStatus="theCount">
                            <h3>${resource.key}</h3>
                            <c:forEach items="${resource.value}" var="source" varStatus="loop">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" name="resource" value="${source.getResourceName()}" id="${resource.key}+${loop.index}">
                                    <label class="custom-control-label" for="${resource.key}+${loop.index}">${source.getResourceName()}</label>
                                </div>
                            </c:forEach>
                        </c:forEach>
                        <button class="btn btn-info btn-block my-4" type="submit">Enroll</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>