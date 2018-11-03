<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Create Driver</title>
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
		<h1>New Person</h1>
		<br>
		<form:form action = '/persons/new/process' method = 'post' modelAttribute = "person">
			<form:label path = "firstName">First Name: </form:label>
			<form:input path = "firstName"/><br><br>
			<form:label path = "lastName">Last Name: </form:label>
			<form:input path = "lastName"/><br><br>
			<input type = "submit" value = "Create">
		</form:form>
	</div>
</body>
</html>