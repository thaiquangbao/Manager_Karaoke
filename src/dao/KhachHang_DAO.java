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
import entity.KhachHang;
import entity.NhanVien;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllDSKhachHang(){
		ArrayList<KhachHang> dsKhachHang =new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from KhachHang";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maKhachHang=rs.getString(1);
				String tenKhachHang=rs.getString(2);
				String soDienThoai=rs.getString(3);
				String diaChi=rs.getString(4);
				int tongtien = rs.getInt(5);
				
				KhachHang kh=new KhachHang(maKhachHang, tenKhachHang, soDienThoai, diaChi, tongtien);
				dsKhachHang.add(kh);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	public boolean create (KhachHang kh, int size) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into KhachHang values (?,?,?,?, ?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (KhachHang x : getAllDSKhachHang()) {
				String maTam = "";
				for (int i = x.getMaKhachHang().length() -3 ; i < x.getMaKhachHang().length(); i++) {
					maTam += String.valueOf( x.getMaKhachHang().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			
			statement.setString(1, "KH_" + d.formarMa(soTam + 1));
			statement.setString(2, kh.getTenKhachHang());
			statement.setString(3, kh.getSoDienThoai());
			statement.setString(4, kh.getDiaChi());
			statement.setInt(5, kh.getTongTienHoaDon());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean update (KhachHang kh) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("update KhachHang set TenKhachHang=?,SoDienThoai=?,DiaChi=?, TongTienHoaDon = ? Where maKhachHang=?");
			statement.setString(5, kh.getMaKhachHang());
			statement.setString(1, kh.getTenKhachHang());
			statement.setString(2, kh.getSoDienThoai());
			statement.setString(3, kh.getDiaChi());
			statement.setInt(4, kh.getTongTienHoaDon());;
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (KhachHang kh) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from KhachHang where maKhachHang=? ");
			statement.setString(1, kh.getMaKhachHang());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
