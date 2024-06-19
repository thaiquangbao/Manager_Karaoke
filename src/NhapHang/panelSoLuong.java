package NhapHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class panelSoLuong extends JPanel {
	public JLabel lblTitle;
	public JTextField txtSoLuong;
	public JButton btnThem;
	
	public panelSoLuong () {
		Font font = new Font ("", 0, 18);
		lblTitle = new JLabel("Nhập Số Lượng Cần Thêm : ");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.white);
		
		txtSoLuong = new JTextField(7);
		txtSoLuong.setFont(font);
		txtSoLuong.setForeground(Color.white);
		txtSoLuong.setOpaque(false);
		txtSoLuong.setBackground(null);
		txtSoLuong.setBorder(new MatteBorder(0,0,2,0, Color.white));
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(font);
		btnThem.setBackground(Color.white);
		add(Box.createRigidArea(new Dimension(500, 18)));
		add (lblTitle);
		add(txtSoLuong);
		add(btnThem);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#12c2e9"), w, h, Color.decode("#c471ed"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
