package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import content.customButton;
import content.table;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuItem;
import content.menuPage.menuPage;
import dao.DichVu_Dao;
import entity.DichVu;
import entity.LoaiDichVu;

public class trangDichVu extends JPanel {
	public menuPage menuPage;
	private DefaultTableModel model;

	private table pane;
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
	public JFrame frame;
   
	
	public trangDichVu (String color1, String color2, String type,trangHoaDon trangHoaDon, String nameEmploy) {
		fontBtn = new Font("Arial", 0 , 17);
		setBackground(Color.white);
		setPreferredSize(new Dimension(1050, 1080));
		totalBox = Box.createVerticalBox();
		Font fontMenu = new Font("Arial",0, 18);
		if (type == "Quan Li") {
			menuPage = new menuPage(color1, color2, "Quản Lí Dịch Vụ","hinh/menu/menu_QuanLi.png");
		} else if (type == "Tra Cuu") {
			menuPage = new menuPage(color1, color2, "Tra Cứu Dịch Vụ", "hinh/menu/menu_TraCuu.png");
		} else if (type == "Loai") {
			menuPage = new menuPage(color1, color2, "Loại Dịch Vụ", "hinh/menu/menu_LoaiDV.png");
		} else if (type == "Nha Cung Cap") {
			menuPage = new menuPage(color1, color2, "Nhà Cung Cấp", "hinh/menu/menu_NCC.png");
		}
		add(menuPage); 
		add(totalBox);
		
		trangQLDV = new trangQLDV();
		trangTCDV = new trangTCDV();
		trangLDV = new trangLDV();
		trangNCC = new trangNCC();
		 
		if (type == "Quan Li") {
			totalBox.removeAll();
			trangQLDV.RenderUIQuanLi(totalBox, fontBtn, color1, color2,trangHoaDon, frame, nameEmploy);
		} else if (type == "Tra Cuu") {
			totalBox.removeAll();
			trangTCDV.RenderUITraCuu(totalBox, fontBtn);
		} else if (type == "Loai") {
			totalBox.removeAll();
			trangLDV.RenderUILoaiDichVu(totalBox, fontBtn);
		} else if (type == "Nha Cung Cap") {
			totalBox.removeAll();
			trangNCC.RenderUINhaCungCap(totalBox, fontBtn);
		}
		
	}
	
}

