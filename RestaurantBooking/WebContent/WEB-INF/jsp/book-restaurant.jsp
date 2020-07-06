<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NewBooking" method="post">
<input type="text" name="userID" value="${userID}" hidden="true">
<input type="text" name="username" value="${username}" hidden="true">
<input type="text" name="restaurantID" value="${restaurantID}" hidden="true">
<input type="text" name="restaurantName" value="${restaurantName}" hidden="true">
UserName: ${username} <br> <br>
Restaurant: ${restaurantName} <br> <br>
Number of Persons: 
<select name="numberOfPersons">
<option value="${selectedNo}" selected>${selectedNo}</option>
  <option value="2">2</option>
  <option value="4">4</option>
  <option value="6">6</option>
  <option value="8">8</option>
</select>
<br> <br>
Booking Date: 
<select name="bookingDate">
<option value="2019-05-15" selected>2019-05-15</option>
  <option value="2019-05-15">2019-05-15</option>
  <option value="2019-05-16">2019-05-16</option>
  <option value="2019-05-17">2019-05-17</option>
  <option value="2019-05-18">2019-05-18</option>
  <option value="2019-05-19">2019-05-19</option>
  <option value="2019-05-20">2019-05-20</option>
  <option value="2019-05-21">2019-05-21</option>
  <option value="2019-05-22">2019-05-22</option>
  <option value="2019-05-23">2019-05-23</option>
</select>
<br> <br>
Booking Type:
<select name="bookingType">
<option value="${selectedType}" selected>${selectedType}</option>
  <option value="Lunch">Lunch</option>
  <option value="Dinner">Dinner</option>  
</select>
<br> <br>
<button type="submit">Book Restaurant</button>
</form>
<br><br>
<form action="LoginPage" method="post">
<button type="submit">Logout</button>
</form>
</body>
</html>