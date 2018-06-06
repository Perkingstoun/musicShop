console.log("ok");
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});


    $("#add-category").click(function () {
        var cName = $("#category").val();

        console.log(cName);
        $.ajax({
            type: 'POST',
            url: '/admin/saveCategory',


            data: cName,
            contentType:'text/plain',

            success: function () {
                console.log("yes");
            },
            error: function () {
                console.log("nooo");
            }
        });
    });

$("#add-sub-category").click(function () {
    var cName = $("#productCategory").val();
    var scName = $("#subcategory").val();
    var subCategory= {subCategoryName:scName, category:{categoryName:cName}};
    console.log(subCategory);
    $.ajax({
        type: 'POST',
        url: '/admin/saveSubCategory',
        data: JSON.stringify(subCategory),
        contentType:'application/json',

        success: function () {
            console.log("yes");
        },
        error: function () {
            console.log("nooo");
        }
    });


});

var cName = $("#productCategory").val();
$.ajax({
    url:"/admin/products/addProductForm/cat",
    type: "GET",
    success:function(rez){
        console.log("Yeee BOyyyy");
        for (let cat of rez) {
            console.log(cat);
            $("<option value=\""+cat+"\">"+cat+"</option>").appendTo("#productCategory");
        }

    },
    error: function () {
        console.log("fuck");
    }
});

$.ajax({
    url:"/admin/products/addProductForm/sub",
    type: "GET",
    success:function(rez){
        console.log("Yeee BOyyyy");
        for (let cat of rez) {
            console.log(cat);
            $("<option value=\""+cat+"\">"+cat+"</option>").appendTo("#productSubCategory");
        }

    },
    error: function () {
        console.log("fuck");
    }
});


    $.ajax({
        url:"/admin/products/getProducts",
        type: "GET",
        success: function (rez) {

            console.log(rez);
            for (let prod of rez) {

            console.log(prod);
                console.log("suka");
                $("<tr id='"+prod.id+"'>" +
                    "<th>" + prod.id+"</th>" +
                    " <th>" + "<img src='" + prod.pphoto + "' style='width: 100px'/>" + "</th>" +
                    "<th>" + prod.pbrand + "</th>" +
                    "<th>" + prod.pname + "</th>" +
                    " <th>" + prod.cname + "</th>" +
                    "<th>" + prod.scName + "</th>" +

                    "<th>" + prod.pprice + "</th>" +
                    " <th>"+" <a href='/refactor?id="+prod.id+"'>Refactor</a>"+"<br>"+"<a href='/delete?id="+prod.id+"'>Delete</a> "+"</th>" +
                    "</tr>").appendTo(".product-table");
            }


        },
        error: function () {
            console.log("fucking shit");
        }
    });



    $("#save-about-us").click(function () {
       var boutUs = $("#about-us").val();
       console.log(boutUs);
       $.ajax({
           url:'/admin/saveAboutUs',
           type: 'post',
           data: boutUs,
           contentType: 'text/plain',
           success: function () {
               console.log("about us : saved");
               boutUs.appendTo("#test");
           }
           ,
           error:function () {
               console.log("about us: error");
           }
       })
    });