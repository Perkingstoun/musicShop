

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

// function searchCategory(category) {
//     for (let cat of categories) {
//         if(cat.categoryName=category) return cat;
//     }
// }




function loadSubCategory(selected) {

    var subCategory = $("#productSubCategory");
    console.log(selected.value.toString());
    var category = selected.value;


    $.ajax({
        url:"/admin/products/addProductForm/sub",
        data: category,
        contentType:'text/plain',
        type: "POST",
        success:function(rez){
            console.log("Yeee BOyy213yy");
            console.log(rez);
            subCategory.html(' ');
            subCategory.css("disabled","enabled");
            for (let cat of rez) {
                console.log(cat);
                $("<option value=\""+cat+"\">"+cat+"</option>").appendTo("#productSubCategory");
            }

        },
        error: function (err) {
            console.log(err);
            console.log("fuckshit");
        }
    });

}