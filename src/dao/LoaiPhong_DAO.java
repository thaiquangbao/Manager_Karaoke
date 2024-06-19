package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;

import entity.LoaiPhong;

public class LoaiPhong_DAO {
public ArrayList<LoaiPhong> getAllLoaiPhong(){
	ArrayList<LoaiPhong> dsLoaiPhong =new ArrayList<LoaiPhong>();
	try {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql ="select * from LoaiPhong";
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		while (rs.next()) {
			String maLoaiPhong=rs.getString(1);
			String tenLoaiPhong=rs.getString(2);
			String moTa=rs.getString(3);
			
			LoaiPhong lp=new LoaiPhong(maLoaiPhong, tenLoaiPhong, moTa);
			dsLoaiPhong.add(lp);
		}
	
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return dsLoaiPhong;

}
public boolean create (LoaiPhong lp, int size) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
	    functionNecessary d = new functionNecessary();
		statement=con.prepareStatement("insert into LoaiPhong values (?,?,?)");
		
		ArrayList<Integer> dsMa = new ArrayList<Integer>();
		for (LoaiPhong x : getAllLoaiPhong()) {
			String maTam = "";
			for (int i = x.getMaLoaiPhong().length() -3 ; i < x.getMaLoaiPhong().length(); i++) {
				maTam += String.valueOf( x.getMaLoaiPhong().charAt(i));
			}
			dsMa.add(Integer.parseInt(maTam));
		}
		
		int soTam = 0;
		for (int x : dsMa) {
			if (x > soTam) {
				soTam = x;
			}
		}
		
		statement.setString(1, "LP_" + d.formarMa(soTam + 1 ));
		statement.setString(2, lp.getTenLoaiPhong());
		statement.setString(3, lp.getMoTa());
		
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}

public boolean update (LoaiPhong lp) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("update LoaiPhong set TenLoaiPhong=?,moTa=? Where maLoaiPhong=?");
		statement.setString(3, lp.getMaLoaiPhong());
		statement.setString(1, lp.getTenLoaiPhong());
		statement.setString(2, lp.getMoTa());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
public boolean delete (LoaiPhong lp) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("delete from LoaiPhong where maLoaiPhong=? ");
		statement.setString(1, lp.getMaLoaiPhong());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
}
