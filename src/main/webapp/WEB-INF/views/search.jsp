<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Search</title>
</head>
<body>
	<h3>Search Movie By Title</h3>
	<form method="get" action="searchByName">
		<table>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<h3>Search Movie By Year</h3>
	<form method="get" action="searchByYear">
		<table>
			<tr>
				<td>Enter Year</td>
				<td><input type="text" name="year"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
	<h3>Search Movie By Artist</h3>
	<form method="get" action="searchByArtist">
		<table>
			<tr>
				<td>Enter ArtistName</td>
				<td><input type="text" name="artist"></td>
				<td><input type="submit" value="Search"></td>
			</tr>

		</table>
	</form>
</body>
</html>