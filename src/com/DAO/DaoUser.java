package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataUser;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoUser {
	private Connection conn = null;
	
	public DaoUser(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataUser data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO tb_data1 (id,username,nama,alamat) VALUES (NULL,?,?,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getNama());
			ps.setString(3, data.getAlamat());
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public List<DataUser> getDataUser(){
		List<DataUser> res = new ArrayList<DataUser>();
		
		try {
			String query = "SELECT id,username,nama,alamat FROM tb_data1";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataUser temp = new DataUser();
				temp.setId(rs.getInt("id"));
				temp.setUsername(rs.getString("username"));
				temp.setNama(rs.getString("nama"));
				temp.setAlamat(rs.getString("alamat"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataUser getDataUserById(int id){
		DataUser res = new DataUser();
		
		try {
			String query = "SELECT id,username,nama,alamat FROM tb_data1 WHERE id="+id;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setId(rs.getInt("id"));
				res.setUsername(rs.getString("username"));
				res.setNama(rs.getString("nama"));
				res.setAlamat(rs.getString("alamat"));
			}else{
				System.out.println("data kosong ....");
			}
			
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public boolean deleteData(int id){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM tb_data1 WHERE id=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id);			
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public boolean updateData(DataUser data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `coba`.`tb_data1` SET `username`=?, `nama`=?, `alamat`=? WHERE `id`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getUsername());
			ps.setString(2, data.getNama());
			ps.setString(3, data.getAlamat());
			ps.setInt(4, data.getId());
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public static void main(String[] args) {
//		List<DataUser> x = new ArrayList<DataUser>();
//		x = new DaoUser().getDataUserById(10);
//		for (DataUser dataUser : x) {
//			System.out.println(dataUser.getNama());
//		}
		
		DataUser a = new DaoUser().getDataUserById(21);
		System.out.print(a.getNama());
	}
}
