package com.betha.util;

import org.hibernate.Session;

import com.betha.infra.EnderecoHibernate;
import com.betha.infra.UsuarioHibernate;
import com.betha.repository.EnderecoRepo;
import com.betha.repository.UsuariosRepo;

public class Repositorios {
	
	private Session session = (Session) FacesUtil.getRequestAttribute("session");
	
	public UsuariosRepo getUsuarios(){
		return new UsuarioHibernate(session);
	}
	
	public EnderecoRepo getEndereco(){
		return new EnderecoHibernate(session);
	}
}
