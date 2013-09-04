
package com.betha.lixeira;

import java.util.ArrayList;

/**
 * @author Administrador
 *
 */
public class Pessoa {

	private String nome,email,senha;
	private String sexo;
	private int id;
	private boolean forasteiro;
	private String vertical;
	private boolean selecionado;
	private ArrayList<String> hobbies = new ArrayList<String>();
	public Pessoa(){
	}
	
	public Pessoa(int id, String nome, String email, String senha){
		this.nome=nome;
		this.email=email;
		this.id=id;
		this.senha=senha;
	}
	public Pessoa(String nome, String email, String senha){
		this.nome=nome;
		this.email=email;
		
		this.senha=senha;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isForasteiro() {
		return forasteiro;
	}

	public void setForasteiro(boolean forasteiro) {
		this.forasteiro = forasteiro;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
}
