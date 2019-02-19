<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<form:form method="post" modelAttribute="hotel" action="/Hotels/addHotel">
<table>
		<tr>
			<th colspan="2">Add Hotel</th>
		</tr>
		<tr>
		<form:hidden path="id" />
          <td><form:label path="hotelName">Hotel Name:</form:label></td>
          <td><form:input path="hotelName" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
		  <td><form:label path="city">City:</form:label></td>
          <td><form:input path="city" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		  <td><form:label path="roomsAvailable">Rooms available:</form:label></td>
          <td><form:input path="roomsAvailable" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		  <td><form:label path="phoneNo">Phone:</form:label></td>
          <td><form:input path="phoneNo" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		  <td><form:label path="roomPrice">Price:</form:label></td>
          <td><form:input path="roomPrice" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Hotel List</h3>
<c:if test="${!empty listOfHotels}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Hotel Name</th>
		<th width="120">City</th>
		<th width="120">Rooms available</th>
		<th width="120">Phone</th>
		<th width="120">Price</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfHotels}" var="hotel">
		<tr>
			<td>${hotel.id}</td>
			<td>${hotel.hotelName}</td>
			<td>${hotel.city}</td>
			<td>${hotel.roomsAvailable}</td>
			<td>${hotel.phoneNo}</td>
			<td>${hotel.roomPrice}</td>
			<td><a href="<c:url value='/updateCountry/${hotel.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteCountry/${hotel.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
