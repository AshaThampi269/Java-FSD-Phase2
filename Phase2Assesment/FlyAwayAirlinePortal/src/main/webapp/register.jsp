<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<center><h1><b>REGISTRATION</b></h1></center> <br><br>

<form action="registerUser" method="POST" id="registerForm">
<table style="width:50%; margin: 0px auto;">
  <tr>
	<td><label for="fullName" style="font-size:16pt; width:270px;" >Full name</label></td> 
	<td><input type="text" name="fullName" style="font-size:16pt; width:270px;" /><br /></td>
  </tr>		

	<tr>		
		<td><label for="address" style="font-size:16pt; width:270px;" >Address</label></td>
		<td><textarea name="address" style="font-size:16pt; width:270px;" ></textarea></td>
	</tr>
			
	<tr>
		<td><label for="age" style="font-size:16pt; width:270px;" >Age</label> </td>
		<td><input name="age" type="number" style="font-size:16pt; width:270px;" /></td>
	</tr>
			
	<tr>
		<td><label for="mobile" style="font-size:16pt; width:270px;" >Mobile Number</label></td> 
		<td><input type="text" name="mobile" style="font-size:16pt; width:270px;" /></td>
	</tr>	
			
	<tr>
		<td><label for="username" style="font-size:16pt; width:270px;">Username</label></td> 
		<td><input disabled type="text" style="font-size:16pt; width:270px;" value="${user.username}" /></td>
	</tr> 
			
	<tr>
		<td><label for="idType" style="font-size:16pt; width:270px;" >ID Type</label> </td>
		<td>

		<select name="ID type" id="id" style="font-size:16pt; width:270px;" >
  		<option value="Aadhar">Aadhar Card</option>
  		<option value="License">Driving License</option>
  		<option value="Voter">Voter Id</option>
  		<option value="Pan">Pan Card</option>
		</select>
		
		</td>
	</tr> 
	
	<tr>
		<td><label for="idno" style="font-size:16pt; width:270px;">Id Number</label></td> 
		<td><input type="text" name="idNo" style="font-size:16pt; width:270px;"/></td>
	</tr> 
		
	<tr>
		<td><label for="country" style="font-size:16pt; width:270px;" >Country</label> </td>
		<td><input type="text" form="registerForm" name="country" style="font-size:16pt; width:270px;"  /></td>
		<td><input hidden name="flightNumber" type="number" value="${param.flightNumber}" /></td>
		<td><input hidden name="date" type="date" value="${param.date}" /></td>
	</tr>
	
	<tr>
		<td><label for="passenger" style="font-size:16pt; width:270px;">No. of Passengers</label></td> 
		<td><input type="text" name="passNo" style="font-size:16pt; width:270px;"/></td>
	</tr> 
	
</table>
<center>
<br> <br>
 <table style="width:20%">
  <tr>
  <td> <input type="submit" value="Register" style="font-size:20pt; width:86pt; background:limegreen" /></td>
  </tr>
</table>
</center>
</form>
	
</body>

</html>