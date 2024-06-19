package content.KhachHang;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import content.customButton;
import content.table;
import content.NhanVien.trangQLNV;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuItem;

public class trangKhachHang extends JPanel {
	public content.menuPage.menuPage menuPage;
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
	private content.KhachHang.trangQLKH trangQLKH;
	private trangTCKH trangTCKH;
	
	public trangKhachHang (String color1, String color2, String type, Box box, trangHoaDon trangHoaDon) {
		fontBtn = new Font("Arial", 0 , 17);
		setBackground(Color.white);
		setPreferredSize(new Dimension(1050, 1080));
		totalBox = Box.createVerticalBox();
		Font fontMenu = new Font("Arial",0, 18);

		menuPage = new content.menuPage.menuPage(color1, color2, "Quản Lí Khách Hàng","hinh/menu/menu_QuanLi.png");
		add(menuPage);
		add(totalBox);
		
		trangQLKH = new trangQLKH(); 
		trangTCKH = new trangTCKH();
		if (type.equals("QLKH")) {
			totalBox.removeAll();
			trangQLKH.RenderUIQuanLi(totalBox, fontBtn, trangHoaDon);
		} else {
			totalBox.removeAll();
			trangTCKH.RenderUITraCuu(totalBox, fontBtn, box, trangHoaDon);
		}
		
		
	}

}
