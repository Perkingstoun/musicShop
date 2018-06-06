var category = $("#cat-give").val();
console.log(category);
var pageCounter = 1;
$("#page-button").click(function () {
    var page = pageCounter;
    var jsonCat = {id: page,categoryName: category};
    console.log(category);
    console.log(page);
    console.log(window.location.href);
    $.ajax({
        url:"/shop/getAllProducts",
        data: JSON.stringify(jsonCat),
        contentType:'application/json',
        type: "POST",
        success: function (rez) {
            console.log("get new prod");
            history.pushState({}, null, "http://localhost:8080/store/allProducts?category="+category+";page="+page+"/");
            // $('#allProducts').html("");
            let i =0;
            for (let prod of rez) {
                i++;
                $("<div class='product-on-page float-left wow slideInLeft'> <div class='prod-image'> <img src='"+prod.image+"' style='width: 90%; margin: 0' > " +
                    " </div><div class='prod-name'><br>"+prod.brand+" "+prod.name +
                    "</div><div class='p-inf'><div class='p-line'></div>"+"<p>"+prod.price+" grn.</p>" +"<a id='goToProdPage'" +
                    " href='/productPage?id="+prod.id+"'>Detalnishe</a></div></div>").appendTo("#allProducts");

            }
            if(rez!=null)
            pageCounter++;
        },
        error: function (err) {
            console.log(page);
            console.log(err);
            console.log("cant get");
        }
    });
});

$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

$(document).ready(function () {
    $.ajax({
        url: "/getPages",
        data: category,
        contentType: "text/plain",
        type: "GET",
        success: function (rez) {
            for (let i=1; i <=rez; i++){
                $("<li class='paginator-li'><a href='/"+category+"/page="+i+"/'>"+i+"</a></li>").appendTo(".paginator");
            }
        }
    })

});


