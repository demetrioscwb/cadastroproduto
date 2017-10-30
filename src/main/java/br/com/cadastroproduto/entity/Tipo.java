package br.com.cadastroproduto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.caelum.vraptor.serialization.SkipSerialization;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tpo_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tpoId;

	@Column(name="tpo_nome")
	private String tpoNome;

	@SkipSerialization
	@OneToMany(mappedBy="tipo")
	private List<Produto> produtos;

	public Tipo() {
	}
	
	public Tipo(int tpoId) {
		this.tpoId = tpoId;
	}

	public int getTpoId() {
		return this.tpoId;
	}

	public void setTpoId(int tpoId) {
		this.tpoId = tpoId;
	}

	public String getTpoNome() {
		return this.tpoNome;
	}

	public void setTpoNome(String tpoNome) {
		this.tpoNome = tpoNome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


}