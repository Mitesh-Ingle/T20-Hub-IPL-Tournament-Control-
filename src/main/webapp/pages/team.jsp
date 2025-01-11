<%@page import="com.tka.entity.Player"%>
<%@page import="com.tka.entity.Team"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>Team and Players List</title>
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
    <h2>Teams and Their Players</h2>
    <table>
        <thead>
            <tr>
                <th>Team ID</th>
                <th>Team Name</th>
                <th>Player Names</th>
            </tr>
        </thead>
        <tbody>
            <%-- Scriptlet to iterate over the list of teams --%>
            <%
                List<Team> teams = (List<Team>) request.getAttribute("teams");
                if (teams != null && !teams.isEmpty()) {
                    for (Team team : teams) {
            %>
                        <tr>
                            <td><%= team.getId() %></td>
                            <td><%= team.getName() %></td>
                            <td>
                                <ul>
                                    <%-- Iterate over players in the team and display only their names --%>
                                    <%
                                        List<Player> players = team.getPlayers();
                                        if (players != null && !players.isEmpty()) {
                                            for (Player player : players) {
                                    %>
                                                <li><%= player.getName() %></li>
                                    <%
                                            }
                                        } else {
                                    %>
                                            <li>No players in this team</li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="3">No teams available</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
