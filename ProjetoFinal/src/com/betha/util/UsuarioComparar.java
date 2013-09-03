/**
 * 
 */
package com.betha.util;

import java.util.Comparator;

import com.betha.cadastro.Pessoa;

/**
 * @author Administrador
 *
 */

//!!!!!!CLASSE EXTINTA!!!!!!!
public class UsuarioComparar implements Comparator<Pessoa> {


	public boolean asc;
	
	public UsuarioComparar(boolean asc) {
		this.asc=asc;
	}


	public int compare(Pessoa usuario1, Pessoa usuario2) {
		
		if (this.asc)
			
			return usuario1.getNome().toLowerCase().compareTo(usuario2.getNome().toLowerCase());
			
		return usuario2.getNome().toLowerCase().compareTo(usuario1.getNome().toLowerCase());
		
	}

}
