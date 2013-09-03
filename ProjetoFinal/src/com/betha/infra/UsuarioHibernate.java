package com.betha.infra;

import java.util.List;

import org.hibernate.Session;

import com.betha.cadastro.Usuario;
import com.betha.repository.UsuariosRepo;

public class UsuarioHibernate implements UsuariosRepo {
	private Session session;
	
	public UsuarioHibernate(Session session){
		this.session=session;
	}
	
	public List<Usuario> listar() {
		
		return session.createCriteria(Usuario.class).list();
	}

}
