<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
</head>
<body>
<%@page contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" import="java.util.*"%>
<h2>你好 JSP</h2>
<br>
<%=new String("我是你爹")%>
<%=new Date().toLocaleString()%>
<%--<% System.out.println("你大爷的");%>--%>
<%! String a="我操";%>
<%=a%>

<%
    List <String> words=new ArrayList<>();
    words.add("today");
    words.add("is");
    words.add("a");
    words.add("great");
    words.add("day");
%>
<%--一种循环遍历的方式--%>
<table width="200px" align="center" border="1" cellspacing="0">
    <%for (String word:words){%>
    <tr>
        <td><%=word%></td>
    </tr>
    <%}%>

</table>
<%--两种包含页面的方式，指令-动作，动作方式需要传参--%>
<%--<%@include file="footer.jsp"%>--%>
<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2021"/>
</jsp:include>
<input type="button" value="跳转" id="goto">
</body>
<script>
    $(function (){
        goto.onclick=function()
        {
//              两种跳转的方式，与Servlet一致
<%--            <jsp:forward page="footer.jsp"></jsp:forward>--%>
<%--            <%request.getRequestDispatcher("footer.jsp").forward(request,response);%>--%>
        }
    })
</script>
</html>
