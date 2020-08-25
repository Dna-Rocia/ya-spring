<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta  http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>@ControllerAdvice Demo</title>
</head>
<body>
<%-- 错误取值示例一：${errMsg}，
原因：原因：isELIgnored在jsp2.0版本以上默认true，默认忽略该页面的el表达式；
方案：设置false的时候，该页面才会去计算当前页面的el表达式--%>
<%-- 错误取值示例二：errMsg=<%=request.getParameter("errMsg")%>--%>
<%--可以取出值  <%=request.getAttribute("errMsg")%>--%>
${errMsg}
</body>
</html>
