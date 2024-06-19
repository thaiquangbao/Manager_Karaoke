package entity;

public class ChucVu {
private String maChucVu;
private String tenChucVu;
private String moTa;
public String getMaChucVu() {
	return maChucVu;
}
public void setMaChucVu(String maChucVu) {
	this.maChucVu = maChucVu;
}
public String getTenChucVu() {
	return tenChucVu;
}
public void setTenChucVu(String tenChucVu) {
	this.tenChucVu = tenChucVu;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public ChucVu(String maChucVu, String tenChucVu, String moTa) {
	super();
	this.maChucVu = maChucVu;
	this.tenChucVu = tenChucVu;
	this.moTa = moTa;
}
public ChucVu(String maChucVu) {
	super();
	this.maChucVu = maChucVu;
}
public ChucVu() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maChucVu == null) ? 0 : maChucVu.hashCode());
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
	ChucVu other = (ChucVu) obj;
	if (maChucVu == null) {
		if (other.maChucVu != null)
			return false;
	} else if (!maChucVu.equals(other.maChucVu))
		return false;
	return true;
}
@Override
public String toString() {
	return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + ", moTa=" + moTa + "]";
}

}
