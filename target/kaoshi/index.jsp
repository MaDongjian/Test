<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
</head>
<body>

<button id="search">天气查询</button>
<input id="city" type="text" value="北京">
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

</div>
</body>
</html>
<script>

        /*
        * 1.输入城市名
        * 2，点击的时候发送请求
        * 3.响应成功渲染页面
        * */

       /* $('#search').on('click',function(){

            $citycode=urlencode("北京");

            url='http://v.juhe.cn/weather/index?format=2&cityname='+$citycode+'&key=08bdb39ca01c375f3c76d12ed22b57e6';
            $.ajax({url: url,
                dataType: "jsonp",
                type:"get",

                success:function(data){
                    var sk = data.result.sk;
                    var today = data.result.today;
                    var futur = data.result.future;
                    var fut = "日期温度天气风向";

                    $("#windDirections").val(sk.wind_direction);
                    $("#windPowers").val(sk.wind_strength);
                    $("#humiditys").val(sk.humidity);
                    $("#temperatures").val(today.temperature);
                    $("#weathers").val(today.weather);
                    $("#weatherDescriptions").val(today.weather);
                    $("#citys").val(today.city);
                    $("#dateYs").val(today.date_y);
                    $("#winds").val(today.week);
                }
            });

        });*/

       $('#search').on('click',function(){


            $citycode=urlencode("北京");


           url='http://v.juhe.cn/weather/index?format=2&cityname='+$citycode+'&key=08bdb39ca01c375f3c76d12ed22b57e6';



           url='http://v.juhe.cn/weather/index?format=2&cityname='+$citycode+'&key=c82727e986a4f6cfc6ba1984f1f9183a';


            $.ajax({url: url,
                dataType: "jsonp",
                type:"get",

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

                }     });

        });
        function urlencode (str) {
            str = (str + '').toString();

            return encodeURIComponent(str).replace(/!/g, '%21').replace(/'/g, '%27').replace(/\(/g, '%28').
            replace(/\)/g, '%29').replace(/\*/g, '%2A').replace(/%20/g, '+');
        }

</script>