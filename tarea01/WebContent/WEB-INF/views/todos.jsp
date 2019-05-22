<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de libros</title>
</head>
<body>
	<input type="button" value="Regresar" onclick="location.href='${pageContext.request.contextPath}/'">
	<h1>Hay ${cantidad1} libros en existencia, de ${cantidad2} autores diferentes</h1>
	<table>
		<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>ISBN</th>
			<th>Genero</th>
			<th>Cantidad</th>
		</tr>
			<c:forEach items="${libros}" var="libros">
				<tr>
					<td>${libros.titulo}</td>
					<td>${libros.autor}</td>
					<td>${libros.isbn}</td>
					<td>${libros.genero}</td>
					<td>${libros.existencia}</td>
				</tr>
					
			</c:forEach>
	</table>
	
</body>
</html>