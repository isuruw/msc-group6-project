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
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.comments.css"
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
			<h2 class="page_title pull-left">All approved comments</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-pencil"
						aria-hidden=true></span> Comments</a></li>
				<li class="active">Approved Comments</li>
			</ol>
		</div>
	</header>

	<div class="content-inner">
		<div class="row search-row">
			<div class="col-md-12">
				<div class="input-group">
					<input type="text" class="form-control saerch-field" id=""
						placeholder="search"> <span class="input-group-btn">
						<button type="button" class="btn btn-primary go">Go</button>
					</span>
				</div>
			</div>
		</div>

		<div class="row comments-row">
			<div class="col-sm-2 col-md-1">
				<img class="img-circle hidden-xs"
					src="http://www.testing-solutions.com/sites/default/files/quotes/Blue%20square%20icon%20130x130_1.jpg">
			</div>
			<div class="col-sm-10 col-md-11">
				<div class="row">
					<div class="col-xs-9 col-sm-10 col-md-9">
						<b>Sasanka Amarasiri</b> posted message on <b>How all things
							are made</b><br /> <small>2.23 pm - 12/08/2015</small>
					</div>
					<div class="col-xs-3 col-sm-2 col-md-3">
						<div class="clearfix">
							<div class="pull-right comment-age">2 days ago</div>
						</div>
					</div>
				</div>
				<div class="well well-sm comments-well">
					Lorem Ipsum is simply dummy text of the
					printing and typesetting industry. Lorem Ipsum has been the
					industry's standard dummy text ever since the 1500s, when an
					unknown printer took a galley of type and scrambled it to make a
					type specimen book. It has survived not only five centuries.
				</div>
				<div class="clearfix">
					<div class="pull-right">
						<a class="btn btn-xs btn-default" href="#" role="button">
							<sapn class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></sapn>
							Un-approve
						</a>
						<a class="btn btn-xs btn-default" href="#" role="button">
							<sapn class="glyphicon glyphicon-remove" aria-hidden="true"></sapn>
							Delete
						</a>
					</div>
				</div>
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

