package content.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.customButton;

public class formNhapChucVu extends JPanel{
	public JTextField tfMaCV;
	public  JTextField tfTenCV;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public JTextField tfMoTaCV;
	public Object btnDong;
	public customButton btnXoaTrang;
	public formNhapChucVu() {
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

		tfMaCV = new JTextField();
		tfMaCV.setPreferredSize(new Dimension(300, 30));
		tfMaCV.setSize(100, 40);
		tfMaCV.setBackground(null);
		tfMaCV.setOpaque(false);
		tfMaCV.setFont(fontLable);
		tfMaCV.setForeground(Color.white);
		tfMaCV.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
        tfMaCV.setEnabled(false);
        tfMaCV.setText("Hệ Thống Tự Động Thêm");
		JLabel lblMaCV = new JLabel("Mã Chức Vụ : ");
		lblMaCV.setFont(fontLable);
		lblMaCV.setForeground(Color.white);
		lblMaCV.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaCV);
		boxText1_1.add(tfMaCV);

		tfTenCV = new JTextField();
		tfTenCV.setPreferredSize(new Dimension(300, 30));
		tfTenCV.setSize(100, 40);
		tfTenCV.setBackground(null);
		tfTenCV.setOpaque(false);
		tfTenCV.setFont(fontLable);
		tfTenCV.setForeground(Color.white);
		tfTenCV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenCV = new JLabel("Tên Chức Vụ : ");
		lblTenCV.setFont(fontLable);
		lblTenCV.setForeground(Color.white);
		lblTenCV.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenCV);
		boxText1_2.add(tfTenCV);

		tfMoTaCV = new JTextField();
		tfMoTaCV.setPreferredSize(new Dimension(300, 30));
		tfMoTaCV.setSize(100, 40);
		tfMoTaCV.setBackground(null);
		tfMoTaCV.setOpaque(false);
		tfMoTaCV.setFont(fontLable);
		tfMoTaCV.setForeground(Color.white);
		tfMoTaCV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMoTaCV = new JLabel("Mô Tả : ");
		lblMoTaCV.setFont(fontLable);
		lblMoTaCV.setForeground(Color.white);
		lblMoTaCV.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblMoTaCV);
		boxText2_1.add(tfMoTaCV);

        boxText2_2.add(Box.createRigidArea(new Dimension(0, 35)));



		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm Chức Vụ",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa Chức Vụ",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa Chức Vụ",fontBtn,"hinh/button/btn_Sua.png" , 
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



