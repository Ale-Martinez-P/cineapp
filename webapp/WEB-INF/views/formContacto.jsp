<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<title>Formulario de Contacto</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="bootstrap/css/theme.css" rel="stylesheet">-->

</head>

<body>

	<jsp:include page="includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title text-center">
			<span class="badge badge-success">Contacto</span>
		</h3>
		<br>

		<form:form class="form-horizontal" method="post" action="${urlRoot}contacto" modelAttribute="contacto">
			<div class="form-group">
				<label for="nombre" class="col-sm-2 control-label">Nombre</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" id="nombre" path="nombre" placeholder="Nombre" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input type="email" class="form-control" path="email" id="email" placeholder="Email" required="required"/>
				</div>
			</div>

			<div class="form-group">
				<label for="genero" class="col-sm-2 control-label">Géneros
					Favoritos</label>
				<div class="col-sm-10">
					<form:select id="genero" path="generos" multiple="multiple" class="form-control" items="${generos}"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Tu experiencia en el sitio</label>
				<div class="col-sm-10">
					<label><form:radiobutton path="rating" value="1"/>Muy Mala</label> 
					<label><form:radiobutton path="rating" value="2"/>Mala</label>
					<label><form:radiobutton path="rating" value="3"/>Regular</label>
					<label><form:radiobutton path="rating" value="4"/>Buena</label>
					<label><form:radiobutton path="rating" value="5"/>Muy Buena</label>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Te gustaría recibir notificaciones de:</label>
				<div class="col-sm-10">
				<form:checkboxes items="${tipos}" path="notificaciones"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Comentarios:</label>
				<div class="col-sm-10">
					<form:textarea class="form-control" path="comentarios" id="comentarios" rows="5"></form:textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Enviar</button>
				</div>
			</div>

		</form:form>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="includes/footer.jsp"></jsp:include>

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
