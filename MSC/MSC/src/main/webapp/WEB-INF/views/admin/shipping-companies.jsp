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
			<h2 class="page_title pull-left">All Shipping Companies</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-th"
						aria-hidden=true></span> General</a></li>
				<li class="active">Shipping Companies</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-5 dashboard-left-cell">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">SHIPPING COMPANY INFORMATION</h3>
				</div>

				<form:form role="form" method="post" action="addShippingCompany"
					onsubmit="" commandName="shippingCompanyDTO">
					<div class="box-body">
						<div class="form-group">
							<label for="input_business_name" class="control-label">Business
								Name <span class="mandatory-field">*</span>
							</label>
							<form:input type="text" class="form-control" path="businessName"
								placeholder="Business Name" />
						</div>
						<div class="form-group">
							<label for="input_business_registration_number"
								class="control-label">Business Registration Number <span
								class="mandatory-field">*</span></label>
							<form:input type="text" class="form-control" path="businessRegNo"
								placeholder="Business Registration Number" />
						</div>
						<div class="form-group">
							<label for="input_street_no" class="control-label">Street
								Number <span class="mandatory-field">*</span>
							</label>
							<form:input type="text" class="form-control" path="streetNo"
								placeholder="Street Number" />
						</div>
						<div class="form-group">
							<label for="input_street_name_1" class="control-label">Street
								Name 1 <span class="mandatory-field">*</span>
							</label>
							<form:input type="text" class="form-control" path="streetName1"
								placeholder="Street Name 1" />
						</div>
						<div class="form-group">
							<label for="input_street_name_2" class="control-label">Street
								Name 2 </label>
							<form:input type="text" class="form-control" path="streetName2"
								placeholder="Street Name 2" />
						</div>

						<div class="form-group">
							<label for="input_city" class="control-label">City <span
								class="mandatory-field">*</span>
							</label>

							<form:select class="form-control" path="cityId">
								<c:forEach items="${cityList}" var="city">
									<option value="${city.id}">${city.name}</option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group">
							<div class="checkbox">
								<label><form:checkbox path="isActive"
										value="Make user active?" />Make Shipping Company Active? </label>
							</div>
						</div>
					</div>
					<div class="box-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-large btn-primary"
								name="submit">Save Shipping Company</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<div class="col-md-7 dashboard-right-cell">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">SEARCH SHIPPING COMPANIES</h3>
				</div>
				<form:form class="form-horizontal" role="form" method="get"
					action="searchPort" onsubmit=" " commandName="shippingCompanyDTO">
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
					<c:when test="${empty shippingCompanyList}">
					</c:when>
					<c:otherwise>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th class="info-table-header">Index</th>
									<th class="info-table-header">Reg. No</th>
									<th class="info-table-header">Name</th>
									<th class="info-table-header">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${searchPortList}" var="shippingCompany"
									varStatus="loop">
									<tr>
										<td>${loop.index + 1}</td>
										<td>${shippingCompany.businessRegNo}</td>
										<td>${shippingCompany.businessName}</td>
										<td>
											<button type="button" class="btn btn-xs btn-warning">Edit</button>
											<button type="button" class="btn btn-xs btn-info">Activate</button>
											<a
											href="${pageContext.request.contextPath}/admin/general/removeShippingCompany/${shippingCompany.id}">
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
					<h3 class="box-title">ACTIVE SHIPPING COMPANIES</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header">Reg. No</th>
							<th class="info-table-header">Name</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${shippingCompanyList}" var="shippingCompany" varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td>${shippingCompany.businessRegNo}</td>
								<td>${shippingCompany.businessName}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<button type="button" class="btn btn-xs btn-info">Activate</button>
									<a
									href="${pageContext.request.contextPath}/admin/general/removeShippingCompany/${shippingCompany.id}">
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
					<h3 class="box-title">NON-ACTIVE SHIPPING COMPANIES</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Index</th>
							<th class="info-table-header">Reg. No</th>
							<th class="info-table-header">Name</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${nonActiveShippingCompanyList}" var="shippingCompany"
							varStatus="loop">
							<tr>
								<td>${loop.index + 1}</td>
								<td>${shippingCompany.businessRegNo}</td>
								<td>${shippingCompany.businessName}</td>
								<td>
									<button type="button" class="btn btn-xs btn-warning">Edit</button>
									<button type="button" class="btn btn-xs btn-info">Activate</button>
									<a
									href="${pageContext.request.contextPath}/admin/general/removeShippingCompany/${shippingCompany.id}">
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