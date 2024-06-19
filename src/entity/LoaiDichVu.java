package entity;

public class LoaiDichVu {
private String maLoaiDichVu;
private String tenLoaiDichVu;
private String moTa;
public String getMaLoaiDichVu() {
	return maLoaiDichVu;
}
public void setMaLoaiDichVu(String maLoaiDichVu) {
	this.maLoaiDichVu = maLoaiDichVu;
}
public String getTenLoaiDichVu() {
	return tenLoaiDichVu;
}
public void setTenLoaiDichVu(String tenLoaiDichVu) {
	this.tenLoaiDichVu = tenLoaiDichVu;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu, String moTa) {
	super();
	this.maLoaiDichVu = maLoaiDichVu;
	this.tenLoaiDichVu = tenLoaiDichVu;
	this.moTa = moTa;
}
public LoaiDichVu(String maLoaiDichVu) {
	super();
	this.maLoaiDichVu = maLoaiDichVu;
}
public LoaiDichVu() {}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maLoaiDichVu == null) ? 0 : maLoaiDichVu.hashCode());
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
	LoaiDichVu other = (LoaiDichVu) obj;
	if (maLoaiDichVu == null) {
		if (other.maLoaiDichVu != null)
			return false;
	} else if (!maLoaiDichVu.equals(other.maLoaiDichVu))
		return false;
	return true;
}
@Override
public String toString() {
	return "LoaiDichVu [maLoaiDichVu=" + maLoaiDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + ", moTa=" + moTa + "]";
}

}
