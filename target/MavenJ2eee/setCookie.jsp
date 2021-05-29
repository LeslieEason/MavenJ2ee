<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>setCookie</title>
</head>
<body>
<%
    Cookie c=new Cookie("name","Gareen");
    c.setMaxAge(60*24*60);//表示Cookie的时常为一小时
    c.setPath("/");
    response.addCookie(c);
%>
<a href="getCookie.jsp">跳转到获取Cookie的页面</a>

</body>
</html>
