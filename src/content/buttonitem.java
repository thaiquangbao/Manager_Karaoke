package content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class buttonitem extends JButton {
	public buttonitem () {
		add(Box.createRigidArea(new Dimension(25,25)));
		setBackground(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(null);
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#ffffff"), w, h, Color.decode("#ffffff"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,100,100);
    }
}
