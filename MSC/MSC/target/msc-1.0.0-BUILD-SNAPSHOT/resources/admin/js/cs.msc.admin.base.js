$(document).ready(function() {
	/*$(".link").removeClass('active');
	$(".link").click(function(e) {
		//e.preventDefault();
		$(this).addClass('active').siblings().removeClass('active');
	});*/

	$('[data-toggle="offcanvas"]').click(function() {
		$('#side-menu').toggleClass('hidden-xs');
	});

});