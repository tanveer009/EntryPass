<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visitor Page</title>
<script type="text/javascript" src="/js/app.js">
	
</script>
<link rel="stylesheet" type="text/css" href="/css/app.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div>
<div id="container">
<form action="/rest/visitorui/find/all" method="post">
<input type="submit" value="GetAllVisitors">
</form>
</div>

<div id="container">
<form onsubmit="yourFunction()" method="post" id=visitorbyid>
<input type="number" value="id" name=id>
<input type="submit" value="GetVisitorById">
</form>
</div>

<div id="container">
<form action="/rest/visitorui/save" method="post">
<p>First Name: <input type="text" name="firstName"/></p>

<p>Last Name: <input type="text" name="lastName"/></p>
<p>Phone Number: <input type="text" name="phoneNumber"/></p>
<p>Email:<input type="text" name="emailAddress"></p>
<p> Purpose of Access:<input type="text" name="purposeOfAccess"></p>
<p>Address Type: <select name="visitorAddress.addressType">
    <option value="Permanent" ></option>
    <option value="Office" ></option>
  </select></p>
<p>Address Line: <input type="text" name="visitorAddress.addressLine"></p>
<p>City: <input type="text" name="visitorAddress.city"></p>
<p>State: <input type="text" name="visitorAddress.state"></p>
<p>Country: <input type="text" name="visitorAddress.country"></p>
<p><input type="submit" value="SaveVisitors"></p>
</form>
${msg}
</div>

</div>


<form name="logoutForm" action="/logout" method="post">
     <p> <input type="submit" value="Sign Out"/></p>
</form> 


<form name="AdminForm" action="/admin">
     <p> <input type="submit" value="AdminPage"/></p>
</form>

</body>
</html>