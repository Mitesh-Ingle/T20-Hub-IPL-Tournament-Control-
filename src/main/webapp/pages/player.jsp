<%@page import="com.tka.entity.Player"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Player List</title>
    <style>
        table {
            width: 50%;
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
    </style>
      <jsp:include page="menu.jsp" />
</head>
<body>
    <h1 style="text-align: center;">Player List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <%-- Scriptlet to iterate over the list of players --%>
            <%
                List<Player> players = (List<Player>) request.getAttribute("players");
                if (players != null && !players.isEmpty()) {
                    for (Player player : players) {
            %>
                        <tr>
                            <td><%= player.getId() %></td>
                            <td><%= player.getName() %></td>
                            <td><%= player.getAge() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3">No players available</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
