<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Thoughts Page</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head> 
<body>
	<#include "header.ftl">
	<div class="tclass">
	<h3>${user}! You have ${numOfThoughts} Thoughts. Here's the list:</h3>
		<table id="thoughttable" border="1">
			<#list thoughts as t>
				<tr class="${t?item_parity}Row">
					<td>${t.thought}</td>
				</tr>
			</#list>
		</table>
	</div>
	
</body>
</html>