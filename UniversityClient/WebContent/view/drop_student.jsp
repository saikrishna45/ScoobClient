<%@page import="edu.cmpe273.univserver.beans.StudentCourse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">
    <div class="hero-unit"> 
    <header class="post-title">
    
    <h2 class="entry-title" id="member-title">Dropped Class</h2>
    
    </header>
    
    <hr>
     <%@ include file="Proxy.jsp" %>
    <%
    String drop= session.getAttribute("CourseNumber").toString();
    StudentCourse s=new StudentCourse();
    String mess= proxy.dropCourse((String)session.getAttribute("user"),drop);
    %>
    <p>drop<%=mess %></p>
    
    </div>
    </div>
</body>
</html>