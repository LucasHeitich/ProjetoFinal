package com.betha.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import com.betha.cadastro.Endereco;
import com.betha.cadastro.Usuario;


import com.betha.repository.EnderecoRepo;
import com.betha.repository.UsuariosRepo;

import com.betha.util.Repositorios;

/**
 * @author Administrador
*/

public class CadastroUserBean {
	
	private Usuario user;
	private List<Usuario> userList;
	private Usuario userSelected;
	private Endereco endereco;
	private boolean cadastro;
	private Repositorios repo = new Repositorios();
	private UsuariosRepo usuariosHibernate;
	private EnderecoRepo enderecoHibernate;
	
	public CadastroUserBean(){
		this.user=new Usuario();
		this.userList= new ArrayList<Usuario>();
		this.endereco = new Endereco();
		this.user.setEndereco(this.endereco);
	}
	
	public void cadastrar(){
		this.usuariosHibernate = repo.getUsuarios();
		this.enderecoHibernate = repo.getEndereco();
		this.enderecoHibernate.insert(this.user.getEndereco());
		this.usuariosHibernate.insert(this.user); //inserindo o usuário e seu endereço no banco!
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!", ""));
		this.user = new Usuario();	
		this.endereco = new Endereco();
		this.user.setEndereco(this.endereco);
	}
	
	public Usuario getUser() {
		return user;
	}
	public List<Usuario> getUserList() {
		return userList;
	}
	
	public Usuario getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(Usuario userSelected) {
		this.userSelected = userSelected;
	}
	
	public boolean isCadastro() {
		return cadastro;
	}

	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
