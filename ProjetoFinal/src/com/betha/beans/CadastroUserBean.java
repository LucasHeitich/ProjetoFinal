package com.betha.beans;

import java.util.ArrayList;
import java.util.List;


import com.betha.cadastro.Usuario;
import com.betha.model.UserDao;
import com.betha.util.Repositorios;

/**
 * @author Administrador
 *gfffgtleandro
 */
public class CadastroUserBean {
	
	private Usuario user;
	private List<Usuario> userList;
	private Usuario userSelected;
	private boolean cadastro;
	
	
	public CadastroUserBean(){
		this.user=new Usuario();
		this.userList= new ArrayList<Usuario>();
		//UserDao ud = new UserDao();
		//userList=(List<Usuario>) ud.selectAll();
		userList=Repositorios.getUsuarios().listar();
	}
	
	
	public void cadastrar(){
		this.userList.add(this.user);
		
		UserDao ud = new UserDao();
		
		//ud.insert(this.user);
		
		
		//System.out.println(this.user.getHobbies().get(1));
		this.cadastro=true;
		
		
		
		this.user = new Usuario();		
	}
	
	/*public void botaoClicado(){
		System.out.println("Botão no Action");
	}*/
	
	public void excluir(){
		this.userList.remove(this.userSelected);
		UserDao ud = new UserDao();
		ud.delete(ud.selectOne(this.userSelected));
		this.cadastro=false;
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
