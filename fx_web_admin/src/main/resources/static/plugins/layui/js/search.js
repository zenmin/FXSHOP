$(function(){

    $(document).on("click","#Search_btn",function () {
        var text = $("#search_text").val();
        window.open("fxshop/product_list?q=" + text);
    })
});
