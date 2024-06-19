package entity;

public class DichVu {
private String maDichVu;
private String tenDichVu;
private String moTa;
private LoaiDichVu loaiDichVu;
private NhaCungCap nhaCungCap;
private int soLuongTon;
private int gia;
private String anhDichVu; 

public String getAnhDichVu() {
	return anhDichVu;
}
public void setAnhDichVu(String anhDichVu) {
	this.anhDichVu = anhDichVu;
}
public String getMaDichVu() {
	return maDichVu;
}
public void setMaDichVu(String maDichVu) {
	this.maDichVu = maDichVu;
}
public String getTenDichVu() {
	return tenDichVu;
}
public void setTenDichVu(String tenDichVu) {
	this.tenDichVu = tenDichVu;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public LoaiDichVu getLoaiDichVu() {
	return loaiDichVu;
}
public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
	this.loaiDichVu = loaiDichVu;
}
public NhaCungCap getNhaCungCap() {
	return nhaCungCap;
}
public void setNhaCungCap(NhaCungCap nhaCungCap) {
	this.nhaCungCap = nhaCungCap;
}
public int getSoLuongTon() {
	return soLuongTon;
}
public void setSoLuongTon(int soLuongTon) {
	this.soLuongTon = soLuongTon;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}

public DichVu(String maDichVu, String tenDichVu, String moTa, LoaiDichVu loaiDichVu, NhaCungCap nhaCungCap,
		int soLuongTon, int gia, String anhDichVu) {
	super();
	this.maDichVu = maDichVu;
	this.tenDichVu = tenDichVu;
	this.moTa = moTa;
	this.loaiDichVu = loaiDichVu;
	this.nhaCungCap = nhaCungCap;
	this.soLuongTon = soLuongTon;
	this.gia = gia;
	this.anhDichVu = anhDichVu;
}
public DichVu(String maDichVu) {
	super();
	this.maDichVu = maDichVu;
}
public DichVu() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maDichVu == null) ? 0 : maDichVu.hashCode());
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
	DichVu other = (DichVu) obj;
	if (maDichVu == null) {
		if (other.maDichVu != null)
			return false;
	} else if (!maDichVu.equals(other.maDichVu))
		return false;
	return true;
}
@Override
public String toString() {
	return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", moTa=" + moTa + ", loaiDichVu=" + loaiDichVu
			+ ", nhaCungCap=" + nhaCungCap + ", soLuongTon=" + soLuongTon + ", gia=" + gia + "]";
}


}
