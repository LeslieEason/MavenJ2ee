<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 13:09
  To change this template use File | Settings | File Templates.
  表示数据只可以在一次请求中使用，请求结束后回收数据
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>requestContext</title>
</head>
<body>

<%
    request.setAttribute("name","gareen");
%>
<%=request.getAttribute("name")%>
<%--可以使用pageContext达到同样的效果--%>
<%--<%--%>
<%--    pageContext.setAttribute("name","gareen",pageContext.REQUEST_SCOPE);--%>
<%--    pageContext.getAttribute("name",pageContext.REQUEST_SCOPE);--%>
<%--%>--%>
<jsp:forward page="getContext.jsp"/>
<%--<%response.sendRedirect("getContext.jsp");%>--%>

</body>
</html>
