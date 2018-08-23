var that = this;
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

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
        $.post("/item/update.do",sd,function(result) {
            if(result.status == "200"){
                layer.msg("更新商品信息成功！", {
                    offset: '6px'
                });
                //更新完成刷新父窗口
                window.parent.location.reload();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                layer.msg("更新商品信息失败！", {
                    offset: '6px'
                });
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

    //初始化表单
    var itemid = that.getUrlParam("itemid");
    if(itemid == null){
        return;
    }else{
        var getidurl = "/item/findbyid/"+itemid;
        var item = null;
        $.get(getidurl,{},function (data) {
            if(data != null){
                //表单初始赋值
                item = data;
                form.val('formfilter', {
                    "id" : data.id,
                    "categoryid" : data.categoryid,
                    "name" : data.name,
                    "tiitle" : data.tiitle,
                    "describle" : data.describle,
                    "barcode" : data.barcode,
                    "price" : data.price,
                    "num" : data.num,
                    "status" : data.status == "1"?true:false,
                    "created" : data.created,
                    "dmsg" : data.itemDeatil != null?data.itemDeatil.bigmsg:"",
                    "imgurl" : data.imgurl
                });

                //图片链接
                $("#imgs").empty();
                if(data.imgurl.indexOf(",")!=-1){
                    var split = data.imgurl.split(",");
                    $.each(split,function (idnex,item) {
                        if(item != "")
                            $("#imgs").append("<div><a target='_blank' href='"+item+"'>"+item+"</a>&nbsp;<a href='javascript:void(0)' style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
                    });
                }else{
                    $("#imgs").append("<div><a target='_blank' href='"+data.imgurl+"'>"+data.imgurl+"</a>&nbsp;<a href='javascript:void(0)'  style='color:#FFB800' class='deleteImg'>删除</a> </div><br>");
                }
                //创建一个编辑器
                var editIndex = layedit.build('editor');
            }else{
                form.val('formfilter',{});
                var editIndex = layedit.build('editor');
            }
        });
    }
    //初始化下拉列表
    setTimeout(function () {
        $.get("/itemcate/findparent",{},function (data) {
            $.each(data.objects,function (index,item) {
                $("#cparent").append("<option value='"+item.id+"'>"+item.name+"</option>");
            });

            //如果商品没有分类  查全部
            if(item.itemCategory == undefined || item.itemCategory == null){
                form.render('select');  //刷新所有select
                return;
            }
            var itemcid = "",itempid = "";
            if(typeof(item.itemCategory)!=undefined && item.itemCategory!=null){
                itemcid = item.itemCategory.id;
                itempid = item.itemCategory.parentid;
            }
            $("#cparent").val(itempid);
            var pidurl = "/itemcate/findbypid/"+itempid;
            $.get(pidurl,{},function (data) {
                console.log(data)
                $.each(data.objects,function (index,item) {
                    $("#cchild").append("<option value='"+item.id+"'>"+item.name+"</option>");
                });
                $("#cchild").val(itemcid);
                form.render('select');  //刷新所有select
            });
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