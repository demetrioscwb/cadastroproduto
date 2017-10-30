
<body ng-controller="usuarioController">

	<form name="formUsuario">

		<div class="form-group">
			<fieldset class="col-sm-10">
				<legend>USUÁRIOS</legend>
		
				<br/><br/>
				<div class="form-group  col-sm-10">
					<table class="table">
						<thead class="thead-inverse">
						<tr>
						<th>Login</th>
						<th></th>
						</tr>
						</thead>
						<tbody>
							<tr ng-repeat="us in usuarioVO.listUsuario">
								<td>{{us.useLogin}}</td>
								<td>
									<button type="submit" class="btn btn-dander" ng-click="excluirUsuario(us.useId)">Excluir</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
		
	</form>

</body>