<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/25
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8" content="text/html">
    <title>servlet async support</title>
</head>
<body>

<script type="text/javascript" src="../../assets/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
    //首次请求
    deferred();

    //调用
    function deferred() {
        $.get('defer',function (data) {
            console.log(data);
            //返回后再次请求
            deferred();
        });
    }
</script>
</body>
</html>
