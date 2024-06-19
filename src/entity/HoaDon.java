package entity;

import java.sql.Date;

public class HoaDon {
private String maHoaDon;
private String tenHoaDon;
private String ngayLapHoaDon;
private KhachHang khachHang;
private NhanVien nhanVien;
private Phong phong;
private String tongTien;
private String tienKhachDua;
public String getMaHoaDon() {
	return maHoaDon;
}
public void setMaHoaDon(String maHoaDon) {
	this.maHoaDon = maHoaDon;
}
public String getTenHoaDon() {
	return tenHoaDon;
}
public void setTenHoaDon(String tenHoaDon) {
	this.tenHoaDon = tenHoaDon;
}
public String getNgayLapHoaDon() {
	return ngayLapHoaDon;
}
public void setNgayLapHoaDon(String ngayLapHoaDon) {
	this.ngayLapHoaDon = ngayLapHoaDon;
}
public KhachHang getKhachHang() {
	return khachHang;
}
public void setKhachHang(KhachHang khachHang) {
	this.khachHang = khachHang;
}
public NhanVien getNhanVien() {
	return nhanVien;
}
public void setNhanVien(NhanVien nhanVien) {
	this.nhanVien = nhanVien;
}
public HoaDon(String maHoaDon,String ngayLapHoaDon, KhachHang khachHang, NhanVien nhanVien, Phong phong, String tongTien, String tienKhach) {
	super();
	this.maHoaDon = maHoaDon;
	this.tenHoaDon = tenHoaDon;
	this.ngayLapHoaDon = ngayLapHoaDon;
	this.khachHang = khachHang;
	this.nhanVien = nhanVien;
	this.phong = phong;
	this.tongTien = tongTien;
	this.tienKhachDua = tienKhach;
}
public HoaDon(String maHoaDon) {
	super();
	this.maHoaDon = maHoaDon;
}
public HoaDon() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	HoaDon other = (HoaDon) obj;
	if (maHoaDon == null) {
		if (other.maHoaDon != null)
			return false;
	} else if (!maHoaDon.equals(other.maHoaDon))
		return false;
	return true;
}
@Override
public String toString() {
	return "HoaDon [maHoaDon=" + maHoaDon + ", tenHoaDon=" + tenHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon
			+ ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + "]";
}
public Phong getPhong() {
	return phong;
}
public void setPhong(Phong phong) {
	this.phong = phong;
}
public String getTongTien() {
	return tongTien;
}
public void setTongTien(String tongTien) {
	this.tongTien = tongTien;
}
public String getTienKhachDua() {
	return tienKhachDua;
}
public void setTienKhachDua(String tienKhachDua) {
	this.tienKhachDua = tienKhachDua;
}



}
