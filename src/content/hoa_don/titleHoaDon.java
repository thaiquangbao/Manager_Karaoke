package content.hoa_don;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Function.functionNecessary;
import content.buttonAnimate;
import content.customButton;
import dao.KhachHang_DAO;
import entity.KhachHang;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.border.MatteBorder;

public class titleHoaDon extends JPanel implements ActionListener {
    public JLabel infoPhong;
    public JLabel infoTime;
    public buttonAnimate btnBamGio;
    public JLabel totalMoney;
    public int priceTotal;
    private int count  = 0;
    private int minute = 0;
    private int hour = 0;
    public String sdtKH;
    public String nameKH;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public Timer t;
    public JLabel lblTime; 
	public JLabel customer;
	public Box boxSDT;
	public JTextField textSDT;
	public JButton btnTimSDT;
	public JPanel title3;
	public String time;
    public int getPriceTotal() {
        return priceTotal;
    }
    public void setPriceTotal(int tong) {
        this.priceTotal = priceTotal;
    }
    public JLabel getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(JLabel totalMoney) {
        this.totalMoney = totalMoney;
    }
    public titleHoaDon (String name, String time, int priceTotal1, String giaPhong) {
        this.priceTotal = priceTotal1;
        this.time = time;
        Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
        setPreferredSize(new Dimension(650, 105));
        Box boxTotal = Box.createVerticalBox();
        add(boxTotal);

        JPanel title1 = new JPanel();
        title1.setPreferredSize(new Dimension(650, 30));
        boxTotal.add(title1);

        infoPhong = new JLabel(name);
        infoPhong.setForeground(Color.white);
        infoPhong.setFont(new Font("", 0, 18));

        infoTime = new JLabel("Giờ Hát : " + time);
        infoTime.setForeground(Color.white);
        infoTime.setFont(new Font("", 0, 18));

        title1.add(infoPhong);
        title1.add(Box.createRigidArea(new Dimension(50, 0)));
        title1.add(infoTime);
        title1.setOpaque(false);




        JPanel title2 = new JPanel();
        title2.setPreferredSize(new Dimension(650, 35));
        boxTotal.add(title2);
        JLabel lblTinhGio = new JLabel("Tính Giờ");
        lblTinhGio.setFont(new Font("", 0, 18));
        lblTinhGio.setForeground(Color.white);
        btnBamGio = new buttonAnimate();
        
        
        functionNecessary d = new functionNecessary();
        totalMoney = new JLabel("Tổng Cộng : " + d.formatMoney(getPriceTotal()));
        totalMoney.setForeground(Color.white);
        totalMoney.setFont(new Font("", 0, 18));
        lblTime = new JLabel("00 : 00 : 00");
        lblTime.setFont(new Font("", 0, 18));
        lblTime.setForeground(Color.white);

        title2.add(lblTinhGio);
        title2.add(btnBamGio);
        title2.add(Box.createRigidArea(new Dimension(5, 0)));
        title2.add(lblTime);
        title2.add(Box.createRigidArea(new Dimension(60, 0)));
        title2.add(totalMoney);
        title2.setOpaque(false);
        
        title3 = new JPanel();
        title3.setPreferredSize(new Dimension(650, 30));
        title3.setOpaque(false);
        
        boxTotal.add(Box.createRigidArea(new Dimension(0, 10)));
        boxTotal.add(title3);
        customer = new JLabel("Khách Hàng : ---");
        customer.setForeground(Color.white);
        customer.setFont(new Font("", 0, 18));
        boxSDT = Box.createHorizontalBox();
        textSDT = new JTextField();
        textSDT.setPreferredSize(new Dimension(130, 30));
        textSDT.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
        textSDT.setFont(new Font("", 0, 17));
        
        
        btnTimSDT = new JButton("Tìm");
        btnTimSDT.setFont(new Font("", 0, 16));
        btnTimSDT.setBackground(Color.white);
        boxSDT.add(textSDT);
        boxSDT.add(Box.createRigidArea(new Dimension(10, 0)));
        boxSDT.add(btnTimSDT);
        title3.add(customer);
       
        btnBamGio.addActionListener(this);
        btnBamGio.buttonitem.addActionListener(this);

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < 59) {
                    count++;
                } else {
                    minute ++;
                    count = 0;
                }
                if (minute == 60) {
                    minute = 0;
                    hour ++;
                }
                priceTotal += d.moneyPerSecond(Integer.parseInt(giaPhong));
                totalMoney.setText("Tổng Cộng : " + d.formatMoney(priceTotal));
                lblTime.setText(d.formatNumber(hour) + " : " + d.formatNumber(minute) + " : " + d.formatNumber(count));
            }
        });
    }
    public void Resettitle () {
    	count = 0;
    	minute = 0;
    	hour = 0;
    	lblTime.setText("00 : 00 : 00");
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
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object obj = arg0.getSource();
        if (obj.equals(btnBamGio) || obj.equals(btnBamGio.buttonitem)) {
            if (infoTime.getText().equals("Giờ Hát : ---")) {
                JOptionPane.showMessageDialog(null,"Phải Lập Hóa Đơn Trước Khi Tính Giờ");
            } else {
                if (btnBamGio.status.equals("close")) {
                    btnBamGio.eventclickbuttonanimation();
                    t.start();
                } else if (btnBamGio.status.equals("open")) {
                	btnBamGio.eventclickbuttonanimation();
                    t.stop();
                }
            }
        }

    }
}
