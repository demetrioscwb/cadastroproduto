package br.com.cadastroproduto.vo;

import java.util.List;

import br.com.cadastroproduto.entity.Marca;


public class MarcaVO {

	private Marca marca;
	
	private List<Marca> marcas;

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	
}
