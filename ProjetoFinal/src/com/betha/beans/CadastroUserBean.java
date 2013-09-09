package com.betha.beans;

import java.util.ArrayList;
import java.util.List;


import com.betha.cadastro.Endereco;
import com.betha.cadastro.Usuario;
import com.betha.lixeira.UserDao;

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
	
	public CadastroUserBean(){
		this.user=new Usuario();
		this.userList= new ArrayList<Usuario>();
		this.endereco = new Endereco();
		this.user.setEndereco(this.endereco);
		//UserDao ud = new UserDao();
		//userList=(List<Usuario>) ud.selectAll();
		//userList=Repositorios.getUsuarios().listar();
	}
	
	public void cadastrar(){
		//this.userList.add(this.user);
		
		//UserDao ud = new UserDao();
		System.out.println("nome:"+user.getNome());
		System.out.println("email:"+user.getEmail());
		System.out.println("endereco:"+this.user.getEndereco().getDescricao());
		//ud.insert(this.user);
		Repositorios.getUsuarios().insert(this.user); //inserindo o usuário e seu endereço no banco!

		//ud.insert(this.user);

		//System.out.println(this.user.getHobbies().get(1));
		//this.cadastro=true;
		this.user = new Usuario();		
	}
	
	/*public void botaoClicado(){
		System.out.println("Botão no Action");
	}*/
	
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
}
