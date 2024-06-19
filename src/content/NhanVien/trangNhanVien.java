package content.NhanVien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import content.customButton;
import content.table;
import content.DichVu.trangLDV;
import content.DichVu.trangNCC;
import content.DichVu.trangQLDV;
import content.DichVu.trangTCDV;
import content.menuPage.menuItem;
import content.menuPage.menuPage;

public class trangNhanVien extends JPanel {
	public menuPage menuPage;
	private DefaultTableModel model;

	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private menuItem subMenuQLDV;
	private menuItem subMenuTCDV;
	private menuItem subMenuLDV;
	private menuItem subMenuNCC;
	private Box totalBox;
	private Font fontBtn;
	private customButton btnTim;
	private customButton btnTaiTrang;
	private trangQLDV trangQLDV;
	private trangTCDV trangTCDV;
	private trangLDV trangLDV;
	private trangNCC trangNCC;
	private trangCV trangCV;
	private trangTCNV trangTCNV;
	private trangQLNV trangQLNV;
	
	public trangNhanVien (String color1, String color2, String type) {
		fontBtn = new Font("Arial", 0 , 17);
		setBackground(Color.white);
		setPreferredSize(new Dimension(1050, 1080));
		totalBox = Box.createVerticalBox();
		Font fontMenu = new Font("Arial",0, 18);
		if (type == "Quan Li") {
			menuPage = new menuPage(color1, color2, "Quản Lí Nhân Viên","hinh/menu/menu_QuanLi.png");
		} else if (type == "Tra Cuu") {
			menuPage = new menuPage(color1, color2, "Tra Cứu Nhân Viên", "hinh/menu/menu_TraCuu.png");
		} else if (type == "Loai") {
			menuPage = new menuPage(color1, color2, "Chức Vụ Nhân Viên", "hinh/menu/menu_LoaiDV.png");
		}
		add(menuPage);
		add(totalBox);
		
		trangQLNV =new trangQLNV();
		trangTCNV = new trangTCNV();
		trangCV = new trangCV();
		
		if (type == "Quan Li") {
			totalBox.removeAll();
			trangQLNV.RenderUIQuanLi(totalBox, fontBtn);
		} else if (type == "Tra Cuu") {
			totalBox.removeAll();
			trangTCNV.RenderUITraCuu(totalBox, fontBtn);
		} else if (type == "Loai") {
			totalBox.removeAll();
			trangCV.RenderUILoaiDichVu(totalBox, fontBtn);
		}
		
	}

}