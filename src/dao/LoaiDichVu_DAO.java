package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;
import entity.LoaiDichVu;


public class LoaiDichVu_DAO {
public ArrayList<LoaiDichVu> getAllLoaiDichVu(){
	ArrayList<LoaiDichVu> dsLDichVu =new ArrayList<LoaiDichVu>();
	try {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql ="select * from LoaiDichVu";
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		while (rs.next()) {
			String maLoaiDV=rs.getString(1);
			String tenLoaiDV=rs.getString(2);
			String moTa=rs.getString(3);
			
			LoaiDichVu ldv=new LoaiDichVu(maLoaiDV, tenLoaiDV, moTa);
			dsLDichVu.add(ldv);
		}
	
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return dsLDichVu;
}
public boolean create (LoaiDichVu ldv, int size) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
	    functionNecessary d = new functionNecessary();
		statement=con.prepareStatement("insert into LoaiDichVu values (?,?,?)");
		
		ArrayList<Integer> dsMa = new ArrayList<Integer>();
		for (LoaiDichVu x : getAllLoaiDichVu()) {
			String maTam = "";
			for (int i = x.getMaLoaiDichVu().length() -3 ; i < x.getMaLoaiDichVu().length(); i++) {
				maTam += String.valueOf( x.getMaLoaiDichVu().charAt(i));
			}
			dsMa.add(Integer.parseInt(maTam));
		}
		
		int soTam = 0;
		for (int x : dsMa) {
			if (x > soTam) {
				soTam = x;
			}
		}
		
		statement.setString(1, "LDV_" + d.formarMa(soTam + 1));
		statement.setString(2, ldv.getTenLoaiDichVu());
		statement.setString(3, ldv.getMoTa());
		
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}

public boolean update (LoaiDichVu ldv) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("update LoaiDichVu set TenLoaiDichVu=?,moTa=? Where maLoaiDichVu=?");
		statement.setString(3,ldv.getMaLoaiDichVu() );
		statement.setString(1, ldv.getTenLoaiDichVu());
		statement.setString(2,ldv.getMoTa());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
public boolean delete (LoaiDichVu ldv) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("delete from LoaiDichVu where maLoaiDichVu=? ");
		statement.setString(1, ldv.getMaLoaiDichVu());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
}
