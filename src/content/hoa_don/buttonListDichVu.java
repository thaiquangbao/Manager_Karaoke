package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Function.functionNecessary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class buttonListDichVu extends JButton implements MouseListener {
    public JLabel image;
    public JLabel title;
    public JLabel Amount;
    public JLabel Price;
    private String color1, color2;
    private Boolean isChoose = false;
    public String name;
    public int amount = 0;
    public int amountTon;
    public String price;
    public String priceText;
    public String getPriceText() {
        return priceText;
    }
    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }
    private JButton btnCong;
    private JButton btnTru;
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public buttonListDichVu (String icon, String name, String amount, String price) {
        this.color1 = "#12c2e9";
        this.color2 = "#c471ed";
        this.name = name;
        this.price = price;
        this.amountTon = Integer.parseInt(amount);
        functionNecessary d = new functionNecessary();
        this.priceText = d.formatMoney(Integer.parseInt(price));
        setBackground(null);
        setOpaque(false);
        setBorder(null);
        Box box = Box.createHorizontalBox();
        add(box);

        image = new JLabel();
        image.setIcon(new ImageIcon(icon));
        box.add(image);
        box.add(Box.createRigidArea(new Dimension(10, 0)));

        Font font1 = new Font("", Font.BOLD, 17);
        Font font2 = new Font("", 0, 15);
        Box boxChildren = Box.createVerticalBox();
        box.add(boxChildren); 
        title = new JLabel(name);
        title.setForeground(Color.white);
        title.setFont(font1);
        boxChildren.add(title);

        Amount = new JLabel("Còn : " + amountTon);
        Amount.setForeground(Color.white);
        Amount.setFont(font2);
        boxChildren.add(Amount);

        Price = new JLabel(priceText);
        Price.setForeground(Color.white);
        Price.setFont(font2);
        boxChildren.add(Price);

        addMouseListener(this);
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
    public void mouseClicked(MouseEvent arg0) {
        
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
            setColor1("#EECDA3");
            setColor2("#EF629F");
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
            setColor1("#12c2e9");
            setColor2("#c471ed");
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
