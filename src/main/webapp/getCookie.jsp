<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>getCookie</title>
</head>
<body>
<%
    Cookie[]cookies=request.getCookies();
    if(cookies!=null)
    {
        for(int d=0;d<=cookies.length-1;d++)
        {
            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
        }
    }
%>

</body>
</html>
