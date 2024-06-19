package content.KhachHang;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.form.formNhapKhachHang;
import dao.KhachHang_DAO;
import entity.KhachHang;
import content.hoa_don.buttonListKhachHang;
import content.hoa_don.buttonListPhong;
import content.hoa_don.listKhachHang;
import content.hoa_don.trangHoaDon;

public class trangTCKH implements ActionListener{
	private table pane;
	private customButton btnTim;
	private customButton btnTaiTrang;
	private JFrame frame;
	private Object[] rowTable;
	private ArrayList<Object[]> ds;
	private formNhapKhachHang panel;
	private KhachHang_DAO khachHang_dao;
	public Box box;
	private trangKhachHang trangKhachHang;
	private trangHoaDon trangHoaDon;
	private ArrayList<KhachHang> dsKH;
	private KhachHang k;
	public void RenderUITraCuu (Box totalBox, Font fontBtn, Box box, trangHoaDon trangHoaDon) {
		this.box = box;
		this.trangHoaDon = trangHoaDon;
		panel = new formNhapKhachHang("TCKH");
		k = new KhachHang();
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		panel.btnTim.addActionListener(this);
		panel.btnXoaTrang.addActionListener(this);
		panel.btnDatPhong.addActionListener(this);
		if (panel.btnTaiTrang.getActionListeners().length == 0) {
			panel.btnTaiTrang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					docDuLieuLoaiDichVu();
				}
			});
		}
		khachHang_dao=new KhachHang_DAO();
        docDuLieuLoaiDichVu();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnTim)) {
			if(panel.tfTenKH.getText().length() !=0  || panel.tfDiaChiKH.getText().length() !=0 || panel.tfSDTKH.getText().length() !=0) {	
				
				docDuLieuLoaiDichVu();
				int row = pane.getRowCount();
				ds = new ArrayList<Object[]>();
				int amount = 0;
				for (int i = 0; i< row; i ++) {
					int x = 0, y = 0;
					if (panel.tfTenKH.getText().length() != 0) {
						x++;
						if (pane.table.getValueAt(i,1).toString().trim().toUpperCase().contains(panel.tfTenKH.getText().trim().toUpperCase())) {
							y ++;
						}
					}
					if (panel.tfDiaChiKH.getText().length() != 0) {
						x++;
						if (pane.table.getValueAt(i,2).toString().trim().toUpperCase().contains(panel.tfDiaChiKH.getText().trim().toUpperCase())) {
							y ++;
						}	
					}
					if (panel.tfSDTKH.getText().length() != 0) {
						x++;
	
						if (pane.table.getValueAt(i,3).toString().trim().toUpperCase().contains(panel.tfSDTKH.getText().trim().toUpperCase())) {
							y ++;
						}
					}
	
					if (x == y) {
						ds.add(new Object[] {pane.table.getValueAt(i, 0),pane.table.getValueAt(i,1), pane.table.getValueAt(i,2), pane.table.getValueAt(i,3)
								});
								amount ++;
					}
				}
	
				if (amount != 0) {
					TableRemoveAll();
					for (Object[] x : ds) {
						pane.addRow(x);
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Dử Liệu Cần Tìm");
			}
				
	}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
		if (obj.equals(panel.btnDatPhong)) {
			if (pane.table.getSelectedRow() > -1) {
				box.remove(1);
				dsKH=khachHang_dao.getAllDSKhachHang();
			    for (KhachHang kh : dsKH) {
			    	if (kh.getMaKhachHang().equals(pane.table.getModel().getValueAt(pane.getSelectedRow(), 0).toString())) {
			    		trangHoaDon.kh = kh;
			    	}
			    }
		
				box.add(trangHoaDon);
				trangHoaDon.panelHoaDon1.type1 = "hoadon1";
				trangHoaDon.type1 = "hoadon1";
				trangHoaDon.panelHoaDon1.setButton();
				box.invalidate();
	        	box.validate();
	        	box.repaint();
	        	
	        	trangHoaDon.panelHoaDon1.btnTroVe.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						box.remove(1);
						trangKhachHang = new trangKhachHang("#5B86E5", "#FC466B", "TCKH", box, trangHoaDon);
						box.add(trangKhachHang);
						box.invalidate();
			        	box.validate();
			        	box.repaint();
					} 
				}); 
	        	
	        	for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
	        		x.panelHoaDon.btnTroVe.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							box.remove(1);
							trangKhachHang = new trangKhachHang("#5B86E5", "#FC466B", "TCKH", box, trangHoaDon);
							box.add(trangKhachHang);
							box.invalidate();
				        	box.validate();
				        	box.repaint();
						}
					});
	        	}
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Khách Hàng Trong Danh Sách");
			}
		}
	} 
	private void XoaTrang() {
		panel.tfMaKH.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenKH.setText("");
		panel.tfDiaChiKH.setText("");
		panel.tfSDTKH.setText("");
		
	}
	public void TableRemoveAll () {
		DefaultTableModel dm = (DefaultTableModel) pane.table.getModel();
		int rowCount = pane.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	public void docDuLieuLoaiDichVu() {
        ArrayList<KhachHang> dsKH=khachHang_dao.getAllDSKhachHang();
        pane.removeAll();
        for (KhachHang kh : dsKH) {
            pane.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getDiaChi(),kh.getSoDienThoai()});
        }
        
    }
	
}
