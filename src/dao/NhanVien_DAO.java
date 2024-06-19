package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;
import entity.ChucVu;
import entity.NhanVien;


public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> dsNhanVien =new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from NhanVien";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maNhanVien=rs.getString(1);
				String tenNhanVien=rs.getString(2);
				String diaChi=rs.getString(3);
				String sdt=rs.getString(4);
				int sodon = rs.getInt(5);
				int tongtien = rs.getInt(6);
				ChucVu cv=new ChucVu(rs.getString(7));
				NhanVien nv=new NhanVien(maNhanVien, tenNhanVien,diaChi, sdt,sodon, tongtien,  cv);
				dsNhanVien.add(nv);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	
	public boolean create (NhanVien nv, int size) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
		    
			statement=con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (NhanVien x : getAllNhanVien()) {
				String maTam = "";
				for (int i = x.getMaNhanVien().length() -3 ; i < x.getMaNhanVien().length(); i++) {
					maTam += String.valueOf( x.getMaNhanVien().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			
			statement.setString(1, "NV_" + d.formarMa(soTam + 1));
			statement.setString(2, nv.getTenNhanVien());
			statement.setString(3, nv.getDiaChi());
			statement.setString(4,nv.getSoDienThoai());
			statement.setInt(5, 0);
			statement.setInt(6, 0);
			statement.setString(7, nv.getChucVu().getMaChucVu());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}/*
		finally {
			try {
				statement.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}*/
		return n>0;
	}

	public boolean update (NhanVien nv) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("update NhanVien set TenNhanVien=?,MaChucVu=?,DiaChi=?,SoDienThoai=?, SoHoaDonLap = ?, TongTienHoaDon = ? Where maNhanVien=?");
			statement.setString(7, nv.getMaNhanVien());
			statement.setString(1, nv.getTenNhanVien());
			statement.setString(2, nv.getChucVu().getMaChucVu());
			statement.setString(3, nv.getDiaChi());;
			statement.setString(4,nv.getSoDienThoai());
			statement.setInt(5,nv.getSoHoaDonLap());
			statement.setInt(6,nv.getTongTienHoaDon());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (NhanVien nv) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from Nhanvien where maNhanVien=? ");
			statement.setString(1, nv.getMaNhanVien());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
