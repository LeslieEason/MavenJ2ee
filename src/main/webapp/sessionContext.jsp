<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 14:16
  To change this template use File | Settings | File Templates.
  使用Session来进行页面间传递数据，缺点是无法在不同用户之间传递数据
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>sessionContext</title>
</head>
<body>
  <%
    session.setAttribute("name","gay");
  %>
  <%--  通过pageContext达到同样的效果--%>
<%--<%--%>
<%--    pageContext.setAttribute("name","gay",pageContext.SESSION_SCOPE);--%>
<%--    pageContext.getAttribute("name",pageContext.SESSION_SCOPE);--%>
<%--%>--%>
<jsp:forward page="getContext.jsp"/>


</body>
</html>
