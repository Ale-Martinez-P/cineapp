<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de imagenes del banner</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/banners" var="urlBanners" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
</head>

<body>

<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de imagenes del Banner</h3>
		<c:if test="${mensaje !=null }">
			<div class="alert alert-success" role="alert">${mensaje}</div>
		</c:if>
		<br>
		<a href="${urlBanners}/create" class="btn btn-success" role="button" title="Nuevo Banner">Nuevo</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Fecha Publicacion</th>
					<th>Nombre Archivo</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach var="banner" items="${banners}">
					<tr>
						<td>${banner.id}</td>
						<td>${banner.titulo}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${banner.fecha}" /></td>
						<td>${banner.archivo}</td>
						<c:choose>
							<c:when test="${banner.estatus eq 'Activo'}">
								<td><span class="badge badge-success">${banner.estatus}</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="badge badge-danger">${banner.estatus}</span></td>
							</c:otherwise>
						</c:choose>
						<td>
						<a href="${urlBanners}/edit/${banner.id}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="fas fa-pencil-alt"></span></a> 
						<a href="${urlBanners}/delete/${banner.id}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button"	title="Eliminar"><span class="fas fa-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
