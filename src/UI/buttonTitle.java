package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class buttonTitle extends JButton {
	public buttonTitle (String name, String icon) {
		setIcon(new ImageIcon(icon));
		setText(name);
		setFont(new Font("Arial", Font.BOLD, 23));
		setForeground(Color.white);
		setBackground(null);
		setBorder(null);
		setContentAreaFilled(false);
	}
	public buttonTitle (String name) {
		setText(name);
		setFont(new Font("Arial", Font.BOLD, 30));
		setForeground(Color.white);
		setBackground(null);
		setBorder(null);
		setContentAreaFilled(false);
	}
}
