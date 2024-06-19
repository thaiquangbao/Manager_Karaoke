package NhapHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

import Function.functionNecessary;
import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

public class titleNhapHang extends JPanel {
	public JLabel lbl1;
	public String TenNhaCungCap = "";
	public String SDTNCC = "";
	public int tongtien = 0;
	public functionNecessary d;
	public JLabel lbl2;
	public JLabel lbl3;
	public JLabel lbl4;
	public JLabel lbl5;
	public String time;
	private Box box2;
	public JComboBox cboNCC;
	private NhaCungCap_DAO nhaCungCap_dao;
	private ArrayList<NhaCungCap> dsNCC;
	public titleNhapHang () {
		d = new functionNecessary();
		this.time = d.getCurrentTime();
		setPreferredSize(new Dimension(630, 100));
		Font fontLable = new Font("Arial", 0, 18);
		Font fontCombo = new Font("Arial", 0, 16);
		lbl1 = new JLabel("Tổng Tiền : " + d.formatMoney(tongtien));
		lbl2 = new JLabel("Thời Gian : " + time);
		lbl3 = new JLabel("Nhà Cung Cấp : ");
		lbl5 = new JLabel("Nhà Cung Cấp : " + TenNhaCungCap);
		lbl4 = new JLabel("Số Điện Thoại : " + SDTNCC);
		cboNCC = new JComboBox();
		cboNCC.setBackground(Color.white);
		cboNCC.setFont(fontCombo);
		cboNCC.addItem("Không");
		LoadDataVaoComboNCC();
		
		lbl1.setFont(fontLable);
		lbl1.setForeground(Color.white);
		lbl2.setFont(fontLable);
		lbl2.setForeground(Color.white);
		lbl3.setFont(fontLable);
		lbl3.setForeground(Color.white);
		lbl5.setFont(fontLable);
		lbl5.setForeground(Color.white);
		lbl4.setFont(fontLable);
		lbl4.setForeground(Color.white);
		
		Box boxTotal = Box.createVerticalBox();
		add(boxTotal);
		Box box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 15)));
		boxTotal.add(box1);
		boxTotal.add(Box.createRigidArea(new Dimension(0, 10)));
		boxTotal.add(box2);

		box1.add(lbl1);
		box1.add(Box.createRigidArea(new Dimension(20, 0)));
		box1.add(lbl2);
		setBox2();
		
		cboNCC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (NhaCungCap ncc: dsNCC) {
					if (ncc.getTenNhaCungCap().equals(cboNCC.getSelectedItem() + "")) {
						TenNhaCungCap = ncc.getTenNhaCungCap();
						SDTNCC = ncc.getSoDienThoai();
						setBox2();
						break;
					}
			    }
			}
		});
    }
	
	public void setBox2 () {
		
		box2.removeAll();
		box2.add(Box.createRigidArea(new Dimension(20, 0)));
		box2.add(lbl3);
		box2.add(Box.createRigidArea(new Dimension(10, 0)));
		box2.add(cboNCC);
		box2.add(Box.createRigidArea(new Dimension(20, 0)));
		box2.invalidate();
		box2.validate();
		box2.repaint();

	}
	public void LoadDataVaoComboNCC () {
		nhaCungCap_dao = new NhaCungCap_DAO();
	     dsNCC=nhaCungCap_dao.getAllNhaCungCap();
       for (NhaCungCap ncc: dsNCC) {
           cboNCC.addItem(ncc.getTenNhaCungCap());
       }
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#12c2e9"), w, h, Color.decode("#c471ed"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
