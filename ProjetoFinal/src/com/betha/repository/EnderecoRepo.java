/**
 * 
 */
package com.betha.repository;

import java.util.List;

import com.betha.cadastro.Endereco;

/**
 * @author Administrador
 *
 */
public interface EnderecoRepo {
	
	public List<Endereco> listar();
	
	public List<Endereco> orderAsc();
	
	public List<Endereco> orderDesc();
	
	public Endereco porCodigo(Integer codigo);
}  
