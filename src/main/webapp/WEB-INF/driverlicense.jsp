<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Driver License Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style>
		#wrapper {
			background-color: lightgrey;
			padding: 25px;
			padding-left: 30px;
			height: 650px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<h1>${person.firstName} ${person.lastName}</h1>
		<h5>License Number: ${licenseNum}</h5>
		<h5>State: ${person.license.state}</h5>
		<h5>Expiration Date: ${time}</h5>
	</div>
</body>
</html>