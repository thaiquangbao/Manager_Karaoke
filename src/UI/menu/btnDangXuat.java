package UI.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.w3c.dom.events.MouseEvent;

public class btnDangXuat extends JButton implements MouseListener {
	private String color;
	public btnDangXuat (String color) {
		this.color = color;
		setText("Đăng Xuất");
		Font font = new Font("Arial", 0, 18);
		setFont(font);
		setForeground(Color.white);
		setBackground(Color.decode(color));
		setContentAreaFilled(false);
		setBorder(null);
		setOpaque(false);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		Object obj = e.getSource();
		((JComponent) obj).setForeground(new Color(98, 94, 94));
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		Object obj = e.getSource();
		((JComponent) obj).setForeground(Color.white);
	}
}
