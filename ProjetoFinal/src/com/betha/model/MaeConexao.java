/**
 * 
 */
package com.betha.model;

import java.sql.Connection;
import java.sql.SQLException;

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
