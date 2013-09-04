package com.betha.infra;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import com.betha.cadastro.Endereco;
import com.betha.cadastro.Usuario;
import com.betha.repository.EnderecoRepo;

public class EnderecoHibernate implements EnderecoRepo{
	private Session session;
	
	public EnderecoHibernate(Session session){
		this.session=session;
	}
	

	public List<Endereco> listar() {
		
		return session.createCriteria(Endereco.class).list();
	}


	public List<Endereco> orderAsc() {
		return this.session.createCriteria(Usuario.class).addOrder(Order.asc("descricao")).list();
	}


	public List<Endereco> orderDesc() {
		return this.session.createCriteria(Usuario.class).addOrder(Order.desc("descricao")).list();
	}

	@Override
	public Endereco porCodigo() {
		
		return (Endereco)session.get(Endereco, codigo);
		//return (Usuario)session.getId(Usuario.class,codigo);
	}

}
