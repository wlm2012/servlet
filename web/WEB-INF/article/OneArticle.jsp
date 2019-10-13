<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <div style="text-align: left;">
        <title>品葱</title>
    </div>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
</head>
<body style="padding-top: 20px;">
<div class="container">
    <div style="text-align: center;" class="col-md-8 col-md-offset-2">
        <h1>问题列表</h1><br>
        <table class="table">
            <tbody>
            <c:forEach items="${articleList}" var="article">
                <div  class="list-group-item">
                    <h4><a href="/Blog/ArticleServlet?id=${article.id}">${article.title}</a></h4>
                    <br/>
                    <span>${article.time}&nbsp;&nbsp;|</span>
                    <a href="/Blog/SortServlet?get=${article.sort}">${article.sort}</a>&nbsp;&nbsp;|
                    <span>阅读次数: ${article.visit}</span>
                    <br/><br/>
                    <span>${article.content}</span>
                    <br/><br/><br/>
                    <a href="/Blog/ArticleServlet?id=${article.id}">阅读全文</a>
                    <br/>
                </div>
            </c:forEach>
            </tbody>
        </table>
        <button class="btn btn-success" onclick="window.location.href='/add'">添加学生</button>
    </div>
</div>
</body>
</html>