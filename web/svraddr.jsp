<%@ page import="Entity.v6" %>
<%@ page import="javax.persistence.criteria.CriteriaBuilder" %><%--
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
    <title>测试专用postman</title>
</head>
<body>
<div>
    <form action="v6" method="post">
        <%
            v6 v6 = (Entity.v6) request.getAttribute("v6");
            Integer num = v6.getNum();
            String five = "";
            String six = "";
            String seven = "";
            String two = "";
            String zero = "";
            switch (num) {
                case 5:
                    five = "checked";
                    break;
                case 6:
                    six = "checked";
                    break;
                case 7:
                    seven = "checked";
                    break;
                case 23:
                    two = "checked";
                    break;
                case 0:
                    zero = "checked";
                    break;
                default:
                    five = "checked";
                    break;
            }
        %>
        服务名：<input type="text" name="svrName" size="120" value="${v6.svrName}"><br>
        服务器：
        <input type="radio" name="num" value="5" <%=five%>>5
        <input type="radio" name="num" value="6" <%=six%>>6
        <input type="radio" name="num" value="7" <%=seven%>>7
        <input type="radio" name="num" value="23" <%=two%>>23
        <input type="radio" name="num" value="0" <%=zero%>>自定义<br>
        输入报文：
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        输出报文：<br>
        <textarea rows="30" cols="60" name="body">${v6.body}</textarea>
        <textarea rows="30" cols="60" name="result">${v6.result}</textarea>
        <br>
        <%--    <input type="text" name="body" value="${v6.body}"><br>--%>
        <input type="submit" value="提交">
    </form>
</div>
<div>
    <form action="findv6log" method="post">
        <input type="text" name="svrName" size="60">
        <input type="submit" value="提交"><br>
    </form>
</div>
</body>
</html>
