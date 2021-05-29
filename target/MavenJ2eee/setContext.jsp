<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 13:04
  To change this template use File | Settings | File Templates.
  演示JSP的作用域pageContext
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--只可以在本页面内通过pageContext.getAttribute来获取--%>
<html>
<head>
    <title>setContext</title>
</head>
<body>
    <%
        pageContext.setAttribute("name","garren");
    %>
    <%=pageContext.getAttribute("name")

    %>
</body>
</html>
