package content.ThongKe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JPanel;

import content.Phong.trangLP;
import content.Phong.trangQLP;
import content.Phong.trangTCP;
import content.menuPage.menuPage;

public class trangThongKe extends JPanel {
	private Font fontBtn;
	private Box totalBox;
	private menuPage menuPage;
	private trangTKHD trangTKHD;
	private trangTKKH trangTKKH;
	private trangTKNV trangTKNV;

	public trangThongKe (String color1, String color2, String type) {
		fontBtn = new Font("Arial", 0 , 17);
		setBackground(Color.white);
		setPreferredSize(new Dimension(1050, 1080));
		totalBox = Box.createVerticalBox();
		Font fontMenu = new Font("Arial",0, 18);
		if (type == "Hoa Don") {
			menuPage = new menuPage(color1, color2, "Thống Kê Thu & Chi","hinh/menu/menu_QuanLi.png");
		} else if (type == "Khach Hang") {
			menuPage = new menuPage(color1, color2, "Thống Kê Khách Hàng", "hinh/menu/menu_TraCuu.png");
		} else if (type == "Nhan Vien") {
			menuPage = new menuPage(color1, color2, "Thống Kê Nhân Viên", "hinh/menu/menu_LoaiDV.png");
		} 
		add(menuPage);
		add(totalBox);
		
		trangTKHD =new trangTKHD();
		trangTKKH = new trangTKKH();
		trangTKNV = new trangTKNV();
		
		if (type == "Hoa Don") {
			totalBox.removeAll();
			trangTKHD.RenderUITKHD(totalBox);
		} 
		else if (type == "Khach Hang") {
			totalBox.removeAll();
			trangTKKH.RenderUITKHD(totalBox);
		} 
		else if (type == "Nhan Vien") {
			totalBox.removeAll();
			trangTKNV.RenderUITKHD(totalBox);
		}
		
	}
}
