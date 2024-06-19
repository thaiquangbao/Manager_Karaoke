package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Function.functionNecessary;
import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.LoaiDichVu;
import entity.Phong;

public class ChiTietHoaDon_DAO {
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon(){
		ArrayList<ChiTietHoaDon> dsChiTietHoaDon =new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from ChiTietHoaDon";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maChiTietHoaDon=rs.getString(1);
				DichVu dv=new DichVu(rs.getString(2));
				int sl=rs.getInt(3);
				HoaDon hd=new HoaDon(rs.getString(4));
				String thanhTien = rs.getString(5);
				ChiTietHoaDon cthd=new ChiTietHoaDon(maChiTietHoaDon, dv, sl, hd, thanhTien);
				dsChiTietHoaDon.add(cthd);
			}
			}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsChiTietHoaDon;
	}
	public boolean create (ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?, ?)");
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (ChiTietHoaDon x : getAllChiTietHoaDon()) {
				String maTam = "";
				for (int i = x.getMaCTHoaDon().length() -3 ; i < x.getMaCTHoaDon().length(); i++) {
					maTam += String.valueOf( x.getMaCTHoaDon().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			statement.setString(1, "CTHD_" + d.formarMa(soTam + 1));
			statement.setString(2, cthd.getDichVu().getMaDichVu());
			statement.setInt(3, cthd.getSoLuong());
			statement.setString(4, cthd.getHoaDon().getMaHoaDon());
			statement.setString(5, cthd.getThanhTien());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
