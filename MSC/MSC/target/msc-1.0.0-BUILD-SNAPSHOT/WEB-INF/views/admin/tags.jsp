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
			<h2 class="page_title pull-left">All Tags</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li class="active">Tags</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-7 dashboard-left-cell">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">CREATE TAGS</h3>
				</div>
				<!-- /.box-header -->
				<form role="form">
					<div class="box-body">
						<div class="form-group">
							<label for="input_tags">Add comma separated tags below</label>
							<p>
								<textarea class="form-control" rows="3"
									placeholder="eg: coding, css, python, ruby"></textarea>
							</p>
						</div>
						<div class="box-footer">
							<p>
								<button type="button"
									class="btn btn-large btn-block btn-primary">Save tags</button>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-5 dashboard-right-cell">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">TAGS</h3>
				</div>
				<!-- /.box-header -->
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="info-table-header">Name</th>
							<th class="info-table-header">Status</th>
							<th class="info-table-header">Created On</th>
							<th class="info-table-header">Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>python</td>
							<td><span class="label label-success">in-use</span></td>
							<td>2 days ago</td>
							<td>
								<button type="button" class="btn btn-xs btn-warning">edit</button>
								<button type="button" class="btn btn-xs btn-danger disabled">delete</button>
							</td>
						</tr>
						<tr>
							<td>css</td>
							<td><span class="label label-success">not used</span></td>
							<td>4 days ago</td>
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

