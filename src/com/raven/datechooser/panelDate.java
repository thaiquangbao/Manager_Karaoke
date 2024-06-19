package com.raven.datechooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelDate extends JPanel {
	public JButton btnDat;
	public DateChooser date;
	public JComboBox comboGio;
	public JComboBox comboPhut;
	public panelDate () {
		date = new DateChooser();
		add(date);
		Box box = Box.createVerticalBox();
		add(box);
		Box box1 = Box.createHorizontalBox();
		box.add(Box.createRigidArea(new Dimension(0, 10)));
		box.add(box1);
		JLabel lable = new JLabel("Giờ Đặt : ");
		lable.setForeground(Color.white);
		lable.setFont(new Font("", 0, 16));
		box1.add(Box.createRigidArea(new Dimension(5, 0)));
		box1.add(lable);
		box1.add(Box.createRigidArea(new Dimension(2, 0)));
		comboGio = new JComboBox();
		for (int i = 0; i< 24 ; i++) {
			comboGio.addItem(i);
		}
		comboGio.setBackground(Color.white);
		box1.add(comboGio);
		JLabel lable1 = new JLabel(" : ");
		lable1.setForeground(Color.white);
		lable1.setFont(new Font("", 0, 16));
		box1.add(lable1);
		comboPhut = new JComboBox();
		for (int i = 0; i< 60 ; i++) {
			comboPhut.addItem(i);
		}
		comboPhut.setBackground(Color.white);
		comboPhut.setFont(new Font("", 0, 15));
		comboGio.setFont(new Font("", 0, 15));
		box1.add(comboPhut);
		
		box1.add(Box.createRigidArea(new Dimension(5, 0)));
		btnDat = new JButton("Đặt Phòng");
		btnDat.setFont(new Font("", 0, 13));
		btnDat.setBackground(Color.white);
		box1.add(btnDat);
		box1.add(Box.createRigidArea(new Dimension(5, 0)));
		
	}
	@Override
	protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      int w = getWidth(), h = getHeight();
      GradientPaint gp = new GradientPaint(0, 0, Color.decode("#fc00ff"), w, h, Color.decode("#00dbde"));
      g2d.setPaint(gp);
      g2d.fillRoundRect(0, 0, w, h,15,15);
	}
}
