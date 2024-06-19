package content.ThongKe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Function.functionNecessary;
import content.customButton;
import content.form.customComBoBox;

public class nodeTongCong extends JPanel {
	private String color1, color2;
	private customComBoBox cboLeft;
	private customButton btnXemThongKe;
	private customButton btnInThongKe;
	private customComBoBox cboLeft1;
	private customComBoBox cboLeft2;
	public int KhoangThu = 0;
	public int KhoangChi = 0;
	public int DoanhThu = 0;
	
	private Font fontTongCong;
	private functionNecessary d;
	public String lbl1;
	public String lbl2;
	public String lbl3;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public nodeTongCong (String color1, String color2, String type, String typeParent) {
		fontTongCong = new Font("Arial", 0 , 19);
		String color3 = "#6dd5ed", color4 = "#2193b0";
		this.color1 = color1;
		this.color2 = color2;
		setPreferredSize(new Dimension(290, 195));
		setBorder(null);
		setBackground(null);
		Box totalBox = Box.createVerticalBox();
		add(totalBox);
		d = new functionNecessary();
		
		lbl1 = ""; 
		lbl2 = ""; 
		lbl3 = "";
		if (typeParent.equals("Hoa Don")) {
			if (type == "Khoang Thu") {
				lbl1 = "Tổng Tiền Các Phòng   : ";
				lbl2 = "Tổng Tiền Dịch Vụ        : " ;
				lbl3 = "Tổng Cộng                   : ";
			} else if (type == "Khoang Chi") {
				lbl1 = "Tổng Số Phiếu Nhập Hàng           : ";
				lbl2 = "Tổng Số Hàng Hóa Được Nhập    : " ;
				lbl3 = "Tổng Tiền Nhập Hàng                  : ";
			} else if (type == "Doanh Thu") {
				lbl1 = "Tổng Khoảng Thu   : " + d.formatMoney(KhoangThu);
				lbl2 = "Tổng Khoảng Chi    : " + d.formatMoney(KhoangChi);
				lbl3 = "Tổng Doanh Thu     : "+ d.formatMoney(DoanhThu);
			}
		} else if (typeParent.equals("Khach Hang")) {
			lbl1 = "Tổng Số Khách Hàng   : ";
			lbl2 = "Tổng Tiền Hóa Đơn    : ";
		} else if (typeParent.equals("Nhan Vien")) {
			lbl1 = "Tổng Số Nhân Viên   : ";
			lbl2 = "Tổng Số Hóa Đơn Đã Lập  : ";
			lbl3 = "Tổng Tiền Hóa Đơn Đã lập : ";
		} else if (typeParent.equals("Y Kien")) {
			lbl1 = "Tổng Số Ý Kiến   : ";
		}
		
		
		
		label1 = new JLabel(lbl1);
		label2 = new JLabel(lbl2);
		label3 = new JLabel(lbl3);
		label1.setForeground(Color.white);
		label2.setForeground(Color.white);
		label3.setForeground(Color.white);
		label1.setFont(fontTongCong);
		label2.setFont(fontTongCong);
		label3.setFont(fontTongCong);
		
		if (typeParent.equals("Hoa Don")) {
			totalBox.add(Box.createRigidArea(new Dimension(0, 35)));
			totalBox.add(label1);
			totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
			totalBox.add(label2);
			totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
			totalBox.add(label3);
		} else if (typeParent.equals("Khach Hang")) {
			totalBox.add(Box.createRigidArea(new Dimension(0, 50)));
			totalBox.add(label1);
			totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
			totalBox.add(label2);
		} else if (typeParent.equals("Nhan Vien")) {
			totalBox.add(Box.createRigidArea(new Dimension(0, 35)));
			totalBox.add(label1);
			totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
			totalBox.add(label2);
			totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
			totalBox.add(label3);
		} else if (typeParent.equals("Y Kien")) {
			totalBox.add(Box.createRigidArea(new Dimension(0, 70)));
			totalBox.add(label1);
		}
			 
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode(color1), w, h, Color.decode(color2));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}