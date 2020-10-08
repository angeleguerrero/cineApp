<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- TAG para tags de accesos -->
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:url value="/" var="urlRoot" />   

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
      
<!--       Acceso Anonimo -->
      <sec:authorize access="isAnonymous()">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}">CineApp-v1.0</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${urlRoot}acerca">Acerca</a></li>
            <li><a href="${urlRoot}formLogin">Login</a></li>  
            <li><a href="${urlRoot}buscar"></a></li> 
                     
          </ul>
        </div><!--/.nav-collapse -->
        </sec:authorize>
        
<!--         Acceso Editor -->
		<sec:authorize access="hasAnyAuthority('EDITOR')">

        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}admin/index">CineApp-v1.0 - Perfil Editor</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          
			<li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
			<li><a href="${urlRoot}horarios/indexPaginate">Horarios</a></li>
			<li><a href="${urlRoot}noticias/listar">Noticias</a></li>
         
			<li><a href="${urlRoot}admin/logout">Salir</a></li>
                     
          </ul>
        </div><!--/.nav-collapse -->
        </sec:authorize>
        
        
<!--         Acceso Administrador -->
        
                <sec:authorize access="hasAnyAuthority('GERENTE')">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}admin/index">CineApp-v1.0 - Administración</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
           <li><a href="${urlRoot}banners/index">Banners</a></li>   
			<li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
			<li><a href="${urlRoot}horarios/indexPaginate">Horarios</a></li>
			<li><a href="${urlRoot}noticias/listar">Noticias</a></li>
      
			<li><a href="${urlRoot}admin/logout">Salir</a></li>
<%-- 			<li>Bienvenido(a) <sec:authentication property="principal.username"/> </li> --%>
                     
          </ul>
        </div><!--/.nav-collapse -->
        </sec:authorize>
        
        
        
        
        
        
        
      </div>
    </nav>