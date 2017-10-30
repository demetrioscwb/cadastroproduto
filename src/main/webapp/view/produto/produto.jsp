
<body ng-controller="produtoController">

	<form name="produtoForm">
	
		<div class="form-group">
			<fieldset class="col-sm-10">
				<legend>PRODUTO</legend>
				<div class="row">
					<div class="col-xs-4">
						<label for="prdNome" class="col-sm-2 control-label">Nome*</label>
						<input type="text" class="form-control" title="Nome" id="prdNome" name="prdNome" required  ng-model="produtoVO.produto.prdNome"/>
					</div>
					<div class="col-xs-4">
						<label for="prdMarca" class="col-sm-2 control-label">Marca*</label>
						<select class="form-control" id="prdMarca" name="prdMarca" required ng-model="produtoVO.mrcId">
					  		<option ng-repeat="mr in produtoVO.marcas" value="{{mr.mrcId}}">{{mr.mrcNome}}</option>
						</select>
					</div>
					<div class="col-xs-4">
						<label for="prdTipo" class="col-sm-2 control-label">Tipo*</label>
						<select class="form-control" id="prdTipo" name="prdTipo" required ng-model="produtoVO.tpoId">
					  		<option ng-repeat="tp in produtoVO.tipos" value="{{tp.tpoId}}">{{tp.tpoNome}}</option>
						</select>
					</div>
					</div>
					<br/>
					<div class="form-group">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-success" ng-click="cadastrarProduto()" ng-show="!produtoVO.produto.prdId">Cadastrar</button>
							<button type="submit" class="btn btn-success" ng-click="alterarProduto()" ng-show="produtoVO.produto.prdId">Confirmar</button>
							<button type="submit" class="btn btn-primary" ng-click="pesquisarProduto()">Pesquisar</button>
						</div>
					</div>
				</div>
				<br/><br/>
				<div class="form-group  col-sm-10">
					<table class="table">
						<thead class="thead-inverse">
						<tr>
						<th>Nome</th>
						<th>Marca</th>
						<th>Tipo</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
							<tr ng-repeat="prod in produtoVO.produtos">
								<td>{{prod.prdNome}}</td>
								<td>{{prod.marca.mrcNome}}</td>
								<td>{{prod.tipo.tpoNome}}</td>
								<td>
									<button type="submit" class="btn btn-warning" ng-click="selecionarProduto(prod)">Alterar</button>
									<button type="submit" class="btn btn-dander" ng-click="excluirProduto(prod.prdId)">Excluir</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
	
	</form>

</body>