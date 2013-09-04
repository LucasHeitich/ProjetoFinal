package com.betha.util;

import org.hibernate.Session;

import com.betha.infra.UsuarioHibernate;
import com.betha.repository.UsuariosRepo;

public class Repositorios {
	
	private static Session session = (Session) FacesUtil.getRequestAttribute("session");
	
	public static UsuariosRepo getUsuarios(){
		return new UsuarioHibernate(session);
	}
}
