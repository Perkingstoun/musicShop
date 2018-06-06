<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 30.01.2018
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@include file="admin-fragments/navbar.jsp"%>
<div class="col-md-9 admin-content float-left">


        <textarea name="aboutUs" id="about-us">${aboutUs}</textarea>
        <br>
        <button id="save-about-us">save</button>
        <div id="test"></div>

</div>

<script><%@include file="/static/js/admin.js"%></script>
</body>
</html>
