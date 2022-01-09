<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

<h1><b>Thank you for booking on FlyAway !!</b></h1>
<br><br><br>

<form onload="confirmServlet">
</form>
<table style="border:1px solid black; align:left;">
				<tr style="text-align:center; width:100%; margin: 0px auto;">
					<th>Username</th>
					<th>Customer Name</th>
					<th>Age</th>
					<th>Contact</th>
					<th>Flight No.</th>
					<th>Travel Date</th>
				</tr>
				<c:forEach var="seat" items="${seatList}">
				
					<tr style="text-align:center; width:100%; margin: 0px auto;">
						<td>${seat.username}</td>
						<td>${seat.fullName}</td>
						<td>${seat.age}</td>	
						<td>${seat.contact}</td>
						<td>${seat.flightNo}</td>
						<td>${seat.travelDate}</td>
					</tr>
					</c:forEach>
				
</table>
<br> <br>
<a href="home.jsp"><h2>Go back home</h2></a>	
</center>
</body>
</html>