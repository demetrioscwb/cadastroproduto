package br.com.cadastroproduto.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cadastroproduto.entity.Produto;
import br.com.cadastroproduto.repository.ProdutoDAO;

@Transactional
public class ProdutoService {

	@Inject
	ProdutoDAO produtoDAO;

	public List<Produto> list() {
		return produtoDAO.list();
	}
	
	public Produto salvarProduto(Produto produto){
		return produtoDAO.salvarProduto(produto);
	}

	public void excluirProduto(int prdId) {
		produtoDAO.excluirProduto(prdId);
	}

	public List<Produto> buscarProduto(String prdNome, int mrcId, int tpoId) {
		return produtoDAO.buscarProduto(prdNome, mrcId, tpoId);
	}
	
}
