package content.DatPhong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import content.trangKhongMenu;

public class listDatPhong extends JPanel {

    public  ArrayList<buttonListDatPhong> listDatPhong;
	private Box box;
	private titleDatPhong title;
	private int choose = 0;
	private Boolean isChoose = false;
	public listDatPhong () {
		this.box = box;
		setPreferredSize(new Dimension(400, 950));
		setBorder(null);
		setLayout(new GridLayout(0, 2,7,7));


		buttonListDatPhong btnphong1 = new buttonListDatPhong ("20093191", "Thái Quang Bảo", "wqe","qwe", "","");
		buttonListDatPhong btnphong2 = new buttonListDatPhong ("qwewq","  Vũ Tiến Đức", "qwewe","qwe", "","");
		buttonListDatPhong btnphong3  = new buttonListDatPhong ("qweqwe","  Lê Xuân Tuấn Anh", "qweqw","wqewqe", "","");
		buttonListDatPhong btnphong4  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong5  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong6  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong7  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong8  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong9  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong10  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong11  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong12  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong13  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong14  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong15  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong16  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong17  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong18  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong19  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong20  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong21  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong22  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong23  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
		buttonListDatPhong btnphong24  = new buttonListDatPhong ("20093191","  Thái Quang  Bảo", "","", "","");
//		buttonListDatPhong btnphong25  = new buttonListDatPhong ("Phòng 25", "", "Thường");
//		buttonListDatPhong btnphong26  = new buttonListDatPhong ("Phòng 26", "", "Thường");
//		buttonListDatPhong btnphong27  = new buttonListDatPhong ("Phòng 27", "", "Thường");
//		buttonListDatPhong btnphong28  = new buttonListDatPhong ("Phòng 28", "", "Thường");
//		buttonListDatPhong btnphong29  = new buttonListDatPhong ("Phòng 29", "", "Thường");
//		buttonListDatPhong btnphong30  = new buttonListDatPhong ("Phòng 30", "", "Thường");
//		buttonListDatPhong btnphong31  = new buttonListDatPhong ("Phòng 31", "", "Thường");
//		buttonListDatPhong btnphong32  = new buttonListDatPhong ("Phòng 32", "", "Thường");
//		buttonListDatPhong btnphong33  = new buttonListDatPhong ("Phòng 33", "", "Thường");
//		buttonListDatPhong btnphong34  = new buttonListDatPhong ("Phòng 34", "", "Thường");
//		buttonListDatPhong btnphong35  = new buttonListDatPhong ("Phòng 35", "", "Thường");
//		buttonListDatPhong btnphong36  = new buttonListDatPhong ("Phòng 36", "", "Thường");


		listDatPhong = new ArrayList<buttonListDatPhong>();
		listDatPhong.add(btnphong1);
		listDatPhong.add(btnphong2);
		listDatPhong.add(btnphong3);
		listDatPhong.add(btnphong4);
		listDatPhong.add(btnphong5);
		listDatPhong.add(btnphong6);
		listDatPhong.add(btnphong7);
		listDatPhong.add(btnphong8);
		listDatPhong.add(btnphong9);
		listDatPhong.add(btnphong10);
		listDatPhong.add(btnphong11);
		listDatPhong.add(btnphong12);
		listDatPhong.add(btnphong13);
		listDatPhong.add(btnphong14);
		listDatPhong.add(btnphong15);
		listDatPhong.add(btnphong16);
		listDatPhong.add(btnphong17);
		listDatPhong.add(btnphong18);
		listDatPhong.add(btnphong19);
		listDatPhong.add(btnphong20);
		listDatPhong.add(btnphong21);
		listDatPhong.add(btnphong22);
		listDatPhong.add(btnphong23);
		listDatPhong.add(btnphong24);
//		listDatPhong.add(btnphong25);
//		listDatPhong.add(btnphong26);
//		listDatPhong.add(btnphong27);
//		listDatPhong.add(btnphong28);
//		listDatPhong.add(btnphong29);
//		listDatPhong.add(btnphong30);
//		listDatPhong.add(btnphong31);
//		listDatPhong.add(btnphong32);
//		listDatPhong.add(btnphong32);

		RenderListDatPhong();
		//addEvent();
    }

	public void RenderListDatPhong () {
		for (buttonListDatPhong x : listDatPhong) {
			add(x);
		}
	}
//	public void addEvent () {
//		for (buttonListDatPhong x : listDatPhong) {
//			x.addActionListener(this);
//			x.addMouseListener(this);
//		}
//	}

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
//		for (buttonListDatPhong x : listDatPhong) {
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