var that = this;
layui.use(['form', 'layedit', 'laydate','upload'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate,
        upload = layui.upload;

    //日期
    laydate.render({
        elem: '#date',
        format: "yyyy-MM-dd HH:mm:ss",
        type: "datetime"
    });

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 2) {
                return '名称至少得2个字符啊';
            }
        }
    });
    upload.render({
        elem: '#uploadimg' //绑定元素
        ,url: '/item/uploadimg' //上传接口
        ,done: function(res){
            //上传完毕回调
            var src = res.data.src;
            var data = $("#imgurl").val();
            data+=","+src;
            $("#imgurl").val(data);
            $("#imgs").empty();
            if(data.indexOf(",")!=-1){
                var split = data.split(",");
                $.each(split,function (idnex,item) {
                    if(item != "")
                    $("#imgs").append("<div><a target='_blank' href='"+item+"'>"+item+"</a>&nbsp;<a href='javascript:void(0)' style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
                });
            }else{
                $("#imgs").append("<div><a target='_blank' href='"+data+"'>"+data+"</a>&nbsp;<a href='javascript:void(0)'  style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
            }
        }
        ,error: function(){
            layui.msg("上传失败，请检查网络连接！")
         }
    });
    //监听指定开关
    form.on('switch(issj)', function (data) {
    });
    //监听提交  监听的是按钮
    form.on('submit(submitbtn)', function(data){
        var sd = data.field;
        var dmsg = layedit.getContent(1);   //取富文本编辑器的值
        if(sd.status == "on"){
            sd.status = 1;
        }else{
            sd.status = 0;
        }
        sd.dmsg = dmsg;
        $.ajax({
            url:"/item/add.do",
            data:sd,
            method:"PUT",
            success:function (result) {
                if(result.status == "200"){
                    layer.msg("添加商品成功！", {
                        offset: '6px'
                    });
                    //完成刷新父窗口
                    window.parent.location.reload();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }else{
                    layer.msg("添加商品信息失败！", {
                        offset: '6px'
                    });
                }
            }

        });

        return false;
    });

    //监听下拉框     选择主类
    form.on('select(cparent)', function (data) {
        var pidurl = "/itemcate/findbypid/"+data.value;
        $.get(pidurl,{},function (data) {
            $("#cchild").empty();
            $("#cchild").append("<option value='-1'>请选择子分类</option>");
            $.each(data.objects,function (index,item) {
                $("#cchild").append("<option value='"+item.id+"'>"+item.name+"</option>");
            });

            $("#cchild").val("-1");
            form.render('select');  //刷新所有select
        });
        return false;
    });

    form.val('formfilter',{});
    layedit.set({
        uploadImage: {
            url: '/item/uploadimg' //接口url
            , type: 'post' //默认post
        }
    });
    var editIndex = layedit.build('dmsg');
        //初始化下拉列表
    setTimeout(function () {
        $.get("/itemcate/findparent",{},function (data) {
            $.each(data.objects,function (index,item) {
                $("#cparent").append("<option value='"+item.id+"'>"+item.name+"</option>");
            });
            form.render('select');  //刷新所有select
        });
    },100);



});
//获取Url参数方法
var getUrlParam = function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substring(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
};
//删除图片
$(document).on("click",".deleteImg",function () {
    var nowurl = "," + $(this).parent().find("a").eq(0).text();
    var data = $("#imgurl").val();
    data = data.replace(nowurl,"");
    $("#imgurl").val(data);
    $(this).parent().remove();
});