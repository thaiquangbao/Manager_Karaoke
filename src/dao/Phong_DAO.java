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
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

public class Phong_DAO {
	public ArrayList<Phong> getAllPhong(){
		ArrayList<Phong> dsPhong =new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from Phong";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				LoaiPhong lp=  new LoaiPhong(rs.getString(3));
				String gia=rs.getString(4);
				
				Phong phong=new Phong(maPhong, tenPhong, lp, gia);
				dsPhong.add(phong);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
	public ArrayList<Phong> getPhongTheoMaP(String id){
		ArrayList<Phong> dsPhong=new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="select * from Phong where MaPhong=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				LoaiPhong lp=new LoaiPhong(rs.getString(3));
				String gia=rs.getString(4);
				Phong p=new Phong(maPhong, tenPhong, lp, gia);
				dsPhong.add(p);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhong;
	}
	
	public boolean create (Phong p, int size) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into Phong values (?,?,?,?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (Phong x : getAllPhong()) {
				String maTam = "";
				for (int i = x.getMaPhong().length() -3 ; i < x.getMaPhong().length(); i++) {
					maTam += String.valueOf( x.getMaPhong().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			
			statement.setString(1,"P_" + d.formarMa(soTam + 1) );
			statement.setString(2, p.getTenPhong());
			statement.setString(3,p.getLoaiPhong().getMaLoaiPhong());
			statement.setString(4, p.getGiaPhong() + "");
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean update (Phong p) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("update Phong set TenPhong=?,MaLoaiPhong=?,GiaLoaiPhong=? Where maPhong=?");
			statement.setString(4,p.getMaPhong() );
			statement.setString(1, p.getTenPhong());
			statement.setString(2,p.getLoaiPhong().getMaLoaiPhong());
			statement.setString(3, p.getGiaPhong());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (Phong p) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from Phong where maPhong=? ");
			statement.setString(1, p.getMaPhong());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
