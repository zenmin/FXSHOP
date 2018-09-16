$(function () {
   $("#username").blur(function () {
       //检查用户名是否存在
       var username = $(this).val();
       if(username != ""){
           $.get("/sso/checkUsername/"+username,{},function (result) {
              if(result.code)
              $(".usernametip").text(result.msg);
              if(result.code == "500"){
                  $("#username").focus();
              }
           });
       }
   });

   //密码框1
   $(".password1").blur(function () {
       var pwd =  $(".password1").val();
      var reg = /^[a-z0-9_-]{6,18}$/;
       if(!reg.test(pwd)){
            $(".pwdtip").text("密码请包含英文加数字，长度6~18位！");
           $(".password1").focus();
       }else{
           $(".pwdtip").text("密码格式正确！");
       }
   });

   //密码框2
    $(".password2").blur(function () {
        var pwd1 =  $(".password1").val();
        var pwd2 = $(".password2").val();
        if(pwd1 != pwd2){
            $(".pwdtip2").text("两次输入密码不一致！");
        }else{
            $(".pwdtip2").text("");
        }
    });

    //发送验证码按钮
    $("#sendCode").click(function () {
        var time = parseInt($("#timer").text());
        if(time != 59){
            return;
        }
        $("#timer").show();
        var sendtimer = setInterval(function () {
            var time = parseInt($("#timer").text());
            if(time<=0){
                $("#timer").hide();
                $("#timer").text(59);
                $("#sendCode").text("重新发送验证码");
                clearInterval(sendtimer);
                return;
            }
            time-=1;
            $("#timer").text(time);
        },"1000");
        var tel = $(".phonenum").val();
        $.get("/sso/sendmsg/"+tel,{},function (result) {
           console.log(result);
        });

        //注册
        $("#regbtn").click(function () {
            var uname = $("#username").val();
            var pwd = $(".password1").val();
            //验证码是否正确



            //执行注册
            if(tel!=""&&uname!=""&&pwd){
                $.ajax({
                    method:"PUT",
                    data:$("#regform").serialize(),
                    success:function (result) {
                        console.log(result);
                    }
                });
            }
        });
    });
});