package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBconnect;
import com.dao.webDao;
import com.pojo.web;


public class webDaoImpl implements webDao{

	Connection con = DBconnect.getConnection();

	public boolean insertweb(web s) {

		String sql = " insert into table2 values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,s.getName());
			ps.setString(2,s.getContact());
			ps.setString(3,s.getEmail());
			ps.setString(4, s.getPass());

			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateweb(web s) {

		String sql = " update table2 set name=?,contact=?, pass=? where email=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,s.getName());
			ps.setString(2,s.getContact());
			
			ps.setString(3, s.getPass());
			ps.setString(4,s.getEmail());

			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	public boolean deletetweb(String email) {

		String sql = "delete from table2 where email=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);


			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public web getUserByEmail(String email){
		String sql="select * from table2 where email=?";
		web e=new web();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
		
				e.setName(rs.getString(1));
				e.setContact(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPass(rs.getString(4));
				

			}

			return e;

		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public List<web> getUserList(){
		String sql="select * from table2";
		List<web> wl=new ArrayList<web>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				web e=new web();
				e.setName(rs.getString(1));
				e.setContact(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPass(rs.getString(4));
				wl.add(e);

			}

			return wl;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
