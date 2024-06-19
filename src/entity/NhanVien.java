package entity;

public class NhanVien {
private String maNhanVien;
private String tenNhanVien;
private ChucVu chucVu;
private int tuoi;
private String diaChi;
private String soDienThoai;
private int soHoaDonLap;
private int tongTienHoaDon;
public int getSoHoaDonLap() {
    return soHoaDonLap;
}
public void setSoHoaDonLap(int soHoaDonLap) {
    this.soHoaDonLap = soHoaDonLap;
}
public int getTongTienHoaDon() {
    return tongTienHoaDon;
}
public void setTongTienHoaDon(int tongTienHoaDon) {
    this.tongTienHoaDon = tongTienHoaDon;
}
public String getMaNhanVien() {
	return maNhanVien;
}
public void setMaNhanVien(String maNhanVien) {
	this.maNhanVien = maNhanVien;
}
public String getTenNhanVien() {
	return tenNhanVien;
}
public void setTenNhanVien(String tenNhanVien) {
	this.tenNhanVien = tenNhanVien;
}
public ChucVu getChucVu() {
	return chucVu;
}
public void setChucVu(ChucVu chucVu) {
	this.chucVu = chucVu;
}
public int getTuoi() {
	return tuoi;
}
public void setTuoi(int tuoi) {
	this.tuoi = tuoi;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String soDienThoai,int soHoaDonLap, int tongTienHoaDon,   ChucVu chucVu) {
	super();
	this.maNhanVien = maNhanVien;
	this.tenNhanVien = tenNhanVien;
	this.chucVu = chucVu;
	this.diaChi = diaChi;
	this.soHoaDonLap = soHoaDonLap;
	this.tongTienHoaDon = tongTienHoaDon;
	this.soDienThoai = soDienThoai;
}
public NhanVien(String maNhanVien) {
	super();
	this.maNhanVien = maNhanVien;
}
public NhanVien() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
	NhanVien other = (NhanVien) obj;
	if (maNhanVien == null) {
		if (other.maNhanVien != null)
			return false;
	} else if (!maNhanVien.equals(other.maNhanVien))
		return false;
	return true;
}
@Override
public String toString() {
	return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", chucVu=" + chucVu + ", tuoi="
			+ tuoi + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + "]";
}


}
