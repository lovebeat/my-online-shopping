$(function(){
	switch(menu){
		case 'About':
			$('#about').addClass('active');
			break;
		case 'Contact':
			$('#contact').addClass('active');
			break;
		default:
			$('#navbar-brand').addClass('active');
			break;
	}

});