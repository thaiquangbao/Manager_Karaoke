package entity;

public class ChiTietHoaDon {
private String maCTHoaDon;
private DichVu dichVu;
private int soLuong;
private HoaDon hoaDon;
private String thanhTien;
public String getMaCTHoaDon() {
	return maCTHoaDon;
}
public void setMaCTHoaDon(String maCTHoaDon) {
	this.maCTHoaDon = maCTHoaDon;
}
public DichVu getDichVu() {
	return dichVu;
}
public void setDichVu(DichVu dichVu) {
	this.dichVu = dichVu;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public HoaDon getHoaDon() {
	return hoaDon;
}
public void setHoaDon(HoaDon hoaDon) {
	this.hoaDon = hoaDon;
}
public ChiTietHoaDon(String maCTHoaDon, DichVu dichVu, int soLuong, HoaDon hoaDon, String thanhTien) {
	super();
	this.maCTHoaDon = maCTHoaDon;
	this.dichVu = dichVu;
	this.soLuong = soLuong;
	this.hoaDon = hoaDon;
	this.thanhTien = thanhTien;
}
public ChiTietHoaDon(String maCTHoaDon) {
	super();
	this.maCTHoaDon = maCTHoaDon;
}
public ChiTietHoaDon() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maCTHoaDon == null) ? 0 : maCTHoaDon.hashCode());
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
	ChiTietHoaDon other = (ChiTietHoaDon) obj;
	if (maCTHoaDon == null) {
		if (other.maCTHoaDon != null)
			return false;
	} else if (!maCTHoaDon.equals(other.maCTHoaDon))
		return false;
	return true;
}
@Override
public String toString() {
	return "ChiTietHoaDon [maCTHoaDon=" + maCTHoaDon + ", dichVu=" + dichVu + ", soLuong=" + soLuong + ", hoaDon="
			+ hoaDon +  "]";
}
public String getThanhTien() {
	return thanhTien;
}
public void setThanhTien(String thanhTien) {
	this.thanhTien = thanhTien;
}


}
