package entity;

import java.time.LocalDate;

public class KhachHang {
private String maKhachHang;
private String tenKhachHang;
private String soDienThoai;
private String diaChi;
private int tongTienHoaDon;
public int getTongTienHoaDon() {
    return tongTienHoaDon;
}
public void setTongTienHoaDon(int tongTienHoaDon) {
    this.tongTienHoaDon = tongTienHoaDon;
}
public String getMaKhachHang() {
	return maKhachHang;
}
public void setMaKhachHang(String maKhachHang) {
	this.maKhachHang = maKhachHang;
}
public String getTenKhachHang() {
	return tenKhachHang;
}
public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, int tongTienHoaDon) {
	super();
	this.maKhachHang = maKhachHang;
	this.tenKhachHang = tenKhachHang;
	this.soDienThoai = soDienThoai;
	this.diaChi = diaChi;
	this.tongTienHoaDon = tongTienHoaDon;
}
public KhachHang(String maKhachHang) {
	super();
	this.maKhachHang = maKhachHang;
}
public KhachHang() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
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
	KhachHang other = (KhachHang) obj;
	if (maKhachHang == null) {
		if (other.maKhachHang != null)
			return false;
	} else if (!maKhachHang.equals(other.maKhachHang))
		return false;
	return true;
}
@Override
public String toString() {
	return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai
			+ ", diaChi=" + diaChi + "]";
}


}
