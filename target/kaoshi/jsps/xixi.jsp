
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<form id="www" method="post">
<table>
    <tr>
        <td>学生姓名：</td>
        <td><input name="stuname"></td>
        <td>家长姓名：</td>
        <td><input name="jzname"></td>
        <td> <input type="button" value="查询" id="find"></td>
    </tr>
    <tr>
        <a onclick="insertSj()">添加</a>
    </tr>
</table>
</form>
<table id="t1">

</table>
<tr>
    <td colspan="15">
       <%-- 共<span id="pages"></span>页 &nbsp;&nbsp;<span id="pageNum"></span>/<span id="pages2"></span>
        &nbsp;&nbsp;每页<span id="pageSize"></span>条 &nbsp;&nbsp;共<span id="total"></span>条&nbsp;&nbsp;
        <span id="pm"></span>\ <span id="to2"></span>
        <a href="javascript:void(0)" onclick="smfy(1);">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
        <a href="javascript:void(0)" onclick="up()">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <radio><button onclick="smfy(2)">2</button></radio>
        <radio><button onclick="smfy(3)">3</button></radio>
        <a href="javascript:void(0)" onclick="next()" >下一页</a>
      <%--  <a href="javascript:void(0)" onclick="weiye()" >尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
          <input type="hidden" id="xs" onmouseout="tzym('xs')">

    </td>
</tr>
</body>
<script>
    $(function () {
        var pages;//共多少页
        var pm;//当前是第几页
        var wy;//尾页
        var xs;//显示条数
        tzym(1);

    });

    //下一页 判断
    function next() {
        //如果当前页小于总页数  就可以点击下一页进行查询
        if(pm<pages){
            tzym(pm+1);
        }
    }
    //上一页
    function up() {
        //只要当前页 不小于1就可以点击上一页
        if(pm>1){
            tzym(pm-1);
        }
    }
    //尾页
    function weiye() {
        //直接把总页数 带参去查询 就是尾页内容
        tzym(pages);
    }

    //点击 下一页和首页时的操作
    function tzym(obj) {

        var url1 = "${pageContext.request.contextPath}/findSj?page="+obj;
        //当每页条数改变时
        if(obj=='xs'){
            xs = $("#xs").val();
            url1 = "${pageContext.request.contextPath}/findSj?pageSize="+xs;

        }

        if(xs>0 && obj!='xs'){
            url1 = "${pageContext.request.contextPath}/findSj?page="+obj+"&pageSize="+$("#xs").val();
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: url1,
            data:$("#form1").serialize(),
            success: function (data) {
                $("#t1").html("");
                var s = " <tr> <td>编号</td> <td>学生姓名</td> <td>学生年龄</td> <td>学生性别</td> <td>家长姓名</td> <td>家长电话</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    s+=" <tr> <td>"+data.list[i].id+"</td> <td>"+data.list[i].stuname+"</td> <td>"+data.list[i].stuage+"</td> <td></td> data.list[i].stusex<td>"+data.list[i].jzname+"</td> <td>"+data.list[i].jztel+"</td> </tr>";
                }
                $(s).appendTo("#t1");
                pages =  data.pages;
                pm = data.pageNum;
                $("#pages").text(data.pages);
                $("#pagesize").text(data.pageSize);
                $("#total").text(data.total);
                $("#pm").text(data.pageNum);
                $("#to2").text(data.pages);

            }
        });
    }
    //点击跳转
    function smfy(page){
        fenye(page);
    }
    //分页的函数事假
    function fenye(page){
        $.ajax({
            url:"${pageContext.request.contextPath}/findSj",
            data:{page:page},
            dataType:"json",
            type:"post",
            success:function(data){
                $("#t1").html("");
                var s = " <tr> <td>编号</td> <td>学生姓名</td> <td>学生年龄</td> <td>学生性别</td> <td>家长姓名</td> <td>家长电话</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    alert("313"+data.list[i].stusex)
                        s+=" <tr> <td>"+data.list[i].id+"</td> <td>"+data.list[i].stuname+"</td> <td>"+data.list[i].stuage+"</td> <td></td> data.list[i].stusex<td>"+data.list[i].jzname+"</td> <td>"+data.list[i].jztel+"</td> </tr>";
                }
                $(s).appendTo("#t1");
                pages =  data.pages;
                pm = data.pageNum;
                $("#pages").text(data.pages);
                $("#pages2").text(data.pages);
                $("#pageNum").text(data.pageNum);
                $("#pageSize").text(data.pageSize);
                $("#total").text(data.total);
                $("#pageStart").text(data.pageStart);
                $("#pageSize").text(data.pageSize);

            }
        })
    }

    //点击查询就行模糊
    $("#find").click(function(){

        $.ajax({
            url:"${pageContext.request.contextPath}/findSj",
            data:$("#www").serialize(),//表单序列化提交
            type:"post",
            success:function(data){

                $("#t1").html("");
                var s = " <tr> <td>编号</td> <td>学生姓名</td> <td>学生年龄</td> <td>学生性别</td> <td>家长姓名</td> <td>家长电话</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    alert("313"+data.list[i].stusex)
                    s+=" <tr> <td>"+data.list[i].id+"</td> <td>"+data.list[i].stuname+"</td> <td>"+data.list[i].stuage+"</td> <td>"+ data.list[i].stusex+"</td> <td>"+data.list[i].jzname+"</td> <td>"+data.list[i].jztel+"</td> </tr>";
                }

                $(s).appendTo("#t1");
            }

        })

    })
    //点击添加
    function insertSj(){
        window.location.href = '${pageContext.request.contextPath}/jsps/add.jsp';
    }
</script>
</html>
