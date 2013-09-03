package com.betha.beans;

import java.util.ArrayList;
import java.util.List;

import com.betha.cadastro.Pessoa;
import com.betha.model.UserDao;

/**
 * @author Administrador
 *gfffgt
 */
public class CadastroUserBean {
	
	private Pessoa user;
	private List<Pessoa> userList;
	private Pessoa userSelected;
	private boolean cadastro;
	
	
	public CadastroUserBean(){
		this.user=new Pessoa();
		this.userList= new ArrayList<Pessoa>();
		UserDao ud = new UserDao();
		userList=(List<Pessoa>) ud.selectAll();
	}
	
	
	public void cadastrar(){
		this.userList.add(this.user);
		
		UserDao ud = new UserDao();
		
		ud.insert(this.user);
		//System.out.println(this.user.getHobbies().get(1));
		this.cadastro=true;
		
		
		
		this.user = new Pessoa();		
	}
	
	public void botaoClicado(){
		System.out.println("Bot�o no Action");
	}
	public void excluir(){
		this.userList.remove(this.userSelected);
		UserDao ud = new UserDao();
		ud.delete(ud.selectOne(this.userSelected));
		this.cadastro=false;
	}

	public Pessoa getUser() {
		return user;
	}
	public List<Pessoa> getUserList() {
		return userList;
	}
	
	public Pessoa getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(Pessoa userSelected) {
		this.userSelected = userSelected;
	}


	public boolean isCadastro() {
		return cadastro;
	}


	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}


}
