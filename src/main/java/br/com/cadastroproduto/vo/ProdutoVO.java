package br.com.cadastroproduto.vo;

import java.util.List;

import br.com.cadastroproduto.entity.Marca;
import br.com.cadastroproduto.entity.Produto;
import br.com.cadastroproduto.entity.Tipo;


public class ProdutoVO {

	private Produto produto;
	
	private int mrcId;
	private int tpoId;
	
	private List<Produto> produtos;
	private List<Marca> marcas;
	private List<Tipo> tipos;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Marca> getMarcas() {
		return marcas;
	}
	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	public List<Tipo> getTipos() {
		return tipos;
	}
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	public int getMrcId() {
		return mrcId;
	}
	public void setMrcId(int mrcId) {
		this.mrcId = mrcId;
	}
	public int getTpoId() {
		return tpoId;
	}
	public void setTpoId(int tpoId) {
		this.tpoId = tpoId;
	}

	
	

}
