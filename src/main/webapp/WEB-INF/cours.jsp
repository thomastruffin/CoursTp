<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<c:forEach var="items" items="${list}">
	<li> ${items.nom}</li>
	<form action="./cours.do" method="post">
		<input type="hidden" name ="deleteItems"  value="${items.ID}"> 
		<input type="submit" value="delete"> 
	</form>
	</c:forEach>
	</ul>
</body>
</html>