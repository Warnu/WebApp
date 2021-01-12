<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
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
    <title>Education Website || Login</title>
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

    <!--Main Navigation-->
    <header>
        <%@ include file="includes/navbar.jsp"%>
    </header>
    <!--Main Navigation-->
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-12 col-md-auto">
                <h1>Education Website Login</h1>
            </div>
        </div>
    </div>
    <br>
    <br>

    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-12 col-md-auto">
                <!-- Default form login -->
                <form class="text-center border border-light p-5" action="login"  method="post" >

                    <p class="h4 mb-4">Sign in</p>

                    <!-- Username -->
                    <input type="text" id="userUsername" name="userUsername" class="form-control mb-4" placeholder="Username" required>

                    <!-- Password -->
                    <input type="password" id="userPassword" name="userPassword" class="form-control mb-3"  placeholder="Password" required>

                    <div class="form-row mb-2">
                        <div class="col">
                            <span>User Type</span>
                            <select name="userType" class="browser-default custom-select ">
                                <option value="Student" selected>Student</option>
                                <option value="Teacher">Teacher</option>
                            </select>
                        </div>
                    </div>

                    <!-- Remember me -->
                    <div class="custom-control custom-checkbox mb-3">
                        <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                        <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                    </div>

                    <p style="color:#ff0000">${message}</p>
                    <p style="color:#ff0000">${message1}</p>
                    <!-- Sign in button -->
                    <button class="btn btn-info btn-block" type="submit">Sign in</button>
                    <div class="mb-3">
                        <!-- Forgot password -->
                        <a href="#">Forgot password?</a>
                    </div>
                    <!-- Register -->
                    <p>Not a member?
                        <a href="studentSignUp.jsp">Register</a>
                    </p>

                    <!-- Social login -->
                    <p>or sign in with:</p>

                    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

                </form>
                <!-- Default form login -->
            </div>
        </div>
    </div>

</body>
</html>