package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import content.customButton;
import content.table;
import content.form.formNhapLoaiDichVu;
import dao.LoaiDichVu_DAO;
import entity.LoaiDichVu;
import entity.NhaCungCap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangLDV implements ActionListener, MouseListener {
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapLoaiDichVu panel;
    private LoaiDichVu_DAO LoaiDichVu_DAO;
    private ArrayList<LoaiDichVu> dsLDV;
    
	public void RenderUILoaiDichVu (Box totalBox, Font fontBtn) {
		
		panel = new formNhapLoaiDichVu();
		
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Loại Dịch Vụ", "Tên Loại Dịch Vụ", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(pane);
		LoaiDichVu_DAO=new LoaiDichVu_DAO();
		docDuLieuLoaiDichVu();
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void SuaDuLieu() {
		panel.txtMaLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.txtTenLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.txtMoTaLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if(panel.txtTenLDV.getText().length() !=0) {
				if(validDataQuanLiDV()) {
			    String maLdv=panel.txtMaLDV.getText();
	            String tenLdv=panel.txtTenLDV.getText();
	            String moTa=panel.txtMoTaLDV.getText();
	            LoaiDichVu ldv=new LoaiDichVu(maLdv, tenLdv, moTa);
	            if(LoaiDichVu_DAO.create(ldv, dsLDV.size()+1)) {
	                pane.removeAll();
	                docDuLieuLoaiDichVu();
	                dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
	                XoaTrang();
	            }
			 }
		  }
			else {
				JOptionPane.showMessageDialog(null, "Không Được Để Trống ");
			}
		}
		if (obj.equals(panel.btnSua)) {
			if (pane.table.getSelectedRow() > -1) {
				if(panel.txtTenLDV.getText().length() !=0) {
					if(validDataQuanLiDV()) {
						LuuDuLieuSua();
						XoaTrang();
					}
				}
			else {
				JOptionPane.showMessageDialog(null, "Không Được Để Trống ");
			}			
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Loại Dịch Vụ Trong Danh Sách");
			}
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            LoaiDichVu ldv=new LoaiDichVu(ma);
	            LoaiDichVu_DAO.delete(ldv);
	            pane.removeRow(r);
	            dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
			if (obj.equals(panel.btnIn)) {
        	
			List<Map<String,?>> datay =new ArrayList<Map<String, ?>>();	
			int row = pane.getRowCount();
			
			for ( int stt1 = 0 ; stt1 < row ; stt1++) {
				Map<String,Object> row_y = new HashMap<String,Object>();
				row_y.put("ma_LDV", pane.table.getModel().getValueAt(stt1, 0).toString());
				row_y.put("ten_LDV", pane.table.getModel().getValueAt(stt1, 1).toString());
				
				datay.add(row_y);
			}
			JRDataSource jrsource = new JRBeanCollectionDataSource(datay);
			String sourceName="src/Report/DS_Loai_DV.jrxml";
			
			try {
                JasperReport rp = JasperCompileManager.compileReport(sourceName);
                JasperPrint filledReport=JasperFillManager.fillReport(rp, null,jrsource);
                JasperViewer jw=new JasperViewer(filledReport, false);
                jw.setVisible(true);
                
            } catch (JRException ex) {
               ex.printStackTrace(); 
            }
        
        }
		
		if (obj.equals(pane.table)) {
			SuaDuLieu();
		}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
		
        

        
	}

	private boolean validDataQuanLiDV() {
		 String tenLDV=panel.txtTenLDV.getText();
	        

	 	 String  mau1 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
        Pattern chuoi1 = Pattern.compile(mau1);
	 	 Matcher m1 = chuoi1.matcher(tenLDV);
	 	 
	 		if (m1.matches() == false) {
	 			if (tenLDV.substring(0,1).equals("Đ")) {
	 				return true;
	 			}
	 			JOptionPane.showMessageDialog(null,"Tên Loại Dịch Vụ Viết Hoa Chữ Cái Đầu Có Thể Dùng Số");
	 			
	 			return false;
	 		} 
		return true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void LuuDuLieuSua () {
	    int row=pane.getSelectedRow();
        String maLdv=panel.txtMaLDV.getText();
        String tenLdv=panel.txtTenLDV.getText();
        String moTa=panel.txtMoTaLDV.getText();
        LoaiDichVu ldv=new LoaiDichVu(maLdv, tenLdv, moTa);
        if(LoaiDichVu_DAO.update(ldv)) {
            pane.removeAll();
            docDuLieuLoaiDichVu();
        }
	}
	public void XoaTrang () {
		panel.txtMaLDV.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenLDV.setText("");
		panel.txtMoTaLDV.setText("");
	}
	public void docDuLieuLoaiDichVu() {
        dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
        for (LoaiDichVu ldv : dsLDV) {
            pane.addRow(new Object[] {ldv.getMaLoaiDichVu(),ldv.getTenLoaiDichVu(),ldv.getMoTa()});
        }
	}
}
