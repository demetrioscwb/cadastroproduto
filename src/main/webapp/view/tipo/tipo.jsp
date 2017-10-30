

<body ng-controller="tipoController">

	<form name="tipoForm">
	
		<div class="form-group">
			<fieldset class="col-sm-10">
				<legend>TIPO</legend>
				<div class="row">
					<div class="col-xs-4">
						<label for="tpoNome" class="col-sm-2 control-label">Nome*</label>
						<input type="text" id="tpoNome" name="tpoNome" required class="form-control" title="Nome" ng-model="tipoVO.tipo.tpoNome"/>
					</div>
					</div>
					<br/>
					<div class="form-group">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-success" ng-click="cadastrarTipo()" ng-show="!tipoVO.tipo.tpoId">Cadastrar</button>
							<button type="submit" class="btn btn-success" ng-click="alterarTipo()" ng-show="tipoVO.tipo.tpoId">Confirmar</button>
						</div>
					</div>
				</div>
				<br/><br/>
				<div class="form-group  col-sm-10">
					<table class="table">
						<thead class="thead-inverse">
						<tr>
						<th>Nome</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
							<tr ng-repeat="tp in tipoVO.tipos">
								<td>{{tp.tpoNome}}</td>
								<td>
									<button type="submit" class="btn btn-warning" ng-click="selecionarTipoAlterar(tp)">Alterar</button>
									<button type="submit" class="btn btn-dander" ng-click="excluirTipo(tp.tpoId)">Excluir</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
	
	</form>

</body>
