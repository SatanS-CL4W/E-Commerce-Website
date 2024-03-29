package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.model.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement st;
	private ResultSet rs;
	
	
	public UserDao(Connection con) {
			this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "select * from users where email=? and password=?";
			st = this.con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			rs = st.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));		
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		
		}
		return user;
	}
	
	
	
}
