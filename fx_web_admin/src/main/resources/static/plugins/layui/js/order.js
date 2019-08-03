$(function () {
    $("#paybtn").click(function () {
        var userid = $("#userid").text();
        var itemids = $("#itemids").text();
        var payway = $("#payform").serialize();
        if(payway == ""){
            alert("请选择支付方式！");
            return;
        }
        if(itemids == ""){
            alert("请选择商品！");
            return;
        }
        var order = {};
        $.each($(".Address_info"),function (index,item) {
            if($(item).attr("check") == "1"){
                var li = $(item).find("li");
                $.each(li,function (lIndex,lItem) {
                    var key = $(lItem).attr("field");
                    var value =$(lItem).text();
                    order[key] = value;
                });
            }
        });
        var split = payway.split("=");
        order[split[0]] = split[1];
        order.itemid = itemids;
        order.userid = userid;
        $.post("/order/addOrder",order,function (result) {

        });
        console.log(order)
    });





});