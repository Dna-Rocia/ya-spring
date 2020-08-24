<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/24
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>file upload page</title>
</head>
<body>

    <div class="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file"/>
            <input type="submit" value="上传"/>
        </form>
    </div>


</body>
</html>
