<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>
<body style="padding-top: 20px;">
<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <h1>学生列表</h1><br>
        <table class="table">
            <thead>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>操作</td>
            </thead>
            <tbody>
            <c:forEach items="${articleList}" var="article">
                <tr>
                    <td>${article.xuehao}</td>
                    <td>${article.xingming}</td>
                    <td>
                        <c:choose>
                            <c:when test="${article.xingbie == 0}">女</c:when>
                            <c:when test="${article.xingbie == 1}">男</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <a class="btn btn-info btn-sm" href="/updatestudent?xuehao=${article.xuehao}">更 新</a>
                        <a class="btn btn-danger btn-sm" href="/deletestudent?xuehao=${article.xuehao}">删 除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="btn btn-success" onclick="window.location.href='/add'">添加学生</button>
    </div>
</div>
</body>
</html>