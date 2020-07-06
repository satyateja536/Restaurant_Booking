<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<div align="center">
<form action="ViewRestaurants" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<select name='city'>
    <option value="${selected}" selected>${selected}</option>
    <c:forEach items="${cities}" var="city">        
            <option value="${city}">${city}</option>        
    </c:forEach>
</select>
<button type="submit">Search Restaurants</button>
</form>
<br><br><br>
<form action="UserHome" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">Go To Home</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button></form>
</div>
</body>
</html>