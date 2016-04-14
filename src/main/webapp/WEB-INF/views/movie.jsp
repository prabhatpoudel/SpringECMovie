<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> This is a test page. </h1>
 
 	<table border=1>
 	<thead>
 	<tr>
 	<td> Title </td>
 	<td> Year</td>
 	<td> Action</td>
 	</tr>
 	
 	</thead>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.title}</td>
				<td>${movie.year}</td>
				<td> <a href="${pageContext.request.contextPath}/movie/edit/${movie.id}" > Edit</a>
				 <a href="${pageContext.request.contextPath}/movie/delete/${movie.id}" > Delete</a>   
				 
				 </td>
			</tr>
		</c:forEach>
	</table>
 
 
 <ul>
 <li><a href="${pageContext.request.contextPath}/movie/add"> Add Movie</a></li>
 <li><a href="${pageContext.request.contextPath}/movie/search/" > Search</a></li> 
 </ul>
</body>
</html>