<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.restaurant.dto.RestaurantDTO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of Restaurants: </h2>
<table border=1 style="width:50%;text-align:left;background-color:yellow;">
<tr>
<th>Restaurant Name</th>
<th>Address</th>
<th>City</th>
<th>Cost Per Two</th>
<th>Rating</th>
</tr>
  <c:forEach items="${restaurants}" var="restaurant">
    <tr>
      <td><c:out value="${restaurant.restaurantName}" /></td>
      <td><c:out value="${restaurant.address}" /></td>
      <td><c:out value="${restaurant.city}" /></td>
      <td><c:out value="${restaurant.costPerTwo}" /></td>
      <td><c:out value="${restaurant.rating}" /></td>
      <td>
      <form action="NewBookingPage"> 
      	<input type="text" name="userID" value="${userID}" hidden="true">
      	<input type="text" name="username" value="${username}" hidden="true">
      	<input type="text" name="restaurantID" value="${restaurant.restaurantID}" hidden="true">
      	<input type="text" name="restaurantName" value="${restaurant.restaurantName}" hidden="true">
      	<button type="submit">Book</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>

<form action="ViewCities" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">Find More Restaurants</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button></form>
</body>
</html>