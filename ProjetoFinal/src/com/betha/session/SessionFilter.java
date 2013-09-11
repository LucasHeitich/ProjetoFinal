package com.betha.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.betha.util.FabricaSessao;
@WebFilter(servletNames="Faces Servlet")
public class SessionFilter implements Filter{

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session =  FabricaSessao.abrirSessao();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			request.setAttribute("session", session);
			chain.doFilter(request, response);
			transacao.commit();
		}catch(Exception e){
			if (transacao != null){
				transacao.rollback();
			}
		}finally{
			session.close();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
