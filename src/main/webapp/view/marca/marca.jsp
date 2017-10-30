
<body ng-controller="marcaController">

	<form name="marcaForm">

		<div class="form-group">
			<fieldset class="col-sm-10">
				<legend>MARCA</legend>
				<div class="row">
					<div class="col-xs-4">
						<label for="mrcNome" class="col-sm-2 control-label">Nome*</label>
						<input type="text" id="mrcNome" name="mrcNome" required class="form-control" title="Nome" ng-model="marcaVO.marca.mrcNome"/>
					</div>
					<div class="col-xs-8">
						<label for="mrcFabricante" class="col-sm-2 control-label">Fabricante*</label>
						<input type="text" class="form-control" id="mrcFabricante" required name="mrcFabricante" title="Fabricante" ng-model="marcaVO.marca.mrcFabricante"/>
					</div>
					</div>
					<br/>
					<div class="form-group">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-success" ng-click="cadastrarMarca()" ng-show="!marcaVO.marca.mrcId">Cadastrar</button>
							<button type="submit" class="btn btn-success" ng-click="alterarMarca()" ng-show="marcaVO.marca.mrcId">Confirmar</button>
						</div>
					</div>
				</div>
				<br/><br/>
				<div class="form-group  col-sm-10">
					<table class="table">
						<thead class="thead-inverse">
						<tr>
						<th>Nome</th>
						<th>Fabricante</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
							<tr ng-repeat="mar in marcaVO.marcas">
								<td>{{mar.mrcNome}}</td>
								<td>{{mar.mrcFabricante}}</td>
								<td>
									<button type="submit" class="btn btn-warning" ng-click="selecionarMarca(mar)">Alterar</button>
									<button type="submit" class="btn btn-dander" ng-click="excluirMarca(mar.mrcId)">Excluir</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
		
	</form>

</body>