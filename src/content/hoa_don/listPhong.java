package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import java.awt.Font;
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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import content.trangKhongMenu;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;

public class listPhong extends JPanel implements ActionListener, MouseListener{

    public  ArrayList<buttonListPhong> listPhong;
	// private Box box;
	private titleHoaDon title;
	private int choose = 0;
	private Phong_DAO phong_dao;
    private LoaiPhong_DAO loaiPhong_dao;
    private listDichVu listDichVu;
    private listKhachHang listKhachHang;
    public int sizeY = 119;
	private ArrayList<Phong> dsP;
	public int m;
	public listPhong (listDichVu listDichVu, listKhachHang listKhachHang) {
		this.listDichVu = listDichVu;
		this.listKhachHang = listKhachHang;
		setBorder(null);
		setLayout(new GridLayout(0, 4,8,8));
		setBackground(Color.white);
		phong_dao=new Phong_DAO();
        loaiPhong_dao=new LoaiPhong_DAO();
        listPhong = new ArrayList<buttonListPhong>();
        docDuLieuPhong();
		RenderListPhong();
		addEvent();
		m = dsP.size() / 4;
		int n = dsP.size() % 4;
		if (n > 0) {
			m++;
		}
		setPreferredSize(new Dimension(520, sizeY * m));
    }
	public void docDuLieuPhong() {
	    dsP=phong_dao.getAllPhong();
        for (Phong p : dsP) {
            functionNecessary d = new functionNecessary();
            String ten = null;
            ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
            for (LoaiPhong lp : dsLP) {
                if (lp.getMaLoaiPhong().equals(p.getLoaiPhong().getMaLoaiPhong())) {
                    ten = lp.getTenLoaiPhong();
                }
            }
            listPhong.add(new buttonListPhong (p.getTenPhong(), "", ten,p.getGiaPhong(), listKhachHang, listDichVu, this));
        }
    }
	
	public void RenderListPhong () {
		for (buttonListPhong x : listPhong) {
			add(x);
		}
	}
	public void addEvent () {
		for (buttonListPhong x : listPhong) {
			x.addActionListener(this);
			x.addMouseListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
	@Override
    public void mouseClicked(MouseEvent arg0) {
		Object obj =arg0.getSource();
			reStartListPhong();
			if (((buttonListPhong) obj).isChoose.equals(false)) {
				if (((buttonListPhong) obj).num == 0) {
					((buttonListPhong) obj).color1 = "#EECDA3";
					((buttonListPhong) obj).color2 = "#EF629F";
				} else {
					((buttonListPhong) obj).color1 = "#7b4397";
					((buttonListPhong) obj).color2 = "#dc2430";
				}
			}
			((buttonListPhong) obj).isChoose = true;
			invalidate();
        	validate();
        	repaint();
    }
	public void reStartListPhong () {
		for (buttonListPhong x : listPhong) {
			if (x.isChoose.equals(true)) {
				if (x.num == 0) {
					x.color1 = "#12c2e9";
					x.color2 = "#c471ed";
				} else {
					x.color1 = "#780206";
					x.color2 = "#061161";
				}
				x.isChoose = false;
				repaint();
			}
			
		}
	}
	public void setColorForButton (buttonListPhong y) {
		for (buttonListPhong x : listPhong) {
			
			if (x.equals(y)) {
				if (x.isChoose.equals(false)) {
					x.color1 = "#EECDA3";
					x.color2 = "#EF629F";
					x.isChoose = true;
					repaint();
				}
			}
		}
	}
	public void UpdatePhongDangSuDung () {
		for (buttonListPhong x : listPhong) {
//			System.out.println(x.name);
			if (x.panelHoaDon.btnLapHoaDon.getLblname().getText().equals(" Lưu Hóa Đơn")) {
				x.label.setText(x.name + " (Sử Dụng)");
				x.label.setFont(new Font("" , 0, 14));
			} else {
				x.label.setText("   " + x.name);
				x.label.setFont(new Font("" , 0, 18));
			}
		}
	}
    @Override
    public void mouseEntered(MouseEvent arg0) {
		Object obj =arg0.getSource();
		if (((buttonListPhong) obj).isChoose.equals(false)) {
			if (((buttonListPhong) obj).num == 0) {
				((buttonListPhong) obj).color1 = "#EECDA3";
				((buttonListPhong) obj).color2 = "#EF629F";
			} else {
				((buttonListPhong) obj).color1 = "#7b4397";
				((buttonListPhong) obj).color2 = "#dc2430";
			}
		}
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
		Object obj =arg0.getSource();
		if (((buttonListPhong) obj).isChoose.equals(false)) {
			if (((buttonListPhong) obj).num == 0) {
				((buttonListPhong) obj).color1 = "#12c2e9";
				((buttonListPhong) obj).color2 = "#c471ed";
			} else {
				((buttonListPhong) obj).color1 = "#780206";
				((buttonListPhong) obj).color2 = "#061161";
			}
		}
    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
