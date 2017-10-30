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
 * The persistent class for the marca database table.
 * 
 */
@Entity
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mrc_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mrcId;

	@Column(name="mrc_fabricante")
	private String mrcFabricante;

	@Column(name="mrc_nome")
	private String mrcNome;

	@SkipSerialization
	@OneToMany(mappedBy="marca")
	private List<Produto> produtos;

	public Marca() {}
	
	public Marca(int mrcId) {
		this.mrcId = mrcId;
	}

	public int getMrcId() {
		return this.mrcId;
	}

	public void setMrcId(int mrcId) {
		this.mrcId = mrcId;
	}

	public String getMrcFabricante() {
		return this.mrcFabricante;
	}

	public void setMrcFabricante(String mrcFabricante) {
		this.mrcFabricante = mrcFabricante;
	}

	public String getMrcNome() {
		return this.mrcNome;
	}

	public void setMrcNome(String mrcNome) {
		this.mrcNome = mrcNome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}