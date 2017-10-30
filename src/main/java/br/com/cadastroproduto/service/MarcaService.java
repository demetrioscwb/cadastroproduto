package br.com.cadastroproduto.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cadastroproduto.entity.Marca;
import br.com.cadastroproduto.repository.MarcaDAO;

@Transactional
public class MarcaService {

	@Inject
	MarcaDAO marcaDAO;

	public List<Marca> list() {
		return marcaDAO.list();
	}
	
	public Marca salvarMarca(Marca marca){
		return marcaDAO.salvarMarca(marca);
	}

	public void excluirMarca(int mrcId) {
		marcaDAO.excluirMarca(mrcId);
	}
	
}
