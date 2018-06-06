$(document).ready(function () {
    $(".singup").hide();




});

$(document).ready(function(){$("p.reg").click(function () {
    $(".login").hide();
    $(".singup").show();
    var start = Date.now(); // сохранить время начала

    var timer = setInterval(function() {
        // вычислить сколько времени прошло с начала анимации
        var timePassed = Date.now() - start;

        if (timePassed >= 2000) {
            clearInterval(timer); // конец через 2 секунды
            return;
        }

        // рисует состояние анимации, соответствующее времени timePassed
        draw(timePassed);

    }, 20);

// в то время как timePassed идёт от 0 до 2000
// left принимает значения от 0 до 400px
    function draw(timePassed) {
        $(".small-line").style.left = timePassed / 5 + 'px';
    }



})});

$(document).ready(function(){$("p.lg").click(function () {
    $(".login").show();

    $(".singup").hide();




})});
console.log("heeellllllllll");



