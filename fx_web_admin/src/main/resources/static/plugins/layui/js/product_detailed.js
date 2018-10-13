var that = this;
//加入购物车
$(function () {
    $("#cartbtn").click(function () {
        var userid = $("#userid").text();
        if(userid == "" || userid == null){
            alert("请先登录!");
            window.location.href = "/fxshop/login?url=" +window.location.href;
        }else{
            //加入购物车逻辑
            var productid = $("#productid").text();
            $.post("/cart/add",{userid:userid,productid:productid},function (result) {
                if(result.code == "200"){
                    alert("添加成功");
                    that.refreCart();
                }else{
                    alert(result.msg);
                }
            });
        }
    });
});

function refreCart() {
    // 当前用户id
    var userid = $("#userid").text();
    //先从cookie取
    var COOKIECART = $.cookie('COOKIECART');
    if(COOKIECART != null){
        var items = JSON.parse(COOKIECART);
        var cookieUser = items.userid;
        if(userid == cookieUser){
            var i = items.items;
            $("#p_s_list").empty();
            var allPrice = 0.0;
            var allCount = 0;
            console.log(i);
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

}
