<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="jsp.jsptest" %>
<html>
<body>
<h2>Hello World!she2222</h2>
<%
    System.out.println("Ip " + request);
    String s = new jsptest().test();
%>
<%=s %>
</body>
</html>
