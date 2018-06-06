<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 30.01.2018
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>



<%@include file="fragments/header.jsp"%>

<div class="col-md-12 banner">

</div>
<hr class="line col-md-10 m-line mt-5">
<p class="col-md-12 text-center zag m-auto">About us</p>
<hr class="line col-md-10 m-line">
<div class="col-md-10 text-left m-auto font-18">${aboutUs}</div>
<div class="col-md-12 about-us"></div>

${a}
${b}
<hr class="line col-md-10 m-line mt-5">
<p class="col-md-12 text-center zag m-auto">BEST SELLERS</p>
<hr class="line col-md-10 m-line">



<p>${photo}</p>
<p>${q}</p>
<p></p>


<div class="col-md-10" >
    <div id="best-sellers" class="col-md-4 float-left"></div>
</div>


<%@include file="fragments/footer.jsp"%>
