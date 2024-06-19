package content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.Timer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class buttonAnimate extends JButton {
	public String color1 = "#232526";
	public String color2 = "#414345";
	public buttonitem buttonitem;
	private Timer t;
	public String status = "close";
	private int width = 2;
	public buttonAnimate () {
		setPreferredSize(new Dimension(53,30));
		setOpaque(false);
		setBorder(null);
		setContentAreaFilled(false);
		buttonitem = new buttonitem();
		Rerender (width);
		
		t = new Timer( 1, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				if (status.equals("open")) {
					if (width < 71) {
						width += 4;
						Rerender(width);
					} else {
						t.stop();
					}
				} else {
					if (width > 5) {
						width -= 4;
						Rerender(width);
					} else {
						t.stop();
					}
				}
			}
        });
		
//		addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				eventclickbuttonanimation ();
//			}
//		});
//		buttonitem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				eventclickbuttonanimation ();
//			}
//		});
	}
	public void eventclickbuttonanimation () {
		if (status.equals("close")) {
			status = "open";
			color1 = "#fc00ff";
			color2 = "#00dbde";
			t.start();
		} else {
			status = "close";
			color1 = "#232526";
			color2 = "#414345";
			t.start();
		}
	}
	public void Rerender (int width) {
		removeAll();
		add(Box.createRigidArea(new Dimension(width,0)));
		add(buttonitem);
		invalidate();
		validate();
		repaint();
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,30,30);
    }
}
