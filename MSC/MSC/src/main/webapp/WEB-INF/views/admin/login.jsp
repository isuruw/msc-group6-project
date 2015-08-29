<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>${title}</title>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/admin/images/favicon-admin.ico" type="image/x-icon">

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/admin/css/cs.msc.admin.login.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-page" onload='document.loginForm.input_username.focus();'>

	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Admin</b>PANEL</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name='loginForm'
				action="<c:url value='/j_spring_security_check' />" method='POST'>
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="username"
						placeholder="Username" /> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password"
						placeholder="Password" /> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> Remember Me
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" value="login"
							class="btn btn-primary btn-block btn-flat" name="btn_login">Sign
							In</button>
					</div>
					
					<!-- /.col -->
				</div>
				
			</form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google-plus btn-flat"><i
					class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div>
			<!-- /.social-auth-links -->

			<a href="#">I forgot my password</a><br> <a href="register.html"
				class="text-center">Register a new membership</a>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>