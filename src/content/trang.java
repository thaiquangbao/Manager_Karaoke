package content;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;

import content.menuPage.menuPage;

public class trang extends JPanel {
	public menuPage menuPage;
	public trang (String color1, String color2) {
		setBackground(Color.pink);
		setPreferredSize(new Dimension(1050, 1080));
		Box totalBox = Box.createVerticalBox();
		add(totalBox);
		totalBox.add(Box.createRigidArea(new Dimension(0, 3)));
	}
}