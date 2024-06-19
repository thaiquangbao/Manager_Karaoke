package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Function.functionNecessary;
import dao.DichVu_Dao;
import entity.DichVu;

public class listDichVu extends JPanel {

    public ArrayList<buttonListDichVu> listDichVu;
	private DichVu_Dao dichVu_dao;
	public int sizeY = 101;
	public int m ;
	private ArrayList<DichVu> dvDV;
	public int kotinh = 0;
	public listDichVu () {
		setBorder(null);
		setLayout(new GridLayout(0, 3,8,8));
		setBackground(Color.white);
		dichVu_dao = new DichVu_Dao();
		listDichVu = new ArrayList<buttonListDichVu>();
		docDuLieuDichVu();
		RenderListDichVu();
		m = (dvDV.size() - kotinh) / 3 ;
		int n = (dvDV.size() - kotinh) % 3;
		if (n > 0) {
			m++;
		}
    }
	public void RenderListDichVu () {
		kotinh = 0;
		for (buttonListDichVu x : listDichVu) {
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
        	listDichVu.add(new buttonListDichVu(dv.getAnhDichVu(), dv.getTenDichVu(), dv.getSoLuongTon() + "", dv.getGia() + ""));
        }
        
    }

}
