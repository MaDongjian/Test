
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

    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/table/bootstrap-table.css">
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/table/locale/bootstrap-table-zh-CN.js"></script>
</head>

<body>
   <div>
       <div style="width: 99%;height: 35px;margin: 10px 10px 10px 30px">
           <form id="www" method="post">
           <div style="width: 99%;height: 35px;margin: 10px 10px 10px 30px">
               地区名字：<select id="dname" name="dId">
               <option value="">--请选择--</option>
           </select>
             工资：<select name="eWages" id="eWages">
               <option value="">--请选择--</option>
               <option value="2">升序</option>
               <option value="1">降序</option>
           </select>
             级别：<select id="elevels" name="eLevel">
                 <option value ="">---请选择---</option>
                 <option value ="王者">王者</option>
                 <option value ="黄金">黄金</option>
                 <option value="青铜">青铜</option>
                 <option value="白银">白银</option>
             </select>
             性别：<select id="eSixs" name="eSix">
               <option value ="">---请选择---</option>
               <option value ="1">男</option>
               <option value="2">女</option>
           </select>
                    员工姓名：<input type="text"placeholder="请输入关键字" name="eName" id="deptName"/>
               <input type="button" value="查询" id="find">
           </div>
           </form>
       </div>
       </div>
   <table class="table table-bordered" style="border: 1px solid royalblue;width:99%;text-align: center;margin: 30px 15px 15px 15px" id="t1">

   </table>
   <tr>
       <td colspan="15">
           共<span id="pages"></span>页 &nbsp;&nbsp;<span id="pageNum"></span>/<span id="pages2"></span>
           &nbsp;&nbsp;每页<span id="pageSize"></span>条 &nbsp;&nbsp;共<span id="total"></span>条&nbsp;&nbsp;
           <span id="pm"></span>\ <span id="to2"></span>
           <a href="javascript:void(0)" onclick="smfy(1);">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="javascript:void(0)" onclick="up()">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="javascript:void(0)" onclick="next()" >下一页</a>
           <a href="javascript:void(0)" onclick="weiye()" >尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;

           跳转到第<input type="text" id="tz"/>页&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="smfy('tz')">跳转</button>
           每页显示
           <select id="xs" onmouseout="tzym('xs')">
               <option value="1">1</option>
               <option value="3">3</option>
               <option value="5">5</option>
           </select>
       </select>
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

        var url1 = "${pageContext.request.contextPath}/findEqm?page="+obj;
        //当每页条数改变时
       if(obj=='xs'){
            xs = $("#xs").val();
            url1 = "${pageContext.request.contextPath}/findEqm?pageSize="+xs;

        }

        if(xs>0 && obj!='xs'){
            url1 = "${pageContext.request.contextPath}/findEqm?page="+obj+"&pageSize="+$("#xs").val();
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: url1,
            data:$("#form1").serialize(),
            success: function (data) {
                $("#t1").html("");
                var s = " <tr> <td>id</td> <td>姓名</td> <td>级别</td> <td>性别</td> <td>工资</td> <td>地区名字</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    if(data.list[i].eSix==1){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>男</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }
                    if(data.list[i].eSix==2){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>女</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }

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
    function smfy(){
        var page=$("#tz").val();
        fenye(page);
    }
    //分页的函数事假
    function fenye(page){
        $.ajax({
            url:"/findEqm",
            data:{page:page},
            dataType:"json",
            type:"post",
            success:function(data){
                $("#t1").html("");
                var s = " <tr> <td>id</td> <td>姓名</td> <td>级别</td> <td>性别</td> <td>工资</td> <td>地区名字</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    if(data.list[i].eSix==1){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>男</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }
                    if(data.list[i].eSix==2){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>女</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }

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
　　var page=1;
    //预加载查询下拉框 的地区名
    $(function(){
        fenye(page)
        $.ajax({
            url:"/findDpei",
            data:{},
            dataType:"json",
            type:"post",
            success:function(data){
                for(var i=0;i<data.length;i++){
                    $("#dname").append("<option value='"+data[i].dId+"'>"+data[i].dNmae+"</option>");
                }
            }
        })


    })
    //点击查询就行模糊
    $("#find").click(function(){

        $.ajax({
            url:"/findEqm",
            data:$("#www").serialize(),//表单序列化提交
            type:"post",
            success:function(data){
                $("#t1").html("");
                var s = " <tr> <td>id</td> <td>姓名</td> <td>级别</td> <td>性别</td> <td>工资</td> <td>地区名字</td> </tr>";
                for (var i = 0; i <data.list.length; i++) {
                    if(data.list[i].eSix==1){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>男</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }
                    if(data.list[i].eSix==2){
                        s+=" <tr> <td>"+data.list[i].eId+"</td> <td>"+data.list[i].eName+"</td> <td>"+data.list[i].eLevel+"</td> <td>女</td> <td>"+data.list[i].eWages+"</td> <td>"+data.list[i].dName+"</td> </tr>";
                    }

                }

                $(s).appendTo("#t1");

            }
        })

    })


</script>
</html>
