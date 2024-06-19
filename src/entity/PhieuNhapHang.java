package entity;

import java.util.Objects;

public class PhieuNhapHang {
	private String maPhieu;
	private String thoiGian;
	private int soLuong;
	private NhaCungCap nhaCungCap;
	private String tongTien;
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieu, nhaCungCap, soLuong, thoiGian);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuNhapHang other = (PhieuNhapHang) obj;
		return Objects.equals(maPhieu, other.maPhieu) && Objects.equals(nhaCungCap, other.nhaCungCap)
				&& soLuong == other.soLuong && Objects.equals(thoiGian, other.thoiGian);
	}
	public PhieuNhapHang(String maPhieu, String thoiGian, int soLuong, String tongTien, NhaCungCap nhaCungCap) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGian = thoiGian;
		this.soLuong = soLuong;
		this.nhaCungCap = nhaCungCap;
		this.tongTien = tongTien;
	}
	public PhieuNhapHang(String maPhieu) {
		super();
		this.maPhieu = maPhieu;
	}
	public PhieuNhapHang () {}
	@Override
	public String toString() {
		return "PhieuNhapHang [maPhieu=" + maPhieu + ", thoiGian=" + thoiGian + ", soLuong=" + soLuong + ", nhaCungCap="
				+ nhaCungCap + "]";
	}
	public String getTongTien() {
		return tongTien;
	}
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
