<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.restaurant.dto.UserDTO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of Users: </h2>
<table border=1 style="width:50%;text-align:left;background-color:yellow;">
<tr>
<th>User ID</th>
<th>User Name</th>
</tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.userID}" /></td>
      <td><c:out value="${user.userName}" /></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>