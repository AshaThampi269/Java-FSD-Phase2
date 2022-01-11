<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>

<center><h1><b>PRODUCT DETAILS</b></h1>
<br><br><br>

<form action="productDetails" method="POST">
 	<label for="pid" style="font-size:16pt;" >Product Id:</label>
 	<input type="number" name="pid" style="font-size:16pt;" />
 	<br> <br> <br>
 	<input type="submit" value="Search" style="font-size:18pt; width:86px; background:limegreen"/>
 </form>
 
 <br><br><br>
 
	<c:choose>
		<c:when test="${products.isEmpty()}">
			<c:out value="No products found with the given id!!"/>
		</c:when>
		<c:otherwise>
	<table style="border:1px solid black;">
				<tr style="text-align:center; width:100%; margin: 0px auto;">
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Price</th>

				</tr>
				<c:forEach var="product" items="${productList}">
					<tr style="text-align:center; width:100%; margin: 0px auto;">
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>	
					</tr>
				</c:forEach>
			</table>
				</c:otherwise>
	</c:choose>
	</center>
</body>

</html>