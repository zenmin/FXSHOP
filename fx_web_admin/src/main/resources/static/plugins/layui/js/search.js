$(function(){

    $(document).on("click","#Search_btn",function () {
        var text = $("#search_text").val();
        if(text == ""){
            return;
        }
        window.location.href = "/item/search?q=" + text;
    })
});
