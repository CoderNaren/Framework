<%@ 
taglib prefix="form" uri = "http://www.springframework.org/tags/form"
 %>

<!DOCTYPE html>
<html>
<head>
<title>Student Registration form</title>
</head>

<body>
	
	<form:form action = "processForm" modelAttribute = "student">
	
				First name:<form:input path = "firstName" />
	<br><br>
				Last name:<form:input path = "lastName" />
    <br><br>
    			Country: 
    			<form:select path = "country">
    			
    			<form:options items = "${student.countryOptions}"/>
    			
    			</form:select>
    <br><br>
    			Favourite Language:
    			<form:radiobutton path = "favouriteLanguage" value = "Java" />
    			<form:radiobutton path = "favouriteLanguage" value = "C++" />
    			<form:radiobutton path = "favouriteLanguage" value = "Python" />
    			<form:radiobutton path = "favouriteLanguage" value = "Ruby" />
    <br><br>
    			Operating System:
    			<form:checkbox path = "operatingSystem" value = "Linux" />
    			<form:checkbox path = "operatingSystem" value = "Windows" />
    			<form:checkbox path = "operatingSystem" value = "Mac" />
    			<form:checkbox path = "operatingSystem" value = "Frzi" />
    <br><br>
    			
    			<input type = "submit" value = "Submit" />
	
	</form:form>
	
	
	
</body>

</html>