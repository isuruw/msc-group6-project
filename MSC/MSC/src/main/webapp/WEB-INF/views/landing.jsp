<!-- Header Details -->
<%@ include file="../jspf/header.jsp"%>

<script>
	$(document).ready(function() {
		$(".options").hide();

		$("#flip").click(function() {
			$("#panel").slideToggle("slow");
		});

		$(".selectContainer").mouseover(function() {
			$(".options").slideDown("slow");
		});

		$(".selectContainer").mouseleave(function() {
			$(".options").hide();
		});
	});
</script>


<style>
#panel, #flip {
	/*padding: 5px;
    text-align: center;
    background-color: #e5eecc;
    border: solid 1px #c3c3c3;*/
	
}

#panel {
	height: auto;
	padding: 10px;
	display: none;
	background-color: red;
	overflow: hidden;
}
</style>

<!-- First Run Section1 - START -->
<div class="first_run_section1">
	<div class="wrapper">
		<div class="container">
			<div class="col-md-0 col-md-push-12">
				<div class="row">
					<div class="col-md-2 pull-right">
						<div class="form-group">
							<div class="col-xs-5 selectContainer">
								<div class="selected-option">
									EN <span class="caret"></span>
								</div>
								<div class="options">
									<ul class="option-list">
										<li>ZH</li>
										<li>FR</li>
										<li>DE</li>
										<li>IT</li>
										<li>JA</li>
										<li>KO</li>
										<li>PT</li>
										<li>RU</li>
										<li>ES</li>
										<li>TR</li>
									</ul>
								</div>
							</div>
						</div>
					</div>





					<div class="row">
						<div class="col-md-6 col-md-offset-3 logo"
							style="position: absolute;">
							<%-- <img
								src="${pageContext.request.contextPath}/resources/images/first_run/logoFirstRun.png" /> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- First Run Section1 - END -->

<!-- First Run Section2 - START -->
<div class="first_run_section2">
	<div class="wrapper">
		<div class="container">

			<div class="col-md-12 blank-area">
				<div class="row"></div>
			</div>
			<div class="row">
				<div class="col-md-12 content-area">
					<h1 class="font-white">WELCOME TO MSC</h1>
					<h3 class="font-yellow">Please select a country</h3>

					<div class="row">
						<div class="col-md-2 col-md-offset-1">
							<div class="form-group">
								<button type="button" class="btn btn-default first_run_btn">AMERICAS</button>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<button type="button" class="btn btn-default first_run_btn">AFRICA</button>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<button type="button" class="btn btn-default first_run_btn">EUROPE</button>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<button type="button" class="btn btn-default first_run_btn">MIDDLE
									EAST</button>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<button type="button" class="btn btn-default first_run_btn"
									id="flip">ASIA - PACIFIC</button>
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<div id="panel">
								<div class="col-md-3">
									<ul>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
									</ul>
								</div>
								<div class="col-md-3">
									<ul>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li>Australia</li>
										<li><a href="/msc/lka">Sri Lanka</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>
<!-- First Run Section2 - END -->

<!-- First Run Section3 - START -->
<div class="first_run_section3">
	<div class="wrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<hr />
					<div class="row">
						<div class="col-md-6 col-md-offset-1">
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<p>
								&copy; Copyright 1996-
								<fmt:formatDate pattern="yyyy" value="${now}" />
								- MSC S.A. All Rights Reserved
							</p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<!-- First Run Section3 - END -->