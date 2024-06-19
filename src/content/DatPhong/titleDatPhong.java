package content.DatPhong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.form.customComBoBox;

public class titleDatPhong extends JPanel {
    
 
	
	public JTextField txtTenKH;
	public JTextField txtSDT;
	public JTextField txtDiaChi;
	public customComBoBox cboGioDat;
	public customComBoBox cboPhongDat;
	private String ma;
	private String diaChi;
	private String time;
	private String phong;
	public String name;
	private String sdt;
	public Object title;
	public JTextField txtMaKH;
    
    public titleDatPhong (String ma, String name, String diaChi,String sdt, String time,String phong) {
    	this.ma = ma;
        this.name = name;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.time = time;
        this.phong = phong;
    	

        Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
        setPreferredSize(new Dimension(650, 320));
        Box boxTotal = Box.createVerticalBox();
        add(boxTotal);
        
		Box boxText = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 20)));
		boxTotal.add(boxText);
		Box boxBtn = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 40)));
		boxTotal.add(boxBtn);
		Box boxText1 = Box.createVerticalBox();
		Box boxText1_1 = Box.createHorizontalBox();
		Box boxText1_2 = Box.createHorizontalBox();
		Box boxText1_3 = Box.createHorizontalBox();
		Box boxText2_1 = Box.createHorizontalBox();
		Box boxText2_2 = Box.createHorizontalBox();
		Box boxText2_3 = Box.createHorizontalBox();
		boxText.add(boxText1);
		boxText.add(Box.createRigidArea(new Dimension(60, 0)));
		
		boxText1.add(boxText1_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_3);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_3);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));

		txtMaKH = new JTextField();
		txtMaKH.setPreferredSize(new Dimension(300, 30));
		txtMaKH.setSize(100, 40);
		txtMaKH.setBackground(null);
		txtMaKH.setOpaque(false);
		txtMaKH.setFont(fontLable);
		txtMaKH.setForeground(Color.white);
		txtMaKH.setText(ma);
		txtMaKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMaKH = new JLabel("Mã Khách Hàng : ");
		lblMaKH.setFont(fontLable);
		lblMaKH.setForeground(Color.white);
		lblMaKH.setPreferredSize(new Dimension(155, 30));
		boxText1_1.add(lblMaKH);
		boxText1_1.add(txtMaKH);
       
		txtTenKH = new JTextField();
		txtTenKH.setPreferredSize(new Dimension(300, 30));
		txtTenKH.setSize(100, 40);
		txtTenKH.setBackground(null);
		txtTenKH.setOpaque(false);
		txtTenKH.setFont(fontLable);
		txtTenKH.setForeground(Color.white);
		txtTenKH.setText(name);
		txtTenKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenKH = new JLabel("Tên Khách Hàng: ");
		lblTenKH.setFont(fontLable);
		lblTenKH.setForeground(Color.white);
		lblTenKH.setPreferredSize(new Dimension(155, 30));
		boxText1_2.add(lblTenKH);
		boxText1_2.add(txtTenKH);

		txtSDT = new JTextField();
		txtSDT.setPreferredSize(new Dimension(300, 30));
		txtSDT.setSize(100, 40);
		txtSDT.setBackground(null);
		txtSDT.setOpaque(false);
		txtSDT.setFont(fontLable);
		txtSDT.setText(sdt);
		txtSDT.setForeground(Color.white);
		txtSDT.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDT = new JLabel("Số Điện Thoại    : ");
		lblSDT.setFont(fontLable);
		lblSDT.setForeground(Color.white);
		lblSDT.setPreferredSize(new Dimension(155, 30));
		boxText1_3.add(lblSDT);
		boxText1_3.add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(300, 30));
		txtDiaChi.setSize(100, 40);
		txtDiaChi.setBackground(null);
		txtDiaChi.setOpaque(false);
		txtDiaChi.setFont(fontLable);
		txtDiaChi.setText(diaChi);
		txtDiaChi.setForeground(Color.white);
		txtDiaChi.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChi = new JLabel("Địa Chỉ                : ");
		lblDiaChi.setFont(fontLable);
		lblDiaChi.setForeground(Color.white);
		lblDiaChi.setPreferredSize(new Dimension(155, 30));
		boxText2_1.add(lblDiaChi);
		boxText2_1.add(txtDiaChi);
		
		cboGioDat = new customComBoBox();
		cboGioDat.setFont(fontLable);
		cboGioDat.addItem("Khong");
		JLabel lblGioDat = new JLabel("Giờ Đặt               : ");
		lblGioDat.setFont(fontLable);
		cboGioDat.setSelectedItem(time);
		lblGioDat.setForeground(Color.white);
		lblGioDat.setPreferredSize(new Dimension(170, 30));
		boxText2_2.add(lblGioDat);
		boxText2_2.add(cboGioDat);

		cboPhongDat = new customComBoBox();
		cboPhongDat.setFont(fontLable);
		cboPhongDat.addItem("Khong");
		JLabel lblPhongDat = new JLabel("Phòng Đặt          : ");
		lblPhongDat.setFont(fontLable);
		lblPhongDat.setForeground(Color.white);
		cboGioDat.setSelectedItem(phong);
		lblPhongDat.setPreferredSize(new Dimension(170, 30));
		boxText2_3.add(lblPhongDat);
		boxText2_3.add(cboPhongDat);

       



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
