package NhapHang;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import dao.DichVu_Dao;
import dao.NhaCungCap_DAO;
import entity.DichVu;
import entity.NhaCungCap;

public class listDVNCC extends JPanel {

    public ArrayList<btnListDV> listDichVu;
	private DichVu_Dao dichVu_dao;
	public int sizeY = 101;
	public int m ;
	private ArrayList<DichVu> dvDV;
	public int kotinh = 0;
	private NhaCungCap_DAO ncc_dao;
	private ArrayList<NhaCungCap> dsNCC;
	private int zz;
	private String ten = "";
	public listDVNCC (String ten) {
		this.ten = ten;
		setBorder(null);
		setLayout(new GridLayout(0, 3,8,8));
		setBackground(Color.white);
		dichVu_dao = new DichVu_Dao();
		listDichVu = new ArrayList<btnListDV>();
		docDuLieuDichVuTheoNCC();
		RenderListDichVu();
		setM();
    }
	public void RenderListDichVu () {
		kotinh = 0;
		for (btnListDV x : listDichVu) {
        	if (!x.title.getText().equals("Giờ Hát ( Thường )")) {
        		if (! x.title.getText().equals("Giờ Hát ( VIP )")) {
        			add (x);
        		}
        		else {
        			kotinh ++;
        		}
        	}else {
        		kotinh ++;
        	}
		}
	}
	public void docDuLieuDichVu() {
        dvDV=dichVu_dao.getAllDichVu();
        for (DichVu dv : dvDV) {
        	listDichVu.add(new btnListDV(dv.getAnhDichVu(), dv.getTenDichVu(), dv.getSoLuongTon() + "", dv.getGia() + ""));
        }
        
    }
	public void docDuLieuDichVuTheoNCC() {
        dvDV=dichVu_dao.getAllDichVu();
        listDichVu.removeAll(listDichVu);
        for (DichVu dv : dvDV) {
        	ncc_dao = new NhaCungCap_DAO();
        	dsNCC = ncc_dao.getAllNhaCungCap();
        	for (NhaCungCap y : dsNCC) {
        		if (y.getMaNhaCungCap().equals(dv.getNhaCungCap().getMaNhaCungCap())) {
        			if (y.getTenNhaCungCap().equals(ten)) {
            			zz ++;
    	        		listDichVu.add(new btnListDV(dv.getAnhDichVu(), dv.getTenDichVu(), dv.getSoLuongTon() + "", dv.getGia() + ""));
    	        	}
        		}
        	}
        }
        
    }
	public void setM () {
		m = zz / 3 ;
		int n = zz % 3;
		if (n > 0) {
			m++;
		}
	}

}
