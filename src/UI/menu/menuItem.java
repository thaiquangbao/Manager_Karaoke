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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menuItem extends JButton{
	public menuItem (String name, String icon, Font font, String color) {
		setText(name);
		setPreferredSize(new Dimension(255, 70));
		setIcon(new ImageIcon(icon));
		setFont(font);
		setOpaque(false);
		setBorder(null);
		setForeground(Color.white);
		setBackground(Color.decode(color));
		setContentAreaFilled(false);
	}
}
