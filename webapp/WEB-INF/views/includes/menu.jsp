<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot"></spring:url>
<!-- NavBar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
	<!-- Menu 1 -->
	<sec:authorize access="isAnonymous()">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${urlRoot}">CineSite</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">				
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}about">Acerca</a></li>				
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}formLogin">Login</a></li>
			</ul>
		</div>
		</sec:authorize>
		<!-- Menu 1 -->
		
		<!-- Menu 2 -->
		<sec:authorize access="hasAnyAuthority('EDITOR')">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${urlRoot}admin/index">CineSite | Administracion</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"	href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
				<li class="nav-item active"><a class="nav-link"	href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}noticias/index">Noticias</a></li>				
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}admin/logout">Cerrar Sesion</a></li>				
			</ul>
		</div>
		</sec:authorize>
		<!-- Menu 2 -->
		
		<!-- Menu 3 -->
		<sec:authorize access="hasAnyAuthority('GERENTE')">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${urlRoot}admin/index">CineSite | Administracion</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"	href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
				<li class="nav-item active"><a class="nav-link"	href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}noticias/index">Noticias</a></li>
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}banners/index">Banners</a></li>				
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}admin/logout">Cerrar Sesion</a></li>				
			</ul>
		</div>
		</sec:authorize>
		<!-- Menu 3 -->
	</div>
</nav>
<!-- NavBar -->