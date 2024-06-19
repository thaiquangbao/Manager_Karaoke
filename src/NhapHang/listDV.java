package NhapHang;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import dao.DichVu_Dao;
import dao.NhaCungCap_DAO;
import entity.DichVu;
import entity.NhaCungCap;

public class listDV extends JPanel {

    public ArrayList<btnListDV> listDichVu;
	private DichVu_Dao dichVu_dao;
	public int sizeY = 101;
	public int m ;
	private ArrayList<DichVu> dvDV;
	public int kotinh = 0;
	private NhaCungCap_DAO ncc_dao;
	private ArrayList<NhaCungCap> dsNCC;
	private int zz = 0;
	public listDV () {
		setBorder(null);
		setLayout(new GridLayout(0, 3,8,8));
		setBackground(Color.white);
		dichVu_dao = new DichVu_Dao();
		listDichVu = new ArrayList<btnListDV>();
		docDuLieuDichVu();
		RenderListDichVu();
		setM();
    }
	public void RenderListDichVu () {
		kotinh = 0;
		removeAll();
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
	public void setM () {
		m = (dvDV.size() - kotinh) / 3 ;
		int n = (dvDV.size() - kotinh) % 3;
		if (n > 0) {
			m++;
		}
	}

}