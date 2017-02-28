<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head> 
<body>
	<#include "header.ftl">
	<div class="tclass">
		<form action="ThoughtBoundary" method="post">
			<label for="nt">New Thought:</label>
			<input type="text" name="newthought" id="nt" class="textcl" />
			<button name="addthought" value="addthought" class="btn">Save Thought</button>
			<button name="viewthought" value="viewthought" class="btn">View My Thoughts</button>
			<input type="hidden" name="uname" value="${user}"/>
		</form>
	</div>
	
</body>
</html>