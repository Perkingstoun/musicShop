<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 31.01.2018
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/static/css/style.css" %>
        <%@include file="/static/css/Animate.css" %>
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="wrapper">
    <div class="content">
        <div class="col-md-2 float-left"></div>
        <ul class="col-md-8 menu-site float-left">
            <li class="float-left col-md-2 text-center"><a href="/main">About us</a></li>
            <li class="float-left col-md-1 text-center"><a href="/store">shop</a></li>
            <li class="float-left col-md-2 text-center"><a href="/contacts">contacts</a></li>
            <li class="float-left col-md-4 text-center"><a href="/userPage">personal cabinet</a></li>
            <li class="float-left col-md-3 text-center"><a href="/basket">kors</a></li>
        </ul>
        <div class="col-md-2 float-left"></div>
        <div class="clearfix"></div>
