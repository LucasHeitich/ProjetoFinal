package com.betha.repository;

import java.util.List;

import com.betha.cadastro.Usuario;

public interface UsuariosRepo {
	
	public List<Usuario> listar();
	
	public List<Usuario> orderAsc();
	
	public List<Usuario> orderDesc();
	
	public void insert(Usuario user);	
	
	
}
