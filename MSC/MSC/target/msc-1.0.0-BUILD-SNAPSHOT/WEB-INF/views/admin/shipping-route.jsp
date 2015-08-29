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
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.css" />


<!-- Header Section 2 -->
<%@ include file="../../jspf/admin/header_section2.jsp"%>

<!-- Side Bar Details -->
<%@ include file="../../jspf/admin/sidebar.jsp"%>

<!-- Navigation Bar Details -->
<%@ include file="../../jspf/admin/navbar.jsp"%>

<div id="content">
	<header class="clearfix">
		<div class="row content-header-row">
			<h2 class="page_title pull-left">All Shipping Routes</h2>
			<ol class="breadcrumb pull-right hidden-xs hidden-sm">
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"
						aria-hidden=true></span> Home</a></li>
				<li class="active">Shipping Routes</li>
			</ol>
		</div>
	</header>

	<div class="row">

		<div class="col-md-12">
			<div class="admin-content-con admin-content-con-info">
				<div class="box-header with-border">
					<h3 class="box-title">Shipping Route</h3>
				</div>
				<!-- /.box-header -->
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
				<div class="route-map">
					<button type="button"
						class="btn btn-blcok btn-info btn-primary btn-toggle-map">Toggle
						Map</button>
					<div id="map" style="height: width: 600px; height: 400px;"></div>
				</div>
			</div>
		</div>

		<div class="col-md-12">
			<div class="admin-content-con admin-content-con-primary">
				<div class="box-header with-border">
					<h3 class="box-title">SHIPPING ROUTE INFORMATION</h3>
				</div>
				<!-- /.box-header -->
				<form role="form" name="shipping_route_form" method="post"
					action="addShippingRoute" onsubmit="" id="shipping_route_form">
					<div class="box-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Ship
										<span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Route
										<span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<hr width="100%"/>
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Departure
										Port <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Departure
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Destination
										Port <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Arrival
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<hr width="100%"/>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Visiting
										Port 1 <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Arrival
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Departure
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Visiting
										Port 2 <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Arrival
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Departure
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Visiting
										Port 3 <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Arrival
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Departure
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_user-role" class="control-label">Visiting
										Port 4 <span class="mandatory-field">*</span>
									</label> <select class="form-control">
										<option>option 1</option>
										<option>option 2</option>
										<option>option 3</option>
										<option>option 4</option>
										<option>option 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Arrival
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="input_date" class="control-label">Time Departure
										<span class="mandatory-field">*</span>
									</label>
									<input type="text" class="form-control"
										path="date" placeholder="date" />
								</div>
							</div>
						</div>
					</div>
					<div class="box-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-large btn-primary"
								name="submit">Save Route</button>
						</div>
					</div>

				</form>
			</div>
		</div>

	</div>
</div>


<!-- Footer Section 1 -->
<%@ include file="../../jspf/admin/footer_section1.jsp"%>

<script
	src="${pageContext.request.contextPath}/resources/admin/js/cs.msc.admin.base.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.3/leaflet.js"></script>

<script>
	var map = L.map('map').setView([ 51.505, -0.09 ], 13);

	L
			.tileLayer(
					'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6IjZjNmRjNzk3ZmE2MTcwOTEwMGY0MzU3YjUzOWFmNWZhIn0.Y8bhBaUMqFiPrDRW9hieoQ',
					{
						maxZoom : 18,
						attribution : 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, '
								+ '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
								+ 'Imagery © <a href="http://mapbox.com">Mapbox</a>',
						id : 'mapbox.streets'
					}).addTo(map);

	L.marker([ 51.5, -0.09 ]).addTo(map).bindPopup(
			"<b>Hello world!</b><br />I am a popup.").openPopup();

	L.circle([ 51.508, -0.11 ], 500, {
		color : 'red',
		fillColor : '#f03',
		fillOpacity : 0.5
	}).addTo(map).bindPopup("I am a circle.");

	L.polygon([ [ 51.509, -0.08 ], [ 51.503, -0.06 ], [ 51.51, -0.047 ] ])
			.addTo(map).bindPopup("I am a polygon.");

	var popup = L.popup();

	function onMapClick(e) {
		popup.setLatLng(e.latlng).setContent(
				"You clicked the map at " + e.latlng.toString()).openOn(map);
	}

	map.on('click', onMapClick);
</script>

<script>
	$(document).ready(function() {
		$(".btn-toggle-map").click(function() {
			$("#map").toggle(500);
		});
	});

</script>


<!-- Footer Section 2 -->
<%@ include file="../../jspf/admin/footer_section2.jsp"%>