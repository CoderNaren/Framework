<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- it gives all tags witch is required for looping over an Array(String[]) -->

<!DOCTYPE html>
<html>

<head>
<title>Student Confirmation</title>
</head>

<body>
	
	The student is confirmed: ${student.firstName} ${student.lastName} 

<br><br>
	
	Country: ${student.country}   <!--student(Model name or Model Attribute) call getCountry() -->
	
<br><br>

	Favourite Language: ${student.favouriteLanguage}
	
<br><br>

	Operating System:
		<ul>
			<c:forEach var = "temp" items = "${student.operatingSystem}">
				<li>
					${temp}
				</li>
			</c:forEach>
		</ul>

</body>

</html>