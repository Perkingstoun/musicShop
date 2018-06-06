$.ajax({
    url:"/shop/getNewProducts",
    type: "GET",
    success: function (rez) {
        console.log("get new prod");

        for (let prod of rez) {
            $("<div class='product-on-page float-left'> <div class='prod-image'> <img src='"+prod.image+"' style='width: 90%' >  </div><br>"+prod.brand+" "+prod.name + "<br>"+prod.price+" grn." +"<br><a id='goToProdPage' href='/productPage?id="+prod.id+"'>Detalnishe</a></div>").appendTo("#new-products");
        }
    },
    error: function () {
        console.log("cant get");
    }
});


