package content.DichVu;

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

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import dao.DichVu_Dao;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.NhaCungCap;

public class trangTCDV implements ActionListener{
	private table pane;
	private customButton btnTim;
	private customButton btnTaiTrang;
	private JFrame frame;
	private Object[] rowTable;
	private ArrayList<Object[]> ds;
	private formNhapDichVu panel;
    private DichVu_Dao dichVu_dao;
	private ArrayList<DichVu> dvDV;
	private functionNecessary d;
	public void RenderUITraCuu (Box totalBox, Font fontBtn) {
	    dichVu_dao =new DichVu_Dao();
		panel = new formNhapDichVu("TCDV");
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Tiền", "Số Lượng Tồn", "Loại Dịch Vụ", "Nhà Cung Cấp", "Mô Tả"} ;
		pane = new table(header);
		pane.setPreferredSize(new Dimension(1200, 400));
		totalBox.add(pane);
		
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnTim = new customButton("Tìm Dịch Vụ",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);
		
		panel.btnTim.addActionListener(this);
		panel.btnXoaTrang.addActionListener(this);
		panel.btnTaiTrang.addActionListener(this);
		docDuLieuDichVu();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnTim)) {
			if(panel.txtTenDV.getText().length() !=0  || panel.txtGiaDV.getText().length() !=0 || panel.txtSoLuongTon.getText().length() !=0
        			|| panel.cboLoaiDV.getSelectedItem().toString() != "Không"
        			|| panel.cboNCC.getSelectedItem().toString() != "Không") {
				docDuLieuDichVu();
				int row = pane.getRowCount();
				ds = new ArrayList<Object[]>();
				int amount = 0;
				for (int i = 0; i< row; i ++) {
					int x = 0, y = 0;
					d = new functionNecessary();
					if (panel.txtTenDV.getText().length() != 0) {
						x++;
						if (pane.table.getValueAt(i,1).toString().trim().toUpperCase().contains(panel.txtTenDV.getText().trim().toUpperCase())) {
							y ++;
						}
					}
					if (panel.txtGiaDV.getText().length() != 0) {
						x++;
						if (d.formatString(pane.table.getValueAt(i,2).toString().trim().toUpperCase()).contains(panel.txtGiaDV.getText().trim().toUpperCase())) {
							y ++;
						}
					}
					if (panel.cboLoaiDV.getSelectedItem() != "Không") {
						x ++;
						if (panel.cboLoaiDV.getSelectedItem().toString().contains(pane.table.getValueAt(i,4).toString())) {
							y++;
						}
					}
					if (panel.cboNCC.getSelectedItem() != "Không") {
						x ++;
						if (panel.cboNCC.getSelectedItem().toString().contains(pane.table.getValueAt(i,5).toString())) {
							y++;
						}
					}
					if (panel.txtSoLuongTon.getText().length() != 0) {
						x ++;
						if (pane.table.getValueAt(i,3).toString().trim().toUpperCase().contains(panel.txtSoLuongTon.getText().trim().toUpperCase())) {
							y++;
						}
					}
					if (x == y) {
						ds.add(new Object[] {pane.table.getValueAt(i, 0),pane.table.getValueAt(i,1), pane.table.getValueAt(i,2), pane.table.getValueAt(i,3)
								, pane.table.getValueAt(i, 4), pane.table.getValueAt(i, 5)});
						amount ++;
					}
				}
				TableRemoveAll();
				for (Object[] x : ds) {
					pane.addRow(x);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Dử Liệu Cần Tìm");
			}
		}
		if (obj.equals(panel.btnTaiTrang)) {
			XoaTrang();
			docDuLieuDichVu();
		}
		if (obj.equals(panel.btnXoaTrang)) {
			XoaTrang();
		}
	}
	private void XoaTrang() {
		panel.txtMaDV.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenDV.setText("");
		panel.txtGiaDV.setText("");
		panel.txtMoTaDV.setText("");
		panel.cboLoaiDV.setSelectedIndex(0);
		panel.cboNCC.setSelectedIndex(0);
		panel.txtSoLuongTon.setText("");
		
	}
	public void TableRemoveAll () {
		DefaultTableModel dm = (DefaultTableModel) pane.table.getModel();
		int rowCount = pane.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	public void docDuLieuDichVu() {
        dvDV=dichVu_dao.getAllDichVu();
        pane.removeAll();
        for (DichVu dv : dvDV) {
			functionNecessary d = new functionNecessary();
			String tenNCC = null, tenLDV = null;
			for (NhaCungCap ncc : panel.dsNCC) {
	            if (ncc.getMaNhaCungCap().equals(dv.getNhaCungCap().getMaNhaCungCap())) {
	                tenNCC = ncc.getTenNhaCungCap();
	            }
	        }
	        for (LoaiDichVu ldv : panel.dsLDV) {
	            if (ldv.getMaLoaiDichVu().equals(dv.getLoaiDichVu().getMaLoaiDichVu())) {
	                tenLDV = ldv.getTenLoaiDichVu();
	            }
	        }
            pane.addRow(new Object[] {dv.getMaDichVu(),dv.getTenDichVu(),d.formatMoney(dv.getGia()),dv.getSoLuongTon(),tenLDV,tenNCC, dv.getMoTa()});
        }
        
    }
	
}
