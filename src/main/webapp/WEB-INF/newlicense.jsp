<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Create License</title>
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
		<h1>New License</h1>
		<br>
		<% Long id = (Long) session.getAttribute("id");%>
		<form:form action = "/licenses/new/process" method = "post" modelAttribute = "license">
			<form:label path = "person">Person: </form:label>
			<form:select path = "person">
				<c:forEach items = "${people}" var = "p">
					<form:option value = "${p}">${p.firstName} ${p.lastName}</form:option>
				</c:forEach>
			</form:select>
			<br><br>
			<form:label path = "state">State: </form:label>
			<form:input path = "state"/><br><br>
			<form:label path = "expiration_date">Expiration Date: </form:label>
			<form:input type = "hidden" value = "${id}" path = "number"/>
			<form:input type = "text" path = "expiration_date"/><br><br>
			<input type = "submit" value = "Create">
		</form:form>
	</div>
</body>
</html>