package com.infy.DemoRestDBConnected.repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.infy.DemoRestDBConnected.entity.Alien;

public class AlienRepository {
	
	Connection con = null;
	Statement st = null;
	
	public AlienRepository() {
		
		String url = "jdbc:mysql://localhost:3306/rest";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Alien> getAllAliens(){
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getLong(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				aliens.add(a);
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return aliens;
	}
	
	
	public Alien getAlienForId(Long id) {
		Alien a1 = null;
		String sql = "select * from alien where id="+id;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				a1 = new Alien();
				a1.setId(rs.getLong(1));
				a1.setName(rs.getString(2));
				a1.setPoints(rs.getInt(3));
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return a1;
	}
	
	public void createAlien(Alien a1) {
		String sql = "INSERT INTO alien (id, name, points) VALUES (?, ?, ?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, a1.getId());
			pst.setString(2, a1.getName());
			pst.setInt(3, a1.getPoints());
			pst.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(Alien a1) {
		String sql = "UPDATE alien SET name = ?, points = ? WHERE id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, a1.getName());
			pst.setInt(2, a1.getPoints());
			pst.setLong(3, a1.getId());
			pst.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(Long id) {
		String sql = "DELETE from alien where id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, id);
			pst.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
