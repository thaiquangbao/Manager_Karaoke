package content.Phong;

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

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import content.customButton;
import content.table;
import content.form.formNhapLoaiPhong;
import dao.LoaiPhong_DAO;
import entity.LoaiPhong;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangLP implements ActionListener, MouseListener{
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private formNhapLoaiPhong panel;
	private JFrame frame;
	private LoaiPhong_DAO loaiPhong_dao;
    private ArrayList<LoaiPhong> dsLP;
	public void RenderUILoaiDichVu (Box totalBox, Font fontBtn) {
		panel = new formNhapLoaiPhong();
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Loại Phòng", "Tên Loại Phòng", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(pane);
		loaiPhong_dao=new LoaiPhong_DAO();
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		docDuLieuLoaiPhong();
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if(panel.txtTenLP.getText().length() != 0  ) {
			if( panel.txtTenLP.getText().equals("Phòng VIP")|| panel.txtTenLP.getText().equals("Phòng Thường")) {
		    String maLP=panel.txtMaLP.getText();
		    
            String tenLP=panel.txtTenLP.getText();
            String mota=panel.txtMoTaLP.getText();
            LoaiPhong lp=new LoaiPhong(maLP, tenLP, mota);
            if(loaiPhong_dao.create(lp, dsLP.size() + 1)) {
                pane.removeAll();
                docDuLieuLoaiPhong();
                dsLP=loaiPhong_dao.getAllLoaiPhong();
                XoaTrang();
            }
		  }else {
				
				JOptionPane.showMessageDialog(null, "Chỉ có 2 loại Phòng là : Phòng VIP Và Phòng Thường");
			
		}
			}
			else {
				
					JOptionPane.showMessageDialog(null, "Nhập Loại Phòng ");
				
			}
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            LoaiPhong lp=new LoaiPhong(ma);
	            loaiPhong_dao.delete(lp);
	            pane.removeRow(r);
	            dsLP=loaiPhong_dao.getAllLoaiPhong();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
		
		if (obj.equals(panel.btnSua)) {
			if (pane.table.getSelectedRow() > -1) {
				if(panel.txtTenLP.getText().length() != 0  ) {
					if( panel.txtTenLP.getText().equals("Phòng VIP")|| panel.txtTenLP.getText().equals("Phòng Thường")) {
						LuuDuLieuSua();
						XoaTrang();
					}else {						
						JOptionPane.showMessageDialog(null, "Chỉ có 2 loại Phòng là : Phòng VIP Và Phòng Thường");}									
					}
					else {					
							JOptionPane.showMessageDialog(null, "Nhập Loại Phòng ");}												
			} else  {
				JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Loại Phòng Trong Danh Sách");
			}			
		}
		if (obj.equals(pane.table)) {
			SuaDuLieu();
		}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
		 if (obj.equals(panel.btnIn)) {
	        	
				List<Map<String,?>> datax =new ArrayList<Map<String, ?>>();
				int row = pane.getRowCount();		
				for ( int stt = 0 ; stt < row ; stt++) {
					Map<String,Object> row_x = new HashMap<String,Object>();
					row_x.put("ma_LP", pane.table.getModel().getValueAt(stt, 0).toString());
					row_x.put("ten_LP", pane.table.getModel().getValueAt(stt, 1).toString());
					
					
					datax.add(row_x);
				}
				JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
				String sourceName="src/Report/DS_Loai_P.jrxml";
				
				try {
	                JasperReport rp = JasperCompileManager.compileReport(sourceName);
	                JasperPrint filledReport=JasperFillManager.fillReport(rp, null,jrsource);
	                JasperViewer jw=new JasperViewer(filledReport, false);
	                jw.setVisible(true);
	                
	            } catch (JRException ex) {
	               ex.printStackTrace(); 
	            }
		 }
	        
	}
	private void SuaDuLieu() {
		panel.txtMaLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.txtTenLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.txtMoTaLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		
	}
	private void LuuDuLieuSua() {
	    int row = pane.getSelectedRow();
        String maLP=panel.txtMaLP.getText();
        String tenLP=panel.txtTenLP.getText();
        String mota=panel.txtMoTaLP.getText();
        LoaiPhong lp=new LoaiPhong(maLP, tenLP, mota);
        if(loaiPhong_dao.update(lp)) {
            pane.removeAll();
            docDuLieuLoaiPhong();
            XoaTrang();
        }
		
	}
	private void XoaTrang() {
		panel.txtMaLP.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenLP.setText("");
		panel.txtMoTaLP.setText("");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void docDuLieuLoaiPhong() {
        dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp : dsLP) {
            pane.addRow(new Object[] {lp.getMaLoaiPhong(),lp.getTenLoaiPhong(),lp.getMoTa()});
        }
    }
}
