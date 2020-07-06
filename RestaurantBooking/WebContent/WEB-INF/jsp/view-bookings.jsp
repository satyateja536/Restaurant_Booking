<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.restaurant.dto.BookingDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of Bookings: </h2>
<table border=1 style="width:50%;text-align:left;background-color:yellow;">
<tr>
<th>Booking ID</th>
<th>Restaurant Name</th>
<th>Number of Persons</th>
<th>Booking Type</th>
<th>Booking Date</th>
</tr>
  <c:forEach items="${bookings}" var="booking">
    <tr>
      <td><c:out value="${booking.bookingID}" /></td>
      <td><c:out value="${booking.restaurantName}" /></td>
      <td><c:out value="${booking.numberOfPersons}" /></td>
      <td><c:out value="${booking.bookingType}" /></td>
      <td><c:out value="${booking.bookingDate}" /></td>
      <td>
      <form action="CancelBooking" method="post"> 
      	<input type="text" name="userID" value="${userID}" hidden="true">
      	<input type="text" name="username" value="${username}" hidden="true">
      	<input type="text" name="bookingID" value="${booking.bookingID}" hidden="true">
      	<input type="text" name="restaurantName" value="${booking.restaurantName}" hidden="true">
      	<button type="submit">Cancel Booking</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>

<form action="ViewCities" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">Find More Restaurants</button><br><br>
</form>
<form action="UserHome" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">Go To Home</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button></form>
<br><br>
<p>${result}</p>
</body>
</html>