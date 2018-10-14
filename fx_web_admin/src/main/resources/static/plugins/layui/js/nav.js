$(function () {
    //查询购物车
    $(document).ready(function () {
        refreCart();
    });

    $("#btn-payforgoods").click(function () {
        var COOKIECART = $.cookie('COOKIECART');
        if(COOKIECART == null){
            alert("购物车中没有任何商品!");

        }else{
            window.location.href = "/cart/toCart";
        }
    });


});
var that = this;
function refreCart() {
    // 当前用户id
    var userid = $("#userid").text();
    //先从cookie取
    var COOKIECART = $.cookie('COOKIECART');
    if(COOKIECART != null){
        this.setCart(COOKIECART,userid);
    }else{
        //cart服务器获取购物车信息
        $.get("/cart/queryCart/"+userid,{},function (result) {
            //同步服务器和cookie数据
            var COOKIECART = $.cookie('COOKIECART');
            if(COOKIECART != null){
                that.setCart(COOKIECART,userid);
            }else {

            }
        });
    }
}

function setCart(COOKIECART,userid) {

    var items = JSON.parse(COOKIECART);
    var cookieUser = items.userid;
    if(userid == cookieUser){
        var i = items.items;
        $("#p_s_list").empty();
        var allPrice = 0.0;
        var allCount = 0;
        $.each(i,function (index,item) {
            var title = item.tiitle;
            if(item.tiitle.length > 15){
                title = title.substring(0,15)+"...";
            }
            $("#p_s_list").append(
                "<li>"+
                "<div class='img'><img src='"+item.imgurl+"'></div>"+
                "<div class='content'><p><a href='/item/detail/"+item.id+"'><span title='"+item.tiitle+"'>"
                +title+
                "</span></a></p><p>数量: "+item.price+"x"
                +item.cartNum+
                "</p></div><div class='Operations'><p class='Price'>"
                +item.cartPrice +
                "</p><p><a href='#'>删除</a></p></div></li>"
            );
            allPrice+=parseFloat(item.cartPrice);
            allCount+=parseInt(item.cartNum);
        });
        $(".ci-count").text(allCount);
        $("#p_s_list_count .parice").text(allPrice);
        $("#p_s_list_count .count").text(allCount);
    }
}
