<%@ page import="models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 27.01.2020
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="views/head.jsp"%>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    out.print(user.getName());
%>

</body>
</html>
