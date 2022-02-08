<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/4
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="inset">
    <div class="login-head">
        <h1>用户登录</h1>
        <div class="alert-close"></div>
    </div>

    <form>
        <ul>
            <li><input type="text" class="text" value="用户名" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '用户名';}" id="userName" name="userName"><a href="#" class=" icon user"></a></li>
            <li><input type="password" value="" id="password" name="password"/> <a href="#" class="icon lock"></a></li>
        </ul>

        <div class="submit">
            <input type="button" onclick="sendForm()" value="登录" >
            <span style="display: block;height: 30px;"><a href="/jsps/register.jsp" class="user_regist">免费注册</a></span>
            <div class="clear">  </div>
        </div>
    </form>
</div>

</body>
<script>
    function sendForm() {

        var userName=$("#userName").val();
        var password=$("#password").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/login/Loging",
            dataType:"json",
            type:"post",
            data:{userName:userName,
                password:password},
            success:function(data){

                if(data){
                    location.href="${pageContext.request.contextPath}/jsps/left.jsp";
                }else{
                    alert("失败")
                }
            }
        })


    }
</script>
</html>
