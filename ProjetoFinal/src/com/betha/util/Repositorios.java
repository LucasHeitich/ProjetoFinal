package com.betha.util;

import org.hibernate.Session;

import com.betha.infra.EnderecoHibernate;
import com.betha.infra.UsuarioHibernate;
import com.betha.repository.EnderecoRepo;
import com.betha.repository.UsuariosRepo;

public class Repositorios {
	
	private static Session session = (Session) FacesUtil.getRequestAttribute("session");
	
	public static UsuariosRepo getUsuarios(){
		return new UsuarioHibernate(session);
	}
	
	public static EnderecoRepo getEndereco(){
		return new EnderecoHibernate(session);
	}
}
