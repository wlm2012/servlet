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
        <h1>文章列表</h1><br>
        <table class="table">
            <tbody>
            <c:forEach items="${articleList}" var="article">
                <div  class="list-group-item">
                    <h4><a href="/OneArticle?id=${article.id}">${article.title}</a></h4>
                    <br/>
                    <span>阅读次数: ${article.visited}</span>
                    <br/>
                    <span>${article.article}</span>
                    <br/>
                    <a href="/OneArticle?id=${article.id}">阅读全文</a>
                </div>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>