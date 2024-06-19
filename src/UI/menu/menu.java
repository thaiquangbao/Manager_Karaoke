package UI.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menu extends JPanel implements MouseListener{
	private String color1, color2;
	public menuItem menuTongQuan;
	public menuItem menuNhanVien;
	public menuItem menuDichVu;
	public menuItem menuPhong;
	public menuItem menuThongKe;
	public menuItem menuYKien;
	public actor actor;
	public ArrayList<menuItem> listMenuItem;
	public Box boxMenuItem;
	public menuItem menuNhanVienBanHang;
	public menuItem menuTroGiup;
	private Box boxTotal;
	private JPanel boxMenu;
	public subMenuItem subQLDV;
	public subMenuItem subTCDV;
	public subMenuItem subLDV;
	public subMenuItem subNCC;
	private Box boxSubDichVu;
	private Boolean isSub = false;
	private int indexSuv = 0;
	public subMenuItem subQLNV;
	public subMenuItem subTCNV;
	public subMenuItem subCV;
	private Box boxSubNhanVien;
	public subMenuItem subQLP;
	public subMenuItem subTCP;
	public subMenuItem subLP;
	private Box boxSubPhong;
	public subMenuItem subTKHD;
	public subMenuItem subTKKH;
	public subMenuItem subTKNV;
	private Box boxSubThongKe;
	public menuItem menuHoaDon;
	public menuItem menuKhachHang;
	public subMenuItem menuDatPhong;
	public subMenuItem subQLKH;
	public subMenuItem subTCKH;
	public Box boxSubKhachHang;
	private Box boxSubHoaDon;
	public subMenuItem subHDBH;
	public subMenuItem subHDNH;
	public subMenuItem subTKTC;
	
	public menu (String color1, String color2, String type, String name, String sdt) {
		this.color1 = color1;
		this.color2 = color2;
		setBackground(Color.decode(color1));
		Font fontMenu = new Font("Arial",0, 19);
		Font fontActor = new Font("Arial",Font.BOLD, 23);
		setPreferredSize(new Dimension(50, 1080));
		boxTotal = Box.createVerticalBox();
		add(boxTotal);
		boxMenu = new JPanel();
		boxMenuItem = Box.createVerticalBox();
		boxMenu.setOpaque(false);
		
		actor = new actor("NVQL_001","hinh/actor.png", fontActor, color1, name , sdt);
		menuTongQuan = new menuItem("Tổng Quan", "hinh/menu/menu_TongQuan.png", fontMenu, color1);
		
		menuDichVu = new menuItem(  "Dịch Vụ", "hinh/menu/menu_DichVu.png", fontMenu, color1);
		subQLDV = new subMenuItem(  "Quản Lí Dịch Vụ",fontMenu, color1);
		subTCDV = new subMenuItem(  "Tra Cứu Dịch Vụ",fontMenu, color1);
		subLDV = new subMenuItem(  "Loại Dịch Vụ",fontMenu, color1);
		subNCC = new subMenuItem(  "Nhà Cung Cấp",fontMenu, color1);
		subTKHD = new subMenuItem("Thống Kê Hóa Đơn",  fontMenu, color1);
		subTKKH = new subMenuItem("Thống Kê Khách Hàng",  fontMenu, color1);
		subTKNV = new subMenuItem("Thống Kê Nhân Viên",  fontMenu, color1);
		boxSubDichVu = Box.createVerticalBox();
		boxSubDichVu.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubDichVu.add(subQLDV);
		boxSubDichVu.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubDichVu.add(subTCDV);
		boxSubDichVu.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubDichVu.add(subLDV);
		boxSubDichVu.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubDichVu.add(subNCC);
		
		menuNhanVien = new menuItem("Nhân Viên", "hinh/menu/menu_NhanVien.png", fontMenu, color1);
		subQLNV = new subMenuItem("Quản Lí Nhân Viên",  fontMenu, color1);
		subTCNV = new subMenuItem("Tra Cứu Nhân Viên",  fontMenu, color1);
		subCV = new subMenuItem("Quản Lí Chức Vụ",  fontMenu, color1);
		boxSubNhanVien = Box.createVerticalBox();
		boxSubNhanVien.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubNhanVien.add(subQLNV);
		boxSubNhanVien.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubNhanVien.add(subTCNV);
		boxSubNhanVien.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubNhanVien.add(subCV);
		boxSubNhanVien.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubNhanVien.add(subTKNV);
		
		menuNhanVienBanHang = new menuItem("Nhân Viên Bán Hàng", "hinh/menu/menu_NVBH.png", fontMenu, color1);
		
		menuPhong = new menuItem(   "Phòng", "hinh/menu/menu_Phong.png", fontMenu, color1);
		subQLP = new subMenuItem("Quản Lí Phòng",  fontMenu, color1);
		subTCP = new subMenuItem("Tra Cứu Phòng",  fontMenu, color1);
		subLP = new subMenuItem("Quản Lí Loại Phòng",  fontMenu, color1);
		boxSubPhong = Box.createVerticalBox();
		boxSubPhong.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubPhong.add(subQLP);
		boxSubPhong.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubPhong.add(subTCP);
		boxSubPhong.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubPhong.add(subLP);
		
		menuThongKe = new menuItem("Thu & Chi", "hinh/menu/menu_ThongKe.png", fontMenu, color1);
		boxTotal.add(Box.createRigidArea(new Dimension(0,20)));
		
		
		// NVBH
		menuHoaDon = new menuItem("Hóa Đơn", "hinh/menu/menu_HoaDon.png", fontMenu, color1);
		subHDBH = new subMenuItem("Bán Hàng",  fontMenu, color1);
		subHDNH = new subMenuItem("Nhập Hàng",  fontMenu, color1);
		subTKTC = new subMenuItem("Thống Kê Thu & Chi",  fontMenu, color1);
		boxSubHoaDon = Box.createVerticalBox();
		boxSubHoaDon.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubHoaDon.add(subHDBH);
		boxSubHoaDon.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubHoaDon.add(subHDNH);
		if (type.equals("NVQL")) {
			boxSubHoaDon.add(Box.createRigidArea(new Dimension(0, 13)));
			boxSubHoaDon.add(subTKTC);
		}
		
		
		menuKhachHang = new menuItem("Khách Hàng", "hinh/menu/menu_KhachHang.png", fontMenu, color1);
		
		subQLKH = new subMenuItem("Quản Lí Khách Hàng",  fontMenu, color1);
		subTCKH = new subMenuItem("Thao Tác Khách Hàng",  fontMenu, color1);
		
		menuYKien = new menuItem("Ý Kiến Khách Hàng", "hinh/menu/menu_YKien.png", fontMenu, color1);
		menuTroGiup = new menuItem("Trợ Giúp", "hinh/menu/menu_TroGiup.png", fontMenu, color1);
		
		boxSubKhachHang = Box.createVerticalBox();
		boxSubKhachHang.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubKhachHang.add(subQLKH);
		boxSubKhachHang.add(Box.createRigidArea(new Dimension(0, 13)));
		boxSubKhachHang.add(subTCKH);
		if (type.equals("NVQL")) {
			boxSubKhachHang.add(Box.createRigidArea(new Dimension(0, 13)));
			boxSubKhachHang.add(subTKKH);
		}
		

		
		boxTotal.add(actor);
		boxTotal.add(boxMenu);
		
		boxMenu.add(boxMenuItem);
		listMenuItem = new ArrayList<menuItem>();

		menuDichVu.addMouseListener(this);
		menuNhanVien.addMouseListener(this);
		menuPhong.addMouseListener(this);
		menuThongKe.addMouseListener(this);
		menuKhachHang.addMouseListener(this);
		menuHoaDon.addMouseListener(this);
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
	
	public void LoadListMenuItem () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
		}
	}
	public void RemoveListMenuItem () {
		boxMenuItem.removeAll();
	}
	
	public void LoadListMenuSubDichVu () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
			if (x.equals(menuDichVu)) {
				boxMenuItem.add(boxSubDichVu);
			}
		}
	}
	public void LoadListMenuSubNhanVien () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
			if (x.equals(menuNhanVien)) {
				boxMenuItem.add(boxSubNhanVien);
			}
		}
	}
	public void LoadListMenuSubPhong () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
			if (x.equals(menuPhong)) {
				boxMenuItem.add(boxSubPhong);
			}
		}
	}
	public void LoadListMenuSubKhachHang () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
			if (x.equals(menuKhachHang)) {
				boxMenuItem.add(boxSubKhachHang);
			}
		}
	}
	public void LoadListMenuSubHoaDon () {
		for (menuItem x : listMenuItem) {
			boxMenuItem.add(Box.createRigidArea(new Dimension(0, 13)));
			boxMenuItem.add(x);
			if (x.equals(menuHoaDon)) {
				boxMenuItem.add(boxSubHoaDon);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(menuDichVu)) {
			if (indexSuv != 1) {
				indexSuv = 1;
				RemoveListMenuItem();
				LoadListMenuSubDichVu();
			} else{
				indexSuv = 0;
				RemoveListMenuItem();
				LoadListMenuItem();
			}
		}
		if (obj.equals(menuNhanVien)) {
			if (indexSuv != 2) {
				indexSuv = 2;
				RemoveListMenuItem();
				LoadListMenuSubNhanVien();
			} else{
				indexSuv = 0;
				RemoveListMenuItem();
				LoadListMenuItem();
			}
		}
		if (obj.equals(menuPhong)) {
			if (indexSuv != 3) {
				indexSuv = 3;
				RemoveListMenuItem();
				LoadListMenuSubPhong();
			} else{
				indexSuv = 0;
				RemoveListMenuItem();
				LoadListMenuItem();
			}
		}
		if (obj.equals(menuKhachHang)) {
			if (indexSuv != 4) {
				indexSuv = 4;
				RemoveListMenuItem();
				LoadListMenuSubKhachHang();
			} else{
				indexSuv = 0;
				RemoveListMenuItem();
				LoadListMenuItem();
			}
		}
		if (obj.equals(menuHoaDon)) {
			if (indexSuv != 5) {
				indexSuv = 5;
				RemoveListMenuItem();
				LoadListMenuSubHoaDon();
			} else{
				indexSuv = 0;
				RemoveListMenuItem();
				LoadListMenuItem();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
