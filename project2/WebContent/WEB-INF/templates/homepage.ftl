<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="UTF-8">
<title></title>
<body>
	<h1>Welcome ${username}!</h1>
	<#list 1..10 as i>
		<p>Our latest product is :
		${li} <a href="${latestProduct.url}">${latestProduct.name}</a>!<br/></p>
	</#list>
</body>
</html>


<!--

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h3> Hello ${username}</h3>
    <form action=thoughtsservlet method="get"> 
    
    Thought:<input type="text" name ="Thought"/><br/>
    
        <input type="submit" value="Save"/>
        </form>
</body>
</html>


-->