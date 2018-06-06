<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 30.01.2018
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <style><%@include file="/static/css/style.css"%></style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


</head>
<body>
<header class="col-md-10">PERSONAL CABINET</header>
<hr class="line"/>
<br>

<div class="col-md-4 m-auto" >
    <div class="float-left col-md-6 "><p class="lg  m-auto">Log in</p></div>
    <div class="float-left col-md-6 "> <p class="reg  m-auto">Register</p></div>
    <hr class="float-left m-0" id="small-line">


    <div class="singup">
            <form action="/save" method="post" >
                <input type="text" name="username" placeholder="username" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'username'"><br>
                <input type="password" name="password" placeholder="password" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'password'"><br>
                <input type="email" name="email" placeholder="email" onfocus="this.placeholder = ''"
                       onblur="this.placeholder = 'email'"><br>

                <input type="submit" value="GO SHOPING bITCH" ><br>

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
    </div>
    <div class="login">
        <form action="/login" method="post" >
            <input type="text" name="username" placeholder="username" onfocus="this.placeholder = ''"
                   onblur="this.placeholder = 'username'"><br>
            <input type="password" name="password" placeholder="password" onfocus="this.placeholder = ''"
                   onblur="this.placeholder = 'password'"><br>


            <input type="submit" value="log in" ><br>

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
    </div>
</div>









<script><%@include file="/static/js/login.js"%></script>
</body>
</html>
