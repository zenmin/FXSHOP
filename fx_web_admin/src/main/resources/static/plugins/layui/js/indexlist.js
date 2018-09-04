layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    table.render({
        elem: '#table'
        ,height: 600
        ,url: '/content/getall.do'
        ,page: true
        ,cols: [[
            {field: 'id', title: '编号', width:177, sort: true, fixed: 'left'}
            ,{field: 'name', title: '商品名称', width:177}
            ,{field: 'title', title: '标题', width:177}
            ,{field: 'img', title: '图片', width:177}
            ,{field: 'url', title: 'URL', width: 177}
            ,{field: 'describle', title: '描述', width: 177, sort: true}
            ,{field: 'right', title: '操作',width:250, align:'center', toolbar: '#cz'}
        ]],
        request: {pageName: 'start' ,limitName: 'size'} ,
        response:{ statusName: 'code' ,statusCode: 200 ,msgName: 'msg',countName: 'total' ,dataName: 'records'},
        done: function(res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        }
    });

    //监听工具条
    table.on('tool(tabledata)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        var url = "/admin/indexdetail.html?indexid=" + data.id;
        if(layEvent === 'detail'){ //查看
            //do somehing
        } else if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                //向服务端发送删除指令
                var url = "/content/delete/"+data.id;
                $.post(url,{_method:"delete"},function (data) {
                    if(data.code == "200"){
                        layer.msg("删除成功！", {
                            offset: '6px'
                        });
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                    }else{
                        layer.msg("删除失败！", {
                            offset: '6px'
                        });
                    }
                })
            });
        } else if(layEvent === 'edit'){ //编辑
            //do something
            //iframe层-父子操作
            layer.open({
                type: 2,
                area: ['1300px', '750px'],
                fixed: false, //不固定
                maxmin: true,
                content: [url]
            });
        }
    });

    //监听排序
    table.on('sort(tabledata)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        // console.log(obj.field); //当前排序的字段名
        // console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
        // console.log(this); //当前排序的 th 对象
        $("[data-field='status']").children().each(function () {
            if ($(this).text() == '1') {
                $(this).text("上架")
            } else if ($(this).text() == '0') {
                $(this).text("下架")
            }
        });
        //尽管我们的 table 自带排序功能，但并没有请求服务端。
        //有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
        // table.reload('idTest', {
        //     initSort: obj //记录初始排序，如果不设的话，将无法标记表头的排序状态。 layui 2.1.1 新增参数
        //     ,where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
        //         field: obj.field //排序字段
        //         ,order: obj.type //排序方式
        //     }
        // });
    });

    //打开添加页面
    $(document).on("click","#addbtn",function () {
        layer.open({
            type: 2,
            area: ['1300px', '750px'],
            fixed: false, //不固定
            maxmin: true,
            content: ["/admin/addindex.html"]
        });
    });


});

