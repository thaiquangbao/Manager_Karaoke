package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.NhaCungCap;
import entity.PhieuDatPhong;


public class DichVu_Dao {
	public ArrayList<DichVu> getAllDichVu(){
		ArrayList<DichVu> dsDichVu =new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from DichVu";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String moTa=rs.getString(3);
				LoaiDichVu ldv=new LoaiDichVu(rs.getString(4));
				NhaCungCap ncc=new NhaCungCap(rs.getString(5));
				int spLuongTon =rs.getInt(6);
				int gia= (int) rs.getInt(7);
				String anh=rs.getString(8);
				DichVu dv=new DichVu(maDichVu, tenDichVu, moTa, ldv, ncc, spLuongTon, gia,anh);
				dsDichVu.add(dv);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDichVu;
	}
	public ArrayList<DichVu> getDichVuTheoMaDV(String id){
		ArrayList<DichVu> dsDV=new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="select * from DichVu where MaDichVu=?";
			statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String maDV=rs.getString(1);
				String tenDV=rs.getString(2);
				String mota=rs.getString(3);
				LoaiDichVu ldv=new LoaiDichVu(rs.getString(4));
				NhaCungCap ncc=new NhaCungCap(rs.getString(5));
				int slt=rs.getInt(6);
				Double gia=rs.getDouble(7);
				String anh=rs.getString(8);
				DichVu dv=new DichVu(maDV, tenDV, mota, ldv, ncc, slt, slt, anh);
				dsDV.add(dv);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsDV;
	}
	
	public boolean create (DichVu dv) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into DichVu values (?,?,?,?,?,?,?,?)");
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (DichVu x : getAllDichVu()) {
				String maTam = "";
				for (int i = x.getMaDichVu().length() -3 ; i < x.getMaDichVu().length(); i++) {
					maTam += String.valueOf( x.getMaDichVu().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			statement.setString(1, "DV_" + d.formarMa(soTam + 1));
			statement.setString(2, dv.getTenDichVu());
			statement.setString(3, dv.getMoTa());
			statement.setString(4, dv.getLoaiDichVu().getMaLoaiDichVu());
			statement.setString(5, dv.getNhaCungCap().getMaNhaCungCap());
			statement.setInt(6, dv.getSoLuongTon());
			statement.setDouble(7, dv.getGia());
			statement.setString(8,dv.getAnhDichVu());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean update (DichVu dv) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("update DichVu set TenDichVu=?,MoTa=?,MaLoaiDichVu=?,MaNhaCungCap=?,soLuongTon=?,Gia=?,AnhDichVu=?  Where maDichVu=?");
			statement.setString(8, dv.getMaDichVu());
			statement.setString(1, dv.getTenDichVu());
			statement.setString(2, dv.getMoTa());
			statement.setString(3, dv.getLoaiDichVu().getMaLoaiDichVu());
			statement.setString(4, dv.getNhaCungCap().getMaNhaCungCap());
			statement.setInt(5, dv.getSoLuongTon());
			statement.setDouble(6, dv.getGia());
			statement.setString(7,dv.getAnhDichVu());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (DichVu dv) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from DichVu where maDichVu=? ");
			statement.setString(1, dv.getMaDichVu());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
