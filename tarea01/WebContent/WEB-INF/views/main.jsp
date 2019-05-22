<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>Buscar por:</h1>
	<form action="${pageContext.request.contextPath}/search" method = "post" id="mainForm">
		<input type="text" name="titulo"/>
		<select name="criterio">
  			<option value="autor">Autor</option>
  			<option value="isbn">ISBN</option>
  			<option value="genero">Género</option>
		</select>
		<input type="submit" value="Buscar"/>
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/todos'" value="Ver Todos" />
	</form>
</body>
</html>