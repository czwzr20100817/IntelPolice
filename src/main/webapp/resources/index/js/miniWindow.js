function pop_init(title,content) {
    //取当前浏览器窗口大小
    var windowWidth=$(document).width();
    var windowHeight=$(document).height();
    //弹窗的大小
    var weight=300;
    var height=200;
    $("body").append(
        "<div id='pop_div'style='display:none;position:absolute;border:1px solid #e0e0e0;z-index:99;width:"+weight+"px;height:"+height+"px;top:"+(windowHeight-height-50)+"px;left:"+(windowWidth-weight-35)+"px'>"+
        "<div style='line-height:32px;background:#f6f0f3;border-bottom:1px solid #e0e0e0;font-size:14px;padding:0 0 0 10px;'>" +
        "<div style='float:left;'><b>"+title+"</b></div><div style='float:right;cursor:pointer;'><b onclick='pop_close()'>×</b></div>" +
        "<div style='clear:both'></div>"+
        "</div>" +
        "<div id='content'>" +
        content+
        "</div>"+
        "</div>"
    );
}
function pop_close(){
    $('#pop_div').fadeOut(400);
}
