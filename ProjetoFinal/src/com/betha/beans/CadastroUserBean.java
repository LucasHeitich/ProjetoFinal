package com.betha.beans;

import java.util.ArrayList;
import java.util.List;


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
	private Repositorios repo;
	private UsuariosRepo usuariosHibernate;
	private EnderecoRepo enderecoHibernate;
	
	public CadastroUserBean(){
		this.repo = new Repositorios();
		
		this.usuariosHibernate = repo.getUsuarios();
		this.enderecoHibernate = repo.getEndereco();
		this.user=new Usuario();
		this.userList= new ArrayList<Usuario>();
		this.endereco = new Endereco();
		this.user.setEndereco(this.endereco);
		
		
	}
	
	public void cadastrar(){
		
		this.enderecoHibernate.insert(this.user.getEndereco());
		this.usuariosHibernate.insert(this.user); //inserindo o usuário e seu endereço no banco!
		this.user = new Usuario();		
	}
	
	
	public void excluir(){ /** Método extinto **/
		//this.userList.remove(this.userSelected);
		//UserDao ud = new UserDao();
		//ud.delete(ud.selectOne(this.userSelected));
		//this.cadastro=false;
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
