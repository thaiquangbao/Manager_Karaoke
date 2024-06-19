package content.form;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

public class customComBoBox extends JComboBox {
	public customComBoBox () {
		setSize(100, 40);
		setOpaque(false);
		setBackground(Color.white);
		setBorder(null);
	}
//	@Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        int w = getWidth(), h = getHeight();
//        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#fc00ff"), w, h, Color.decode("#00dbde"));
//        g2d.setPaint(gp);
//        g2d.fillRoundRect(0, 0, w, h,15,15);
//    }
}
