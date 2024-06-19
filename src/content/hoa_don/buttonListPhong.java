package content.hoa_don;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class buttonListPhong extends JButton{
    public String name;
    public String type;
    public GradientPaint gp;
    private int w;
    private int h;
    public String color1, color2;
    public Boolean isChoose = false;
    public panelHoaDon panelHoaDon;
    public listDichVu listDichVu;
    public listKhachHang listKhachHang;
    public int num = 0;
    public JLabel label;
    public String icon;
    public String price;
    public listPhong listPhong;
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
    public buttonListPhong (String name, String icon, String type, String giaPhong,listKhachHang listKhachHang,  listDichVu listDichVu, listPhong listPhong) {
        this.listDichVu = listDichVu;
        this.listKhachHang = listKhachHang;
        this.listPhong = listPhong;
        this.type = type;
        this.name = name;
        this.icon = icon;
        this.price = giaPhong;
        panelHoaDon = new panelHoaDon(name, type,giaPhong, listPhong);
        if (type.equals("Phòng VIP")) {
            this.color1 = "#12c2e9";
            this.color2 = "#c471ed";
        }else {
            this.color1 = "#12c2e9";
            this.color2 = "#c471ed";
        }
        setBackground(null);
        setOpaque(false);
        setBorder(null);

        label = new JLabel("   " + name);
        label.setForeground(Color.white);
        label.setFont(new Font("", 0, 18));
        label.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        label.setIcon(new ImageIcon(icon));
        add(label);
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
