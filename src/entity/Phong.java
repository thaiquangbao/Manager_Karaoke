package entity;

public class Phong {
private String maPhong;
private String tenPhong;
private LoaiPhong loaiPhong;
private String giaPhong;

public String getMaPhong() {
	return maPhong;
}
public void setMaPhong(String maPhong) {
	this.maPhong = maPhong;
}
public String getTenPhong() {
	return tenPhong;
}
public void setTenPhong(String tenPhong) {
	this.tenPhong = tenPhong;
}
public LoaiPhong getLoaiPhong() {
	return loaiPhong;
}
public void setLoaiPhong(LoaiPhong loaiPhong) {
	this.loaiPhong = loaiPhong;
}
public String getGiaPhong() {
	return giaPhong;
}
public void setGiaPhong(String giaPhong) {
	this.giaPhong = giaPhong;
}
public Phong(String maPhong, String tenPhong, LoaiPhong loaiPhong, String giaPhong) {
	super();
	this.maPhong = maPhong;
	this.tenPhong = tenPhong;
	this.loaiPhong = loaiPhong;
	this.giaPhong = giaPhong;
}
public Phong(String maPhong) {
	super();
	this.maPhong = maPhong;
}
public Phong() {
	super();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
	Phong other = (Phong) obj;
	if (maPhong == null) {
		if (other.maPhong != null)
			return false;
	} else if (!maPhong.equals(other.maPhong))
		return false;
	return true;
}
@Override
public String toString() {
	return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", giaPhong="
			+ giaPhong + "]";
}



}
