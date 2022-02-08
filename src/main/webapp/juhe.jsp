<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/4
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<hr style="width:20%;text-align: left;">
<br/>

<div id="weatherDiv" >
    <form id="weatherForms" style="">
        <input id="weatherDescriptions" name="weatherDescriptions" value="">
        <input id="windPowers" name="windPowers" value="">
        <input id="humiditys" name="humiditys" value="">
        <input id="temperatures" name="temperatures" value="">
        <input id="windDirections" name="windDirections" value="">
        <input id="weathers" name="weathers" value="">
        <input id="citys" name="citys" value="">
        <input id="dateYs" name="dateYs" value="">
        <input id="winds" name="winds" value="">
    </form>
    <button onclick="getWeathers()">获取天气数据</button>
</div>
</body>
<script>
    //定时查询天气
    setInterval(function(){
        getWeathers()
    },5*60*1000);

    //获取天气数据
    function getWeathers() {
        $.ajax({
            url:"http://v.juhe.cn/weather/index?cityname=%E5%8C%97%E4%BA%AC&dtype=json&format=2&key=08bdb39ca01c375f3c76d12ed22b57e6",
            type:"get",
            dataType:"jsonp",
            success:function(data){
                var sk = data.result.sk;
                var today = data.result.today;
                var futur = data.result.future;
                $("#windDirections").val(sk.wind_direction);
                $("#windPowers").val(sk.wind_strength);
                $("#humiditys").val(sk.humidity);
                $("#temperatures").val(today.temperature);
                $("#weathers").val(today.weather);
                $("#weatherDescriptions").val(today.weather);
                $("#citys").val(today.city);
                $("#dateYs").val(today.date_y);
                $("#winds").val(today.week);
                insertWeather();
            },error:function(){
                alert("getWeather执行异常");
            }
        });
    }
    function insertWeather() {
        $.ajax({
            url:"/insertWeather",
            type:"get",
            dataType:"json",
            data:$("#weatherForms").serialize(),
            processData: false,
            contentType: false,
            success:function(data){
               alert("成功")
            }
        });
    }
</script>
</html>
