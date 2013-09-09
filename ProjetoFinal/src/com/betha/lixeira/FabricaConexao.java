package com.betha.lixeira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class FabricaConexao {
	
	
	private Connection con;
	
	
	public FabricaConexao(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjetoJSF","root","");
			
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
