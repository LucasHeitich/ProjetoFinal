package com.betha.util;

import org.hibernate.Session;

import com.betha.infra.EnderecoHibernate;
import com.betha.infra.UsuarioHibernate;
import com.betha.repository.EnderecoRepo;
import com.betha.repository.UsuariosRepo;

public class Repositorios {
	

	
	public UsuariosRepo getUsuarios(){
		return new UsuarioHibernate(this.getSession());
	}

	public EnderecoRepo getEndereco(){

		return new EnderecoHibernate(this.getSession());
	}
	public Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}
}
