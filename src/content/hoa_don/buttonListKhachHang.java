package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

import entity.KhachHang;

public class buttonListKhachHang extends JButton implements MouseListener  {
	 
    
		public String type;
	    public GradientPaint gp;
	    private int w;
	    private int h;
	    public String color1;
		public String color2;
	    public Boolean isChoose = false;
		private String ma;
		private String diaChi;
		private String time;
		private String phong;
		public String name;
		private String sdt;
	 public String getColor1() {
	        return color1;
	    }
	    public String getName() {
		return name;
	}
		public void setName(String name) {
			this.name = name;
		}
		public String getMa() {
			return ma;
		}
		public void setMa(String ma) {
			this.ma = ma;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getPhong() {
			return phong;
		}
		public void setPhong(String phong) {
			this.phong = phong;
		}
		
		public String getSdt() {
			return sdt;
		}
		public void setSdt(String sdt) {
			this.sdt = sdt;
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
	 public buttonListKhachHang (KhachHang kh) {
	        
	        this.ma = kh.getMaKhachHang();
	        this.name = kh.getTenKhachHang();
	        this.diaChi = kh.getDiaChi();
	        this.sdt = kh.getSoDienThoai();
//	        if (type.equals("VIP")) {
//	            this.color1 = "#12c2e9";
//	            this.color2 = "#c471ed";
//	        }else {}
	            this.color1 = "#12c2e9";
	            this.color2 = "#c471ed";
	        
	        setBackground(null);
	        setOpaque(false);
	        setBorder(null);
	        setPreferredSize(new Dimension(200, 800));
	        Box box = Box.createHorizontalBox();
	        add(box);
	        
	        Font font1 = new Font("", Font.BOLD, 17);
	        Font font2 = new Font("", 0, 15);
	       
	        JLabel labelname = new JLabel("     " + name);
	        labelname.setForeground(Color.white);
	        labelname.setFont(new Font("", 0, 18));
	        labelname.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	        add(labelname);
	        addMouseListener(this);
	        
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
		@Override
		public void mouseClicked(MouseEvent arg0) {
//			// TODO Auto-generated method stub
//			setColor1("#EECDA3");
//           setColor2("#EF629F");
//           isChoose = true;
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
	        if (isChoose.equals(false)) {
	            setColor1("#EECDA3");
	            setColor2("#EF629F");
	        }
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			if (isChoose.equals(false)) {
	            setColor1("#12c2e9");
	            setColor2("#c471ed");
			}
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}

