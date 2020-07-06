<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${username} !!!
<br><br>
<form action="UserDetails" method="post">
<input type="text" hidden="true" name="username" value="${username}" >
<input type="text" name="userID" value="${userID}" hidden="true">
<br><button type="submit">About me</button><br><br>
</form>
<form action="ShowBookingsPage" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" hidden="true" name="username" value="${username}" >
<button type="submit">My Bookings</button><br><br>
</form>
<form action="ViewCities" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<button type="submit">New Booking</button><br><br>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button>
</form>
<br>
<br>
<br>
<br>
<br>
<p>${result}</p>
</body>
</html>