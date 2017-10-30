package br.com.cadastroproduto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prd_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prdId;

	@Column(name="prd_nome")
	private String prdNome;

	@ManyToOne
	@JoinColumn(name="prd_marca")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name="prd_tipo")
	private Tipo tipo;

	public Produto(){}
	

	public Produto(int prdId){
		this.prdId = prdId;
	}


	public int getPrdId() {
		return this.prdId;
	}

	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}

	public String getPrdNome() {
		return this.prdNome;
	}

	public void setPrdNome(String prdNome) {
		this.prdNome = prdNome;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}