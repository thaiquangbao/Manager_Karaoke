package content.Phong;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.form.formNhapPhong;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;

public class trangTCP implements ActionListener {
	private table pane;
	private customButton btnTim;
	private customButton btnTaiTrang;
	private formNhapPhong panel;
	private ArrayList<Object[]> ds;
	private LoaiPhong_DAO loaiPhong_dao;
    private Phong_DAO phong_dao;
	private functionNecessary d;
	public void RenderUITraCuu (Box totalBox, Font fontBtn) {
		panel = new formNhapPhong("TCP");
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Phòng", "Tên Phòng","Giá Phòng", "Loại Phòng"} ;
		pane = new table(header);
		totalBox.add(pane);
		phong_dao=new Phong_DAO();
        loaiPhong_dao=new LoaiPhong_DAO();
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnTim = new customButton("Tìm Nhân Viên",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		
		boxBtn.add(btnTim);
		boxBtn.add(Box.createRigidArea(new Dimension(20,0)));
		boxBtn.add(btnTaiTrang);

		panel.btnTim.addActionListener(this);
		panel.btnXoaTrang.addActionListener(this);
		panel.btnTaiTrang.addActionListener(this);
		if (panel.btnTaiTrang.getActionListeners().length == 0) {
			panel.btnTaiTrang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					docDuLieuPhong();
				}
			});
		}
		docDuLieuLoaiPhong();
        docDuLieuPhong();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnTim)) {
			if(panel.txtTenP.getText().length()!=0 || panel.txtGiaP.getText().length()!=0 ||  panel.cboLP.getSelectedItem().toString() != "Không") {
	        docDuLieuPhong();
	        d = new functionNecessary();
			int row = pane.getRowCount();
			ds = new ArrayList<Object[]>();
			int amount = 0;
			for (int i = 0; i< row; i ++) {
				int x = 0, y = 0;
				if (panel.txtTenP.getText().length() != 0) {
					x++;
					if (pane.table.getValueAt(i,1).toString().trim().toUpperCase().contains(panel.txtTenP.getText().trim().toUpperCase())) {
						y ++;
					}
				}
				if (panel.txtGiaP.getText().length() != 0) {
					x++;
					if (d.formatString(pane.table.getValueAt(i,2).toString().trim().toUpperCase()).contains(panel.txtGiaP.getText().trim().toUpperCase())) {
						y ++;
					}
				}
				if (panel.cboLP.getSelectedItem() != "Không") {
					x ++;
					if (panel.cboLP.getSelectedItem().toString().contains(pane.table.getValueAt(i,3).toString())) {
						y++;
					}
				}
				if (x == y) {
					ds.add(new Object[] {pane.table.getValueAt(i, 0),pane.table.getValueAt(i,1), pane.table.getValueAt(i,2), pane.table.getValueAt(i,3)});
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
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();
        }
		if (obj.equals(panel.btnTaiTrang)) {
			XoaTrang();
			docDuLieuPhong();
		}
	} 
	private void XoaTrang() {
		panel.txtMaP.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenP.setText("");
		panel.txtGiaP.setText("");
		panel.cboLP.setSelectedItem("Không");
		
	}


	public void TableRemoveAll () {
		DefaultTableModel dm = (DefaultTableModel) pane.table.getModel();
		int rowCount = pane.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	public void docDuLieuLoaiPhong() {
        ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp : dsLP) {
            panel.cboLP.addItem(lp.getTenLoaiPhong());
        }
    }
    
    public void docDuLieuPhong() {
    	TableRemoveAll();
        ArrayList<Phong> dsP=phong_dao.getAllPhong();
        for (Phong p : dsP) {
            functionNecessary d = new functionNecessary();
            String ten = null;
            ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
            for (LoaiPhong lp : dsLP) {
                if (lp.getMaLoaiPhong().equals(p.getLoaiPhong().getMaLoaiPhong())) {
                    ten = lp.getTenLoaiPhong();
                }
            }
            pane.addRow(new Object[] {p.getMaPhong(),p.getTenPhong(),d.formatMoney(Integer.parseInt(p.getGiaPhong())),ten});
        }
    }
	
}
