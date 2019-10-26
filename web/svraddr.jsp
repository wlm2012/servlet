<%--
  Created by IntelliJ IDEA.
  User: lenovo2
  Date: 2019/10/26
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="v6"  method="post">
    服务名：<input type="text" name="svrName" ><br>
    服务器：
    <input type="radio" num="num" value="5">5
    <input type="radio" num="num" value="6">6
    <input type="radio" num="num" value="7">7<br>
    输入报文：
    <input type="text" name="body">
    <input type="submit" value="提交">
</form>
</body>
</html>
