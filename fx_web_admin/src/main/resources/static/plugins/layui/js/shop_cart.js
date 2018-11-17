$(document).ready(function () {
    //全选
    $("#CheckedAll").click(function () {
        if (this.checked) {                 //如果当前点击的多选框被选中
            $('input[type=checkbox][name=checkitems]').attr("checked", true);
        } else {
            $('input[type=checkbox][name=checkitems]').attr("checked", false);
        }
    });
    $('input[type=checkbox][name=checkitems]').click(function () {
        var flag = true;
        $('input[type=checkbox][name=checkitems]').each(function () {
            if (!this.checked) {
                flag = false;
            }
        });

        if (flag) {
            $('#CheckedAll').attr('checked', true);
        } else {
            $('#CheckedAll').attr('checked', false);
        }
    });
    //输出值
    $("#send").click(function () {
        if($("input[type='checkbox'][name='checkitems']:checked").attr("checked")){
            var str = "你是否要删除选中的商品：\r\n";
            $('input[type=checkbox][name=checkitems]:checked').each(function () {
                str += $(this).val() + "\r\n";
            });
            alert(str);
        }
        else{
            var str = "你未选中任何商品，请选择后在操作！";
            alert(str);
        }
    });

    setTimeout(function () {
        var allPrice = $("#p_s_list_count .parice").text();
        $("#Total_price").text('￥'+allPrice);
        $("#total_points").text(Math.floor(allPrice/10));
    },1000);

    //减
    $(document).on("click",".Numbers .jian",function () {
        var num = $(this).parent().find("#qty_item_1").val();
        if(num <=1){
            alert("数量不可小于1！");

        }else{
            num--;
            var itemid = $(this).parent().find("#itemid").text();
            var price = $(this).parent().parent().parent().find("#Original_Price_1").text();
            $(this).parent().find("#qty_item_1").val(num);
            var allprice = parseFloat(price)*num;
            var xj =  $(this).parent().parent().parent().find(".xj");
            xj.find("#total_price_text").text('￥'+allprice);
            xj.find("#total_price").val(allprice);
            $("#total_points").text(Math.floor(allprice/10));
            $.post("/cart/udpateCart",{itemid:itemid,num:num,type:1},function (result) {
                if(result){
                    that.refreCart();
                    var allPrice = $("#p_s_list_count .parice").text();
                    $("#Total_price").text('￥'+allPrice);
                    $("#total_points").text(Math.floor(allPrice/10));
                }else{
                    alert("服务器繁忙，请稍后再试！")
                }
            });
        }
    });

    //加
    $(document).on("click",".Numbers .jia",function () {
        var itemid = $(this).parent().find("#itemid").text();
        var num = $(this).parent().find("#qty_item_1").val();
        var price = $(this).parent().parent().parent().find("#Original_Price_1").text();
        num++;
        $(this).parent().find("#qty_item_1").val(num);
        var allprice = parseFloat(price)*num;
        var xj =  $(this).parent().parent().parent().find(".xj");
        xj.find("#total_price_text").text('￥'+allprice);
        xj.find("#total_price").val(allprice);
        $("#total_points").text(Math.floor(allprice/10));

        $.post("/cart/udpateCart",{itemid:itemid,num:num,type:1},function (result) {
            if(result){
                that.refreCart();
                var allPrice = $("#p_s_list_count .parice").text();
                $("#Total_price").text('￥'+allPrice);
                $("#total_points").text(Math.floor(allPrice/10));
            }else{
                alert("服务器繁忙，请稍后再试！")
            }
        });
        });

    //删除
    $(".deleteCart").click(function () {
        var itemid = $(this).parent().parent().parent().find("#itemid").text();
        var othis = $(this);
        $.post("/cart/udpateCart",{itemid:itemid,type:2},function (result) {
            if(result){
                othis.parent().parent().parent().remove();
                that.refreCart();
                var allPrice = $("#p_s_list_count .parice").text();
                $("#Total_price").text('￥'+allPrice);
                $("#total_points").text(Math.floor(allPrice/10));
                $(this).parent().parent().parent().remove();
            }else{
                alert("服务器繁忙，请稍后再试！")
            }
        });
    });

    //提交订单
    $(".cartsubmit").click(function () {
        var ids = new Set();
        $.each($(".table_list tr"),function (index,item) {
            if($(item).find(":checkbox").eq(0).attr("checked") == "checked"){
                var itemId = $(item).find("#itemid").eq(0).text();
                ids.add(itemId);
            }
        });
        if(ids.size == 0){
            alert("你未选择任何商品！");
            return;
        }
        try {
            ifeame('确认订单','/fxshop/order_address');
        }catch (e) {
        }
    });


});
var that = this;
function refreCart() {
    // 当前用户id
    var userid = $("#userid").text();
    //先从cookie取
    var COOKIECART = $.cookie('COOKIECART');
    if (COOKIECART != null) {
        var items = JSON.parse(COOKIECART);
        var cookieUser = items.userid;
        if (userid == cookieUser) {
            var i = items.items;
            $("#p_s_list").empty();
            var allPrice = 0.0;
            var allCount = 0;
            $.each(i, function (index, item) {
                var title = item.tiitle;
                if (item.tiitle.length > 15) {
                    title = title.substring(0, 15) + "...";
                }
                $("#p_s_list").append(
                    "<li>" +
                    "<div class='img'><img src='" + item.imgurl + "'></div>" +
                    "<div class='content'><p><a href='/item/detail/" + item.id + "'><span title='" + item.tiitle + "'>"
                    + title +
                    "</span></a></p><p>数量: " + item.price + "x"
                    + item.cartNum +
                    "</p></div><div class='Operations'><p class='Price'>"
                    + item.cartPrice +
                    "</p><p><a href='#'>删除</a></p></div></li>"
                );
                allPrice += parseFloat(item.cartPrice);
                allCount += parseInt(item.cartNum);
            });
            $(".ci-count").text(allCount);
            $("#p_s_list_count .parice").text(allPrice);
            $("#p_s_list_count .count").text(allCount);
        }
    }else{
        $.get("/cart/queryCart/"+ userid,{},function () {
            console.log("已刷新购物车");
        });
    }
}