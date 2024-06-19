package content.hoa_don;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
public class buttonTotal extends JButton {
    private String color1, color2;
    private int w;
    private int h;
    private GradientPaint gp;
    public JLabel lblname;
    public JLabel getLblname() {
        return lblname;
    }
    public void setLblname(JLabel lblname) {
        this.lblname = lblname;
    }
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
    public buttonTotal (String name, String icon) {
        this.color1 = "#12c2e9";
        this.color2 = "#c471ed";
        Font font = new Font("", 0, 17);
        setPreferredSize(new Dimension(120, 80));
        JLabel lblIcon = new JLabel();
        lblIcon.setIcon(new ImageIcon(icon));
        lblname = new JLabel(name);
        lblname.setForeground(Color.white);
        lblname.setFont(font);
        Box box = Box.createVerticalBox();
        add(box);
        box.add(lblIcon);
        box.add(lblname);
        setOpaque(false);
        setBorder(null);
        setBackground(null);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        w = getWidth();
        h = getHeight();
        gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
