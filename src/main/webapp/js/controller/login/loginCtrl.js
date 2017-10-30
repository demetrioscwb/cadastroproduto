testeUmApp.controller("loginController",function($scope,$http,requiredAPI){

	$scope.logar = function () {
		
		if(!requiredAPI.validaForm($scope.loginForm)){
			return;
		}
		
		$http.get('/cadastroproduto/login/'+$scope.loginVO.usuario.useLogin+"/"+$scope.loginVO.usuario.useSenha).success(function(data){
			
				$scope.loginVO = data;
				
				$scope.flaglogado = true;
			
			}).error(function(data, status, headers, config) {				
				$scope.msgErro = requiredAPI.validaErro(data);			
			}
		);
	}

	
	$scope.salvar = function () {
		
		if(!requiredAPI.validaForm($scope.loginForm)){
			return;
		}
		
		$http.post('/cadastroproduto/salvarUsuario',$scope.loginVO).success(function(data){
			$scope.loginVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}
	
});