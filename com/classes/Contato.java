package com.classes;

public class Contato {

	private String nome;
	private String tel;
	private String local;
	
	public Contato (String nome, String tel, String local) {
		this.nome = nome;
		this.tel = tel;
		this.local = local;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getTelefone(){
		return this.tel;
	}

	public String getEndereco(){
		return this.local;
	}
}
