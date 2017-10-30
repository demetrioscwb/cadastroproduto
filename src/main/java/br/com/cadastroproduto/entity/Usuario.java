package br.com.cadastroproduto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="use_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int useId;

	@Column(name="use_login")
	private String useLogin;
	
	@Column(name="use_senha")
	private String useSenha;

	public Usuario() {
	}
	
	public Usuario(int useId) {
		this.useId = useId;
	}

	public int getUseId() {
		return useId;
	}

	public void setUseId(int useId) {
		this.useId = useId;
	}

	public String getUseLogin() {
		return useLogin;
	}

	public void setUseLogin(String useLogin) {
		this.useLogin = useLogin;
	}

	public String getUseSenha() {
		return useSenha;
	}

	public void setUseSenha(String useSenha) {
		this.useSenha = useSenha;
	}





}