package content.menuPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menuItem extends JButton implements MouseListener {
	public menuItem (String name, String icon, Font font, String color) {
		setText(name);
		setPreferredSize(new Dimension(250, 70));
		setIcon(new ImageIcon(icon));
		setFont(font);
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
		((JComponent) obj).setBorder(BorderFactory.createMatteBorder(0,0,5,0, Color.white));
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		((JComponent) obj).setBorder(null);
	}
}
