package UI;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.IllegalComponentStateException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import NhapHang.trangNhapHang;
import UI.menu.menu;
import UI.menu.menuItem;
import connect.ConnectDB;
import content.trang;
import content.trangKhongMenu;
import content.TongQuan.trangTongQuan;
import content.hoa_don.buttonListPhong;
import content.hoa_don.panelInHoaDon;
import content.hoa_don.trangHoaDon;
import dao.NhaCungCap_DAO;
import entity.KhachHang;
import content.DichVu.trangDichVu;
import content.DichVu.trangNCC;
import content.KhachHang.trangKhachHang;
import content.NhanVien.trangNhanVien;
import content.Phong.trangPhong;
import content.ThongKe.trangThongKe;

public class main extends JFrame implements MouseListener{
	private menu menu;
	private trangKhongMenu trangTongQuan; 
	private Box boxTotal;
	private Box boxTotal1;
	private buttonTitle BtnMinimax;
	private buttonTitle BtnExit;
	private trangDichVu trangDichVu;
	private trangNhanVien trangNhanVien;
	private trangPhong trangPhong;
	private trangThongKe trangThongKe;
	private content.ThongKe.trangThongKe trangYKien;
	private String type;
	private trangKhachHang trangKhachHang;
	private trangHoaDon trangHoaDon;
	private String color1;
	private String color2;
	private trangNCC trangNCC;
	private KhachHang KhachHang;
	private String MANHANVIEN = "NV_001";
	private trangNhapHang trangNhapHang;
	private formDangNhap formDangNhap;
	private String nameEmploy;

	public main (String type, String nameEmploy, String phoneEmploy) throws IOException{
		super("KARAOKE NICE");
		this.nameEmploy = nameEmploy;
		this.type = type;
		setSize(1550,870);
		setLocationRelativeTo(null);
		boxTotal = Box.createHorizontalBox();
		boxTotal1 = Box.createVerticalBox();
		///TUANANH    DAO
		try {
            ConnectDB.getInstance().connect();
        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace(); 
        }
		//DAO

		
		
		trangHoaDon = new trangHoaDon(MANHANVIEN);
		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(26, 25, 25));
		titleBar.setPreferredSize(new Dimension(1550, 45));
		BtnMinimax = new buttonTitle("","hinh/button/btn_ThuNho.png");
		BtnExit = new buttonTitle("X");
		JLabel title = new JLabel("KARAOKE NICE");
		title.setFont(new Font("Arial", 0, 23));
		title.setForeground(Color.white);
		titleBar.add(title);
		titleBar.add(new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                     "));
		titleBar.add(BtnMinimax);
		titleBar.add(BtnExit);
		boxTotal1.add(titleBar);
		BtnMinimax.addMouseListener(this);
		BtnExit.addMouseListener(this);
		setUndecorated(true);
		
		add(boxTotal1);
		boxTotal1.add(boxTotal);
		color1 = "#12c2e9";
		color2 = "#c471ed";
		
		formDangNhap = new formDangNhap();
		
		menu = new menu(color1, color2, type, nameEmploy , phoneEmploy);
		menu.actor.btnDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean isHaveOrder = false;
				for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
					if (x.label.getText().equals(x.name + " (Sử Dụng)")) {
						isHaveOrder = true;
						break;
					}
				}
				if (isHaveOrder == true) {
					int a = JOptionPane.showConfirmDialog(null, "Vẫn Còn Phòng Đang Sử Dụng, Bạn Vẫn Muốn Đăng Xuất ?");
					if ( a == JOptionPane.YES_OPTION) {
						setVisible(false);
						formDangNhap.setVisible(true);
					}
				} else {
					int b = JOptionPane.showConfirmDialog(null, "Bạn Muốn Đăng Xuất ?");
					if (b == JOptionPane.YES_OPTION) {
						setVisible(false);
						formDangNhap.setVisible(true);
					}
				}
				
			}
		});
		
		
		if (type.equals("NVQL")) {

			menu.listMenuItem.add(menu.menuTongQuan);
			menu.listMenuItem.add(menu.menuDichVu);
			menu.listMenuItem.add(menu.menuPhong);
			menu.listMenuItem.add(menu.menuNhanVien);
			menu.listMenuItem.add(menu.menuKhachHang);
			menu.listMenuItem.add(menu.menuHoaDon);
			menu.LoadListMenuItem();
			boxTotal.add(menu);
			trangTongQuan = new trangTongQuan(trangHoaDon);
			boxTotal.add(trangTongQuan);
		} else if (type.equals("NVBH")) {

			menu.listMenuItem.add(menu.menuHoaDon);
			menu.listMenuItem.add(menu.menuKhachHang);
			menu.listMenuItem.add(menu.menuTroGiup);
			menu.LoadListMenuItem();
			
			boxTotal.add(menu);
			
			boxTotal.add(trangHoaDon);
			trangHoaDon.panelHoaDon1.type1 = "hoadon";
			trangHoaDon.type1 = "hoadon";
			trangHoaDon.kh = null;
			trangHoaDon.panelHoaDon1.setButton();
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		addEvent();
		menu.subQLDV.addMouseListener(this);
		menu.subTCDV.addMouseListener(this);
		menu.subLDV.addMouseListener(this);
		menu.subNCC.addMouseListener(this);
		menu.subQLNV.addMouseListener(this);
		menu.subTCNV.addMouseListener(this);
		menu.subCV.addMouseListener(this);
		menu.subQLP.addMouseListener(this);
		menu.subTCP.addMouseListener(this);
		menu.subLP.addMouseListener(this);
		menu.subTKHD.addMouseListener(this);
		menu.subTKKH.addMouseListener(this);
		menu.subTKNV.addMouseListener(this);
		menu.menuKhachHang.addMouseListener(this);
		menu.menuNhanVienBanHang.addMouseListener(this);
		menu.menuHoaDon.addMouseListener(this);
		menu.subQLKH.addMouseListener(this);
		menu.subTCKH.addMouseListener(this);
		menu.subHDBH.addMouseListener(this);
		menu.subHDNH.addMouseListener(this);
		menu.subTKTC.addMouseListener(this);
		menu.subHDNH.addMouseListener(this);
		
	}
	public void addEvent () {
		for (menuItem x : menu.listMenuItem) {
			x.addMouseListener(this);
		}
	} 
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj.equals(menu.menuTongQuan)) {
			boxTotal.remove(1);
			trangTongQuan = new trangTongQuan(trangHoaDon);
			boxTotal.add(trangTongQuan);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.menuDichVu)) {
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subQLDV)) {

			boxTotal.remove(1);
			trangDichVu = new trangDichVu("#5B86E5", "#FC466B", "Quan Li", trangHoaDon,nameEmploy);
			trangDichVu.frame = this;
			boxTotal.add(trangDichVu);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTCDV)) {
			boxTotal.remove(1);
			trangDichVu = new trangDichVu("#5B86E5", "#FC466B", "Tra Cuu", trangHoaDon,nameEmploy);
			boxTotal.add(trangDichVu);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subLDV)) {
			boxTotal.remove(1);
			trangDichVu = new trangDichVu("#5B86E5", "#FC466B", "Loai", trangHoaDon,nameEmploy);
			boxTotal.add(trangDichVu);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subNCC)) {
			boxTotal.remove(1);
			trangDichVu = new trangDichVu("#5B86E5", "#FC466B", "Nha Cung Cap", trangHoaDon,nameEmploy);
			boxTotal.add(trangDichVu);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.menuNhanVien)) {
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		
		
		if(obj.equals(menu.subQLNV)) {
			boxTotal.remove(1);
			trangNhanVien = new trangNhanVien("#5B86E5", "#FC466B", "Quan Li");
			boxTotal.add(trangNhanVien);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTCNV)) {
			boxTotal.remove(1);
			trangNhanVien = new trangNhanVien("#5B86E5", "#FC466B", "Tra Cuu");
			boxTotal.add(trangNhanVien);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subCV)) {
			boxTotal.remove(1);
			trangNhanVien = new trangNhanVien("#5B86E5", "#FC466B", "Loai");
			boxTotal.add(trangNhanVien);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		
		
		
		if(obj.equals(menu.menuPhong)) {
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		
		
		if(obj.equals(menu.subQLP)) {
			boxTotal.remove(1);
			trangPhong = new trangPhong("#5B86E5", "#FC466B", "Quan Li", trangHoaDon);
			boxTotal.add(trangPhong);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTCP)) {
			boxTotal.remove(1);
			trangPhong = new trangPhong("#5B86E5", "#FC466B", "Tra Cuu", trangHoaDon);
			boxTotal.add(trangPhong);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subLP)) {
			boxTotal.remove(1);
			trangPhong = new trangPhong("#5B86E5", "#FC466B", "Loai", trangHoaDon);
			boxTotal.add(trangPhong);
        	boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTKKH)) {
			boxTotal.remove(1);
			trangThongKe = new trangThongKe("#5B86E5", "#FC466B", "Khach Hang");
			boxTotal.add(trangThongKe);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTKNV)) {
			boxTotal.remove(1);
			trangThongKe = new trangThongKe("#5B86E5", "#FC466B", "Nhan Vien");
			boxTotal.add(trangThongKe);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.menuKhachHang)) {
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.subQLKH)) {
			boxTotal.remove(1);
			trangKhachHang = new trangKhachHang("#5B86E5", "#FC466B", "QLKH", boxTotal, trangHoaDon);
			boxTotal.add(trangKhachHang);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.subTCKH)) {
			boxTotal.remove(1);
			trangKhachHang = new trangKhachHang("#5B86E5", "#FC466B", "TCKH", boxTotal, trangHoaDon);
			boxTotal.add(trangKhachHang);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.menuYKien)) {
		}
		if (obj.equals(BtnMinimax)) {
			setExtendedState(JFrame.ICONIFIED);
		}
		if (obj.equals(BtnExit)) {
			setVisible(false);
		}
		if (obj.equals(menu.menuNhanVienBanHang)) {
			boxTotal.removeAll();
			menu.RemoveListMenuItem();
			menu.listMenuItem.removeAll(menu.listMenuItem);
			menu.listMenuItem.add(menu.menuHoaDon);
			menu.listMenuItem.add(menu.menuKhachHang);
			menu.listMenuItem.add(menu.menuYKien);
			menu.listMenuItem.add(menu.menuTroGiup);
			menu.LoadListMenuItem();
			KhachHang = new KhachHang();
			boxTotal.add(menu);
			trangHoaDon = new trangHoaDon(MANHANVIEN);
			boxTotal.add(trangHoaDon);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.menuHoaDon)) {
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.subHDBH)) {
			boxTotal.remove(1); 
			boxTotal.add(trangHoaDon);
			trangHoaDon.panelHoaDon1.type1 = "hoadon";
			trangHoaDon.type1 = "hoadon";
			trangHoaDon.kh = null;
			trangHoaDon.panelHoaDon1.setButton();
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if(obj.equals(menu.subTKTC)) {
			boxTotal.remove(1);
			trangThongKe = new trangThongKe("#5B86E5", "#FC466B", "Hoa Don");
			boxTotal.add(trangThongKe);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
		}
		if (obj.equals(menu.subHDNH)) {
			boxTotal.remove(1); 
			trangNhapHang = new trangNhapHang(boxTotal, trangHoaDon);
			boxTotal.add(trangNhapHang);
			boxTotal.invalidate();
        	boxTotal.validate();
        	boxTotal.repaint();
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
		Object obj = e.getSource();
		//	((JComponent) obj).setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		((JComponent) obj).setForeground(new Color(98, 94, 94));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		//	((JComponent) obj).setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		((JComponent) obj).setForeground(Color.white);
	}

}
