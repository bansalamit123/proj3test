<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.rays.dto.DeveloperDTO" scope="request"></jsp:useBean>
	<form action="DeveloperCtl" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<center>
			<%
				if (msg != null) {
			%>
			<h2><%=msg%></h2>
			<%
				}
			%>
			<%
				if (dto.getId() > 0) {
			%>
			<h2>Update Developer</h2>
			<table>
				<tr>
					<th>Name:</th>
					<td><input type="text" name="name" value=<%=dto.getName()%>></td>

				</tr>
				<tr>
					<th>Project:</th>
					<td><input type="text" name="project"
						value=<%=dto.getProject()%>></td>

				</tr>
				<tr>
					<th>Department:</th>
					<td><input type="text" name="department"
						value=<%=dto.getDepartment()%>></td>

				</tr>
				<tr>
					<th>Status:</th>
					<td><input type="text" name="status"
						value=<%=dto.getStatus()%>></td>

				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="text" name="status" value=<%=dto.getDob()%>></td>

				</tr>



			</table>
			<input type="submit" name="operation" value="update"> <input
				type="submit" name="operation" value="cancel">
			<%
				} else {
			%>


			<table>
				<tr>
					<th>Name:</th>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<th>Project:</th>
					<td><input type="text" name="project"></td>

				</tr>
				<tr>
					<th>Department:</th>
					<td><input type="text" name="department"></td>

				</tr>
				<tr>
					<th>Status:</th>
					<td><input type="text" name="status"></td>

				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="text" name="status"></td>

				</tr>



			</table>
			<input type="submit" name="operation" value="save"> <input
				type="submit" name="operation" value="cancel">



			<%
				}
			%>

		</center>


		<input type="hidden" name=id value="<%=dto.getId()%>">

	</form>

</body>
</html>