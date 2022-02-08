<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/29
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <!-- css文件-->
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<!-- 头部列表开始-->

<!-- 头部列表结束-->
<p class="titlep">用户注册</p>
<form class="form-horizontal" role="form" id="wqe">


    <div class="form-group">
        <label class="col-sm-2 control-label" for="password1">密码：</label>
        <div class="col-sm-3">
            <input type="password" name="password" id="password1" value="">
        </div>
        <div><span></span></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="rnewpassword">请确认密码:</label>
        <div class="col-sm-3">
            <input type="password" name="rnewpassword" id="rnewpassword" value="">
        </div>
        <div><span></span></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" ></label>
        <div class="col-sm-3">
            <input type="checkbox"  id="qq" >我一阅读并同意
        </div>

    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" ></label>
        <div class="col-sm-6">
            <input class="btn btn-default" type="button" value="注册" id="btn">
        </div>
    </div>

</form>

<script>
    $(document).ready(function(){
        //修改验证码
        $("img").click(function(){
            var img=document.getElementById("img");
            img.src="/authImage?date="+new Date();
        });
    })


        $("#mobile").blur(function () {
            var mobile=$("#mobile");
            var reg=/^1[3-9][0-9]{9}$/;
            if(reg.test($(this).val())){
                $.ajax({
                    url:"${pageContext.request.contextPath}/findMo",
                    type:"post",
                    dataType:"json",
                    data:{mobile:$(this).val()},
                    success:function(data){
                        if(data){
                            isError(mobile,"此手机号已被注册，请重新输入.");
                            // ("#sub1").
                            return false;
                        }else{
                            isOk(mobile,"√√√√√");
                        }
                    },error:function(){
                        isError(mobile,"发生异常，请稍后重试.");
                        return false;
                    }
                });
            }else{
                isError(mobile,"手机号格式不正确");
                return false;
            }
    })
        function yzm(){
        var mobile=$("#mobile").val();
        alert(mobile)
        $.ajax({
            url:"${pageContext.request.contextPath}/Hqyzm",
            dataType:"json",
            type:"post",
            data:{mobile:mobile},
            success:function(data){
                if(data){
                    //rabbitmq (mobile);
                    alert("成功")
                    $("#code1").val(data);
                }else{
                    alert("失败")
                }
            }
        })
    }



    $("#code").blur(function(){
        var code=$("#code").val();

        var code1=$("#code1").val();

        if(code==""){
            isError($("#code"),"验证码不能为空")
            return false;
        }
        if(code!=code1){
            isError($("#code"),"验证码不zhengque")
            return false;
        }
        isOk($("#code"),"验证成功")

    })
    $("#password1").blur(function(){
        var password1=$(this).val();
        var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
        if(reg.test(password1)){
            isOk($(this),"密码正确")
        }else{
            isError($(this),"密码格式bu正确")
            return false;
        }
    })
    $("#rnewpassword").blur(function(){
        var rnewpassword=$("#rnewpassword").val();
        var password1=$("#password1").val();
        if(rnewpassword==""){
            isError($(this),"请确认密码")
            return false;
        }
        if(rnewpassword!=password1){
            isError($(this),"请确认密码")
            return false;
        }
        isOk($(this),"正确")
    })
    $("#Codestext").blur(function(){
        var Codestext=$(this).val();
        if(!Codestext){
            isError($(this),"发生异常，请稍后重试.");
            return false;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/YZ",
            dataType:"json",
            type:"post",
            data:{Codestext:Codestext},
            success:function(data){

                if(!data){
                    alert(data)
                    isError($("#Codestext"),"发生异常，请稍后重试.");
                    return false;
                }

            }
        })
        isOk($(this),"正确")
    })

    $("#btn").click(function(){
        var mobile=$("#mobile");
        if(!mobile.val()){
            isError(mobile,"手机号不能为空")
            return false;
        }
        var code=$("#code");
        if(!code.val()){
            isError(code,"yanzhengma不能为空")
        }
        var password1=$("#password1");
        if(!password1.val()){
            isError(password1,"密码不能为空")
            return false;
        }
        var rnewpassword=$("#rnewpassword");
        if(!rnewpassword.val()){
            isError(rnewpassword,"新密码不能为空")
            return false;
        }
        var Codestext=$("#Codestext");
        if(!Codestext.val()){
            isError(Codestext,"验证码不能为空")
            return false;
        }
        if(!$("#qq").is(":checked")){
            alert("请勾选")
            return false;
        }
        $.ajax({
            url:"${pageContext.request.contextPath}/UpMobile",
            dataType:"json",
            type:"post",
            data:$("#wqe").serialize(),
            success:function(){
                alert("注册成功")
            }
        })
    })

    function isOk(obj,text){
        obj.parent().parent().removeClass("has-error");
        obj.parent().parent().addClass("has-success");
        obj.parent().next().children(":first").html(text);
    }
    function isError(obj,text){
        obj.parent().parent().removeClass("has-success");
        obj.parent().parent().addClass("has-error");
        obj.parent().next().children(":first").html(text);
    }

</script>
</body>
</html>
