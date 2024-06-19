package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;
import entity.ChucVu;
import entity.PhieuDatPhong;


public class ChucVu_DAO {
public ArrayList<ChucVu> getAllDSChucVu()
{
	ArrayList<ChucVu> dsCV=new ArrayList<ChucVu>();
	try {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql ="select * from ChucVu";
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		while (rs.next()) {
			String maCV=rs.getString(1);
			String tenCV=rs.getString(2);
			String moTa=rs.getString(3);
			
			ChucVu cv=new ChucVu(maCV, tenCV, moTa);
			dsCV.add(cv);
		}
	
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return dsCV;
}
public boolean create (ChucVu cv, int size) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
	    functionNecessary d= new functionNecessary();
		statement=con.prepareStatement("insert into ChucVu values (?,?,?)");
		ArrayList<Integer> dsMa = new ArrayList<Integer>();
		for (ChucVu x : getAllDSChucVu()) {
			String maTam = "";
			for (int i = x.getMaChucVu().length() -3 ; i < x.getMaChucVu().length(); i++) {
				maTam += String.valueOf( x.getMaChucVu().charAt(i));
			}
			dsMa.add(Integer.parseInt(maTam));
		}
		
		int soTam = 0;
		for (int x : dsMa) {
			if (x > soTam) {
				soTam = x;
			}
		}
		statement.setString(1, "CV_" + d.formarMa(soTam + 1));
		statement.setString(2, cv.getTenChucVu());
		statement.setString(3, cv.getMoTa());
		
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}

public boolean update (ChucVu cv) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("update ChucVu set TenChucVu=?,MoTa=? Where MaChucVu=?");
		statement.setString(3,cv.getMaChucVu() );
		statement.setString(1, cv.getTenChucVu());
		statement.setString(2,cv.getMoTa());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
public boolean delete (ChucVu cv) {
	ConnectDB.getInstance();
	Connection con=ConnectDB.getConnection();
	PreparedStatement statement=null;
	int n=0;
	try {
		statement=con.prepareStatement("delete from ChucVu where maChucVu=? ");
		statement.setString(1, cv.getMaChucVu());
		n=statement.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n>0;
}
}
