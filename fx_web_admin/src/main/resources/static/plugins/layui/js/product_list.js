function infonav_more_down(index) {
    var inHeight = ($("div[class='p_f_name infonav_hidden']").eq(index).find('p').length)*30;//先设置了P的高度，然后计算所有P的高度
    if(inHeight > 60){
        $("div[class='p_f_name infonav_hidden']").eq(index).animate({height:inHeight});
        $(".infonav_more").eq(index).replaceWith('<p class="infonav_more"><a class="more"  onclick="infonav_more_up('+index+');return false;" href="javascript:">收起<em class="pulldown"></em></a></p>');
    }else{
        return false;
    }
}
function infonav_more_up(index) {
    var infonav_height = 85;
    $("div[class='p_f_name infonav_hidden']").eq(index).animate({height:infonav_height});
    $(".infonav_more").eq(index).replaceWith('<p class="infonav_more"> <a class="more" onclick="infonav_more_down('+index+');return false;" href="javascript:">更多<em class="pullup"></em></a></p>');
}

function onclick(event) {
    info_more_down();
    return false;
}

$(function () {
    var page = JSON.parse($("#pageable").text());
    var q = getUrlParams("q");
    for(var i=0;i<page.totalPage;i++){
        var nowpage = i+1;
        if(i == parseInt(page.page)){
            $("#pages").append("<a href=/item/search?q="+q + "&page="+ i +"&size=12"+" class='on'>"+nowpage+"</a>")
        }else{
            $("#pages").append("<a href=/item/search?q="+q + "&page="+ i +"&size=12"+">"+nowpage+"</a>")
        }
    }
    var prepage = parseInt(page.page)-1;
    if(prepage < 0){
        prepage = 0;
    }
    var nextpage = parseInt(page.page)+1;
    var totalPage = parseInt(page.totalPage);
    if(nextpage > totalPage){
        prepage = totalPage;
    }
    $(".pn-prev").attr("href","/item/search?q="+q + "&page="+ prepage +"&size=12");
    $(".nextpage").attr("href","/item/search?q="+q +"&page="+ nextpage +"&size=12");

    $(".commitpage").click(function () {
        var val = $("#page_jump_num").val();
        if(val != ""){
            if(parseInt(val) > 0){
                var page = parseInt(val)-1;
                window.location.href = "/item/search?q="+q+"&page="+ page +"&size=12";
            }
        }
    });

    //添加到购物车中
    $("#addTocart").click(function () {
        var itemid = $(this).parent().find(".itemid").eq(0).text();
        var userid = $("#userid").text();
        var name = $(this).parent().parent().find(".name").eq(0).text();
        var price = $(this).parent().parent().find(".Price").eq(0).text();

        console.log(itemid);
        console.log(userid);
        console.log(name);
        console.log(price)

    });
});
/**获取url中的参数并转换成json格式*/
var getUrlParams = function(params){
    var str=document.URL;
    var num=str.indexOf("?");
    str=str.substr(num+1);
    var arr=str.split("&");
    for(var i=0;i < arr.length;i++){
        num=arr[i].indexOf("=");
        if(num>0){
            var key=arr[i].substring(0,num);
            var value=arr[i].substr(num+1);
            if(key == params){
                return value;
            }
        }
    }
};