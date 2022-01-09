<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*, com.mysql.jdbc.Driver"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SQL Tags Assignment</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost:3306/db_world"  
     user="root"  password="sayHello"/>  
	

	<c:out value="1. Insert 5 records in table: " />  
<%-- 	<sql:update dataSource="${db}" var="count">  
	INSERT INTO Employee VALUES (1146,'Venkatesh', 9000);  
	</sql:update>
	
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO Employee VALUES (1275,'Harish', 12000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO Employee VALUES (1872,'Sneha', 14000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO Employee VALUES (1242,'Namratha', 2000);  
	</sql:update>
	
	<sql:update dataSource="${db}" var="count">  
	INSERT INTO Employee VALUES (1525,'Neha', 28000);  
	</sql:update>
	 --%>
	<b> Records inserted successfully !!</b>
	
	<br> <br>
	
	<c:out value="2. Update empname to manager where sal > 20000: " />  
	
	<sql:update dataSource="${db}" var="updateEmpSalary">  
	UPDATE emp SET empname='Manager' WHERE empSalary > 20000;
	</sql:update>
	
	<b> Records updated successfully !!</b>
	
	<br> <br>
	
	<c:out value="3. delete record with empid 102 and 103: " />  
	
	<sql:update dataSource="${db}" var="deleteEmpID">  
	DELETE FROM emp WHERE empid IN (1872, 1146);
	</sql:update>
	
	<b> Record deleted successfully !!</b>
	
	<br> <br>
	
	<c:out value="4. Fetch all records: " />  
	
	<b> Fetching records from the database</b>
		
	<sql:query dataSource="${db}" var="rs">  
		SELECT * FROM emp WHERE EmpId >= 1000 and EmpId <= 1500;  
	</sql:query>  
	
	<table border="2" width="100%">  
<tr>  
<th>Employee ID</th>  
<th>Employee Name</th>  
<th>Employee Salary</th>  

</tr>  
	<c:forEach var="table" items="${rs.rows}">  
		<tr>  		
			<td><c:out value="${table.EmpId}"/></td>  
			<td><c:out value="${table.EmpName}"/></td>  
			<td><c:out value="${table.EmpSalary}"/></td>  		
		</tr>  
	</c:forEach>  
</table>  
</body>
</html>