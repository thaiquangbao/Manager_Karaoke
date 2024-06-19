package content.ThongKe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.raven.datechooser.DateChooser;

import Function.functionNecessary;
import content.customButton;
import content.form.customComBoBox;

public class nodeThongKe extends JPanel {
	private String color1, color2;
	private customComBoBox cboLeft;
	private Font fontBtn;
	public customButton btnXemThongKe;
	public customButton btnInThongKe;
	public customComBoBox cboLeft1;
	public customComBoBox cboLeft2;
	public customButton btnTaiLai;
	private JButton btndate;
	private DateChooser date;
	private JTextField txtmau;
	public JTextField txtdate1;
	private JButton btndate1;
	public JTextField txtdate2;
	private JButton btndate2;
	private JLabel lbldate1;
	private JLabel lbldate2;
	private DateChooser date1;
	private DateChooser date2;
	private functionNecessary d;
	
	public nodeThongKe (String color1, String color2, String type) {
		fontBtn = new Font("Arial", 0 , 17);
		String color3 = "#6dd5ed", color4 = "#2193b0";
		this.color1 = color1;
		this.color2 = color2;
		setPreferredSize(new Dimension(290, 195));
		setBorder(null);
		setBackground(null);
		Box totalBox = Box.createVerticalBox();
		add(totalBox);
		d = new functionNecessary();
		JLabel lableLeft1 = new JLabel("Loại Thống Kê        ");
		lableLeft1.setForeground(Color.white);
		lableLeft1.setFont(new Font ("Arial", 0, 17));
		cboLeft1 = new customComBoBox();
		cboLeft1.setFont(new Font ("Arial", 0, 17));
		if (type.equals("Hoa Don")) {
			cboLeft1.addItem("Thống Kê Khoảng Thu");
			cboLeft1.addItem("Thống Kê Khoảng Chi");
		} else if (type.equals("Khach Hang")) {
			cboLeft1.addItem("Thống Kê Khách Hàng");
		} else if (type.equals("Nhan Vien")) {
			cboLeft1.addItem("Thống Kê Nhân Viên");
		} else if (type.equals("Y Kien")) {
			cboLeft1.addItem("Thống Kê Ý Kiến");
		}
		
		Font fontdate = new Font("", 0, 17);
		
		txtdate1 = new JTextField();
		txtdate1.setText(d.getCurrentTime().substring(10, 21));
		txtdate1.setBackground(null);
		txtdate1.setOpaque(false);
		txtdate1.setBorder(new MatteBorder(0,0,2,0,Color.white));
		txtdate1.setForeground(Color.white);
		txtdate1.setFont(fontdate);
		btndate1 = new JButton();
		btndate1.setBackground(null);
		btndate1.setOpaque(false);
		btndate1.setBorder(null);
		btndate1.setIcon(new ImageIcon("hinh/button/btn_Down.png"));
		lbldate1 = new JLabel("Từ Ngày   ");
		lbldate1.setForeground(Color.white);
		lbldate1.setFont(fontdate);
		date1 = new DateChooser();
		date1.textRefernce = txtdate1;
		if (btndate1.getActionListeners().length == 0) {
			btndate1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					date1.showPopup();
				}
			});
		}
		txtdate2 = new JTextField("");
		txtdate2.setText(d.getCurrentTime().substring(10, 21));
		txtdate2.setBackground(null);
		txtdate2.setOpaque(false);
		txtdate2.setBorder(new MatteBorder(0,0,2,0,Color.white));
		txtdate2.setForeground(Color.white);
		txtdate2.setFont(fontdate);
		btndate2 = new JButton();
		btndate2.setBackground(null);
		btndate2.setOpaque(false);
		btndate2.setBorder(null);
		btndate2.setIcon(new ImageIcon("hinh/button/btn_Down.png"));
		lbldate2 = new JLabel("   Đến Ngày   ");
		lbldate2.setForeground(Color.white);
		lbldate2.setFont(fontdate);
		date2 = new DateChooser();
		date2.textRefernce = txtdate2;
		if (btndate2.getActionListeners().length == 0) {
			btndate2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					date2.showPopup();
				}
			});
		}
		
		cboLeft1.setPreferredSize(new Dimension(300, 40));
		btnXemThongKe = new customButton("Xem Thống Kê",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnInThongKe = new customButton("In Thống Kê",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTaiLai = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);
		
		Box boxinfo2 = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 12)));
		totalBox.add(boxinfo2);
		totalBox.add(Box.createRigidArea(new Dimension(0, 10)));
		boxinfo2.add(lbldate1);
		boxinfo2.add(txtdate1);
		boxinfo2.add(btndate1);
		
		boxinfo2.add(lbldate2);
		boxinfo2.add(txtdate2);
		boxinfo2.add(btndate2);
		
		Box boxinfo1 = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 5)));
		totalBox.add(boxinfo1);
		totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
		boxinfo1.add(lableLeft1);
		boxinfo1.add(cboLeft1);
		Box boxbtn = Box.createHorizontalBox();
		totalBox.add(boxbtn);
		boxbtn.add(btnXemThongKe);
		boxbtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxbtn.add(btnInThongKe);
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
