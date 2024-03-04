<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.rays.dto.UserDTO" scope="request"></jsp:useBean>
	<form action="UserCtl" method="post">
		<%
			
			String msg = (String) request.getAttribute("msg");
		%>

		<center>
			<%
				if (msg != null) {
			%>
			<h3 style="color: green"><%=msg%></h3>
				<%} %>
				
			


			<%
				if (dto.getId() > 0 ) {
			%>
			<h2>Update User</h2>
			<table>

			    <tr>
					<th>Name:<th>
					<td><input type="text" name="name" value="<%= dto.getName() %>"></td>
				</tr>
				<tr>
					<th>LoginId:<th>
					<td><input type="text" name="login" value="<%=dto.getLoginId() %>"></td>
				</tr>
				<tr>
					<th>Password:<th>
					<td><input type="text" name="password" value="<%= dto.getPassword() %>"></td>
				</tr>
				<tr>
					
					<th>DATE:<th>
					<td><input type="text" name="dob" value="<%= dto.getDob() %>"></td>
				</tr>
				<tr>
					<th>Address:<th>
					<td><input type="text" name="address" value="<%= dto.getAddress() %>"></td>
				</tr>
				
				 </table>
              <input type="submit" name="operation" value="update">
              <input type="submit" name="operation" value="cancel">
			<%
				} else {
			%>
			  <h2>Add User</h2>
			<table>

				<tr>
					<th>Name:</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>LoginId:</th>
					<td><input type="text" name="login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					
					<th>DATE:</th>
					<td><input type="text" name="dob"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"></td>
				</tr>
				
				</table>
				<input type="submit" name="operation" value="save">
				<input type="submit" name="operation" value="cancel">
			
		<% }%>
        
     </center>
  
<input type=hidden name="id" value="<%=dto.getId()%>">
	</form>
	
</body>
</html>