testeUmApp.controller("produtoController",function($scope,$http,requiredAPI){
	
	$scope.initProduto = function () { 
		
		$http.get('/cadastroproduto/initProduto').success(function(data){							

			$scope.produtoVO = data;
			
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});	
		
	}
	
	$scope.cadastrarProduto = function () {		
		
		if(!requiredAPI.validaForm($scope.produtoForm)){
			return;
		}
		
		$http.post('/cadastroproduto/cadastrarProduto',$scope.produtoVO).success(function(data){
			
			$scope.produtoVO = data;
	
		}).error(function(data, status, headers, config) {			
			$scope.msgErro = requiredAPI.validaErro(data);			
		});
		
	}
	
	$scope.excluirProduto = function (prdId) {
		
		$http({
		    method: 'DELETE',
		    url: '/cadastroproduto/excluirProduto/'+prdId,
		    headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).success(function(data){
			
			$scope.produtoVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});
		
	}
	
	$scope.selecionarProduto = function (pd) {
		$scope.produtoVO.produto = angular.copy(pd);	
		$scope.produtoVO.tpoId = angular.copy(pd).tipo.tpoId.toString();
		$scope.produtoVO.mrcId = angular.copy(pd).marca.mrcId.toString();
	}
	
	$scope.alterarProduto = function () {
		
		if(!requiredAPI.validaForm($scope.produtoForm)){
			return;
		}
		
		$http.put('/cadastroproduto/alterarProduto',$scope.produtoVO).success(function(data){
			
			$scope.produtoVO = data;
	
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);;
		});
	}
	
	$scope.pesquisarProduto = function () { 
		
		var url  = '/cadastroproduto/pesquisarProduto';
		url = url + '/' + (typeof($scope.produtoVO.produto.prdNome)=='string'?$scope.produtoVO.produto.prdNome:'') ;
		url = url + '/' + $scope.produtoVO.mrcId;
		url = url + '/' + $scope.produtoVO.tpoId;
		
		$http.get(url).success(function(data){							

			$scope.produtoVO.produtos = data.produtos;
			
		}).error(function(data, status, headers, config) {
			$scope.msgErro = requiredAPI.validaErro(data);
		});	
		
	}
	
	$scope.initProduto();
	
});