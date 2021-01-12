<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
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
    <title>Home</title>
    <meta charset="UTF-8">
    <title>Education Website || Sign Up</title>
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
    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-12 col-md-auto">
                <h1>Education Website SignUp</h1>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-12 col-md-auto">
                <!-- Default form register -->
                <form class="text-center border border-light p-5" action="studentSignup" method="post">

                    <p class="h4 mb-4">Student Sign up</p>

                    <div class="form-row mb-4">
                        <div class="col">
                            <!-- First name -->
                            <input type="text" id="studentFirstName" name="studentFirstName" class="form-control" placeholder="First name" required>
                        </div>
                        <div class="col">
                            <!-- Last name -->
                            <input type="text" id="studentLastName" name="studentLastName" class="form-control" placeholder="Last name" required>
                        </div>
                    </div>

                    <div class="form-row mb-4">
                        <div class="col">
                            <!-- Student Username -->
                            <input type="text" id="studentUserName" name="studentUserName" class="form-control" placeholder="User name" required>
                        </div>
                    </div>

                    <!-- E-mail -->
                    <input type="email" id="studentEmailAddress" name="studentEmailAddress" class="form-control mb-4" placeholder="E-mail" required>

                    <!-- Password -->
                    <input type="password" id="studentPassword" name="studentPassword" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock" required>
                    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                        At least 8 characters and 1 digit
                    </small>

                    <div class="form-row mb-4">
                        <div class="col">
                            <span>Grade Level</span>
                            <select name="studentGradeLevel" class="browser-default custom-select mb-4">
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

                    <p style="color: red">${message}</p>
                    <p style="color: red">${message2}</p>

                    <!-- Sign up button -->
                    <button class="btn btn-info my-4 btn-block" type="submit">Sign up!</button>

                    <!-- Social register -->
                    <p>or sign up with:</p>

                    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
                    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

                    <hr>

                    <!-- Terms of service -->
                    <p>By clicking
                        <em>Sign up</em> you agree to our
                        <a href="" target="_blank">terms of service</a>
                </form>
                <!-- Default form register -->
            </div>
        </div>
    </div>

</body>
</html>