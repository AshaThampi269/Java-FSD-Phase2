<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
</head>
<body>
<center>
<h1><b>PAYMENT GATEWAY</b></h1>
</center>
<form onload="paymentServlet" action="confirmServlet" method="POST">

<table style="border:1px solid black; align:left;">
				<tr style="text-align:center; width:100%; margin: 0px auto;">
					<th>Flight Name</th>
					<th>Flight No.</th>
					<th>Travel Date</th>
					<th>Source City</th>
					<th>Destination City</th>
					<th>No. of Seats</th>
					<th>Price</th>
				</tr>
				<c:forEach var="flight" items="${flightList}">
				
					<tr style="text-align:center; width:100%; margin: 0px auto;">
						<td>${flight.number}</td>
						<td>${flight.name}</td>
						<td>${flight.date}</td>	
						<td>${flight.source}</td>
						<td>${flight.destination}</td>
						
						
						<d:forEach var="seat" items="${seatList}">
						<td>${seat.passenger}</td>
						<td>${seat.passenger * flight.price}</td>
						</d:forEach>
					</tr>
					</c:forEach>
					
				
</table>
			
<table align="right">
<tr>
<td><img src="img/qr.png"  width="300" height="300"> <br></td>
</tr>
<tr>
<td align="center"> <h2>Scan QR to pay</h2></td>
</tr>
<tr>
<td align="center"> <input type="submit" value="Done" style="font-size:20pt; width:86pt; background:limegreen"/> </td>
</tr>

</table>
</form>
</body>

</html>