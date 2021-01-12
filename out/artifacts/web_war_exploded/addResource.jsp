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
            <form class="text-center border border-light p-5" action="addResource"  method="post">

                <p class="h4 mb-4">Add Resource</p>

                <!-- Name -->
                <input type="text" id="resourceName" name="resourceName" class="form-control mb-4" placeholder="Name" required>

                <!-- Subject -->
                <input type="text" id="resourceSubject" name="resourceSubject" class="form-control mb-4" placeholder="Subject" required>

                <!-- Link -->
                <input type="text" id="resourceLink" name="resourceLink" class="form-control"  placeholder="Link" required>

                <!-- Grade Level -->
                <div class="form-row mb-4">
                    <div class="col">
                        <span>Grade Level</span>
                        <select id="resourceLevel" name="resourceLevel" class="browser-default custom-select mb-4">
                            <option value="" disabled>Choose option</option>
                            <option value="0" selected>Kindergarten</option>
                            <option value="1">1st Grade</option>
                            <option value="2">2nd Grade</option>
                            <option value="3">3rd Grade</option>
                            <option value="4">4th Grade</option>
                            <option value="5">5th Grade</option>
                            <option value="6">6th Grade</option>
                            <option value="7">7th Grade</option>
                            <option value="8">8th Grade</option>
                            <option value="9">9th Grade</option>
                            <option value="10">10th Grade</option>
                            <option value="11">11th Grade</option>
                            <option value="12">12th Grade</option>
                        </select>
                    </div>
                </div>
                <p></p>

                <!-- Add Model.Resource button -->
                <button class="btn btn-info my-4 btn-block" type="submit">Add Resource</button>
            </form>

        </div>
    </div>

</body>
</html>