<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 29.04.2018
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <style>
        <%@include file="/static/css/style.css" %>
    </style>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="col-md-6 m-auto ">
    <div class="font-48">Змініть інформацію про продукт <br></div>
    <form action="/refactProduct" method="post" enctype="multipart/form-data" id="add-prod-form" >
        <div class="float-left font-18">
            Виберіть фото продукту:<br><br>
            Виберіть бренд:<br>
            Введіть ім'я продукту:<br>
            Введіть ціну:<br>
            Виберіть категорію:<br>
            Виберіть субкатегорію:<br>
        </div>
        <input type="file" name="productPhoto" id="productPhoto" class="inp-300" value="${pPhoto}"><br><br>

        <input type="text" name="productBrand" id="productBrand" class="inp-300" value="${pBrand}"><br>

        <input type="text" name="productName" id="productName" class="inp-300" value="${pName}" ><br>

        <input type="number" name="productPrice" id="productPrice" class="inp-300" value="${pPrice}"><br>

        <select name="productCategory" id="productCategory" class="inp-300" onchange="loadSubCategory(this)" value="${pCat}">



        </select>
        <br>

        <select name="productSubCategory" class="inp-300" id="productSubCategory" value="${pSCat}">



        </select><br>
        <br>
        <div class="font-18 clearfix">Введіть опис продукту:</div>
        <textarea name="productDescription" class="inp-300" id="productDescription">${pDescr}</textarea><br><br>
        <input type="submit" class="inp-300 m-auto" value="Зберегти продукт">
        <input type="hidden" name="id" id="id" value="${id}">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

</div>

<script><%@include file="/static/js/addForm.js"%></script>
</body>
</html>