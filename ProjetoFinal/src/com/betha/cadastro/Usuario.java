package com.betha.cadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pessoas")
public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String sexo;
	private Integer codigo;
	private Endereco endereco;
	public boolean selecionado;

	public Usuario(){
		
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

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Id //sempre antes do get do Id
	@GeneratedValue //aqui é pra dizer p/ o hibernate que o id é auto increment
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	//caso a variavel seja diferente do nome da coluna na tabela... 
	//@Column(name="nome")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@ManyToOne
	@JoinColumn(name="endereco") //fk
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
