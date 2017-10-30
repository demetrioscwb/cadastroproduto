testeUmApp.service("requiredAPI", function($location){	

	this.validaForm = function(form){
		
		var text = '';
		
		var valid = true;
		
		for (var error in form.$error.required){
			valid = false;
		}

		
		return	valid;
		
	};
	
	this.validaErro = function(data){
		
		if(data.validationMessage.id=='HTTP 403'){
			return data.validationMessage.message;
		}

		$location.path("/errorLogin");
		
	};
	

		
});

