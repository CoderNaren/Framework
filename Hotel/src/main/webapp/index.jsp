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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
jQuery(document).ready(function()
        {	
           
            var url = "http://localhost:8080/Hotel/getAllHotels";
                jQuery.ajax(
                {	
                	type: 'GET',
                    url: url,
                    dataType: 'json',
                    success: function (data) {
                    RenderTable(data);
                    },
                    error: function (jqxhr, textStatus, errorMessage) {
                    alert("oops something went wrong!");
                    }
                });
});
        
function RenderTable(data)
{
	
	var hotelRow = "";

	hotelRow += "<tr>" +  "<th width=\"120\">Hotel Name</th>";
	hotelRow += "<th width=\"120\">City</th>";
	hotelRow += "<th width=\"120\">Rooms available</th>";
	hotelRow += "<th width=\"120\">Phone</th>";
	hotelRow += "<th width=\"120\">Price</th>";
	hotelRow += "<th width=\"60\">Edit</th>";
	hotelRow += "<th width=\"60\">Delete</th></tr>";



    for (var i = 0; i < data.length; i++)
    {	
    	var id = data[i].id;
        var hotelName = data[i].hotelName;
        var city = data[i].city;
        var roomsAvailable = data[i].roomsAvailable;
        var phoneNo = data[i].phoneNo;
        var roomPrice = data[i].roomPrice;

        hotelRow += "<tr><td>" + hotelName + "</td>" ;
        hotelRow += "<td>" + city + "</td>" ;
        hotelRow += "<td>" + roomsAvailable + "</td>" ;
        hotelRow += "<td>" + phoneNo + "</td>" ;
        hotelRow += "<td>" + roomPrice + "</td>" ;
        hotelRow += "<td><a id=\"updateResource\" href=\"#\" onclick=\"return updateHotel(" + id + ",'" + hotelName + "','" + city + "'," + roomsAvailable + "," + phoneNo + "," + roomPrice + "); return false; \">Edit</a></td>" ;
        hotelRow += "<td><a id=\"deleteResource\" href=\"#\" onclick=\"return deleteHotel("+ id + "); return false; \" >Delete</a></td></tr>" ;
    }
    
    jQuery('#hotelTable').empty();
    jQuery('#hotelTable').append(hotelRow);
}
        
function updateHotel(id,hotelName,city,roomsAvailable,phoneNo,roomPrice){
	
	var url = "http://localhost:8080/Hotel/updateHotel";
	var dataObject = { 'id': id, 'hotelName': hotelName, 'city': city, 'roomsAvailable': roomsAvailable, 'phoneNo': phoneNo, 'roomPrice': roomPrice};
	
	jQuery.ajax(
            {	headers: { 
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            	},
            	type: 'PUT',
                url: url,
                dataType: 'json',
                data :  JSON.stringify(dataObject),
                success: function (data) {
                	alert("successfully updated the resource!");
                },
                error: function (jqxhr, textStatus, errorMessage) {
                alert("oops something went wrong while deleting the resource!");
                }
            });
	
	
}   

function deleteHotel(id){
	
	var url = "http://localhost:8080/Hotel/deleteHotel/"+id;
	
	jQuery.ajax(
            {	
            	type: 'DELETE',
                url: url,
                success: function (data) {
                	alert("successfully deleted the resource!");
                },
                error: function (jqxhr, textStatus, errorMessage) {
                alert("oops something went wrong while updating the resource!");
                }
            });
	
}

function insert(){
	
	var url = "http://localhost:8080/Hotel/addHotel";
	
    var hotelName = jQuery('[name="hotelName"]').val();
    var city = jQuery('[name="city"]').val();
    var roomsAvailable = jQuery('[name="roomsAvailable"]').val();
    var phoneNo = jQuery('[name="phoneNo"]').val();
    var roomPrice = jQuery('[name="roomPrice"]').val();
	var dataObject = { "hotelName": hotelName, "city": city, "roomsAvailable": roomsAvailable, "phoneNo": phoneNo, "roomPrice": roomPrice};
	
	jQuery.ajax(
    {	headers: { 
        'Accept' : 'application/json',
        'Content-Type': 'application/json'
    	},
    	type: 'POST',
        url: url,
        dataType: 'json',
        data :  JSON.stringify(dataObject),
        success: function (data) {
        	alert("Hotel has been added!");
        },
        error: function (jqxhr, textStatus, errorMessage) {
        	alert("oops something went wrong!"+errorMessage);
        }
    });
}
        
        
</script>
</head>
<body>


<table>
<tr>
	<th colspan="2">Add Hotel</th>
</tr>
<tr>
   <td>Hotel Name:</td>
   <td><input type="text" name="hotelName" placeholder="Hotel Name"></td>
</tr>
<tr>
	<td>City:</td>
    <td><input type="text" name="city" placeholder="city"></td>
</tr>
<tr>
	<td>Rooms available:</td>
    <td><input type="text" name="roomsAvailable" placeholder="how many rooms"></td>
</tr>
<tr>
	<td>Phone:</td>
    <td><input type="text" name="phoneNo" placeholder="phone"></td>
</tr>
<tr>
	<td>Price:</td>
    <td><input type="text" name="roomPrice" placeholder="price"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" class="blue-button" onclick="return insert();"/></td>
</tr>
</table>

</br>
<h3>Hotel List</h3>

<table class="tg" id="hotelTable">
</table>
</body>
</html>

