package UI;

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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import connect.ConnectDB;
import content.customButton;
import dao.NhanVien_DAO;
import entity.NhanVien;

public class panelDangNhap extends JPanel implements ActionListener{
	private String color1, color2;
	private JPanel boxDangNhap;
	private JTextField tfTaiKhoan;
	private JTextField tfMatKhau;
	public customButton btnDangNhap;
	public customButton btnDong;
	private JFrame frame;
	private NhanVien_DAO NhanVien_DAO;
	private ArrayList<NhanVien> dsNV;
	
	public panelDangNhap (String color1, String color2, JFrame frame) throws IOException {
		this.color1 = color1;
		this.color2 = color2;
		this.frame = frame;
		boxDangNhap = new JPanel();
		Box boxTotal = Box.createVerticalBox();
		setBackground(Color.decode(color1));
		try {
            ConnectDB.getInstance().connect();
        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace(); 
        }
		JLabel title = new JLabel();
		
//		URL url = new URL("hinh/icon_User.png");
		title.setIcon(new ImageIcon("hinh/icon_User.png"));
		
		
		title.setPreferredSize(new Dimension(80, 108));
		JLabel label1 = new JLabel("Tài Khoản");
		label1.setFont(new Font("", 0, 21));
		label1.setForeground(Color.white);
		JLabel label2 = new JLabel("Mật Khẩu");
		label2.setFont(new Font("", 0, 21));
		label2.setForeground(Color.white);
		boxDangNhap.setLayout(new GridLayout(0,1));
		boxDangNhap.setBackground(null);
		boxDangNhap.setOpaque(false);
		boxDangNhap.setPreferredSize(new Dimension(410, 300));
//		boxTotal.add(Box.createRigidArea(new Dimension(0, 20)));
		add(title);
		boxTotal.add (boxDangNhap);
		add (boxTotal);
		
		
		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setBorder(new MatteBorder(0,0,3,0, Color.white));
		tfTaiKhoan.setBackground(null);
		tfTaiKhoan.setOpaque(false);
		tfTaiKhoan.setFont(new Font("", 0 , 19));
		tfTaiKhoan.setForeground(Color.white);
		
		tfMatKhau = new JTextField();
		tfMatKhau.setBorder(new MatteBorder(0,0,3,0, Color.white));
		tfMatKhau.setBackground(null);
		tfMatKhau.setOpaque(false);
		tfMatKhau.setFont(new Font("", 0 , 19));
		tfMatKhau.setForeground(Color.white);
		
		boxDangNhap.add(label1);
		boxDangNhap.add(tfTaiKhoan);
		boxDangNhap.add(Box.createRigidArea(new Dimension(0, 10)));
		boxDangNhap.add(label2);
		boxDangNhap.add(tfMatKhau);
		boxDangNhap.add(Box.createRigidArea(new Dimension(0, 10)));
		Box box1 = Box.createHorizontalBox();
		boxDangNhap.add(box1);
		String color3 = "#5B86E5", color4 = "#36D1DC";
		Font fontBtn = new Font("", 0, 20);
		btnDangNhap = new customButton("Đăng Nhập", fontBtn, "hinh/button/btn_DangNhap.png", color3, color4);
		btnDong = new customButton(    "    Đóng    ", fontBtn, "hinh/button/btn_Dong.png", color3, color4);
		
		box1.add(Box.createRigidArea(new Dimension(20, 0)));
		box1.add(btnDangNhap);
		box1.add(Box.createRigidArea(new Dimension(20, 0)));
		box1.add(btnDong);
		
		btnDong.addActionListener(this);
		btnDangNhap.addActionListener(this);
	
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnDong)) {
			frame.setVisible(false);
		}
		if (obj.equals(btnDangNhap)) {
			
			NhanVien_DAO = new NhanVien_DAO();
			dsNV = NhanVien_DAO.getAllNhanVien();
			Boolean isTrue = false;
			for (NhanVien x : dsNV) {
				if (x.getMaNhanVien().equals(tfTaiKhoan.getText()) && tfMatKhau.getText().equals("1")) {
					if (x.getChucVu().getMaChucVu().equals("CV_001")) {
						try {
							new main("NVQL", x.getTenNhanVien(), x.getSoDienThoai()).setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(false);
					} else {
						try {
							new main("NVBH", x.getTenNhanVien(), x.getSoDienThoai()).setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(false);
					}
					isTrue = true;
				}
			}
			if (isTrue == false ) {
				JOptionPane.showMessageDialog(null,"Thông Tin Đăng Nhập Không Đúng");
			}
		}
	}
	
}
