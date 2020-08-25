<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/25
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>接收服务端推送随机消息示例</title>
</head>
<body>

<div id="msgFromPush">

</div>

<script type="text/javascript" src="<c:url value="../../assets/js/jquery-3.5.1.js"/>"></script>
<script type="text/javascript">

    if (!!window.EventSource){//EventSource是SSE的客户端。只有在新版本的浏览器才会有
        var source = new EventSource('push');
        debugger
        s='';
        //添加SSE客户端监听端口
        source.addEventListener('message',function (e) {
            s+=e.data+"<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open',function (e) {
            console.log("连接打开");
        },false);

        source.addEventListener('error',function (e) {
            //readyState -  XMLHttpRequest对象属性
            /*
                0：初始化，XMLHttpRequest对象还没有完成初始化
                1：载入，XMLHttpRequest对象开始发送请求
                2：载入完成，XMLHttpRequest对象的请求发送完成
                3：解析，XMLHttpRequest对象开始读取服务器的响应
                4：完成，XMLHttpRequest对象读取服务器响应结束
             */
            if (e.readyState === EventSource.CLOSED){
                console.log("连接关闭");
            }else {
                console.log("e.readyState:"+e.readyState);
            }
        },false);

    }else {
        console.log("您的浏览器不支持SSE")
    }
</script>
</body>
</html>
