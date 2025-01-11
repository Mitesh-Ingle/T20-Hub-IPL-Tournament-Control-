<center>
<h2>Edit Match Details</h2>
<form action="/update-match" method="post">

Id <input readonly="readonly" type="text" name="id" value="${match.id}"/>
<br>
Match Date <input type="text" name="matchDate" value="${match.matchDate }"/>
<br>

Location <input type="text" name="location" value="${match.location}"/>
<br>
<input type="submit" value="Update"/>




</form>
</center>