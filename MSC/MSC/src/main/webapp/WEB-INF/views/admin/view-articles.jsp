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
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.view-articles.css"
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
			<h2 class="page_title pull-left">All articles</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-list-alt"
						aria-hidden=true></span> Article</a></li>
				<li class="active">View Articles</li>
			</ol>
		</div>
		<div class="row content-header-row">
		<button type="button" class="btn btn-xs btn-primary pull-right">Create new article</button>
		</div>
	</header>

	<div class="content-inner">
		<div class="row search-row">
			<div class="col-md-12">
				<div class="input-group">
					<input type="text" class="form-control saerch-field" id="" placeholder="search">
					<span class="input-group-btn">
						<button type="button" class="btn btn-primary go">Go</button>
					</span>
				</div>
			</div>
		</div>
		<div class="row article-row">
			<div class="col-xs-2 col-sm-1 col-md-1 status-padding">
				<span class="label label-success label-sm">Active</span>
			</div>
			<div class="col-xs-10 col-sm-6 col-md-8 article-title">
				<p>lorum ipsum dolor btter com'on lanka</p>
				<small>Created 12th August 2015</small>
			</div>
			<div class="col-xs-10 col-sm-5 col-md-3 col-xs-offset-2 col-sm-offset-0 col-md-offset-0 col-lg-offset-0">
				<div class="article-actions">
					<a class="btn btn-xs btn-default" href="#" role="button">
						<span class="glyphicon glyphicon-folder-open" aria-hidden="true">&nbsp;View</span>
					</a>
					<a class="btn btn-xs btn-default" href="#" role="button">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true">&nbsp;Edit</span>
					</a>
					<a class="btn btn-xs btn-default" href="#" role="button">
						<span class="glyphicon glyphicon-remove" aria-hidden="true">&nbsp;Delete</span>
					</a>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<nav>
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</nav>
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