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
import entity.DichVu;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;


public class PhieuDatPhong_DAO {
	private KhachHang_DAO khachHang_dao;
	private ArrayList<KhachHang> dsKH;
	private Phong_DAO phong_dao;
	private ArrayList<Phong> dsP;
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong(){
		ArrayList<PhieuDatPhong> dsPhieuDatPhong =new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from PhieuDatPhong";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maPhieuDatPhong=rs.getString(1);
				Phong p=null;
		       phong_dao = new Phong_DAO();
		       dsP=phong_dao.getAllPhong();
		        for (Phong ph : dsP) {
		        	if (ph.getMaPhong().equals(rs.getString(2))) {
		        		p =ph;
		        	}
		        }

				KhachHang kh=null;
				khachHang_dao = new KhachHang_DAO();
				dsKH=khachHang_dao.getAllDSKhachHang();
		       for (KhachHang k : dsKH) {   
		    	   if (k.getMaKhachHang().equals(rs.getString(3))) {
		    		   kh = k;
		    	   }
		       }
				
				String date= rs.getString(4);
				PhieuDatPhong phieu=new PhieuDatPhong(maPhieuDatPhong, p, kh, date);
				dsPhieuDatPhong.add(phieu);
			}
		
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhieuDatPhong;
	}
	public boolean create (PhieuDatPhong p) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into PhieuDatPhong values (?,?,?,?)");
			
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (PhieuDatPhong x : getAllPhieuDatPhong()) {
				String maTam = "";
				for (int i = x.getMaPhieuDatPhong().length() -3 ; i < x.getMaPhieuDatPhong().length(); i++) {
					maTam += String.valueOf( x.getMaPhieuDatPhong().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}

			statement.setString(1, "PDP_" + d.formarMa(soTam + 1));
			statement.setString(2, p.getPhong().getMaPhong());
			statement.setString(3, p.getKhachHang().getMaKhachHang());
			statement.setString(4, p.getNgayDat()+ "");
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete (PhieuDatPhong p) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
			statement=con.prepareStatement("delete from PhieuDatPhong where MaPhieuDatPhong=? ");
			statement.setString(1, p.getMaPhieuDatPhong());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
