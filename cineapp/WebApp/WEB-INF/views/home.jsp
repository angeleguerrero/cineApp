<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenidos a CineAPP</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	

<!-- 	<ol> -->
<%-- 		<c:forEach items="${peliculas}" var="pelicula"> --%>
<%-- 			<li>${pelicula}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ol> -->



	
	<div class="container">
 
  <div class="panel panel-default">
    <div class="panel-heading">Lista de Peliculas</div>
    <div class="panel-body">
	<table class="table table-hover table-striped table-bordered">
  <thead class="thead-dark">
		
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Duracion</th>
				<th>Clasificacion</th>
				<th>Genero</th>
				<th>Fecha Estreno</th>
				<th>Estatus</th>
				<th>Imagen</th>

			</tr>
			 </thead>
		
		<tbody>

			<c:forEach items="${peliculas}" var="pelicula">
				<tr>
					<td>${pelicula.id}</td>
					<td>${pelicula.titulo}</td>
					<td>${pelicula.duracion} MIN</td>
					<td>${pelicula.calificacion}</td>
					<td>${pelicula.genero}</td>
					<td>${pelicula.fechaEstreno}</td>
					<td>${pelicula.estatus}</td>
					<td>${pelicula.imagen}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</div>
</div>
</div>


</body>
</html>