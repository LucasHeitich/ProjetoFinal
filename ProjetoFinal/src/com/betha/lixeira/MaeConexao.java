/**
 * 
 */
package com.betha.lixeira;

import java.sql.Connection;
import java.sql.SQLException;

import com.betha.lixeira.FabricaConexao;

/**
 * @author Administrador
 *
 */
public class MaeConexao {
	protected Connection con;
	public MaeConexao(){
		
		this.con = new FabricaConexao().getCon();
		
	}
	public void closeConnection(){
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
