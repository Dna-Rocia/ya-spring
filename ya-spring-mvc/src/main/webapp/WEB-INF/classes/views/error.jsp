<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta  http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>@ControllerAdvice Demo</title>
</head>
<body>
<%-- 错误取值示例一：${errMsg} --%>
<%-- 错误取值示例二：errMsg=<%=request.getParameter("errMsg")%>--%>

<%=request.getAttribute("errMsg")%>
</body>
</html>
