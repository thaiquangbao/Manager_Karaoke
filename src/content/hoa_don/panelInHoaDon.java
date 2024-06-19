package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class panelInHoaDon extends JPanel{
	public JLabel lbl1;
	public buttonIn btnIn;
	public JLabel lbl2;
	public JTextField txtTienKhachDua;
	public JLabel lblTien;
	public buttonIn btnIn2;
	public panelInHoaDon () {
		setPreferredSize(new Dimension(700, 300));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setPreferredSize(new Dimension(335, 250));
		panel2.setPreferredSize(new Dimension(335, 250));
		panel1.setBackground(null);
		panel1.setOpaque(false);
		panel1.setBorder(new MatteBorder(1,1,1,1, Color.white));
		panel2.setBackground(null);
		panel2.setOpaque(false);
		panel2.setBorder(new MatteBorder(1,1,1,1, Color.white));
		add(panel1);
		add(panel2);
		
		Box box1 = Box.createVerticalBox();
		panel1.add(box1);
		Box box1_1 = Box.createHorizontalBox();
		Box box1_2 = Box.createHorizontalBox();
		Box box1_3 = Box.createHorizontalBox();
		box1.add(Box.createRigidArea(new Dimension(0, 25)));
		box1.add(box1_1);
		box1.add(Box.createRigidArea(new Dimension(0, 30)));
		box1.add(box1_2);
		box1.add(box1_3);
		
		lbl1 = new JLabel("In Phiếu Tạm Tính");
		lbl1.setFont(new Font("", 0, 20));
		lbl1.setForeground(Color.white);
		lbl1.setIcon(new ImageIcon("hinh/menu/lbl_In1.png"));
		box1_1.add(lbl1);
		
		btnIn = new buttonIn(" In Hóa Đơn", "hinh/button/btn_Print.png");
		btnIn.setBackground(Color.decode("#fc00ff"));
		box1_2.add(btnIn);
		
		
		
		Box box2 = Box.createVerticalBox();
		panel2.add(box2);
		Box box2_1 = Box.createHorizontalBox();
		Box box2_2 = Box.createHorizontalBox();
		Box box2_3 = Box.createHorizontalBox();
		box2.add(Box.createRigidArea(new Dimension(0, 20)));
		box2.add(box2_1);
		box2.add(Box.createRigidArea(new Dimension(0, 20)));
		box2.add(box2_2);
		box2.add(Box.createRigidArea(new Dimension(0, 20)));
		box2.add(box2_3);
		lbl2 = new JLabel("In Phiếu Thanh Toán");
		lbl2.setFont(new Font("", 0, 20));
		lbl2.setForeground(Color.white);
		lbl2.setIcon(new ImageIcon("hinh/menu/lbl_In1.png"));
		box2_1.add(lbl2);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setBorder(new MatteBorder(0,0,2,0, Color.white));
		txtTienKhachDua.setBackground(null);
		txtTienKhachDua.setOpaque(false);
		txtTienKhachDua.setFont(new Font("", 0, 17));
		txtTienKhachDua.setForeground(Color.white);
		lblTien = new JLabel("Tiền Của Khách : ");
		lblTien.setFont(new Font("", 0, 17));
		lblTien.setForeground(Color.white);
		box2_2.add(lblTien);
		box2_2.add(txtTienKhachDua);
		
		btnIn2 = new buttonIn(" In Hóa Đơn", "hinh/button/btn_Print.png");
		btnIn2.setBackground(Color.decode("#fc00ff"));
		box2_3.add(btnIn2);
		
		
		
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
}
