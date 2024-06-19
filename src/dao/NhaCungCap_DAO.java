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
import entity.DichVu;
import entity.NhaCungCap;


public class NhaCungCap_DAO {
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		ArrayList<NhaCungCap> dsNhaCungCap =new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from NhaCungCap";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maNhaCungCap=rs.getString(1);
				String tenNhaCungCap=rs.getString(2);
				String diaChi=rs.getString(3);
				String sdt=rs.getString(4);
				NhaCungCap ncc=new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, sdt);
				dsNhaCungCap.add(ncc);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhaCungCap;
	}
	public boolean create (NhaCungCap ncc, int size) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into NhaCungCap values (?,?,?,?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (NhaCungCap x : getAllNhaCungCap()) {
				String maTam = "";
				for (int i = x.getMaNhaCungCap().length() -3 ; i < x.getMaNhaCungCap().length(); i++) {
					maTam += String.valueOf( x.getMaNhaCungCap().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			
			statement.setString(1, "NCC_" + d.formarMa(soTam + 1));
			statement.setString(2, ncc.getTenNhaCungCap());
			statement.setString(3, ncc.getDiaChi());
			statement.setString(4, ncc.getSoDienThoai());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}

	public boolean update (NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("update NhaCungCap set TenNhaCungCap=?,DiaChi=?,SoDienThoai=? Where maNhaCungCap=?");
			statement.setString(4, ncc.getMaNhaCungCap());
			statement.setString(1, ncc.getTenNhaCungCap());
			statement.setString(2,ncc.getDiaChi());
			statement.setString(3, ncc.getSoDienThoai());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from NhaCungCap where maNhaCungCap=? ");
			statement.setString(1, ncc.getMaNhaCungCap());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
