package content.hoa_don;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;

import content.DatPhong.buttonListDatPhong;
import content.DatPhong.titleDatPhong;
import dao.KhachHang_DAO;
import entity.KhachHang;

public class listKhachHang extends JPanel{
	private Box box;
	private titleDatPhong title;
	private int choose = 0;
	private Boolean isChoose = false;
	private KhachHang_DAO khachHang_dao;
	private ArrayList<KhachHang> dsKH;
	public ArrayList<buttonListKhachHang> listKhachHang;
	public listKhachHang () {
		setPreferredSize(new Dimension(400, 950));
		setBorder(null);
		setLayout(new GridLayout(0, 2,7,7));
		listKhachHang = new ArrayList<buttonListKhachHang>();
		khachHang_dao=new KhachHang_DAO();
		docDuLieuKhachHang();
		RenderListDatPhong();
//		addEvent();
    }

	public void RenderListDatPhong () {
		for (buttonListKhachHang x : listKhachHang) {
			add(x);
		}
	}
	public void docDuLieuKhachHang() {
        dsKH=khachHang_dao.getAllDSKhachHang();
       for (KhachHang kh : dsKH) {
    	   listKhachHang.add(new buttonListKhachHang(kh));
       }
       
   }
//	public void addEvent () {
//		for (buttonListKhachHang x : listKhachHang) {
//			x.addActionListener(this);
//			x.addMouseListener(this);
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		Object obj = arg0.getSource();
////		box.removeAll();
////		
////		title = new titleDatPhong("",((buttonListDatPhong) obj).name , "", "","","");
////		box.add(title);
////		box.invalidate();
////    	box.validate();
////    	box.repaint();
//	}
//	@Override
//    public void mouseClicked(MouseEvent arg0) {
//		Object obj =arg0.getSource();
//			reStartListDatPhong();
//			((buttonListDatPhong) obj).setColor1("#EECDA3");
//			((buttonListDatPhong) obj).setColor2("#EF629F");
//			((buttonListDatPhong) obj).isChoose = true;
//			invalidate();
//        	validate();
//        	repaint();
//    }
//	public void reStartListDatPhong () {
//		for (buttonListKhachHang x : listKhachHang) {
//			if (x.isChoose.equals(true)) {
//				x.setColor1("#12c2e9");
//				x.setColor2("#c471ed");
//				x.isChoose = false;
//				repaint();
//			}
//			
//		}
//	}
//    @Override
//    public void mouseEntered(MouseEvent arg0) {
//		Object obj =arg0.getSource();
//        if (((buttonListDatPhong) obj).isChoose.equals(false)) {
//            ((buttonListDatPhong) obj).color1 = "#EECDA3";
//            ((buttonListDatPhong) obj).color2 = "#EF629F";
//        }
//        
//    }
//    @Override
//    public void mouseExited(MouseEvent arg0) {
//		Object obj =arg0.getSource();
//        if (((buttonListDatPhong) obj).isChoose.equals(false)) {
//            ((buttonListDatPhong) obj).color1 = "#12c2e9";
//            ((buttonListDatPhong) obj).color2 = "#c471ed";
//        }
//    }
//    @Override
//    public void mousePressed(MouseEvent arg0) {
//        // TODO Auto-generated method stub
//        
//    }
//    @Override
//    public void mouseReleased(MouseEvent arg0) {
//        // TODO Auto-generated method stub
//        
//    }

	
	
}