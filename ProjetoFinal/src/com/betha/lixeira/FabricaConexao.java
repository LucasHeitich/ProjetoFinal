package com.betha.lixeira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.betha.cadastro.Pessoa;

public class FabricaConexao {
	
	
	private Connection con;
	
	
	public FabricaConexao(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjetoJSF","root","1234");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public Connection getCon() {
		return con;
	}
	
	public void closeConnection(){
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
