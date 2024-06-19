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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.form.formNhapPhong;
import content.hoa_don.buttonListPhong;
import content.hoa_don.titleHoaDon;
import content.hoa_don.trangHoaDon;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangQLP implements MouseListener{
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapPhong panel;
	private Phong_DAO phong_dao;
    private LoaiPhong_DAO loaiPhong_dao;
    private ArrayList<Phong> dsP;
    private trangHoaDon trangHoaDon;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn, trangHoaDon trangHoaDon) {
		this.trangHoaDon = trangHoaDon;
		panel = new formNhapPhong("QLP");
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
		
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		
		docDuLieuLoaiPhong();
		docDuLieuPhong();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if (panel.txtTenP.getText().length() != 0 && panel.txtGiaP.getText().length() != 0 && panel.cboLP.getSelectedItem().toString() != "Không") {	
			    if(validDataQuanLiP() ) {
			        String maP=panel.txtMaP.getText();
		            String tenP=panel.txtTenP.getText();
		            int giaP=Integer.parseInt(panel.txtGiaP.getText());
		            String lp=panel.cboLP.getSelectedItem().toString();
		            
		            String ma = null;
		            ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
		            for (LoaiPhong lp1 : dsLP) {
		                if (lp1.getTenLoaiPhong().equals(panel.cboLP.getSelectedItem().toString())) {
		                    ma = lp1.getMaLoaiPhong();
		                }
		            }
		            dsP=phong_dao.getAllPhong();
		            LoaiPhong lpB= new LoaiPhong(ma);
		            Phong p=new Phong(maP, tenP, lpB, giaP + "");
		            if(phong_dao.create(p, dsP.size() + 1)) {
		                pane.removeAll();
		                docDuLieuPhong();
		                dsP=phong_dao.getAllPhong();
		                XoaTrang();
		                buttonListPhong btnNewPhong = new buttonListPhong(tenP,"", lp,giaP + "", trangHoaDon.listKhachHang, trangHoaDon.listDichVu, trangHoaDon.listPhong);
		                trangHoaDon.listPhong.listPhong.add(btnNewPhong);
		                trangHoaDon.listPhong.add(btnNewPhong);
		                trangHoaDon.listPhong.repaint();
		                trangHoaDon.addEventBTNPhong();
		                trangHoaDon.listPhong.addEvent();
		                trangHoaDon.setHeightListObject ();
		            }
			    }
		   
		  } else {
		        JOptionPane.showMessageDialog(null, "Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
		    }
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
		    	for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
	            	if (x.name.equals(pane.table.getValueAt(r, 1).toString())) {
	            		trangHoaDon.listPhong.remove(x);
			            trangHoaDon.listPhong.listPhong.remove(x);
	            		trangHoaDon.listPhong.repaint();
	            		break;
	            	}
	            }
	            String ma=pane.table.getValueAt(r, 0).toString();
	            Phong p=new Phong(ma);
	            phong_dao.delete(p);
	            pane.removeRow(r);
	            dsP=phong_dao.getAllPhong();
	            trangHoaDon.setHeightListObject ();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
		
		if (obj.equals(panel.btnSua)) {
			if (pane.table.getSelectedRow() > -1) {
				if (panel.txtTenP.getText().length() != 0 && panel.txtGiaP.getText().length() != 0 && panel.cboLP.getSelectedItem().toString() != "Không") {
					 if(validDataQuanLiP() ) {
						LuuDuLieuSua();
						XoaTrang();
					 }
				} else {
			        JOptionPane.showMessageDialog(null, "Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
			    }
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Phòng Trong Danh Sách");
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
					row_x.put("ma_P", pane.table.getModel().getValueAt(stt, 0).toString());
					row_x.put("ten_P", pane.table.getModel().getValueAt(stt, 1).toString());
					row_x.put("gia_P", pane.table.getModel().getValueAt(stt, 2).toString());
					row_x.put("loai_p", pane.table.getModel().getValueAt(stt, 3).toString());
					
					datax.add(row_x);
				}
				JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
				String sourceName="src/Report/DS_Phong.jrxml";
				
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

		
	

	private boolean validDataQuanLiP() {
		String tenP=panel.txtTenP.getText().trim();
		 String giaP=panel.txtGiaP.getText().trim();
		 
		 String  mau1 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
        Pattern chuoi1 = Pattern.compile(mau1);
	 	 Matcher m1 = chuoi1.matcher(tenP);
	 	 
	 		if (m1.matches() == false) {
	 			if (tenP.substring(0,1).equals("Đ")) {
	 				return true;
	 			}
	 			JOptionPane.showMessageDialog(null,"Tên Phòng Viết Hoa Chữ Cái Đầu Có Thể Dùng Số");
	 			
	 			return false;
	 		} 
	 		String  mau2 = "(^[1-9]+)([0-9])*";
	         Pattern chuoi2 = Pattern.compile(mau2);
		 	 Matcher m2 = chuoi2.matcher(giaP);
		 	if (m2.matches() == false) {
	 			JOptionPane.showMessageDialog(null,"Giá Phòng Phải Lớn Hơn 0 Và Chỉ Dùng Số");
	 			
	 			return false;
	 		} 	 	
		return true;
	}

	private void XoaTrang() {
		panel.txtMaP.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenP.setText("");
		panel.txtGiaP.setText("");
		panel.cboLP.setSelectedItem("Không");
		
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
	public void SuaDuLieu() {
	    functionNecessary d = new functionNecessary();
		panel.txtMaP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.txtTenP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.txtGiaP.setText(d.formatString((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2)));
		panel.cboLP.setSelectedItem((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row = pane.getSelectedRow();
        
        String maP=panel.txtMaP.getText();
        String tenP=panel.txtTenP.getText();
        int giaP=Integer.parseInt(panel.txtGiaP.getText());
        String lp=panel.cboLP.getSelectedItem().toString();
        
        String ma = null;
        ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp1 : dsLP) {
            if (lp1.getTenLoaiPhong().equals(panel.cboLP.getSelectedItem().toString())) {
                ma = lp1.getMaLoaiPhong();
            }
        }
        
        LoaiPhong lpB= new LoaiPhong(ma);
        Phong p=new Phong(maP, tenP, lpB, giaP+"");
        if(phong_dao.update(p)) {
     
            for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
            	if (x.name.equals(pane.table.getModel().getValueAt(pane.getSelectedRow(), 1).toString())) {
            		x.name = tenP;
            		x.type = lp;
            		x.label.setText("   " + x.name);
            		x.panelHoaDon.title.infoPhong.setText(x.name);
            		
            		if (x.type.equals("Phòng Thường")) {
            			x.panelHoaDon.title.infoPhong.setText(x.name + " - Phòng Thường");
                    } else if (x.type.equals("Phòng VIP")) {
                    	x.panelHoaDon.title.infoPhong.setText(x.name + " - Phòng VIP");
                    }
            		
            		trangHoaDon.listPhong.UpdatePhongDangSuDung();
            		break;
            	}
            }
            pane.removeRow(row);
            pane.removeAll();
            docDuLieuPhong();
            XoaTrang();
            
        }
	}
	
	public void docDuLieuLoaiPhong() {
        ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp : dsLP) {
            panel.cboLP.addItem(lp.getTenLoaiPhong());
        }
    }
	
	public void docDuLieuPhong() {
        dsP=phong_dao.getAllPhong();
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
