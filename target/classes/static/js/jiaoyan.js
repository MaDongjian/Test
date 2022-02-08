function isOK(obj,text){
    obj.parent().parent().removeClass("has-error");
    obj.parent().parent().addClass("has-success");
    obj.parent().next().children(":first").html(text);
}
function isErroy(obj,text){
    obj.parent().parent().removeClass("has-success");
    obj.parent().parent().addClass("has-error");
    obj.parent().next().children(":first").html(text);
}