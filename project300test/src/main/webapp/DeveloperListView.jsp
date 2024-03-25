<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.dto.DeveloperDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="DeveloperListCtl" method="post">
		<%
			DeveloperDTO dto = new DeveloperDTO();
			List list = (List) request.getAttribute("List");
			Iterator it = list.iterator();
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
			<table border="1" width="100%">
				<tr style="background: orange">
					<th>Select</th>
					<th>Name</th>
					<th>Project</th>
					<th>Department</th>
					<th>status</th>
					<th>DOB</th>
					<th>Edit</th>
				<tr>
					<%
						while (it.hasNext()) {
							dto = (DeveloperDTO) it.next();
					%>
				
				<tr>
					<td><input type="checkbox" name="ids" value=<%=dto.getId()%>>
					</td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getProject()%></td>
					<td><%=dto.getDepartment()%></td>
					<td><%=dto.getStatus()%></td>
					<td><%=dto.getDob()%></td>
					<td><a href="DeveloperCtl?id=<%=dto.getId()%>">Edit</a></td>

				</tr>

				<%
					}
				%>
			</table>
			<br> <input type="submit" name="operation" value="delete"><br>
			<br> <a href="index.jsp">Back</a>



		</center>
	</form>
</body>
</html>