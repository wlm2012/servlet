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
    <div style="text-align: center;" class="col-md-8 col-md-offset-2">
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
                    <td>${article.id}</td>
                    <td>${article.user_id}</td>
                    <td>${article.article}</td>
                    <td>${article.title}</td>
                    <td>${article.update_time}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="btn btn-success" onclick="window.location.href='/add'">添加学生</button>
    </div>
</div>
</body>
</html>