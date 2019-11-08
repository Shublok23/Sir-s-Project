package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.DBconnect;
import com.pojo.web;

public class LoginDao {
		Connection con=DBconnect.getConnection();

	public web getUserLogin(String email,String pass) {
		web u=new web();
		String sql="select email,pass from table2 where email=? and pass=?";	
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				u.setEmail(rs.getString(1));
				u.setPass(rs.getString(2));
				
			}
			
			return u;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}

}
