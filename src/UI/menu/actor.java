package UI.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class actor extends JPanel {
	public btnDangXuat btnDangXuat;

	public actor (String name , String icon, Font font, String color, String nameEM , String sdt) {
		setLayout(new GridLayout(1,0));
		setPreferredSize(new Dimension(50, 110));
		JLabel title = new JLabel();
		title.setIcon(new ImageIcon(icon));
		setOpaque(false);
		Box boxTotal = Box.createVerticalBox();
		title.setFont(font);
		title.setForeground(Color.white);
		setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		add(boxTotal);
		btnDangXuat = new btnDangXuat(color);
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		
		JLabel nameEmploy = new JLabel(nameEM);
		nameEmploy.setFont(new Font ("", 0, 20));
		nameEmploy.setForeground(Color.white);
		JLabel phoneEmploy = new JLabel(sdt);
		phoneEmploy.setFont(new Font ("", 0, 20));
		phoneEmploy.setForeground(Color.white);
		Box box1_1 = Box.createVerticalBox();
		box1_1.add(nameEmploy);
		box1_1.add(phoneEmploy);
		
		box1.add(title);
		box1.add(Box.createRigidArea(new Dimension(15, 0)));
		box1.add(box1_1);
		box2.add(btnDangXuat);
		
		boxTotal.add(box1);
		boxTotal.add(Box.createRigidArea(new Dimension(0, 10)));
		boxTotal.add(box2);
	}
}
