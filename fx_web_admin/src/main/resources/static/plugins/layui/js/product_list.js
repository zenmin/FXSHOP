function infonav_more_down(index)
{
    var inHeight = ($("div[class='p_f_name infonav_hidden']").eq(index).find('p').length)*30;//先设置了P的高度，然后计算所有P的高度
    if(inHeight > 60){
        $("div[class='p_f_name infonav_hidden']").eq(index).animate({height:inHeight});
        $(".infonav_more").eq(index).replaceWith('<p class="infonav_more"><a class="more"  onclick="infonav_more_up('+index+');return false;" href="javascript:">收起<em class="pulldown"></em></a></p>');
    }else{
        return false;
    }
}
function infonav_more_up(index)
{
    var infonav_height = 85;
    $("div[class='p_f_name infonav_hidden']").eq(index).animate({height:infonav_height});
    $(".infonav_more").eq(index).replaceWith('<p class="infonav_more"> <a class="more" onclick="infonav_more_down('+index+');return false;" href="javascript:">更多<em class="pullup"></em></a></p>');
}

function onclick(event) {
    info_more_down();
    return false;
}