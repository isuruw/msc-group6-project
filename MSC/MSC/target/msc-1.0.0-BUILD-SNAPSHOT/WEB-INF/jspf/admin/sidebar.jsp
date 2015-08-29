
<%
	String url = request.getAttribute(
			"javax.servlet.forward.request_uri").toString();
	url = url.substring(url.lastIndexOf("/") + 1, url.length());
%>

<!-- Side menu -->
<div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top"
	id="side-menu">
	<h1 id="admin-panel-name" class="hidden-sm hidden-xs">
		<b>Admin</b> PANEL
	</h1>
	<div class="col-xs-12 user-section">
		<div class="row">
			<div class="col-xs-3">
				<img
					src="${pageContext.request.contextPath}/resources/admin/images/system_users/Sasa.jpg"
					class="img-circle img-user hidden-sm hidden-xs" alt="Cinque Terre" />
			</div>
			<div class="col-xs-9">
				<h3 id="logged-in-user" class="hidden-sm hidden-xs">${pageContext.request.userPrincipal.principal.name}</h3>
				<h5 id="logged-in-user" class="hidden-sm hidden-xs">
					<span class="online-sign glyphicon glyphicon-cd"></span>Online
				</h5>
			</div>
		</div>
	</div>
	<h4 class="hidden-sm hidden-xs">MAIN NAVIGATION</h4>
	<ul>
		<li
			class="link <%if ("dashboard".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="${pageContext.request.contextPath}/admin/dashboard"> <span
				class="glyphicon glyphicon-dashboard" aria-hidden=true></span> <span
				class="hidden-sm hidden-xs">Dashboard</span>
		</a>
		</li>
		<li
			class="link <%if ("add-article".endsWith(url) || "view-articles".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="#collapse-post" data-toggle="collapse"
			aria-controls="collapse-post"> <span
				class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> <span
				class="hidden-sm hidden-xs">Article</span> <span
				class="label label-success pull-right hidden-sm hidden-xs">20</span>
		</a>
			<ul class="collapse collapseable" id="collapse-post">
				<li><a
					href="${pageContext.request.contextPath}/admin/article/add-article">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>Create New</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/article/view-articles">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>View Article</a></li>
			</ul>
		</li>

		<li
			class="link <%if ("approved-comments".endsWith(url)
					|| "unapproved-comments".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="#collapse-comments" data-toggle="collapse"
			aria-controls="collapse-comments"> <span
				class="glyphicon glyphicon-pencil" aria-hidden="true"></span> <span
				class="hidden-sm hidden-xs">Comments</span>
		</a>
			<ul class="collapse collapseable" id="collapse-comments">
				<li><a
					href="${pageContext.request.contextPath}/admin/comments/approved-comments">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>Approved<span
						class="label label-success pull-right hidden-sm hidden-xs">10</span>
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/comments/unapproved-comments">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>Un-approved<span
						class="label label-warning pull-right hidden-sm hidden-xs">10</span>
				</a></li>
			</ul>
		</li>

		<li
			class="link <%if ("system-users".endsWith(url) || "customers".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="#collapse-users" data-toggle="collapse"
			aria-controls="collapse-users"> <span
				class="glyphicon glyphicon-user" aria-hidden="true"></span> <span
				class="hidden-sm hidden-xs">Users</span>
		</a>
			<ul class="collapse collapseable" id="collapse-users">
				<%-- <sec:authorize access="hasRole('ROLE_MSC_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/users/system-users">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>System-users<span
						class="label label-success pull-right hidden-sm hidden-xs">6</span>
				</a></li>
				</sec:authorize> --%>
				<li><a
					href="${pageContext.request.contextPath}/admin/users/system-users">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>System-users<span
						class="label label-success pull-right hidden-sm hidden-xs">6</span>
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/users/customers">
					<span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span>Customers<span
						class="label label-warning pull-right hidden-sm hidden-xs">21</span>
				</a></li>
			</ul>
		</li>

		<li
			class="link <%if ("shipping-route".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="${pageContext.request.contextPath}/admin/shipping-route">
				<span class="glyphicon glyphicon-road" aria-hidden=true></span> <span
				class="hidden-sm hidden-xs">Shipping Routes</span>
		</a>
		</li>

		<li
			class="link <%if ("tags".endsWith(url)) {%>active <%} else {%> null <%}%>">
			<a href="${pageContext.request.contextPath}/admin/tags"> <span
				class="glyphicon glyphicon-tags" aria-hidden=true></span> <span
				class="hidden-sm hidden-xs">Tags</span>
		</a>
		</li>
		<li class="link settings-btn"><a href="#"> <span
				class="glyphicon glyphicon-cog" aria-hidden=true></span> <span
				class="hidden-sm hidden-xs">Settings</span>
		</a></li>
	</ul>
</div>