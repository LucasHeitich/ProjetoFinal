package com.betha.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.betha.cadastro.Usuario;
import com.betha.util.FabricaSessao;
import com.betha.util.FacesUtil;
import com.betha.util.Repositorios;

public class TabelaBeanjpa {
	
	private List<Usuario> usuario;
	Session session = (Session) FacesUtil.getRequestAttribute("session");
	public TabelaBeanjpa(){
		//usuario = new ArrayList<>();
		//this.usuario = session.createCriteria(Usuario.class).list();
		this.usuario = Repositorios.getUsuarios().listar();
		
	}
	
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
