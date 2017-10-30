package br.com.cadastroproduto.vo;

import java.util.List;

import br.com.cadastroproduto.entity.Tipo;


public class TipoVO {

	private Tipo tipo;
	private List<Tipo> tipos;
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public List<Tipo> getTipos() {
		return tipos;
	}
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	
	
	
}
