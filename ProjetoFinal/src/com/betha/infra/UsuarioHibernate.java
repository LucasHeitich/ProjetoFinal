package com.betha.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

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

	@Override
	public List<Usuario> orderAsc() {
		
		return this.session.createCriteria(Usuario.class).addOrder(Order.asc("nome")).list();
	}

	@Override
	public List<Usuario> orderDesc() {
		
		return this.session.createCriteria(Usuario.class).addOrder(Order.desc("nome")).list();
	}

	@Override
	public void insert(Usuario user) {
		this.session.persist(user);
		
	}

}
