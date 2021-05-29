<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>setSession</title>
</head>
<body>
  <%
    session.setAttribute("name","teemo");
  %>
  <a href="getSession.jsp">跳转到获取session的页面</a><br>
    <a href="<%=response.encodeURL("getSession.jsp")%>">无Cookie使用Session</a>
</body>
</html>
