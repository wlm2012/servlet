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
    <title>Title</title>
</head>
<body>
<form  action="v6"  method="post">
    <%
    v6 v6= (Entity.v6) request.getAttribute("v6");
    Integer num=v6.getNum();
    String five="";
    String six="";
    String seven="";
    switch (num)
    {
        case 5:
            five="checked";
            break;
        case 6:
            six="checked";
            break;
        case 7:
            seven="checked";
            break;
        default:
            five="checked";
            break;
    }
    %>
    服务名：<input type="text" name="svrName" size="40" value="${v6.svrName}"><br>
    服务器：
    <input type="radio" name="num" value="5" <%=five%>>5
    <input type="radio" name="num" value="6" <%=six%>>6
    <input type="radio" name="num" value="7" <%=seven%>>7<br>
    输入报文：
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    输出报文：<br>
    <textarea rows="20" cols="30" name="body" >${v6.body}</textarea>
    <textarea rows="20" cols="30" name="result" >${v6.body}</textarea><br>
<%--    <input type="text" name="body" value="${v6.body}"><br>--%>
    <input type="submit" value="提交">
</form>
</body>
</html>
