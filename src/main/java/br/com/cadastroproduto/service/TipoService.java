package br.com.cadastroproduto.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cadastroproduto.entity.Tipo;
import br.com.cadastroproduto.repository.TipoDAO;

@Transactional
public class TipoService {

	@Inject
	TipoDAO tipoDAO;

	public List<Tipo> list() {
		return tipoDAO.list();
	}
	
	public Tipo salvarTipo(Tipo tipo){
		return tipoDAO.salvarTipo(tipo);
	}
	
	public void excluirTipo(int tpoId){
		tipoDAO.excluirTipo(tpoId);
	}
	
}
