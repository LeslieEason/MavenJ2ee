<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>getSession</title>
</head>
<body>
<%
    String name=(String)session.getAttribute("name");

%>
session中的name: <%=name%>
</body>
</html>
