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
import entity.NhaCungCap;
import entity.PhieuNhapHang;

public class PhieuNhapHang_DAO {
	
	private NhaCungCap_DAO nhaCungCap_dao;
	private ArrayList<NhaCungCap> dsNCC;

	public ArrayList<PhieuNhapHang> getAllPhieuNhapHang(){
		ArrayList<PhieuNhapHang> dsPhieuNhapHang =new ArrayList<PhieuNhapHang>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from PhieuNhapHang";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuNhapHang=rs.getString(1);
				String thoiGian = rs.getString(2);
				int soLuong = rs.getInt(3);
				NhaCungCap ncc1 = null;
				nhaCungCap_dao = new NhaCungCap_DAO();
			    dsNCC=nhaCungCap_dao.getAllNhaCungCap();
		        for (NhaCungCap ncc: dsNCC) {
		            if (ncc.getMaNhaCungCap().equals(rs.getString(5))) {
		            	ncc1 = ncc;
		            }
		        }
				PhieuNhapHang phieu=new PhieuNhapHang(maPhieuNhapHang, thoiGian, soLuong, rs.getString(4), ncc1);
				dsPhieuNhapHang.add(phieu);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhieuNhapHang;
	}
	
	public boolean create (PhieuNhapHang p) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into PhieuNhapHang values (?,?,?,?,?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (PhieuNhapHang x : getAllPhieuNhapHang()) {
				String maTam = "";
				for (int i = x.getMaPhieu().length() -3 ; i < x.getMaPhieu().length(); i++) {
					maTam += String.valueOf( x.getMaPhieu().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}

			statement.setString(1, "PNH_" + d.formarMa(soTam + 1));
			statement.setString(2, p.getThoiGian());
			statement.setInt(3, p.getSoLuong());
			statement.setString(4, p.getTongTien());
			statement.setString(5, p.getNhaCungCap().getMaNhaCungCap());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
}
