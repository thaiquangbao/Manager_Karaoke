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

public class formNhapNhaCungCap extends JPanel {

	public JTextField txtMaNCC;
	public JTextField txtTenNCC;
	public JTextField txtGiaNCC;
	public JTextField txtDiaChiNCC;
	public customComBoBox cboLoaiNCC;
	public customComBoBox cboNCC;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public JTextField  txtSDTNCC;
	public customButton btnXoaTrang;
	public formNhapNhaCungCap () {
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

		txtMaNCC = new JTextField();
		txtMaNCC.setPreferredSize(new Dimension(300, 30));
		txtMaNCC.setSize(150, 40);
		txtMaNCC.setBackground(null);
		txtMaNCC.setOpaque(false);
		txtMaNCC.setFont(fontLable);
		txtMaNCC.setForeground(Color.white);
		txtMaNCC.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		txtMaNCC.setEnabled(false);
		txtMaNCC.setText("Hệ Thống Tự Động Thêm");
		JLabel lblMaNCC = new JLabel("Mã NCC : ");
		lblMaNCC.setFont(fontLable);
		lblMaNCC.setForeground(Color.white);
		lblMaNCC.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaNCC);
		boxText1_1.add(txtMaNCC);

		txtTenNCC = new JTextField();
		txtTenNCC.setPreferredSize(new Dimension(300, 30));
		txtTenNCC.setSize(150, 40);
		txtTenNCC.setBackground(null);
		txtTenNCC.setOpaque(false);
		txtTenNCC.setFont(fontLable);
		txtTenNCC.setForeground(Color.white);
		txtTenNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenNCC = new JLabel("Tên NCC : ");
		lblTenNCC.setFont(fontLable);
		lblTenNCC.setForeground(Color.white);
		lblTenNCC.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenNCC);
		boxText1_2.add(txtTenNCC);

		txtDiaChiNCC = new JTextField();
		txtDiaChiNCC.setPreferredSize(new Dimension(300, 30));
		txtDiaChiNCC.setSize(150, 40);
		txtDiaChiNCC.setBackground(null);
		txtDiaChiNCC.setOpaque(false);
		txtDiaChiNCC.setFont(fontLable);
		txtDiaChiNCC.setForeground(Color.white);
		txtDiaChiNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChiNCC = new JLabel("Địa Chỉ : ");
		lblDiaChiNCC.setFont(fontLable);
		lblDiaChiNCC.setForeground(Color.white);
		lblDiaChiNCC.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblDiaChiNCC);
		boxText2_1.add(txtDiaChiNCC);

        txtSDTNCC = new JTextField();
		txtSDTNCC.setPreferredSize(new Dimension(300, 30));
		txtSDTNCC.setSize(150, 40);
		txtSDTNCC.setBackground(null);
		txtSDTNCC.setOpaque(false);
		txtSDTNCC.setFont(fontLable);
		txtSDTNCC.setForeground(Color.white);
		txtSDTNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDTNCC = new JLabel("Số Điện Thoại : ");
		lblSDTNCC.setFont(fontLable);
		lblSDTNCC.setForeground(Color.white);
		lblSDTNCC.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblSDTNCC);
		boxText2_2.add(txtSDTNCC);



		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm NCC",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa NCC",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa NCC",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("Xóa Trắng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh Sách",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);

		boxBtn.add(btnThem);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnXoa);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnSua);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnXoaTrang);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnIn);
		
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
