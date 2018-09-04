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
            $("#imgurl").val(src);
            $("#imgs").empty();
            $("#imgs").append("<div><a target='_blank' href='"+src+"'>"+src+"</a>&nbsp;<a href='javascript:void(0)'  style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
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
        $.post("/content/update.do",sd,function(result) {
            if(result.code == "200"){
                layer.msg("更新内容信息成功！", {
                    offset: '6px'
                });
                //更新完成刷新父窗口
                window.parent.location.reload();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                layer.msg("更新内容信息失败！", {
                    offset: '6px'
                });
            }
        });

        return false;
    });

    //初始化表单
    var itemid = that.getUrlParam("indexid");
    if(itemid == null){
        return;
    }else{
        //初始化下拉列表
        $.get("/content/getcates",{},function (data) {
            $.each(data.objects,function (index,item) {
                $("#cparent").append("<option value='"+item.id+"'>"+item.name+"</option>");
            });
            //如果商品没有分类  查全部
            if(item.parentid == undefined || item.parentid == null){
                form.render('select');  //刷新所有select
                return;
            }
        });
        setTimeout(function(){
            var getidurl = "/content/"+itemid;
            var item = null;
            $.get(getidurl,{},function (data) {
                if(data != null){
                    //表单初始赋值
                    item = data;
                    form.val('formfilter', {
                        "id" : data.id,
                        "name" : data.name,
                        "parentid" : data.parentid,
                        "title" : data.title,
                        "img" : data.img,
                        "url" : data.url,
                        "describle" : data.describle,
                    });

                    //图片链接
                    $("#imgs").empty();
                    if(data.img!=null)
                    $("#imgs").append("<div><a target='_blank' href='"+data.img+"'>"+data.img+"</a>&nbsp;<a href='javascript:void(0)'  style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
                    //创建一个编辑器
                    var editIndex = layedit.build('editor');
                }else{
                    form.val('formfilter',{});
                    var editIndex = layedit.build('editor');
                }
            });
        },100);
    }
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
    $("#imgurl").val("");
    $(this).parent().remove();
});