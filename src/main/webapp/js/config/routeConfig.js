testeUmApp.config(function($routeProvider){
		
		$routeProvider.when('/tipo', {
	      templateUrl : 'view/tipo/tipo.jsp',
	      controller: 'tipoController'
		})
		$routeProvider.when('/produto', {
	      templateUrl : 'view/produto/produto.jsp',
	      controller: 'produtoController'
		})	
		$routeProvider.when('/marca', {
	      templateUrl : 'view/marca/marca.jsp',
	      controller: 'marcaController'
		})	
	 	$routeProvider.when('/usuario', {
	      templateUrl : 'view/login/usuario.jsp',
	      controller: 'usuarioController'
	    	  
		})
	 	$routeProvider.when('/errorLogin', {
	      templateUrl : 'view/login/errorLogin.jsp'
		})
		

	   // caso não seja nenhum desses, redirecione para a rota '/'
	   .otherwise ({ redirectTo: '/' });
	
	
});