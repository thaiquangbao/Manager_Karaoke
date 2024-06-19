package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedDate;
import com.raven.datechooser.panelDate;

import Function.functionNecessary;
import content.customButton;
import content.table;
import dao.DichVu_Dao;
import entity.DichVu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.ArrayList;
public class panelHoaDon extends JPanel implements ActionListener, MouseListener{
    public titleHoaDon title;

    public table table1;
    public buttonTotal btnInHoaDon;
    public buttonTotal btnLapHoaDon;
    public buttonTotal btnChuyenBan;
    private buttonTotal btnTinhTien;
    public Box box;
    private buttonTotal btnXoa;
    public int tong;
    public int tongtam;
    public int soLan = 0;
    public JPanel boxButton1;
    private String type;
    public String name;

    private listDichVu listDichVu;

    private functionNecessary d;

    public content.hoa_don.listDichVu listDichVuMini;

    public JScrollPane js2;

	public listKhachHang listKhachhangMini;

	public JScrollPane js3;

	public buttonTotal btnTroVe;
	private String giaPhong;
	public listPhong listPhong;
	public String type1;
	public int thanhTien = 0;
	public buttonTotal btnDatPhong;

	public Timer t;

	private DichVu_Dao dichVu_dao;

	private ArrayList<DichVu> dvDV;
    public titleHoaDon getTitle() {
        return title;
    }

    public void setTitle(titleHoaDon title) {
        this.title = title;
    }
    public buttonTotal getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(buttonTotal btnXoa) {
        this.btnXoa = btnXoa;
    }

    public buttonTotal getBtnInHoaDon() {
        return btnInHoaDon;
    }

    public void setBtnInHoaDon(buttonTotal btnInHoaDon) {
        this.btnInHoaDon = btnInHoaDon;
    }

    public buttonTotal getBtnLapHoaDon() {
        return btnLapHoaDon;
    }

    public void setBtnLapHoaDon(buttonTotal btnLapHoaDon) {
        this.btnLapHoaDon = btnLapHoaDon;
    }

    public buttonTotal getBtnChuyenBan() {
        return btnChuyenBan;
    }

    public void setBtnChuyenBan(buttonTotal btnChuyenBan) {
        this.btnChuyenBan = btnChuyenBan;
    }

    public buttonTotal getBtnTinhTien() {
        return btnTinhTien;
    }

    public void setBtnTinhTien(buttonTotal btnTinhTien) {
        this.btnTinhTien = btnTinhTien;
    }

    public panelHoaDon (String name, String type,String giaPhong, listPhong listPhong) {
        this.type = type;
        this.name = name;
        this.listPhong = listPhong;
        this.giaPhong = giaPhong;
        listDichVuMini = new listDichVu();
        js2 =new JScrollPane(listDichVuMini, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js2.setBorder(BorderFactory.createEmptyBorder());
        js2.getVerticalScrollBar().setUnitIncrement(6);
        js2.setBackground(Color.white);
        
        d = new functionNecessary(); 
        Font fontBtn = new Font("Arial", 0 , 17);
        String color3 = "#6dd5ed", color4 = "#2193b0";
        setPreferredSize(new Dimension(650, 750));
        setBackground(Color.white);
         
        setTitle();
        
        
        title.setPreferredSize(new Dimension(630, 120));
        box  = Box.createHorizontalBox();
        box.add(title);
        add(box);
        add(Box.createRigidArea(new Dimension(0, 20)));

        String[] header = {"#", "Tên Dịch Vụ", "Số Lượng", "Giá Bán", "Thành Tiền"} ;
		table1 = new table(header);
        
		table1.setPreferredSize(new Dimension(630, 570));
		add(table1);
        add(Box.createRigidArea(new Dimension(0, 20)));

        boxButton1 = new JPanel();
        boxButton1.setBackground(null);
        add (boxButton1);

        btnLapHoaDon = new buttonTotal(" Lập Hóa Đơn", "hinh/button/btn_LapHoaDon.png");
        btnInHoaDon = new buttonTotal(" In Hóa Đơn", "hinh/button/btn_TinhTien.png");


        btnChuyenBan = new buttonTotal(" Chuyển Phòng", "hinh/button/btn_ChuyenBan.png");
        btnTroVe = new buttonTotal(" Trở Về", "hinh/button/btn_TroVe.png");
        btnXoa = new buttonTotal(" Xóa Dịch Vụ", "hinh/button/btn_Xoa.png");
        btnDatPhong = new buttonTotal(" Đặt Phòng", "hinh/button/btn_InHoaDon.png");
         
        btnXoa.setColor1("#EECDA3");
        btnXoa.setColor2("#EF629F");
        

      
        btnXoa.addActionListener(this);
        btnLapHoaDon.addActionListener(this);
        functionNecessary d = new functionNecessary();
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thanhTien += d.moneyPerSecond(Integer.parseInt(giaPhong));
                table1.table.getModel().setValueAt(d.formatMoney(thanhTien), 0, 4);
            }
        });
        
        if (title.btnBamGio.getActionListeners().length == 1) {
        	title.btnBamGio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (btnLapHoaDon.getLblname().getText() != " Lập Hóa Đơn") {
						String ten = "";
						if (type.equals("Phòng Thường")) {
							ten  = "Giờ Hát ( Thường )";
						} else if (type.equals("Phòng VIP")) {
							ten  = "Giờ Hát ( VIP )";
						}
						
						if (title.btnBamGio.status.equals("close")) {
							if (table1.getRowCount() > 0) {
								if (table1.table.getModel().getValueAt(0, 2) != "0") {
									table1.insertRow(0, new Object[] {table1.getRowCount() + 1, ten, "0", d.formatMoney(Integer.parseInt(giaPhong)), d.formatMoney(thanhTien)});	
								}
							} else {
								table1.insertRow(0, new Object[] {table1.getRowCount() + 1, ten, "0", d.formatMoney(Integer.parseInt(giaPhong)), d.formatMoney(thanhTien)});	
							}

							t.start();
						} else {
							t.stop();
						}
						
						reSetSTT();
					}
					
				}
			});
        }
    }
    public void setTitle () {
    	if (type.equals("Phòng Thường")) {
            title = new titleHoaDon(name + " - Phòng Thường", "---", tong, giaPhong);
        } else if (type.equals("Phòng VIP")) {
            title = new titleHoaDon(name + " - Phòng VIP", "---", tong, giaPhong);
        } else {
            title = new titleHoaDon("Phòng : Trống", "---", tong, giaPhong);
        }
    }
    public void setButton () {
    	if (type1.equals("hoadon")) {
    		boxButton1.removeAll();
        	boxButton1.add(btnLapHoaDon);
            boxButton1.add(btnInHoaDon);
            boxButton1.add(btnDatPhong);
            boxButton1.add(btnChuyenBan);
            boxButton1.add(btnXoa);
        } else {
        	boxButton1.removeAll();
        	boxButton1.add(btnLapHoaDon);
            boxButton1.add(btnInHoaDon);
            boxButton1.add(btnDatPhong);
            boxButton1.add(btnTroVe);
            boxButton1.add(btnXoa);
        }
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object obj = arg0.getSource();
        if (obj.equals(getBtnXoa())) {
        	int zz ;
        	if (title.lblTime.getText().equals("00 : 00 : 00")) {
        		zz = 0;
        	} else {
        		zz = 1;
        	}
        	
            if (table1.getSelectedRow() >= zz) {
                String name = (String) table1.table.getModel().getValueAt(table1.getSelectedRow(),1);
                int soLuong = (int) table1.table.getModel().getValueAt(table1.getSelectedRow(),2);
                table1.removeRow(table1.getSelectedRow());
                for (buttonListDichVu x : listDichVuMini.listDichVu) {
                    if (x.getName().equals(name)) {
                        x.setAmount(0);
                        tong = title.priceTotal;
                        tong -= soLuong * Integer.parseInt(x.getPrice());
                        title.totalMoney.setText("Tổng Cộng : " + d.formatMoney(tong));
                        title.priceTotal = tong;
                        
                        dichVu_dao = new DichVu_Dao();
						dvDV=dichVu_dao.getAllDichVu();
				        for (DichVu dv : dvDV) {
				        	 if (dv.getTenDichVu().equals(name)) {
				        		 dv.setSoLuongTon(dv.getSoLuongTon() + soLuong);
				        		 if(dichVu_dao.update(dv)) {
						    			for (buttonListPhong z : listPhong.listPhong) {
									    	for (buttonListDichVu t : z.panelHoaDon.listDichVuMini.listDichVu) {
									    		if (dv.getTenDichVu().equals(t.name)) {
									    			t.amountTon = dv.getSoLuongTon();
									    			t.Amount.setText("Còn : " + t.amountTon);
									    			reSetSTT();
									    		}
									    	}
									    }
					        		}
				        	 }
				        }
                    }
                }
    
            } else {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
            }
        } 
        if (obj.equals(getBtnLapHoaDon())) {
        	if (title.customer.getText().equals("Khách Hàng : ---") || title.customer.getText().equals("Số Điện Thoại Khách Hàng : ")) {
        		JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Khách Hàng Sử Dụng");
        	}
        	else {
        		if (btnLapHoaDon.getLblname().getText().equals(" Lập Hóa Đơn")) {
                    if (type != "Rỗng") {
                        title.infoTime.setText("Giờ Hát : " + d.getCurrentTime());
                        title.time = d.getCurrentTime();
                        btnLapHoaDon.getLblname().setText(" Lưu Hóa Đơn");
                        btnLapHoaDon.setColor1("#EECDA3");
                        btnLapHoaDon.setColor2("#EF629F");
                        repaint();
                        listPhong.UpdatePhongDangSuDung();
                        JOptionPane.showMessageDialog(null, "Lập Hóa Đơn Thành Công !!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Chọn Phòng Trước Khi Lập Hóa Đơn !!!");
                    }
                } else if (btnLapHoaDon.getLblname().getText().equals(" Lưu Hóa Đơn")) {
                    // btnLapHoaDon.getLblname().setText(" Lập Hóa Đơn");
                    JOptionPane.showMessageDialog(null, "Lưu Hóa Đơn Thành Công !!!!");
        	} 		
       }}
        
    }
    public void setTenPhong () {
    	if (type.equals("Phòng Thường")) {
    		title.infoPhong.setText(name + " - Phòng Thường");
        } else if (type.equals("Phòng VIP")) {
        	title.infoPhong.setText(name + " - Phòng VIP");
        }
    }
	public void reSetSTT () {
		for (int i =0; i < table1.getRowCount(); i++) {
			table1.table.getModel().setValueAt(i+1, i, 0);
		}
	}

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
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
