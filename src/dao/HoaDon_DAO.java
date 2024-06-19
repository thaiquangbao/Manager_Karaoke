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
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

public class HoaDon_DAO {
	private KhachHang_DAO khachHang_dao;
	private ArrayList<KhachHang> dsKH;
	private ChucVu_DAO chucVu_dao;
	private ArrayList<ChucVu> dsCV;
	private NhanVien_DAO nhanVien_dao;
	private ArrayList<NhanVien> dsNV;
	private Phong_DAO phong_dao;
	private ArrayList<Phong> dsP;
	public ArrayList<HoaDon> getAllHoaDon(){
		ArrayList<HoaDon> dsHoaDon =new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql ="select * from HoaDon";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon=rs.getString(1);
				String date=rs.getString(2);
				KhachHang kh=null;
				NhanVien nv=null;
				Phong p = null;
				String tong = rs.getString(6);
				String tienKhach = rs.getString(7);
				
				khachHang_dao = new KhachHang_DAO();
				dsKH=khachHang_dao.getAllDSKhachHang();
		        for (KhachHang kh1 : dsKH) {
		        	if (kh1.getMaKhachHang().equals(rs.getString(3))) {
		        		kh = kh1;
		        	}
		        }
		        nhanVien_dao = new NhanVien_DAO();
		        dsNV = nhanVien_dao.getAllNhanVien();
			    for (NhanVien nv1 : dsNV) {
			        if (nv1.getMaNhanVien().equals(rs.getString(4))) {
			        	nv = nv1;
			        }
			    }
			    phong_dao = new Phong_DAO();
			    dsP=phong_dao.getAllPhong();
		        for (Phong p1 : dsP) {
		        	if (p1.getMaPhong().equals(rs.getString(5))) {
		        		p = p1;
		        	}
		        }
		        HoaDon hd=new HoaDon(maHoaDon, date, kh, nv, p, tong, tienKhach);
				dsHoaDon.add(hd);
			}
			}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHoaDon; 
	}
	public boolean create (HoaDon hd) { 
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		int n=0;
		try {
		    functionNecessary d = new functionNecessary();
			statement=con.prepareStatement("insert into HoaDon values (?,?,?,?,?,?,?)");
			ArrayList<Integer> dsMa = new ArrayList<Integer>();
			for (HoaDon x : getAllHoaDon()) {
				String maTam = "";
				for (int i = x.getMaHoaDon().length() -3 ; i < x.getMaHoaDon().length(); i++) {
					maTam += String.valueOf( x.getMaHoaDon().charAt(i));
				}
				dsMa.add(Integer.parseInt(maTam));
			}
			
			int soTam = 0;
			for (int x : dsMa) {
				if (x > soTam) {
					soTam = x;
				}
			}
			statement.setString(1, "HD_" + d.formarMa(soTam + 1));
			statement.setString(2, hd.getNgayLapHoaDon());
			statement.setString(3, hd.getKhachHang().getMaKhachHang());
			statement.setString(4, hd.getNhanVien().getMaNhanVien());
			statement.setString(5, hd.getPhong().getMaPhong());
			statement.setString(6, hd.getTongTien());
			statement.setString(7, hd.getTienKhachDua());
			n=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
