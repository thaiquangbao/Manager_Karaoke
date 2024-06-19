package entity;

public class NhaCungCap {
private String maNhaCungCap;
private String tenNhaCungCap;
private String diaChi;
private String soDienThoai;

public String getMaNhaCungCap() {
	return maNhaCungCap;
}
public void setMaNhaCungCap(String maNhaCungCap) {
	this.maNhaCungCap = maNhaCungCap;
}
public String getTenNhaCungCap() {
	return tenNhaCungCap;
}
public void setTenNhaCungCap(String tenNhaCungCap) {
	this.tenNhaCungCap = tenNhaCungCap;
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

public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
	super();
	this.maNhaCungCap = maNhaCungCap;
	this.tenNhaCungCap = tenNhaCungCap;
	this.diaChi = diaChi;
	this.soDienThoai = soDienThoai;
}
public NhaCungCap(String maNhaCungCap) {
	super();
	this.maNhaCungCap = maNhaCungCap;
}
public NhaCungCap() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maNhaCungCap == null) ? 0 : maNhaCungCap.hashCode());
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
	NhaCungCap other = (NhaCungCap) obj;
	if (maNhaCungCap == null) {
		if (other.maNhaCungCap != null)
			return false;
	} else if (!maNhaCungCap.equals(other.maNhaCungCap))
		return false;
	return true;
}
@Override
public String toString() {
	return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
			+ ", soDienThoai=" + soDienThoai + "]";
}



}
