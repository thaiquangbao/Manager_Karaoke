package content.TongQuan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nodeTongQuan extends JPanel {
	private String name;
	private String value;
	private String icon;
	private String color1 , color2;
	private Font font;
	public nodeTongQuan (String name, String value, String icon, String color1, String color2, Font font) {
		this.name = name;
		this.value = value;
		this.icon = icon;
		this.color1 = color1;
		this.color2 = color2;
		this.font = font;
		setPreferredSize(new Dimension(290, 135));
		setBorder(null);
		setBackground(null);
		//setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.black));
		JLabel hinhThongKe1 = new JLabel();
		hinhThongKe1.setIcon(new ImageIcon(icon));
		Box totalBox = Box.createVerticalBox();
		add(totalBox);
		Box thongKe1Box = Box.createHorizontalBox(), thongKe1BoxRight = Box.createVerticalBox();
		JPanel thongKe1Left = new JPanel(),thongKe1Right = new JPanel(), thongKeNull = new JPanel();
		thongKe1Left.setPreferredSize(new Dimension(100, 163));
		thongKe1Right.setPreferredSize(new Dimension(180, 163));
		thongKeNull.setPreferredSize(new Dimension(50, 163));
		thongKe1Right.setBackground(null);
		thongKe1Right.setOpaque(false);
		thongKe1Left.setOpaque(false);
		thongKe1Box.add(thongKe1Left);
		thongKeNull.setOpaque(false);
		thongKe1Box.add(thongKe1Right);
		//thongKe1Box.add(thongKeNull);
		thongKe1Left.add(hinhThongKe1);
		totalBox.add(Box.createRigidArea(new Dimension(10,20)));
		totalBox.add(thongKe1Box);
		totalBox.add(Box.createRigidArea(new Dimension(10,4)));
		thongKe1Right.add(thongKe1BoxRight);
		JLabel soLieuThongKe1 = new JLabel(value);
		JLabel tenThongKe1 = new JLabel(name);
		soLieuThongKe1.setFont(font);
		tenThongKe1.setFont(font);
		soLieuThongKe1.setForeground(Color.white);
		tenThongKe1.setForeground(Color.white);
		thongKe1BoxRight.add(Box.createRigidArea(new Dimension(0,10)));
		thongKe1BoxRight.add(tenThongKe1);
		thongKe1BoxRight.add(Box.createRigidArea(new Dimension(0,7)));
		thongKe1BoxRight.add(soLieuThongKe1);
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
