<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 08.05.2018
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="fragments/header.jsp" %>
<%@include file="fragments/storeMenu.jsp" %>


<div class="col-md-3 float-left"></div>
<div class="col-md-9 float-left">
    <div class="col-md-12 " id="allProducts"></div>

    <ul class="paginator">

    </ul>

</div>

<input type="text" id="cat-give" hidden value="${category}">


<script>
    <%@include file="/static/js/allProducts.js" %>
</script>

<%@include file="fragments/footer.jsp" %>