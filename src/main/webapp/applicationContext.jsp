<%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 14:22
  To change this template use File | Settings | File Templates.
  application是全局的方式，所有的用户使用同一数据，其是ServletContext接口的实例
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>applicationContext</title>
</head>
<body>
    <%
        application.setAttribute("name","gay");
        System. out.println(application==request.getServletContext());

        //同样可以使用pageContext代替
//        pageContext.setAttribute("name","gareen",pageContext.APPLICATION_SCOPE);
//        pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE);
    %>

<jsp:forward page="getContext.jsp"></jsp:forward>
</body>
</html>
