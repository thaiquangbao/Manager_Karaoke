package content.DatPhong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JPanel;

import content.table;
import content.customButton;

public class panelDatPhong extends JPanel {
   

    public table table;   
    public Box box;
    public buttonTotal btnXoa;
    public JPanel boxButton1;
    public buttonTotal btnDatPhong;
	public buttonTotal btnXoaTrang;
	public buttonTotal btnSuaDatPhong;
	public titleDatPhong title;
    public titleDatPhong getTitle() {
        return title;
    }

    public void setTitle(titleDatPhong title) {
        this.title = title;
    }
    public buttonTotal getBtnDatPhong() {
		return btnDatPhong;
	}

	public void setBtnDatPhong(buttonTotal btnDatPhong) {
		this.btnDatPhong = btnDatPhong;
	}

	public buttonTotal getBtnXoa() {
		return btnXoa;
	}

	public void setBtnXoa(buttonTotal btnXoa) {
		this.btnXoa = btnXoa;
	}

	

	public buttonTotal getBtnXoaTrang() {
		return btnXoaTrang;
	}

	public void setBtnXoaTrang(buttonTotal btnXoaTrang) {
		this.btnXoaTrang = btnXoaTrang;
	}

	public buttonTotal getBtnSuaDatPhong() {
		return btnSuaDatPhong;
	}

	public void setBtnSuaDatPhong(buttonTotal btnSuaDatPhong) {
		this.btnSuaDatPhong = btnSuaDatPhong;
	}

	public panelDatPhong () {
        Font fontBtn = new Font("Arial", 0 , 17);
        String color3 = "#6dd5ed", color4 = "#2193b0";
        setPreferredSize(new Dimension(650, 750));
        setBackground(Color.white);
        title = new titleDatPhong("", "", "", "", "", "");
        box  = Box.createHorizontalBox();
        box.add(title);
        add(box);
        add(Box.createRigidArea(new Dimension(0, 20)));

        String[] header = {"Tên Khách Hàng", "Số Điện Thoại","Địa Chỉ", "Giờ Đặt","Phòng Đặt"} ;
		table = new table(header);
		table.setPreferredSize(new Dimension(660, 350));
		add(table);
        add(Box.createRigidArea(new Dimension(0, 20)));

        boxButton1 = new JPanel();
        boxButton1.setBackground(null);
        add (boxButton1);

        btnDatPhong = new buttonTotal(" Đặt Phòng", "hinh/button/btn_LapHoaDon.png");
        btnDatPhong.setPreferredSize(new Dimension(140, 90));   
        btnSuaDatPhong = new buttonTotal(" Sửa Đặt Phòng", "hinh/button/btn_Sua.png");
        btnSuaDatPhong.setPreferredSize(new Dimension(140, 90));
        btnXoa = new buttonTotal(" Xóa Đặt Phòng", "hinh/button/btn_Xoa.png");
        btnXoa.setPreferredSize(new Dimension(140, 90));
        btnXoaTrang = new buttonTotal(" Xóa trắng", "hinh/button/btn_Them.png");
        btnXoaTrang.setPreferredSize(new Dimension(140, 90));
     
        
        boxButton1.add(btnDatPhong);
        boxButton1.add(btnSuaDatPhong);
        boxButton1.add(btnXoa);
        boxButton1.add(btnXoaTrang);
        
       
    }
}
