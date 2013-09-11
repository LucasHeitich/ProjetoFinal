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
	
	
	public void insert (Endereco endereco){
		this.session.persist(endereco);
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


	public Endereco porCodigo(Integer codigo) {
		
		return (Endereco)session.get(Endereco.class,codigo);
		
	}
	
	public void alterar(Endereco endereco) {
		this.session.merge(endereco);	
	}


	public void excluir(Endereco endereco) {
		this.session.delete(endereco);
	}

}
