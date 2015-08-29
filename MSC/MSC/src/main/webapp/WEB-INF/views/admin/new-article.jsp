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
	href="${pageContext.request.contextPath}/resources/admin/plugins/chosen_v1.4.2/chosen.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/plugins/font-awesome-4.4.0/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/plugins/summernote-master/dist/summernote.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.base.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.new-article.css"
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
			<h2 class="page_title pull-left">Create new article</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-list-alt"
						aria-hidden=true></span> Article</a></li>
				<li class="active">New Article</li>
			</ol>
		</div>
	</header>


	<div class="content-inner">
		<div class="form-wrapper">
			<form>
				<div class="form-group">
					<label class="sr-only">Title</label> <input type="text"
						class="form-control" id="title" placeholder="Title">
				</div>
				<div class="form-group">
					<label class="sr-only">Tags</label> <select
						data-placeholder="Select tags" multiple name="tags"
						class="form-control chosen-select">
						<option></option>
						<option>html</option>
						<option>css</option>
						<option>coding</option>
						<option>programming</option>
					</select>
				</div>
				<div class="form-group">
					<label class="sr-only">Article</label>
					<textarea class="form-control summernote" placeholder="Article"
						name="article"></textarea>
				</div>

				<div class="checkbox">
					<label> <input type="checkbox"> Publish article
						when I click on save
					</label>
				</div>

				<div class="clearfix">
					<button type="submit" class="btn btn-primary pull-right">Save
						/ Publish</button>
				</div>
			</form>
		</div>
	</div>
</div>



<!-- Footer Section 1 -->
<%@ include file="../../jspf/admin/footer_section1.jsp"%>

<script
	src="${pageContext.request.contextPath}/resources/admin/chosen_v1.4.2/chosen.jquery.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/admin/js/cs.msc.admin.base.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/admin/summernote-master/dist/summernote.min.js"></script>

<script type="text/javascript">
	var config = {
		'.chosen-select' : {},
		'.chosen-select-deselct' : {
			allow_single_deselect : true
		},
		'.chosen-select-no-single' : {
			disable_search_threshold : 10
		},
		'.chosen-select-no-result' : {
			no_results_text : 'Oops, nothing found!'
		},
		'.chosen-select-width' : {
			width : "95%"
		}
	}
	for ( var selector in config) {
		$(selector).chosen(config[selector]);
	}
</script>

<script type="text/javascript">
	$('.summernote').summernote({
		height : 200
	});
</script>

<!-- Footer Section 2 -->
<%@ include file="../../jspf/admin/footer_section2.jsp"%>