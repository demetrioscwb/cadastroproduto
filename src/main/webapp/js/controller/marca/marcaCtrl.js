testeUmApp.controller("marcaController",function($scope,$http,requiredAPI){

	$scope.cadastrarMarca = function () {
		
		if(!requiredAPI.validaForm($scope.marcaForm)){
			return;
		}
		
		$http.post('/cadastroproduto/cadastrarMarca',$scope.marcaVO).success(function(data){
			
			$scope.marcaVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}

	$scope.initMarca = function () { 
	
		$http.get('/cadastroproduto/initMarca').success(function(data){							

			$scope.marcaVO = data;
			
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});	
		
	}
	
	$scope.excluirMarca = function (mrcId) {
	
		$http({
		    method: 'DELETE',
		    url: '/cadastroproduto/excluirMarca/'+mrcId,
		    headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).success(function(data){
			
			$scope.marcaVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}
	
	$scope.selecionarMarca = function (mr) {
		$scope.marcaVO.marca = angular.copy(mr);		
	}
	
	$scope.alterarMarca = function () {
		
		if(!requiredAPI.validaForm($scope.marcaForm)){
			return;
		}
		
		$http.put('/cadastroproduto/alterarMarca',$scope.marcaVO).success(function(data){
			
			$scope.marcaVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
	}
	
	$scope.initMarca();
	
});