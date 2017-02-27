<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student info</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<form action="StudentServlet" method="post"> 
		<div id="login"><div>
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" class="textcl" /></div>
			<div>
			<label for="password">Password:&nbsp;</label>
			<input type="password" id="password" name="password" class="textcl" />
			</div>
			<button name="signin" class="btn">Sign in</button>
		</div>
	</form>
</body>
</html>