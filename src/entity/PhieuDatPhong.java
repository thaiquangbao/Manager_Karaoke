package entity;

import java.sql.Date;


public class PhieuDatPhong {
private String maPhieuDatPhong;
private Phong phong;
private KhachHang khachHang;
private String ngayDat;
public String getMaPhieuDatPhong() {
	return maPhieuDatPhong;
}
public void setMaPhieuDatPhong(String maPhieuDatPhong) {
	this.maPhieuDatPhong = maPhieuDatPhong;
}
public Phong getPhong() {
	return phong;
}
public void setPhong(Phong phong) {
	this.phong = phong;
}
public KhachHang getKhachHang() {
	return khachHang;
}
public void setKhachHang(KhachHang khachHang) {
	this.khachHang = khachHang;
}
public String getNgayDat() {
	return ngayDat;
}
public void setNgayDat(String ngayDat) {
	this.ngayDat = ngayDat;
}
public PhieuDatPhong(String maPhieuDatPhong, Phong phong, KhachHang khachHang,String ngayDat) {
	super();
	this.maPhieuDatPhong = maPhieuDatPhong;
	this.phong = phong;
	this.khachHang = khachHang;
	this.ngayDat = ngayDat;
}
public PhieuDatPhong(String maPhieuDatPhong) {
	super();
	this.maPhieuDatPhong = maPhieuDatPhong;
}
public PhieuDatPhong() {
	super();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maPhieuDatPhong == null) ? 0 : maPhieuDatPhong.hashCode());
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
	PhieuDatPhong other = (PhieuDatPhong) obj;
	if (maPhieuDatPhong == null) {
		if (other.maPhieuDatPhong != null)
			return false;
	} else if (!maPhieuDatPhong.equals(other.maPhieuDatPhong))
		return false;
	return true;
}
@Override
public String toString() {
	return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", phong=" + phong + ", khachHang=" + khachHang
			+ ", ngayDat=" + ngayDat + "]";
}

}
