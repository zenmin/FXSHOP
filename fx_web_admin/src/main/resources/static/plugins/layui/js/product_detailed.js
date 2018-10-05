$(function () {
    //加入购物车
    $("#cartbtn").click(function () {
        var userid = $("#userid").text();
        if(userid == "" || userid == null){
            alert("请先登录!");
            window.location.href = "/fxshop/login?url=" +window.location.href;
        }else{
            //加入购物车逻辑
            var productid = $("#productid").text();
            console.log(userid);
            $.post("/cart/add",{userid:userid,productid:productid},function (result) {

            });
        }
    });
});