<!-- Header Section 1 -->
<%@ include file="../../jspf/admin/header_section1.jsp"%>

<!-- Bootstrap -->
<%-- <link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet"> --%>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.form.css"
	rel="stylesheet">

<!-- Header Section 2 -->
<%@ include file="../../jspf/admin/header_section2.jsp"%>

<!-- Side Bar Details -->
<%@ include file="../../jspf/admin/sidebar.jsp"%>

<!-- Navigation Bar Details -->
<%@ include file="../../jspf/admin/navbar.jsp"%>

<div id="content">
	<header class="clearfix">
		<div class="row content-header-row">
			<h2 class="page_title pull-left">All System-users</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"
						aria-hidden=true></span> Users</a></li>
				<li class="active">System-users</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-5 dashboard-left-cell">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">SYSTEM USER INFORMATION</h3>
				</div>
				<!-- /.box-header -->
				<form:form role="form" method="post" action="addSystemUser"
					onsubmit="" commandName="systemUserDTO">
					<div class="box-body">
						<div class="form-group">
							<label for="input_name" class="control-label">Name <span
								class="mandatory-field">*</span></label>
							<form:input type="text" class="form-control" path="name"
								placeholder="Name" />
						</div>
						<div class="form-group">
							<label for="input_username" class="control-label">Username
								<span class="mandatory-field">*</span>
							</label>
							<form:input type="text" class="form-control" path="username"
								placeholder="Username" />
						</div>
						<div class="form-group">
							<label for="input_password" class="control-label">Password
								<span class="mandatory-field">*</span>
							</label>
							<form:input type="password" class="form-control" path="password"
								placeholder="Password" />
						</div>
						<%-- <div class="form-group">
							<label for="input_re_password" class="control-label">Re-enter
								Password <span class="mandatory-field">*</span>
							</label> <form:input type="password" class="form-control"
								id="input_re_password" name="input_re_password"
								placeholder="Re-enter Password" />
						</div> --%>
						<div class="form-group">
							<label for="input_image" class="control-label">Profile
								Image</label>
							<form:input type="file" class="form-control" path="image" />
							<p class="help-block">
								<i>NOTE: Image should not be larger than 2MB</i>
							</p>
						</div>
						<div class="form-group">
							<label for="input_email" class="control-label">Email <span
								class="mandatory-field">*</span></label>
							<form:input type="email" class="form-control" path="email"
								placeholder="Email" />
						</div>
						<div class="form-group">
							<label for="input_user-role" class="control-label">User
								Role <span class="mandatory-field">*</span>
							</label>
							<form:select class="form-control" path="systemUserRoleId">
								<c:forEach items="${systemUserRoleList}" var="systemUserRole">
									<option value="${systemUserRole.id}">${systemUserRole.displayRoleName}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group">
							<label for="input_user-role" class="control-label">User
								Country</label>
							<form:select class="form-control" path="countryId">
								<c:forEach items="${countryList}" var="country">
									<option value="${country.id}">${country.displayName}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group">
							<div class="checkbox">
								<label><form:checkbox path="isActive"
										value="Make user active?" />Make user active? </label>
							</div>
						</div>
					</div>
					<div class="box-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-large btn-primary"
								name="submit">Save User</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-md-7 dashboard-right-cell">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">SEARCH SYSTEM USERS</h3>
				</div>
				<form:form class="form-horizontal" role="form" method="get"
					action="searchSystemUser" onsubmit="" commandName="systemUserDTO">
					<div class="form-group">
						<div class="col-xs-10 col-sm-11 col-md-11">
							<form:input type="text" class="form-control saerch-field"
								placeholder="search" path="" />
						</div>
						<div class="col-xs-2 col-sm-1  col-md-1">
							<div class="form-group">
								<button type="submit" class="btn btn-primary col-md-3 go">Go</button>
							</div>
						</div>
					</div>
				</form:form>

				<c:choose>
					<c:when test="${empty searchSystemUserList}">
			        I see!  You don't have a name.. well.. Hello no name
			    </c:when>
					<c:otherwise>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th class="info-table-header">Index</th>
									<th class="info-table-header hidden-xs">Name</th>
									<th class="info-table-header hidden-xs">Country</th>
									<th class="info-table-header">Username</th>
									<th class="info-table-header">User Role</th>
									<th class="info-table-header">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${searchSystemUserList}" var="systemUser"
									varStatus="loop">
									<tr>
										<td>${loop.index + 1}</td>
										<td class="hidden-xs">${systemUser.name}</td>
										<td class="hidden-xs">${systemUser.country.displayName}</td>
										<td><span class="label label-success">${systemUser.username}</span></td>
										<td>${systemUser.systemUserRole.displayRoleName}</td>
										<td>
											<button type="button" class="btn btn-xs btn-warning">Edit</button>
											<button type="button" class="btn btn-xs btn-info">Activate</button>
											<a
											href="${pageContext.request.contextPath}/admin/users/removeSystemUser/${systemUser.id}">
												<button type="button" class="btn btn-xs btn-danger">Delete</button>
										</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>




			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">ACTIVE SYSTEM USERS</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header hidden-xs">Name</th>
							<th class="info-table-header hidden-xs">Country</th>
							<th class="info-table-header">Username</th>
							<th class="info-table-header">User Role</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<!-- <tr>
							<td>1</td>
							<td>Sasanka Amarasiri</td>
							<td><span class="label label-success">sasa_dssc</span></td>
							<td>MSC Admin</td>
							<td>
								<button type="button" class="btn btn-xs btn-warning">edit</button>
								<button type="button" class="btn btn-xs btn-danger disabled">delete</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Isuru Prashasthi</td>
							<td><span class="label label-success">ip_wimale</span></td>
							<td>MSC Admin</td>
							<td>
								<button type="button" class="btn btn-xs btn-warning">edit</button>
								<button type="button" class="btn btn-xs btn-danger">delete</button>
							</td>
						</tr> -->


						<c:forEach items="${systemUserList}" var="systemUser"
							varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td class="hidden-xs">${systemUser.name}</td>
								<td class="hidden-xs">${systemUser.country.displayName}</td>
								<td><span class="label label-success">${systemUser.username}</span></td>
								<td>${systemUser.systemUserRole.displayRoleName}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<a
									href="${pageContext.request.contextPath}/admin/users/removeSystemUser/${systemUser.id}">
										<button type="button" class="btn btn-xs btn-danger">Delete</button>
								</a>
								</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>

			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">NON-ACTIVE SYSTEM USERS</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header hidden-xs">Name</th>
							<th class="info-table-header hidden-xs">Country</th>
							<th class="info-table-header">Username</th>
							<th class="info-table-header">User Role</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${nonActiveSystemUserList}"
							var="nonActiveSystemUser" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td class="hidden-xs">${nonActiveSystemUser.name}</td>
								<td class="hidden-xs">${nonActiveSystemUser.country.displayName}</td>
								<td><span class="label label-success">${nonActiveSystemUser.username}</span></td>
								<td>${nonActiveSystemUser.systemUserRole.displayRoleName}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<button type="button" class="btn btn-xs btn-info">Activate</button>
									<a
									href="${pageContext.request.contextPath}/admin/users/removeSystemUser/${nonActiveSystemUser.id}">
										<button type="button" class="btn btn-xs btn-danger">Delete</button>
								</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</div>


<!-- Footer Section 1 -->
<%@ include file="../../jspf/admin/footer_section1.jsp"%>

<script
	src="${pageContext.request.contextPath}/resources/admin/js/cs.msc.admin.base.js"></script>

<!-- Footer Section 2 -->
<%@ include file="../../jspf/admin/footer_section2.jsp"%>