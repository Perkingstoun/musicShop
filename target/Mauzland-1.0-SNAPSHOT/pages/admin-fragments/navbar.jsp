<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 26.02.2018
  Time: 12:03
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
<div class="col-md-3 admin-menu float-left">
    <p>Admin cabinet</p>
    <hr class="line">
    <a href="/admin/products">Products</a>
    <hr class="line">
    <a href="/admin/users">Users</a>
    <hr class="line">

    <hr class="line">
    Offers 
    <hr class="line">
    Account
    <hr class="line">
    <a href="/logout">logout</a>
    <hr class="line">
</div>
