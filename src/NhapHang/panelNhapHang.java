package NhapHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import Function.functionNecessary;
import content.table;
import content.hoa_don.buttonListDichVu;
import content.hoa_don.buttonListPhong;
import content.hoa_don.buttonTotal;
import content.hoa_don.listDichVu;
import content.hoa_don.listPhong;
import content.hoa_don.trangHoaDon;
import dao.DichVu_Dao;
import dao.NhaCungCap_DAO;
import dao.PhieuNhapHang_DAO;
import entity.DichVu;
import entity.NhaCungCap;
import entity.PhieuNhapHang;

public class panelNhapHang extends JPanel{
	private functionNecessary d;
	public table table;
	public titleNhapHang title;
	private buttonTotal btnLapPhieu;
	private buttonTotal btnXoa;
	private JPanel boxButton1;
	private buttonTotal btnXoaTatCa;
	private buttonTotal btnDoiNCC;
	public buttonTotal btnQLDV;
	private PhieuNhapHang_DAO phieuNhapHang_dao;

	public panelNhapHang (trangHoaDon trangHoaDon) {
        
        d = new functionNecessary(); 
        Font fontBtn = new Font("Arial", 0 , 17);
        String color3 = "#6dd5ed", color4 = "#2193b0";
        setPreferredSize(new Dimension(650, 750));
        setBackground(Color.white);
        
        
        String[] header = {"#", "Tên Dịch Vụ", "Số Lượng", "Giá Bán", "Thành Tiền"} ;
		table = new table(header);
		table.setPreferredSize(new Dimension(630, 570));
		title = new titleNhapHang();
		
		btnLapPhieu= new buttonTotal(" Lập Phiếu", "hinh/button/btn_LapHoaDon.png");
		btnQLDV = new buttonTotal(" Đến QLDV", "hinh/button/btn_LapHoaDon.png");
        btnXoa = new buttonTotal(" Xóa Dịch Vụ", "hinh/button/btn_Xoa.png");
        btnXoaTatCa = new buttonTotal(" Xóa Tất Cả", "hinh/button/btn_Xoa.png");
        btnXoa.setColor1("#EECDA3");
        btnXoa.setColor2("#EF629F");
        btnXoaTatCa.setColor1("#EECDA3");
        btnXoaTatCa.setColor2("#EF629F");
        phieuNhapHang_dao = new PhieuNhapHang_DAO();
        
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(title);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(table);
        add(Box.createRigidArea(new Dimension(0, 20)));
        boxButton1 = new JPanel();
        boxButton1.setBackground(null);
        add (boxButton1);
        setButton();
 
        
        if (btnXoa.getActionListeners().length == 0) {
        	btnXoa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					title.tongtien -= Integer.parseInt( d.formatString((String) table.table.getModel().getValueAt(table.getSelectedRow(), 4)));
					title.lbl1.setText("Tổng Tiền : " + d.formatMoney(title.tongtien));
					table.removeRow(row);
					reSetSTT();
				}
			});
        }
        if (btnXoaTatCa.getActionListeners().length == 0) {
        	btnXoaTatCa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int a = JOptionPane.showConfirmDialog(null, "Xác Nhận Xóa Tất Cả ? ");
					if (a == JOptionPane.YES_OPTION) {
						table.removeAll();
						reSetSTT();
						title.tongtien = 0;
						title.lbl1.setText("Tổng Tiền : " + d.formatMoney(title.tongtien));
					}
				}
			});
        }
        
        if (btnLapPhieu.getActionListeners().length == 0) {
        	btnLapPhieu.addActionListener(new ActionListener() {
				private NhaCungCap_DAO nhaCungCap_dao;
				private ArrayList<NhaCungCap> dsNCC;
				private DichVu_Dao dichVu_dao;
				private ArrayList<DichVu> dvDV;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (table.getRowCount() > 0) {
						int a = JOptionPane.showConfirmDialog(null, "Xác Nhận Lập Phiếu Nhập Hàng ? ");
						if (a == JOptionPane.YES_OPTION) {
							String maPhieu = "";
							String thoiGian = title.time;
							int soLuong = 0;
							for (int i =0; i< table.getRowCount(); i++) {
								soLuong +=  Integer.parseInt((String) table.table.getModel().getValueAt(i, 2));
							}
							String tongTien = d.formatMoney(title.tongtien);
							System.out.println(tongTien);
							NhaCungCap ncc1 = null;
							nhaCungCap_dao = new NhaCungCap_DAO();
						    dsNCC=nhaCungCap_dao.getAllNhaCungCap();
					        for (NhaCungCap ncc: dsNCC) {
					            if (ncc.getTenNhaCungCap().equals(title.cboNCC.getSelectedItem()+"")) {
					            	ncc1 = ncc;
					            }
					        }
					        PhieuNhapHang pp = new PhieuNhapHang(maPhieu, thoiGian, soLuong, tongTien, ncc1);
							if (phieuNhapHang_dao.create(pp)) {
								dichVu_dao = new DichVu_Dao();
								dvDV=dichVu_dao.getAllDichVu();
								for (int i =0; i< table.getRowCount(); i++) {
									for (DichVu dv : dvDV) {
							        	if (dv.getTenDichVu().equals(table.table.getModel().getValueAt(i, 1))) {
							        		dv.setSoLuongTon(dv.getSoLuongTon() + Integer.parseInt((String) table.table.getModel().getValueAt(i, 2)));
							        		if (dichVu_dao.update(dv)) {
							        			for (buttonListPhong z : trangHoaDon.listPhong.listPhong) {
											    	for (buttonListDichVu t : z.panelHoaDon.listDichVuMini.listDichVu) {
											    		if (dv.getTenDichVu().equals(t.name)) {
											    			t.amountTon = dv.getSoLuongTon();
											    			t.Amount.setText("Còn : " + t.amountTon);
											    		}
											    	}
											    }
							        		}
							        	}
							        }
								}
								table.removeAll();
								reSetSTT();
								title.tongtien = 0;
								title.lbl1.setText("Tổng Tiền : " + d.formatMoney(title.tongtien));
								JOptionPane.showMessageDialog(null, "Lập Phiếu Nhập Hàng Thành Công");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Dịch Vụ");
					}
				}
			});
        }
    }
	public void setButton () {
		boxButton1.add(btnLapPhieu);
		boxButton1.add(btnQLDV);
		boxButton1.add(btnXoa);
		boxButton1.add(btnXoaTatCa);
    }
	public void reSetSTT () {
		for (int i =0; i < table.getRowCount(); i++) {
			table.table.getModel().setValueAt(i+1, i, 0);
		}
	}
}
