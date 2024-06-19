package UI.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class subMenuItem extends JButton implements MouseListener{
	public subMenuItem (String name, Font font, String color) {
		setText("     + "+name);
		setPreferredSize(new Dimension(255, 70));
		setFont(font);
		setOpaque(false);
		setBorder(null);
		setForeground(Color.white);
		setBackground(Color.decode(color));
		setContentAreaFilled(false);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		((JComponent) obj).setForeground(new Color(98, 94, 94));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		((JComponent) obj).setForeground(Color.white);
	}
}
