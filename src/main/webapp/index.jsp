<%@ page language="java" contentType="text/html; charset=UTF-8		"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html ng-app="testeUmApp">
<head>
<meta charset="ISO-8859-1">
	<link href="lib/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet" media="screen"></link>
	<script type="text/javascript" src="lib/angular.min.js"></script>
	<script type="text/javascript" src="lib/angular-route.min.js"></script>

	<script type="text/javascript" src="js/controller/app.js"></script>	
	<script type="text/javascript" src="js/service/requiredApiService.js"></script>
	<script type="text/javascript" src="js/controller/login/loginCtrl.js"></script>
	
	<script type="text/javascript" src="js/controller/usuario/usuarioCtrl.js"></script>
	<script type="text/javascript" src="js/controller/marca/marcaCtrl.js"></script>
	<script type="text/javascript" src="js/controller/produto/produtoCtrl.js"></script>
	<script type="text/javascript" src="js/controller/tipo/tipoCtrl.js"></script>
	
	<script type="text/javascript" src="js/config/routeConfig.js"></script>	

	
<title></title>
</head>
<body>

	<div ng-controller="loginController">
	
	<form name="loginForm">
	
		<div class="alert alert-danger" ng-show="msgErro">{{msgErro}}</div>
	
		<div class="container" ng-show="!flaglogado">
		    <div class="row">
		        <div class="form_bg">
		            <form>
						<h2 class="text-center">{{isCadastro?'CADASTRAR USUÁRIO':'LOGIN'}}</h2>
		                <br/>
		                <div class="form-group">
		                    <input type="text" class="form-control" id="useLogin" name="useLogin" required ng-model="loginVO.usuario.useLogin" placeholder="Login">
		                </div>
		                <div class="form-group">
		                    <input type="password" class="form-control" id="useSenha" name="useSenha" required ng-model="loginVO.usuario.useSenha" placeholder="Senha">
		                
		                    </div>
		                    <br/>
		                   <div class="align-center">
		                		<button class="btn btn-success" id="btn_login" ng-show="!isCadastro" ng-click="logar()">Login</button>
		                		<button class="btn btn-primary" id="bt_cadastrar" ng-show="!isCadastro" ng-click="isCadastro=true">Cadastrar</button>
		                		<button class="btn btn-success" id="bt_salvar" ng-show="isCadastro" ng-click="salvar();isCadastro=false">Salvar</button>
		                    </div>
		            </form>
		        </div>
		    </div>
		</div> 
		
	</form>   
		<div ng-show="flaglogado">
			<ul class="nav nav-tabs">
			   <li ng-class="{active: activetab == '/'}"><a href="#/tipo">TIPO</a></li>
			   <li ng-class="{active: activetab == '/'}"><a href="#/produto">PRODUTO</a></li>
			   <li ng-class="{active: activetab == '/'}"><a href="#/marca">MARCA</a></li>
			   <li ng-class="{active: activetab == '/'}"><a href="#/usuario">USUÀRIOS</a></li>
			</ul>
			
			<div ng-view></div>
		</div>
		
	</div>

</body>
</html>