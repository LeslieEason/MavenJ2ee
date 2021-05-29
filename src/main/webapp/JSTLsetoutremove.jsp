<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 27915
  Date: 2021/5/29
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>JSTLsetoutremove</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--用于fn标签--%>


<c:set var="name" value="${'gareen'}" scope="request" />

通过标签获取name: <c:out value="${name}" /> <br>

<c:remove var="name" scope="request" /> <br>

通过标签获取name: <c:out value="${name}" /> <br>

<c:set var="hp" value="${10}" scope="request"/>

<c:if test="${hp<5}">
    <p>这个英雄要挂了</p>
</c:if>

<c:if test="${!(hp<5)}">
    <p>他觉得自己还可以抢救一下</p>
</c:if>
<%
    Date now = new Date();
    pageContext.setAttribute("now",now);
    pageContext.setAttribute("weapon", null);
    pageContext.setAttribute("lastwords", "");
    pageContext.setAttribute("items", new ArrayList());

    List<String> heros = new ArrayList<String>();
    heros.add("塔姆");
    heros.add("艾克");
    heros.add("巴德");
    heros.add("雷克赛");
    heros.add("卡莉丝塔");
    request.setAttribute("heros",heros);

%>

<c:if test="${empty weapon}">
    <p>没有装备武器</p>
</c:if>
<c:if test="${empty lastwords}">
    <p>没有遗言</p>
</c:if>
<c:if test="${empty items}">
    <p>没有物品</p>
</c:if>

<p>choose来代替else</p>
<c:set var="hp" value="${3}" scope="request" />
<c:choose>
    <c:when test="${hp<5}">
        <p>这个英雄要挂了</p>
    </c:when>
    <c:otherwise>
        <p>这个英雄觉得自己还可以再抢救抢救</p>
    </c:otherwise>
</c:choose>
<br>


<p>使用jsp中的for循环来遍历List</p>
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>编号</td>
        <td>英雄</td>
    </tr>
    <%
        int i =0;
        for (String hero : heros) {
            i++;
    %>

    <tr>
        <td><%=i%></td>
        <td><%=hero%></td>
    </tr>

    <%}%>

</table>
<br>

<p>使用JSTL中的c:forEach 循环来遍历List</p>
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>编号</td>
        <td>英雄</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td><c:out value="${st.count}" /></td>
            <td><c:out value="${hero}" /></td>
        </tr>
    </c:forEach>
</table>
<br>

<p>使用forTokens分割字符串</p>
<c:set var="heros" value="塔姆,艾克;巴德|雷克赛!卡莉丝塔" />
<c:forTokens items="${heros}" delims=":;|!" var="hero">
    <c:out value="${hero}" /> <br />
</c:forTokens>
<br>

<p>使用fmt:formatNumber格式化数字</p>
<c:set var="money" value="888.8" />
<c:set var="pi" value="3.1415926" />
最少两个小数点:
<fmt:formatNumber type="number" value="${money}" minFractionDigits="2"/>
<br>
最多两个小数点:
<fmt:formatNumber type="number" value="${pi}" maxFractionDigits="2" />
<br>

<p>fmt:formatDate格式化日期</p>
完整日期: <fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br>
完整时间: <fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br>
常见格式: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>


</body>
</html>
