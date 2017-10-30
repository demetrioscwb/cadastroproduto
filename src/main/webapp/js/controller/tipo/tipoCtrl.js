testeUmApp.controller("tipoController",function($scope,$http, $rootScope,requiredAPI){
	
	$scope.cadastrarTipo = function () {	
		
		if(!requiredAPI.validaForm($scope.tipoForm)){
			return;
		}
		
		$http.post('/cadastroproduto/cadastrarTipo',$scope.tipoVO).success(function(data){
			
			$scope.tipoVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}

	$scope.initTipo = function () { 
	
		$http.get('/cadastroproduto/initTipo').success(function(data){							

			$scope.tipoVO = data;
			
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});	
		
	}
	
	$scope.excluirTipo = function (tpoId) {
	
		$http({
		    method: 'DELETE',
		    url: '/cadastroproduto/excluirTipo/'+tpoId,
		    headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).success(function(data){
			
			$scope.tipoVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}
	
	$scope.selecionarTipoAlterar = function (tp) {
		$scope.tipoVO.tipo = angular.copy(tp);		
	}
	
	$scope.alterarTipo = function () {
		
		if(!requiredAPI.validaForm($scope.tipoForm)){
			return;
		}
		
		$http.put('/cadastroproduto/alterarTipo',$scope.tipoVO).success(function(data){
			
			$scope.tipoVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
	}
	
	$scope.initTipo();

	
});