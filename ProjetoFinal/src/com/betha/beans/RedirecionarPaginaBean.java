/**
 * 
 */
package com.betha.beans;

/**
 * @author Administrador
 *
 */
public class RedirecionarPaginaBean {
	
	private String local;
	
	public String redirecionar (){
		return local+"?faces-redirect=true";
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
}
