package com.betha.lixeira;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDao extends MaeConexao implements Dao<Pessoa> {

	@Override
	public ArrayList<Pessoa> selectAll() {
		ArrayList<Pessoa> user = new ArrayList<Pessoa>();
		try {
			
			PreparedStatement ps = this.con.prepareStatement("Select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				user.add(new Pessoa(rs.getInt("idUser"),rs.getString("Nome"),rs.getString("Email"),rs.getString("Senha")));
			}
		}catch (SQLException s){
			return null;
		}
		return user;
	}
	
	

	@Override
	public void insert(Pessoa objeto) {
		// TODO Auto-generated method stub
		
		try {
			this.con.setAutoCommit(false);
			PreparedStatement ps = this.con.prepareStatement("insert into user(nome,email,senha) values(?,?,?)");
			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getEmail());
			ps.setString(3, objeto.getSenha());
			ps.executeUpdate();
			this.con.commit();
			this.con.setAutoCommit(true);

		}catch(SQLException s){
			try {
				this.con.rollback();
			} catch (SQLException e) {
				this.closeConnection();
				//e.printStackTrace();
			}
			s.printStackTrace();
		}
		
	}

	@Override
	public Object selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int selectOne(Pessoa objeto) {
		
		try {
			PreparedStatement ps = this.con.prepareStatement("Select idUser from user where nome=? and email=? and senha=?");
			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getEmail());
			ps.setString(3, objeto.getSenha());
			
			ResultSet rs = ps.executeQuery();			
			
			if (rs.next()){
				return (rs.getInt("idUser"));
			}
		}catch(SQLException s){			
			this.closeConnection();
			s.printStackTrace();
		}
		return 0;
	}

	@Override
	public void delete(Pessoa objeto) {
	
		
	}

	
	public void delete(int id) {
		
		try {
			
			PreparedStatement ps = this.con.prepareStatement("delete from user where idUser=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			this.closeConnection();

		}catch(SQLException s){
			this.closeConnection();
			s.printStackTrace();
		}
	}

}
