


    $.ajax({
        url:"/getUserCart",
        type: "GET",
        success: function (rez) {
            console.log(rez);
            for (let prod of rez) {
                console.log(prod.brand);
                $("<li class='cart-list-point'> <img src='"+prod.img+"'> Name: "+prod.brand+" "+prod.name+" Price: "+prod.price+"grn. Amount:" +
                    prod.amount+" SumPrice: "+prod.sumPrice+" </li>").appendTo(".cart-list");
            }
            console.log("cart here");
        },
        error: function (err) {
            console.log("can't get cart");
        }
    });



