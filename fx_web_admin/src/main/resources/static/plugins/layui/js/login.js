$(function () {
   $(".btn_login").click(function () {
       var uname =  $(".username").val();
       var pwd =  $(".password").val();
       if(uname == "" || pwd == ""){
           $(".Prompt").show();
           return;
       }
       $.ajax({
           url:"/sso/login",
           method:"POST",
           data:{username:uname,password:pwd},
           success:function (result) {
                if(result.code == "200"){
                    //登录成功  跳转
                    var url = getUrlParam("url");
                    if(url != null && url != ""){
                        window.location.href = url;
                    }else{
                        window.location.href = "/";
                    }
                }else{
                    $(".logintext").text(result.msg);
                }
           }
       });

   });
    //获取Url参数方法
    var getUrlParam = function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substring(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };
});