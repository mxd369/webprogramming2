<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
	<title>Thoughts Bank</title>
</head>
<body>
	<h1>Welcome ${username}!</h1>
	
	<#list 1..10 as i>
		<p>Our latest product is :
		${li} <a href="${thoughts.url}">${thoughts.name}</a>!<br/></p>
	</#list>

	
	<form action=viewthoughts method="get">
    
    Thought:<input type="text" name ="Thought"/><br/>
    
        <input type="submit" value="Save"/>
    </form>
	
</body>
</html>
