package content.Phong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JPanel;

import content.NhanVien.trangCV;
import content.NhanVien.trangQLNV;
import content.NhanVien.trangTCNV;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuPage;

public class trangPhong extends JPanel {

	private Box totalBox;
	private Font fontBtn;
	private menuPage menuPage;
	private trangQLP trangQLP;
	private trangTCP trangTCP;
	private trangLP trangLP;
	private trangHoaDon trangHoaDon;

	public trangPhong (String color1, String color2, String type, trangHoaDon trangHoaDon) {
		this.trangHoaDon = trangHoaDon;
		fontBtn = new Font("Arial", 0 , 17);
		setBackground(Color.white);
		setPreferredSize(new Dimension(1050, 1080));
		totalBox = Box.createVerticalBox();
		Font fontMenu = new Font("Arial",0, 18);
		if (type == "Quan Li") {
			menuPage = new menuPage(color1, color2, "Quản Lí Phòng","hinh/menu/menu_QuanLi.png");
		} else if (type == "Tra Cuu") {
			menuPage = new menuPage(color1, color2, "Tra Cứu Phòng", "hinh/menu/menu_TraCuu.png");
		} else if (type == "Loai") {
			menuPage = new menuPage(color1, color2, "Quản Lí Loại Phòng", "hinh/menu/menu_LoaiDV.png");
		}
		add(menuPage);
		add(totalBox);
		
		trangQLP =new trangQLP();
		trangTCP = new trangTCP();
		trangLP = new trangLP();
		
		if (type == "Quan Li") {
			totalBox.removeAll();
			trangQLP.RenderUIQuanLi(totalBox, fontBtn, trangHoaDon);
		} else if (type == "Tra Cuu") {
			totalBox.removeAll();
			trangTCP.RenderUITraCuu(totalBox, fontBtn);
		} else if (type == "Loai") {
			totalBox.removeAll();
			trangLP.RenderUILoaiDichVu(totalBox, fontBtn);
		}
		
	}
}
