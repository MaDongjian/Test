<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/26
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
</head>
<body>
  <h3>添加学生信息</h3>
 <br>
  <form id="rrr" >
 <table>
     <td>学生姓名：<input name="stuname"></td>
     <td>学生年龄:<input name="stuage"></td>
     <td>学生性别:<input name="stusex"></td>
     <td>家长姓名:<input name="jzname"></td>
     <td>家长电话:<input name="jztel"></td>
     <td><input type="button" onclick="insertss()"></td>
 </table>
  </form>
</body>
<script>

    function insertss(){
        $.ajax({
            url:"${pageContext.request.contextPath}/insertSj",
            data:$("#rrr").serialize(),//表单序列化提交
            type:"post",
            success:function(data){
                alert("cg")
                window.location.href = '${pageContext.request.contextPath}/jsps/xixi.jsp';
            }
        })
    }
</script>
</html>
