<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Details</title>
</head>
<body>

<center><h1><b>FLIGHT DETAILS</b></h1>
<br><br><br>
	<c:choose>
		<c:when test="${flights.isEmpty()}">
			<p>Sorry, no flights available according to search criteria.</p>
			<a href="/home.jsp/">Go back</a>
		</c:when>
		<c:otherwise>
	<table style="border:1px solid black;">
				<tr style="text-align:center; width:100%; margin: 0px auto;">
					<th>Flight Number</th>
					<th>Name</th>
					<th>Price</th>
					<th>Source City</th>
					<th>Destination City</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Total Seats</th>
					<th>Booked Seats</th>
					<th>Seat Availability</th>
					<th>Travel Date</th>
					<th>Class</th>
				</tr>
				<c:forEach var="flight" items="${flightList}">
					<tr style="text-align:center; width:100%; margin: 0px auto;">
						<td><a href= "register.jsp?flightNumber=${flight.number}&date=${flight.date}">${flight.number}</a></td>
						<td>${flight.name}</td>
						<td>${flight.price}</td>	
						<td>${flight.source}</td>
						<td>${flight.destination}</td>
						<td>${flight.sourceTime}</td>
						<td>${flight.destinationTime}</td>
						<td>${flight.totalSeats}</td>
						<td>${flight.bookedSeats}</td>
						<td>${flight.seatAvailable}</td>
						<td>${flight.date}</td>
						<td>${flight.classType}</td>
						
					</tr>
				</c:forEach>
			</table>
				</c:otherwise>
	</c:choose>
	</center>
</body>

</html>