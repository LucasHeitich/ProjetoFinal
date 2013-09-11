package com.betha.util;

import java.util.Comparator;
import com.betha.cadastro.Usuario;

/**
 * @author Administrador
 *
 */

public class UsuarioComparar implements Comparator<Usuario> {

	public boolean asc;
	
	public UsuarioComparar(boolean asc) {
		this.asc=asc;
	}
	
	public int compare(Usuario usuario1, Usuario usuario2) {
		if (this.asc)
			return usuario1.getNome().toLowerCase().compareTo(usuario2.getNome().toLowerCase());
		return usuario2.getNome().toLowerCase().compareTo(usuario1.getNome().toLowerCase());
	}
}
