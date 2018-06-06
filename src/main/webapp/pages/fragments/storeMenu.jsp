<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 18.03.2018
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<div class="col-md-12 store-banner">
    <div class="store-menu">
        <a href="/store/new" class="col-md-4 float-left button-nav">New</a>
        <%--<a href="/store/allProducts" class="col-md-4 float-left">All Products</a>--%>
        <div class="allProdMenu col-md-4 float-left">
            <ul class="main-prod-menu button-nav">
                <li>All Products</li>
                <ul class="prod-category">
                    <li><a href="/store/allProducts?category=Guitars">Guitars</a></li>
                    <li><a href="/store/allProducts?category=Drums">Drums</a></li>
                    <li><a href="/store/allProducts?category=Synthesathors">Synthesathors</a></li>
                    <li><a href="/store/allProducts?category=Accesoirs">Accesoirs</a></li>
                </ul>
            </ul>
        </div>

        <a href="/store/sale" class="col-md-4 float-left button-nav">sale</a>
    </div>
</div>