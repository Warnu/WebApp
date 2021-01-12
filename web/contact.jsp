<!DOCTYPE html>
<html lang="en">
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
                <!-- Default form contact -->
                <form class="text-center border border-light p-5" action="#!">

                    <p class="h4 mb-4">Contact us</p>

                    <!-- Name -->
                    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Name">

                    <!-- Email -->
                    <input type="email" id="defaultContactFormEmail" class="form-control mb-4" placeholder="E-mail">

                    <!-- Subject -->
                    <label>Subject</label>
                    <select class="browser-default custom-select mb-4">
                        <option value="" disabled>Choose option</option>
                        <option value="1" selected>Feedback</option>
                        <option value="2">Report a bug</option>
                        <option value="3">Feature request</option>
                        <option value="4">Feature request</option>
                    </select>

                    <!-- Message -->
                    <div class="form-group">
                        <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" placeholder="Message"></textarea>
                    </div>

                    <!-- Copy -->
                    <div class="custom-control custom-checkbox mb-4">
                        <input type="checkbox" class="custom-control-input" id="defaultContactFormCopy">
                        <label class="custom-control-label" for="defaultContactFormCopy">Send me a copy of this message</label>
                    </div>

                    <!-- Send button -->
                    <button class="btn btn-info btn-block" type="submit">Send</button>

                </form>
                <!-- Default form contact -->
            </div>
        </div>
    </div>
</body>
</html>