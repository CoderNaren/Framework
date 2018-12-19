<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html">
<html>
<head>
	<title>
			User Login page
	</title>
	
	<spring:url value = "/resources/themes/Css/Css1.css" var = "styleSheet" />
	<spring:url value = "/resources/themes/Js/Js1.js" var = "JsFile" />
	
	<link href = "${styleSheet}" rel = "stylesheet" />
	<script src = "${JsFile}"></script>	
	
</head>


<body>
	<div class="login-page">
    <div class="form1">
    
<!--   <c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>
 -->  
     
    <form:form action="processform" modelAttribute="userlogin" method="POST" class="login-form">
<!--  <form:hidden path="id" />  -->
     
      <form:input path = "userName" placeholder = "username"/>
      <form:password path = "password" placeholder = "password"/> 
     
      <button>login</button>
    
      <p class="message">Not registered? <a href="registrationform">Create an account</a></p>
    
    </form:form>
    
  </div>
  </div> 
</body>
</html>