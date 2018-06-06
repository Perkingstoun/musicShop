<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 21.04.2018
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@include file="fragments/header.jsp"%>


<div class="col-md-12 line"></div>

 ${prod.category}/${prod.subCategory}/${prod.brand}/${prod.name}
<div class="col-md-12 line"></div>
<div class="m-5">
<div class="col-md-6 float-left " >
    <img src="${prod.image}" >
</div>
<div class="col-md-6 float-left p-5">
    <p>${prod.brand} ${prod.name}</p>
    <input type="number" id="prod-id" value="${prod.id}" hidden>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <p>${prod.price}</p>
    <button id="add-to-cart">ADD to cart</button>
</div>
</div>
<div class="clearfix"></div>
<div class="col-md-12 details">
    <p class="font-48">Details</p>
    ${prod.details}
</div>



<script>
    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });

    $("#add-to-cart").click(function () {
        let prodId = $("#prod-id").val();
        $.ajax({
            url:"/productPage/add-product-to-cart",
            type: "POST",
            data: prodId,
            contentType: "text/plain",
            success: function () {

                console.log(prodId+"added!!!");
            },
            error: function (err) {
                console.log(err);
                console.log(prodId+"cant add(");
            }
        });
    });
</script>

</body>
</html>