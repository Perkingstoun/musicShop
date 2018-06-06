<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 26.02.2018
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@include file="admin-fragments/navbar.jsp" %>
<div class="col-md-9 admin-content float-left">


    Doday categoriyu
    <input type="text" name="category" id="category">
    <br>
    <button id="add-category">Add category</button>
    <br>
    Doday subcategoriyu
    <select name="productCategory" id="productCategory" ></select>
    <input type="text" name="subcategory" id="subcategory">
        <br>
    <button id="add-sub-category">Add sub-category</button>
    <a href="/addProductForm">Add product</a>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <br>
    <table border="1" class="product-table">
        <caption>Products</caption>
        <tr>
            <th>Id</th>
            <th>Photo</th>
            <th>Brand</th>
            <th>Name</th>
            <th>Category</th>
            <th>Subcategory</th>

            <th>Price</th>
            <th>Refactor</th>
        </tr>


    </table>


</div>

<script>
    <%@include file="/static/js/admin.js" %>
</script>
</body>
</html>
