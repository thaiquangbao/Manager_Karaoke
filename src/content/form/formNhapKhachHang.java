package content.form;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.customButton;

public class formNhapKhachHang extends JPanel {

	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnTim;
	public customButton btnTaiTrang;
    public JTextField tfTenKH;
    public JTextField tfMaKH;
    public JTextField tfDiaChiKH;
    public JTextField tfSGKH;
    public JTextField tfSDTKH;
	public customButton btnXoaTrang;
	public customButton btnDatPhong;
	public formNhapKhachHang (String type) {
		Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
		setPreferredSize(new Dimension(300, 260));
		setLayout(getLayout());
		Box boxTotal = Box.createVerticalBox();
		add(boxTotal);
		Box boxText = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 20)));
		boxTotal.add(boxText);
		Box boxBtn = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 40)));
		boxTotal.add(boxBtn);
		Box boxText1 = Box.createVerticalBox();
		Box boxText1_1 = Box.createHorizontalBox();
		Box boxText1_2 = Box.createHorizontalBox();
		Box boxText1_3 = Box.createHorizontalBox();
		Box boxText2 = Box.createVerticalBox();
		Box boxText2_1 = Box.createHorizontalBox();
		Box boxText2_2 = Box.createHorizontalBox();
		Box boxText2_3 = Box.createHorizontalBox();
		boxText.add(boxText1);
		boxText.add(Box.createRigidArea(new Dimension(60, 0)));
		boxText.add(boxText2);
		boxText1.add(boxText1_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_3);
		boxText2.add(boxText2_1);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_2);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_3);

		tfMaKH = new JTextField();
		tfMaKH.setPreferredSize(new Dimension(300, 30));
		tfMaKH.setSize(100, 40);
		tfMaKH.setBackground(null);
		tfMaKH.setOpaque(false);
		tfMaKH.setFont(fontLable);
		tfMaKH.setForeground(Color.white);
		tfMaKH.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		tfMaKH.setEnabled(false);
		tfMaKH.setText("Hệ Thống Tự Động Thêm");
		JLabel lblMaKH = new JLabel("Mã Khách Hàng : ");
		lblMaKH.setFont(fontLable);
		lblMaKH.setForeground(Color.white);
		lblMaKH.setPreferredSize(new Dimension(180, 35));
		boxText1_1.add(lblMaKH);
		boxText1_1.add(tfMaKH);

		tfTenKH = new JTextField();
		tfTenKH.setPreferredSize(new Dimension(300, 30));
		tfTenKH.setSize(100, 40);
		tfTenKH.setBackground(null);
		tfTenKH.setOpaque(false);
		tfTenKH.setFont(fontLable);
		tfTenKH.setForeground(Color.white);
		tfTenKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenKH = new JLabel("Tên Khách Hàng : ");
		lblTenKH.setFont(fontLable);
		lblTenKH.setForeground(Color.white);
		lblTenKH.setPreferredSize(new Dimension(180, 35));
		boxText1_2.add(lblTenKH);
		boxText1_2.add(tfTenKH);

		tfDiaChiKH = new JTextField();
		tfDiaChiKH.setPreferredSize(new Dimension(300, 30));
		tfDiaChiKH.setSize(100, 40);
		tfDiaChiKH.setBackground(null);
		tfDiaChiKH.setOpaque(false);
		tfDiaChiKH.setFont(fontLable);
		tfDiaChiKH.setForeground(Color.white);
		tfDiaChiKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChiKH = new JLabel("Địa Chỉ : ");
		lblDiaChiKH.setFont(fontLable);
		lblDiaChiKH.setForeground(Color.white);
		lblDiaChiKH.setPreferredSize(new Dimension(180, 35));
		boxText2_1.add(lblDiaChiKH);
		boxText2_1.add(tfDiaChiKH);

		tfSDTKH = new JTextField();
		tfSDTKH.setPreferredSize(new Dimension(300, 30));
		tfSDTKH.setSize(100, 40);
		tfSDTKH.setBackground(null);
		tfSDTKH.setOpaque(false); 
		tfSDTKH.setFont(fontLable);
		tfSDTKH.setForeground(Color.white);
		tfSDTKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDTKH = new JLabel("Số Điện Thoại : ");
		lblSDTKH.setFont(fontLable);
		lblSDTKH.setForeground(Color.white);
		lblSDTKH.setPreferredSize(new Dimension(180, 35));
		boxText2_2.add(lblSDTKH);
		boxText2_2.add(tfSDTKH);


		boxText2_3.add(Box.createRigidArea(new Dimension(0, 10)));
		boxText1_3.add(Box.createRigidArea(new Dimension(0, 10)));


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm Khách Hàng",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa Khách Hàng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa Khách Hàng",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("Xóa Trắng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh Sách",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTim = new customButton("Tìm Khách Hàng",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);
		btnDatPhong = new customButton("Thao Tác Hóa Đơn",fontBtn,"hinh/button/btn_ThaoTac.png" , 
				color3, color4);
		
		
		if (type.equals("QLKH")) {
			boxBtn.add(btnThem);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoa);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnSua);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoaTrang);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnIn); 
		} else {
			boxBtn.add(btnTim);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnTaiTrang);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnDatPhong);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoaTrang);
		}
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#5B86E5"), w, h, Color.decode("#FC466B"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
