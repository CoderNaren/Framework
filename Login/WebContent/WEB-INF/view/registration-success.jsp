<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration-success</title>

<style>
	body {
    		background-color: lightblue;
		}
	
	#username 
	{
    	text-align: center;
    	color: green;
	}
	
	.h3
	{
    	text-align: center;
    	color: green;
	}
	
</style>

</head>
<body>
<h3 class = "h3">Registration success for User</h3>
<br>
	<div id = "username">
<h4>	Name: ${newuser.firstName} &nbsp; ${newuser.lastName};   </h4>
	</div>
</body>
</html>