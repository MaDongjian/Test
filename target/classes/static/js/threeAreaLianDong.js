
//加载某市下所有的县数据
function loadAllAreaByCity(pid) {
    $.ajax({
        url:"/findAreaByParentId",
        type:"post",
        data:{"parentId":pid},
        dataType:"json",
        success:function (data) {
            if(null!=data && data.length>0){
                var str="";
                for(var i=0;i<data.length;i++){
                    str+="<option value='"+data[i].id+"'>"+data[i].className+"</option>";
                }
                $("#qu").html(str);
            }
        },error:function () {
            alert("加载市数据失败！");
        }
    })
}
//加载某省下所有的市数据
function loadAllCityByProvince(pid) {
    $.ajax({
        url:"/findAreaByParentId",
        type:"post",
        data:{"parentId":pid},
        dataType:"json",
        success:function (data) {
            if(null!=data && data.length>0){
                var str="";
                for(var i=0;i<data.length;i++){
                    str+="<option value='"+data[i].id+"'>"+data[i].className+"</option>";
                }
                $("#shi").html(str);
            }
        },error:function () {
            alert("加载市数据失败！");
        }
    })
}
//加载所有的省数据，pid=1
function loadAllAearByParentId(pid) {
    $.ajax({
        url:"/findAreaByParentId",
        type:"post",
        data:{"parentId":pid},
        dataType:"json",
        success:function (data) {
            if(null!=data && data.length>0){
                var str="";
                for(var i=0;i<data.length;i++){
                    str+="<option value='"+data[i].id+"'>"+data[i].className+"</option>";
                }
                $("#sheng").html(str);
            }
        },error:function () {
            alert("加载省数据失败！");
        }
    })
}
//用于省市县的数据回显
function loadThreeAreaByAreaId(areaId) {
    $.ajax({
        url:"/loadThreeAreaByAreaId",
        type:"post",
        data:{"areaId":areaId},
        dataType:"json",
        success:function (data) {
            if(null!=data.provinceList && data.provinceList.length>0){
                var str="";var temp="";
                for(var i=0;i<data.provinceList.length;i++){
                    temp=data.provinceList[i];
                    if(temp.id==data.provinceId){
                        str+="<option value='"+temp.id+"' selected='selected'>"+temp.className+"</option>";
                    }else{
                        str+="<option value='"+temp.id+"'>"+temp.className+"</option>";
                    }
                }
                $("#sheng").html(str);
            }
            if(null!=data.cityList && data.cityList.length>0){
                var str="";var temp="";
                for(var i=0;i<data.cityList.length;i++){
                    temp=data.cityList[i];
                    if(temp.id==data.cityId){
                        str+="<option value='"+temp.id+"' selected='selected'>"+temp.className+"</option>";
                    }else{
                        str+="<option value='"+temp.id+"'>"+temp.className+"</option>";
                    }
                }
                $("#shi").html(str);
            }
            if(null!=data.areaList && data.areaList.length>0){
                var str="";var temp="";
                for(var i=0;i<data.areaList.length;i++){
                    temp=data.areaList[i];
                    if(temp.id==data.areaId){
                        str+="<option value='"+temp.id+"' selected='selected'>"+temp.className+"</option>";
                    }else{
                        str+="<option value='"+temp.id+"'>"+temp.className+"</option>";
                    }
                }
                $("#qu").html(str);
            }
        },error:function () {
            console.log("加载当前用户的省市县信息失败！");
        }
    })
}