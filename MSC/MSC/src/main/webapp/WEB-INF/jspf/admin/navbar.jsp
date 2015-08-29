
<!-- Main Content Area -->
<div class="col-md-10 col-sm-11 display-table-cell valign-top box">


<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>


<%-- <c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>  --%>


	<div class="row">
		<header id="nav-header" class="clearfix">
			<div class="col-md-5">
				<nav class="navbar-default pull-left">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="offcanvas" data-target="#side-menu">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</nav>
				<input type="text" class="hidden-sm hidden-xs"
					id="header-search-field" placeholder="Search...">
			</div>
			<div class="col-md-7">
				<ul class="top-nav pull-right">
					<li id="welcome" class="hidden-xs">Welcome, ${pageContext.request.userPrincipal.principal.systemUserRoleDisplayName}!</li>
					<%-- <li id="welcome" class="hidden-xs">Welcome, Admin! <%if(request.getUserPrincipal().getName() != null){ %>${pageContext.request.userPrincipal.name} <% }else{ %>''<% } %></li> --%>
					<li class="fixed-width"><a href="#"> <span
							class="glyphicon glyphicon-bell" aria-hidden=true></span> <span
							class="label label-warning">3</span>
					</a></li>
					<li class="fixed-width"><a href="#"> <span
							class="glyphicon glyphicon-envelope" aria-hidden=true></span> <span
							class="label label-message">3</span>
					</a></li>
					<li><a href="#"><img
						src="${pageContext.request.contextPath}/resources/admin/images/system_users/Sasa.jpg"
						class="img-circle img-user hidden-sm hidden-xs"
						alt="Cinque Terre" />
						<h3 id="logged-in-user" class="hidden-sm hidden-xs">${pageContext.request.userPrincipal.principal.name}</h3></a></li>
					<li><a href="javascript:formSubmit()" class="logout"> <span
							class="glyphicon glyphicon-log-out" aria-hidden=true></span> log
							out
					</a></li>
				</ul>
			</div>
		</header>
	</div>