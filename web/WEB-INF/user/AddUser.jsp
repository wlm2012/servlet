<%--
  Created by IntelliJ IDEA.
  User: wlm
  Date: 2019/10/19
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form>
    用户名：<input type="text" name="name"><br>
    密  码：<input type="password" name="password"><br>
    性  别：
    <input type="radio" name="sex" value="0">男
    <input type="radio" name="sex" value="1">女
    <input type="radio" name="sex" value="2">保密<br>
    <input type="submit" value="注册">
</form>

</body>
</html>
