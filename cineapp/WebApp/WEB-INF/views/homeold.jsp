<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenidos a CineAPP</title>
<!-- variable al modelo con la URL relativa a resources, se coloca aqui para que este disponible al llegar a usar los recursos locales -->
<spring:url value="/resources" var="urlPublic" />


<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">


<!-- CDN <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
crossorigin="anonymous">-->



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
					<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
					<td>
						<c:choose > 
						<c:when test="${pelicula.estatus=='Activa' }"> 
							<span class="label label-success">ACTIVA </span>
						</c:when>
						<c:otherwise> 
							<span class ="label label-danger"> INACTIVA </span>
						</c:otherwise>
						
						</c:choose>
					
					</td>
					<td><img src="${urlPublic }/images/${pelicula.imagen}" width="100" height="100"></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</div>
</div>
</div>


</body>
</html>