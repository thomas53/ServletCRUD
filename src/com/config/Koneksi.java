package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
	private String myDriver = "com.mysql.jdbc.Driver";
	private String myUrl = "jdbc:mysql://127.0.0.1:3306/coba";
	private String username = "root";
	private String password = "r00?00t";
	private Connection conn = null;
	
	public Connection getKoneksi() {
		try {
			Class.forName(myDriver);			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Ready");
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(myUrl,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void a(){
		try {
			Class.forName(myDriver);			
			System.out.print("sukses");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Ready");
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(myUrl,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Koneksi().a();
	}
}
