<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<style>
.textcl {
	width: 30%;
}
.regcl {
	width: 70%;
}
.regcl input {
	margin-right:40px;
}
</style>
</head>
<body>
<h3>Please enter the following information and submit the form:</h3>
 <form action="StudentServlet" method="post">
    <div class="regcl">
 		<label for="fname">First Name:</label>
 		<input type="text" name="fname" class="textcl" />
 	</div>
 	<div class="regcl">
 		<label for="lname">Last Name:</label>
 		<input type="text" name="lname" class="textcl" />
 	</div>
 	<div class="regcl">
 		<label for="email">Email:</label>
 		<input type="text" name="emial" class="textcl" />
 	</div>
 	<div>
 		<label for="username">Username:</label>
 		<input type="text" name="username" class="textcl" />
 	</div>
 	<div>
 		<label for="password">Password:</label>
 		<input type="password" name="password" class="textcl" />
 	</div>
 	<div>
 	<button name="register" value="register" class="btn">Register</button>
 	<button type="reset" name="clear" value="clear" class="btn">Clear</button>
 	</div>
 
 </form>
</body>
</html>