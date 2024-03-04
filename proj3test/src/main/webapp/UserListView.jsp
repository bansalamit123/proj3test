<%@page import="com.rays.dto.UserDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<form action="UserListCtl" method="post">

		<%
			UserDTO dto = new UserDTO();
			List list = (List) request.getAttribute("List");
			Iterator it = list.iterator();

			String msg = (String) request.getAttribute("msg");
		%>

		<center>
			<%
				if (msg != null) {
			%>
			<h3 style="color: green"><%=msg%></h3>

			<%
				}
			%>
			<table border="1" width="100%" align="center">
				<tr style="background: orange">
					<th>SelectAll</th>
					<th>S.No.</th>
					<th>Name</th>
					<th>LoginId</th>
					<th>Password</th>
					<th>DOB</th>
					<th>Address</th>
					<th>Edit</th>

				</tr>
				<%
					while (it.hasNext()) {
						dto = (UserDTO) it.next();
				%>

				<tr>
					<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
					<td><%=dto.getId()%></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getLoginId()%></td>
					<td><%=dto.getPassword()%></td>
					<td><%=dto.getDob()%></td>
					<td><%=dto.getAddress()%></td>
					<td><a href="UserCtl?id=<%=dto.getId()%>">Edit</a></td>

                  </tr>

                  <%
					}
				%>
				</table>
				<br>

				<input type="submit" name="operation" value="delete">
				<br>
				<br>
				<br>
				<a href="index.jsp">Back</a>

               </center>
				</form>
</body>
</html>