<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu</title>

<style type="text/css">
/* General reset */
body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.menu {
	background-color: #333;
	padding: 0;
}

.menu ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
}

.menu ul li {
	margin: 0;
	padding: 0;
}

.menu ul li a {
	display: block;
	color: white;
	text-decoration: none;
	padding: 15px 20px;
	transition: background-color 0.3s ease;
}

.menu ul li a:hover {
	background-color: #575757;
}
</style>

</head>
<body>
	<nav class="menu">
		<ul>
			<li><a href="all-player">All Player</a></li>
			<li><a href="all-team">All Team</a></li>
			<li><a href="all-matches">All Matches</a></li>
		</ul>
	</nav>
</body>
</html>
