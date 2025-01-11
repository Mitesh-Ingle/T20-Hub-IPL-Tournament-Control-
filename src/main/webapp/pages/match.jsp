<!DOCTYPE html>
<%@page import="com.tka.entity.Matches"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Match List</title>
<style>
table {
	width: 80%;
	margin: auto;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f4f4f4;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

h2 {
	text-align: center;
}
</style>
<jsp:include page="menu.jsp" />
</head>
<body>
	<center>
		<h2>Match List</h2>
		<c:if test="${not empty msg}">
			<div class="alert">${message}</div>

		</c:if>
	</center>
	<table>
		<thead>
			<tr>
				<th>Match ID</th>
				<th>Match Date</th>
				<th>Location</th>
				<th>Team 1</th>
				<th>Team 2</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%-- Scriptlet to iterate over the list of matches --%>
			<%
			List<Matches> matches = (List<Matches>) request.getAttribute("matches");
			if (matches != null && !matches.isEmpty()) {
				for (Matches match : matches) {
			%>
			<tr>
				<td><%=match.getId()%></td>
				<td><%=match.getMatchDate()%></td>
				<td><%=match.getLocation()%></td>
				<td><%=match.getTeam1().getName()%></td>
				<td><%=match.getTeam2().getName()%></td>
				<td><a href="/delete-match/<%=match.getId()%>">Delete</a> <a
					href="/edit-match/<%=match.getId()%>">Edit</a></td>

			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="5">No matches available</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
