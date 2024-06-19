package content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class buttonForm extends JButton implements MouseListener{
	private String color1;
	private String color2;
	private String color3;
	private String color4;
	
	public String getColor1() {
		return color1;
	}
	public void setColor1(String color1) {
		this.color1 = color1;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public buttonForm (String name, Font font, String icon, String color1, String color2) {
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color1;
		this.color4 = color2;
		JLabel title = new JLabel( name + "   ");
		title.setFont(font);
		title.setForeground(Color.white);
		title.setIcon(new ImageIcon(icon));
		setPreferredSize(new Dimension(0, 50));
		setBorder(BorderFactory.createEmptyBorder(5,13,7,0)); 
		add(title);
		setContentAreaFilled(false);
		addMouseListener(this);
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth(), h = getHeight();
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);

    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		((buttonForm) obj).setBorder(BorderFactory.createEmptyBorder(5,15,7,3)); 
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		((buttonForm) obj).setBorder(BorderFactory.createEmptyBorder(5,13,7,0)); 
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		((buttonForm) obj).setColor1("#BE5869");
		((buttonForm) obj).setColor2("#403A3E");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		((buttonForm) obj).setColor1(color3);
		((buttonForm) obj).setColor2(color4);
		
	}

}
