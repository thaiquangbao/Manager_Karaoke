package content.menuPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import content.menuPage.menuItem;

public class menuPage extends JPanel {
	private String color1, color2;
	private menuItem subMenuQLDV;
	private menuItem subMenuTCDV;
	private menuItem subMenuLDV;
	private menuItem subMenuNCC;
	
	public menuPage (String color1, String color2, String name, String icon) {
		this.color1 = color1;
		this.color2 = color2;
		setPreferredSize(new Dimension(1100, 55));
		setBackground(null);
		JLabel title = new JLabel(name);
		title.setFont(new Font("Arial", 0, 22));
		title.setForeground(Color.white);
		title.setIcon(new ImageIcon(icon));
		title.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		setLayout(new GridLayout(0,1));
		add (title);
		
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
