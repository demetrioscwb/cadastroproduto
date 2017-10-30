testeUmApp.controller("usuarioController",function($scope,$http,$rootScope,requiredAPI){	
		
	
	$scope.initUsuarioControle = function () { 
		
		$http.get('/cadastroproduto/initUsuarioControle').success(function(data){							

			$scope.usuarioVO = data;
			
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});	
		
	}
	
	$scope.initUsuarioControle();
	
	$scope.excluirUsuario = function (useId) {
	
		$http({
		    method: 'DELETE',
		    url: '/cadastroproduto/excluirUsuario/'+useId,
		    headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).success(function(data){
			
			$scope.usuarioVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);		
		});
		
	}
		
	
});