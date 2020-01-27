<%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 27.01.2020
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="/main" method="post">
    <input name="name" type="text">
    <input name="password" type="password">
    <button>sign in</button>
  </form>
<%
  String error = request.getParameter("error");
  if (error!=null){
    if(error.equals("1")){
      out.write("offline");
    }
  }
%>
  </body>
</html>
