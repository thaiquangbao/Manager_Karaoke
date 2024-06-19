package content.form;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.buttonForm;


public class formKhachHang extends JPanel implements ActionListener{
	
	private JLabel title;
	public buttonForm btnThem;
	public buttonForm btnXoaTrang;
	public buttonForm btnDong;
	public buttonForm btnSua;
	public buttonForm btnTim;
    public JTextField txtMaKH;
    public JTextField txtTenKH;
    public JTextField txtDiaChiKH;
    public JTextField txtSDTKH;
	public formKhachHang (String type) {
		setLayout(new GridLayout(0,1));
		Font fontBtn = new Font("Arial", 0 , 17);
		Font fontLable = new Font("Arial", 0, 19);
		
		// Title
		if (type == "Them") {
			title = new JLabel("Thêm Khách Hàng");
			title.setIcon(new ImageIcon("hinh/button/btn_Them.png"));
		} else if (type == "Sua") {
			title = new JLabel("Cập Nhật Khách Hàng");
			title.setIcon(new ImageIcon("hinh/button/btn_Sua.png"));
		}
		
		title.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		title.setForeground(Color.white);
		title.setFont(new Font("Arial", 0, 28));
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(title);
		// Complete Title

		// Content
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		Box boxlblMaKH = Box.createHorizontalBox();
		lblMaKH.setFont(fontLable);
		lblMaKH.setForeground(Color.white);
		if (type == "Tim") {
			boxlblMaKH.add(Box.createRigidArea(new Dimension(20, 0)));
			boxlblMaKH.add (lblMaKH);
		}else {
			boxlblMaKH.add(Box.createRigidArea(new Dimension(100, 0)));
			boxlblMaKH.add (lblMaKH);
		}
		
		txtMaKH = new JTextField();
		txtMaKH.setPreferredSize(new Dimension(300, 30));
		txtMaKH.setSize(100, 40);
		txtMaKH.setBackground(null);
		txtMaKH.setOpaque(false);
		txtMaKH.setFont(fontLable);
		txtMaKH.setForeground(Color.white);
		txtMaKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		Box boxtxtMaKH = Box.createHorizontalBox();
		
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		Box boxlblTenKH = Box.createHorizontalBox();
		lblTenKH.setFont(fontLable);
		lblTenKH.setForeground(Color.white);
		if (type == "Tim") {
			boxlblTenKH.add(Box.createRigidArea(new Dimension(20, 0)));
			boxlblTenKH.add (lblTenKH);
		}else {
			boxlblTenKH.add(Box.createRigidArea(new Dimension(100, 0)));
			boxlblTenKH.add (lblTenKH);
		}
		txtTenKH = new JTextField();
		txtTenKH.setPreferredSize(new Dimension(100, 30));
		txtTenKH.setSize(100, 40);
		txtTenKH.setBackground(null);
		txtTenKH.setOpaque(false);
		txtTenKH.setFont(fontLable);
		txtTenKH.setForeground(Color.white);
		txtTenKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		Box boxtfTenKH = Box.createHorizontalBox();

		
		
		JLabel lblDiaChiKH = new JLabel("Địa Chỉ Khách Hàng");
		Box boxlblDiaChiKH = Box.createHorizontalBox();
		lblDiaChiKH.setFont(fontLable);
		lblDiaChiKH.setForeground(Color.white);
		if (type == "Tim") {
			boxlblDiaChiKH.add(Box.createRigidArea(new Dimension(20, 0)));
			boxlblDiaChiKH.add (lblDiaChiKH);
		}else {
			boxlblDiaChiKH.add(Box.createRigidArea(new Dimension(100, 0)));
			boxlblDiaChiKH.add (lblDiaChiKH);
		}
		txtDiaChiKH = new JTextField(50);
		txtDiaChiKH.setPreferredSize(new Dimension(400, 30));
		txtDiaChiKH.setSize(100, 40);
		txtDiaChiKH.setBackground(null);
		txtDiaChiKH.setOpaque(false);
		txtDiaChiKH.setFont(fontLable);
		txtDiaChiKH.setForeground(Color.white);
		txtDiaChiKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		Box boxtxtDiaChiKH = Box.createHorizontalBox();
		

		JLabel lblSDTKH = new JLabel("Số Điện Thoại");
		Box boxlblSDTKH = Box.createHorizontalBox();
		lblSDTKH.setFont(fontLable);
		lblSDTKH.setForeground(Color.white);
		if (type == "Tim") {
			boxlblSDTKH.add(Box.createRigidArea(new Dimension(20, 0)));
			boxlblSDTKH.add (lblSDTKH);
		}else {
			boxlblSDTKH.add(Box.createRigidArea(new Dimension(100, 0)));
			boxlblSDTKH.add (lblSDTKH);
		}
		txtSDTKH = new JTextField();
		txtSDTKH.setPreferredSize(new Dimension(300, 30));
		txtSDTKH.setSize(100, 40);
		txtSDTKH.setBackground(null);
		txtSDTKH.setOpaque(false);
		txtSDTKH.setFont(fontLable);
		txtSDTKH.setForeground(Color.white);
		txtSDTKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		Box boxtxtSDTKH = Box.createHorizontalBox();



		
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(boxlblMaKH);
		add(boxtxtMaKH);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(boxlblTenKH);
		add(boxtfTenKH);	
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(boxlblDiaChiKH);
		add(boxtxtDiaChiKH);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(boxlblSDTKH);
		add(boxtxtSDTKH);
		
		
		String color3 = "#232526", color4 = "#414345";
		btnThem = new buttonForm("Thêm ", fontBtn, "", color3, color4);
		btnXoaTrang = new buttonForm("Xóa Trắng ", fontBtn, "", color3, color4);
		btnDong = new buttonForm("Đóng ", fontBtn, "", color3, color4);
		btnSua = new buttonForm("Sửa ", fontBtn, "", color3, color4);
		btnTim = new buttonForm("Tìm ", fontBtn, "", color3, color4);
		Box boxBtn = Box.createHorizontalBox();

//		if (type == "Them") {
//			boxBtn.add(Box.createRigidArea(new Dimension(205, 0)));
//			boxBtn.add(btnThem);
//			boxtxtMaKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtMaKH.add (txtMaKH);
//			boxtxtMaKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtfTenKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtfTenKH.add (tfTenKH);
//			boxtfTenKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtDiaChiKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtDiaChiKH.add (txtDiaChiKH);
//			boxtxtDiaChiKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtSDTKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtSDTKH.add (txtSDTKH);
//			boxtxtSDTKH.add(Box.createRigidArea(new Dimension(100, 0)));
//		} else if (type == "Sua") {
//			boxBtn.add(Box.createRigidArea(new Dimension(205, 0)));
//			boxBtn.add(btnSua);
//			boxtxtMaKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtMaKH.add (txtMaKH);
//			boxtxtMaKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtfTenKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtfTenKH.add (tfTenKH);
//			boxtfTenKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtDiaChiKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtDiaChiKH.add (txtDiaChiKH);
//			boxtxtDiaChiKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtSDTKH.add(Box.createRigidArea(new Dimension(100, 0)));
//			boxtxtSDTKH.add (txtSDTKH);
//			boxtxtSDTKH.add(Box.createRigidArea(new Dimension(100, 0)));
//		}
		
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnXoaTrang);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnDong);
		
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(boxBtn);
		add(Box.createRigidArea(new Dimension(0, 10)));
		// Complete Content
		btnXoaTrang.addActionListener(this);
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#fc00ff"), w, h, Color.decode("#00dbde"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnXoaTrang)) {
			XoaTrang();
		}
	}
	public void XoaTrang () {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtDiaChiKH.setText("");
		txtSDTKH.setText("");
	}


}
