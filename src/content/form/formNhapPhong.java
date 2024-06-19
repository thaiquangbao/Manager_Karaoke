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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.customButton;

public class formNhapPhong extends JPanel{
	public JTextField txtMaP;
	public JTextField txtTenP;
	public JTextField txtGiaP;
	public customComBoBox cboLP;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnTim;
	public customButton btnTaiTrang;
	public customButton btnXoaTrang;
	public formNhapPhong(String type)
	{
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

		txtMaP = new JTextField();
		txtMaP.setPreferredSize(new Dimension(300, 30));
		txtMaP.setSize(100, 40);
		txtMaP.setBackground(null);
		txtMaP.setOpaque(false);
		txtMaP.setFont(fontLable);
		txtMaP.setForeground(Color.white);
		txtMaP.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		txtMaP.setText("Hệ Thống Tự Động Thêm");
		txtMaP.setEnabled(false);
		JLabel lblMaP = new JLabel("Mã Phòng : ");
		lblMaP.setFont(fontLable);
		lblMaP.setForeground(Color.white);
		lblMaP.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaP);
		boxText1_1.add(txtMaP);

		txtTenP = new JTextField();
		txtTenP.setPreferredSize(new Dimension(300, 30));
		txtTenP.setSize(100, 40);
		txtTenP.setBackground(null);
		txtTenP.setOpaque(false);
		txtTenP.setFont(fontLable);
		txtTenP.setForeground(Color.white);
		txtTenP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenP = new JLabel("Tên Phòng: ");
		lblTenP.setFont(fontLable);
		lblTenP.setForeground(Color.white);
		lblTenP.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenP);
		boxText1_2.add(txtTenP);

		txtGiaP = new JTextField();
		txtGiaP.setPreferredSize(new Dimension(300, 30));
		txtGiaP.setSize(100, 40);
		txtGiaP.setBackground(null);
		txtGiaP.setOpaque(false);
		txtGiaP.setFont(fontLable);
		txtGiaP.setForeground(Color.white);
		txtGiaP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblGiaP = new JLabel("Giá Phòng : ");
		lblGiaP.setFont(fontLable);
		lblGiaP.setForeground(Color.white);
		lblGiaP.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblGiaP);
		boxText2_1.add(txtGiaP);

		

		cboLP= new customComBoBox();
		cboLP.setFont(fontLable);
		cboLP.addItem("Không");
		JLabel lblLP = new JLabel("Loại Phòng : ");
		lblLP.setFont(fontLable);
		lblLP.setForeground(Color.white);
		lblLP.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblLP);
		boxText2_2.add(cboLP);

		


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm Phòng",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa Phòng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa Phòng",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("Xóa Trắng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh Sách",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTim = new customButton("Tìm Phòng",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);

		if (type.equals("QLP")) {
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


