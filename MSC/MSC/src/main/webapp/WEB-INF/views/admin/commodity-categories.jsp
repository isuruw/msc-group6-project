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
			<h2 class="page_title pull-left">All Commodity Categories</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-th"
						aria-hidden=true></span> General</a></li>
				<li class="active">Commodity Categories</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-5 dashboard-left-cell">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">COMMODITY CATEGORY INFORMATION</h3>
				</div>

				<form:form role="form" method="post" action="addCommodityCategory"
					onsubmit="" commandName="commodityCategoryDTO">
					<div class="box-body">
						<div class="form-group">
							<label for="input_code" class="control-label">code <span
								class="mandatory-field">*</span></label>
							<form:input type="text" class="form-control" path="code"
								placeholder="Code" />
						</div>
						<div class="form-group">
							<label for="input_name" class="control-label">name <span
								class="mandatory-field">*</span>
							</label>
							<form:input type="text" class="form-control" path="name"
								placeholder="Name" />
						</div>
						<div class="form-group">
							<label for="input_description" class="control-label">Description
							</label>
							<%-- <form:input type="password" class="form-control" path="description"
								placeholder="Password" /> --%>
							<form:textarea class="form-control" rows="5" path="description"
								placeholder="Description"></form:textarea>
						</div>

						<div class="form-group">
							<div class="checkbox">
								<label><form:checkbox path="isActive"
										value="Make user active?" />Make category active? </label>
							</div>
						</div>
					</div>
					<div class="box-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-large btn-primary"
								name="submit">Save Commodity Category</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<div class="col-md-7 dashboard-right-cell">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">SEARCH COMMODITY CATEGORIES</h3>
				</div>
				<form:form class="form-horizontal" role="form" method="get"
					action="searchCommodityCategory" onsubmit=" " commandName="commodityCategoryDTO">
					<div class="form-group">
						<div class="col-xs-10 col-sm-11 col-md-11">
							<form:input type="text" class="form-control saerch-field"
								placeholder="search" path="" />
						</div>
						<div class="col-xs-2 col-sm-1 col-md-1">
							<div class="form-group">
								<button type="submit" class="btn btn-primary col-md-3 go">Go</button>
							</div>
						</div>
					</div>
				</form:form>

				<c:choose>
					<c:when test="${empty searchCommodityCategoryList}">
			    </c:when>
					<c:otherwise>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th class="info-table-header">Index</th>
									<th class="info-table-header">Code</th>
									<th class="info-table-header">Name</th>
									<th class="info-table-header">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${searchCommodityCategoryList}"
									var="commodityCategory" varStatus="loop">
									<tr>
										<td>${loop.index + 1}</td>
										<td>${commodityCategory.code}</td>
										<td>${commodityCategory.name}</td>
										<td>
											<button type="button" class="btn btn-xs btn-warning">Edit</button>
											<button type="button" class="btn btn-xs btn-info">Activate</button>
											<a
											href="${pageContext.request.contextPath}/admin/general/removeCommodityCategory/${commodityCategory.id}">
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
					<h3 class="box-title">ACTIVE COMMODITY CATEGORIES</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header">Code</th>
							<th class="info-table-header hidden-xs">Name</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${commodityCategoryList}"
							var="commodityCategory" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td>${commodityCategory.code}</td>
								<td class="hidden-xs">${commodityCategory.name}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<button type="button" class="btn btn-xs btn-info">Deactivate</button>
									<a
									href="${pageContext.request.contextPath}/admin/general/removeCommodityCategory/${commodityCategory.id}">
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
					<h3 class="box-title">NON-ACTIVE COMMODITY CATEGORIES</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header">Code</th>
							<th class="info-table-header hidden-xs">Name</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${nonActiveCommodityCategoryList}"
							var="commodityCategory" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td>${commodityCategory.code}</td>
								<td class="hidden-xs">${commodityCategory.name}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<button type="button" class="btn btn-xs btn-info">Activate</button>
									<a
									href="${pageContext.request.contextPath}/admin/general/removeCommodityCategory/${commodityCategory.id}">
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