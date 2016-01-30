package com.jeony.helloworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jeony.helloworld.model.User;

public class UserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<User> getUserList(){
		List<User> users = new ArrayList<User>();
		
		try {
			Connection c = this.dataSource.getConnection();
			
			PreparedStatement ps = c.prepareStatement( "SELECT * FROM USER" );
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()){
				User user = new User();
				user.setId( rs.getString("id"));
				user.setPw( rs.getString("pw"));
				users.add( user);
			}
			rs.close();
			ps.close();
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return users;
	}
	
}
