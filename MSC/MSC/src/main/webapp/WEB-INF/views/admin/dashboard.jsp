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
	href="${pageContext.request.contextPath}/resources/admin/plugins/font-awesome-4.4.0/css/font-awesome.min.css"
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
			<h2 class="page_title pull-left">Dashboard</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</div>
	</header>

	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-red"><i
					class="fa fa-cog icon-color"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">CPU Traffic</span> <span
						class="info-box-number">90<small>%</small></span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-aqua"><i
					class="fa fa-facebook icon-color"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">Likes</span> <span
						class="info-box-number">41,410</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->

		<!-- fix for small devices only -->
		<div class="clearfix visible-sm-block"></div>

		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i
					class="fa fa-shopping-cart icon-color"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">Sales</span> <span
						class="info-box-number">760</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-yellow"><i
					class="fa fa-users icon-color"></i></span>
				<div class="info-box-content">
					<span class="info-box-text">New Members</span> <span
						class="info-box-number">2,000</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->

	
    




	<!-- Footer Section 1 -->
	<%@ include file="../../jspf/admin/footer_section1.jsp"%>
	
	<!-- jQuery 2.1.4 -->
    <script src="${pageContext.request.contextPath}/resources/admin/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath}/resources/admin/js/cs.msc.admin.base.js"></script>


	<!-- Footer Section 2 -->
	<%@ include file="../../jspf/admin/footer_section2.jsp"%>