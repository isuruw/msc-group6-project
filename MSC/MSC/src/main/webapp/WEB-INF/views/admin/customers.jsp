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
			<h2 class="page_title pull-left">All Customers</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"
						aria-hidden=true></span> Users</a></li>
				<li class="active">Customers</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-6 dashboard-left-cell">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">CUSTOMER INFORMATION</h3>
				</div>
				<!-- /.box-header -->
				<form:form role="form" method="post" action="addCustomer"
					onsubmit="" commandName="customerDTO">
					<div class="box-body">
						<div class="form-group">
							<label for="input_business_name" class="control-label">Business
								Name</label>
								<form:input type="text" class="form-control" path="businessName" placeholder="Business Name" />
						</div>
						<div class="form-group">
							<label for="input_registration_number"
								class="control-label">Reg. No</label>
								<form:input type="text" class="form-control" path="businessRegNo" placeholder="Business Registration Number" />
						</div>
						<div class="form-group">
							<label for="input_email" class="control-label">Email</label>
								<form:input type="email" class="form-control" path="email" placeholder="Email" />
						</div>
						<div class="form-group">
							<label for="input_password" class="control-label">Password</label>
								<input type="password" class="form-control" id="input_password"
									name="input_password" placeholder="Password">
						</div>
						<div class="form-group">
							<label for="input_street_no"
								class="control-label">Street No.</label>
								<input type="text" class="form-control"
									id="input_street_no" name="input_street_no"
									placeholder="Street number">
						</div>
						<div class="form-group">
							<label for="input_street_name_1"
								class="control-label">Street Name 1</label>
								<input type="text" class="form-control"
									id="input_street_name_1" name="input_street_name_1"
									placeholder="Street Name 1">
						</div>
						<div class="form-group">
							<label for="input_street_name_2"
								class="control-label">Street Name 2</label>
								<input type="text" class="form-control"
									id="input_street_name_2" name="input_street_name_2"
									placeholder="Street Name 2">
						</div>
						<div class="form-group">
							<label for="input_telephone" class="control-label">Tel.
								No</label>
								<input type="text" class="form-control" id="input_telephone"
									name="input_telephone" placeholder="Telephone">
						</div>
						<div class="form-group">
							<label for="input_fax" class="control-label">Fax</label>
								<input type="text" class="form-control" id="input_fax"
									name="input_fax" placeholder="Fax">
						</div>
						<div class="form-group">
							<label for="input_city" class="control-label">City</label>
								<select class="form-control">
									<option>option 1</option>
									<option>option 2</option>
									<option>option 3</option>
									<option>option 4</option>
									<option>option 5</option>
								</select>
						</div>
						<div class="form-group">
							<label for="input_country" class="control-label">Country</label>
								<select class="form-control">
									<option>option 1</option>
									<option>option 2</option>
									<option>option 3</option>
									<option>option 4</option>
									<option>option 5</option>
								</select>
						</div>
						<div class="form-group">
							<div class="checkbox">
								<label><form:checkbox path="isActive" value="Make customer active?"/>Make customer active?
								</label>
							</div>
						</div>

					</div>
					<div class="box-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-large btn-block btn-primary">Save Customer</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-md-6 dashboard-right-cell">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">REGISTERED CUSTOMERS</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Business Name</th>
							<th class="info-table-header">Active</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>DHL</td>
							<td><span class="label label-success">Yes</span></td>
							<td>
								<button type="button" class="btn btn-xs btn-warning">edit</button>
								<button type="button" class="btn btn-xs btn-danger disabled">delete</button>
							</td>
						</tr>
						<tr>
							<td>Kapruka</td>
							<td><span class="label label-success">No</span></td>
							<td>
								<button type="button" class="btn btn-xs btn-warning">edit</button>
								<button type="button" class="btn btn-xs btn-danger">delete</button>
							</td>
						</tr>
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