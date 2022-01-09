<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
Welcome ${user.username } !!
<center>

<h1><b>BOOKING DETAILS</b></h1>
<br>
<a href="logout"><h2 align="right">Logout</h2></a>
<br><br>
<form action="flightDetails" method="POST">

<table style="width:50%; margin: 0px auto;">
  <tr>
    <td><label for="date" style="font-size:16pt;" >Date of Travel:</label></td>
    <td><input type="date" name="travelDate" style="font-size:16pt; width:270px;" /></td>
  </tr>
  
  <tr>
    <td><label for="source" style="font-size:16pt;" >Source:</label></td>
    <td><input type="text" name="source" style="font-size:16pt;" /></td>
  </tr>
  
  <tr>
    <td><label for="destination" style="font-size:16pt;" >Destination:</label></td>
    <td><input type="text" name="destination" style="font-size:16pt;" /></td>
  </tr>
  
  <tr>
    <td><label for="persons" style="font-size:16pt;" >No. of Persons:</label></td>
    <td><input type="number" name="seats" style="font-size:16pt;" /></td>
  </tr>
 </table>
 
 <br> <br>
 <table style="width:20%">
  <tr>
  <td> <input type="submit" value="Login" style="font-size:20pt; width:86pt; background:limegreen"/> </td>
  </tr>
</table>

 </form>
 <br>

</center>

</body>

</html>