package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.hoa_don.buttonListDichVu;
import content.hoa_don.buttonListPhong;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuPage;
import dao.DichVu_Dao;
import dao.LoaiDichVu_DAO;
import entity.DichVu;
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

public class trangQLDV implements MouseListener{
	public table pane;
	private JFrame frame;
	private Dimension dim;
	private Dimension screenSize;
	private menuPage menuPage;
	private formNhapDichVu panel;
	private DichVu_Dao dichVu_dao;
    private String ncc1; 
    private String ldv1;
    private LoaiDichVu_DAO LoaiDichVu_DAO;
    private ArrayList<DichVu> dvDV;
    private trangHoaDon trangHoaDon;
    private String nameEmploy;
    
	public void RenderUIQuanLi (Box totalBox, Font fontBtn,String color1, String color2, trangHoaDon trangHoaDon, JFrame frame, String nameEmploy) {
		this.trangHoaDon =trangHoaDon;
		this.nameEmploy = nameEmploy;
		// add table
		panel = new formNhapDichVu("QLDV");
		totalBox.add(panel);
		
		String[] header = {"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Tiền", "Số Lượng Tồn", "Loại Dịch Vụ", "Nhà Cung Cấp", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		totalBox.add(pane); 
		dichVu_dao =new DichVu_Dao();
		pane.setPreferredSize(new Dimension(1200, 400));
		docDuLieuDichVu();
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
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
	    for (DichVu dv : dvDV) { 
	    	if (dv.getMaDichVu().equals((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0))) {
	    		panel.txtMaDV.setText(dv.getMaDichVu());
	    		panel.txtTenDV.setText(dv.getTenDichVu());
	    		panel.txtGiaDV.setText(d.formatString(dv.getGia() + ""));
	    		panel.txtMoTaDV.setText(dv.getMoTa());
	    		
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
		        
		        panel.cboLoaiDV.setSelectedItem(tenLDV);
	    		panel.cboNCC.setSelectedItem(tenNCC);
	    		panel.txtSoLuongTon.setText(dv.getSoLuongTon()+ "");
	    		panel.txtAnh.setText(dv.getAnhDichVu());
	    		break;
	    	}
	    }
	
	}
	public void LuuDuLieuSua () {
	    if (panel.cboNCC.getSelectedItem().toString() != "Không" && panel.cboLoaiDV.getSelectedItem().toString() != "Không") {
    	    functionNecessary d = new functionNecessary();
            int row = pane.getSelectedRow();
            String maDV=panel.txtMaDV.getText();
            String tenDV=panel.txtTenDV.getText();
            int gia =Integer.parseInt(panel.txtGiaDV.getText());
            String mota=panel.txtMoTaDV.getText();
            for (NhaCungCap ncc : panel.dsNCC) {
                if (ncc.getTenNhaCungCap().equals(panel.cboNCC.getSelectedItem().toString())) {
                    ncc1= ncc.getMaNhaCungCap();
                }
            }
            for (LoaiDichVu ldv : panel.dsLDV) {
                if (ldv.getTenLoaiDichVu().equals(panel.cboLoaiDV.getSelectedItem().toString())) {
                    ldv1 = ldv.getMaLoaiDichVu();
                }
            }
            
            LoaiDichVu ldvB=new LoaiDichVu(ldv1);
            NhaCungCap nccB=new NhaCungCap(ncc1);
            int soLuongTon = Integer.parseInt(panel.txtSoLuongTon.getText());
            String imageLink = panel.txtAnh.getText();
            DichVu dv=new DichVu(maDV, tenDV, mota, ldvB, nccB,soLuongTon, gia, imageLink);
            if(dichVu_dao.update(dv)) {
            	for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
			    	for (buttonListDichVu y : x.panelHoaDon.listDichVuMini.listDichVu) {
			    		if (y.name.equals(pane.table.getValueAt(row, 1).toString())) {

			    			y.name = tenDV;
			    			y.price = gia + "";
			    			y.amount = soLuongTon;
			    			y.title.setText(y.name);
			    			y.Amount.setText("Còn : " + y.amount);
			    			y.Price.setText(d.formatMoney(Integer.parseInt(y.price)));
	                		y.image.setIcon(new ImageIcon(imageLink));
			    			break;
			    		}
			    	}
			    }
            	pane.removeRow(row);
                pane.removeAll();
                docDuLieuDichVu();
                XoaTrang();
            }
	    } else {
	        JOptionPane.showMessageDialog(null,"Vui Lòng Chọn Nhà Cung Cấp và Loại Dịch Vụ");
	    }
    }
	public void XoaTrang () {
		panel.txtMaDV.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenDV.setText("");
		panel.txtGiaDV.setText("");
		panel.txtMoTaDV.setText("");
		panel.cboLoaiDV.setSelectedIndex(0);
		panel.cboNCC.setSelectedIndex(0);
		panel.txtAnh.setText("");
		panel.txtSoLuongTon.setText("");
	}
	public void docDuLieuDichVu() {
        dvDV=dichVu_dao.getAllDichVu();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj.equals(panel.btnThem)) { 
        	if(panel.txtTenDV.getText().length() !=0  && panel.txtGiaDV.getText().length() !=0 && panel.txtSoLuongTon.getText().length() !=0
        			&& panel.cboLoaiDV.getSelectedItem().toString() != "Không"
        			&& panel.cboNCC.getSelectedItem().toString() != "Không") {
	        	if(validDataQuanLiDV()) {	        		
			            functionNecessary d = new functionNecessary();
			            String maDV=panel.txtMaDV.getText();
			            String tenDV=panel.txtTenDV.getText();		            
			            int gia =Integer.parseInt(panel.txtGiaDV.getText());		            
			            String mota=panel.txtMoTaDV.getText();
			            for (NhaCungCap ncc : panel.dsNCC) {
			                if (ncc.getTenNhaCungCap().equals(panel.cboNCC.getSelectedItem().toString())) {
			                    ncc1= ncc.getMaNhaCungCap();
			                }
			            }
			            for (LoaiDichVu ldv : panel.dsLDV) {
			                if (ldv.getTenLoaiDichVu().equals(panel.cboLoaiDV.getSelectedItem().toString())) {
			                    ldv1 = ldv.getMaLoaiDichVu();
			                }
			            }
			            
			            int soLuongTon = Integer.parseInt(panel.txtSoLuongTon.getText());
			            
			            String imageLink = panel.txtAnh.getText();
			            LoaiDichVu ldvB=new LoaiDichVu(ldv1);
			            NhaCungCap nccB=new NhaCungCap(ncc1);
			            DichVu dv=new DichVu(maDV, tenDV, mota, ldvB, nccB,soLuongTon, gia, imageLink);
			            if(dichVu_dao.create(dv)) {
			                pane.removeAll();
			                docDuLieuDichVu();
			                dvDV=dichVu_dao.getAllDichVu();
			                XoaTrang();
			                buttonListDichVu btnNewDichVu = new buttonListDichVu("",tenDV,0 + "",gia + "");
			                for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
			                	x.panelHoaDon.listDichVuMini.removeAll();
			                	x.panelHoaDon.listDichVuMini.listDichVu.removeAll(x.panelHoaDon.listDichVuMini.listDichVu);
			                	x.panelHoaDon.listDichVuMini.docDuLieuDichVu();
			                	x.panelHoaDon.listDichVuMini.RenderListDichVu();
			                	x.panelHoaDon.listDichVuMini.repaint();
			                	trangHoaDon.addEventBTNDichVu();
			                	trangHoaDon.setHeightListObject();
			                } 
			            }
	        		
	        		
	        	}
	        }
        	else {
		        JOptionPane.showMessageDialog(null, "Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
		    }      	
        }

        if (obj.equals(panel.btnSua)) {
        	if (pane.table.getSelectedRow() > -1) {
	        	if(panel.txtTenDV.getText().length() !=0  && panel.txtGiaDV.getText().length() !=0 && panel.txtSoLuongTon.getText().length() !=0
	        			&& panel.cboLoaiDV.getSelectedItem().toString() != "Không"
	        			&& panel.cboNCC.getSelectedItem().toString() != "Không") {
		        	if(validDataQuanLiDV()) {
			            LuuDuLieuSua();
			            XoaTrang();
		        	}
	        	}else {
			        JOptionPane.showMessageDialog(null, "Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
			    }
        	} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Dịch Vụ Trong Danh Sách");
			}
        }
        if (obj.equals(panel.btnXoa)) {
            if (pane.getSelectedRow() >= 0) {
                int r=pane.getSelectedRow();
                for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
			    	for (buttonListDichVu y : x.panelHoaDon.listDichVuMini.listDichVu) {
			    		if (y.name.equals(pane.table.getValueAt(r, 1).toString())) {
			    			x.panelHoaDon.listDichVuMini.remove(y);
			    			x.panelHoaDon.listDichVuMini.listDichVu.remove(y);
			    			x.panelHoaDon.listDichVuMini.repaint();
			    			break;
			    		}
			    	}
			    }
                String ma=pane.table.getValueAt(r, 0).toString();
                DichVu dv=new DichVu(ma);
                dichVu_dao.delete(dv);
                pane.removeRow(r);
                dvDV=dichVu_dao.getAllDichVu();
                trangHoaDon.setHeightListObject();
                XoaTrang();
            } else {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
            }
        }
        if (obj.equals(pane.table)) {
            SuaDuLieu();
        }
        if (obj.equals(panel.btnIn)) {
        	
			List<Map<String,?>> datax =new ArrayList<Map<String, ?>>();
			Map<String,Object> row_main = new HashMap<String,Object>();
			row_main.put("ten", nameEmploy);
			
			int row = pane.getRowCount();
//			datax.add(row_main);
			for ( int stt = 0 ; stt < row ; stt++) {
				Map<String,Object> row_x = new HashMap<String,Object>();
				row_x.put("ma_DV", pane.table.getModel().getValueAt(stt, 0).toString());
				row_x.put("ten_DV", pane.table.getModel().getValueAt(stt, 1).toString());
				row_x.put("gia_tien", pane.table.getModel().getValueAt(stt, 2).toString());
				row_x.put("so_luong_ton", pane.table.getModel().getValueAt(stt, 3).toString());
				row_x.put("loai_dich_vu", pane.table.getModel().getValueAt(stt, 4).toString());
				row_x.put("nha_cung_cap", pane.table.getModel().getValueAt(stt, 5).toString());
				datax.add(row_x);
			}
			JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
			String sourceName="src/Report/DS_Dich_Vu.jrxml";
			
			try {
                JasperReport rp = JasperCompileManager.compileReport(sourceName);
                JasperPrint filledReport=JasperFillManager.fillReport(rp, null,jrsource);
                JasperViewer jw=new JasperViewer(filledReport, false);
                jw.setVisible(true);
                
            } catch (JRException ex) {
               ex.printStackTrace(); 
            }
        
        }
        if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
        
    }

	private boolean validDataQuanLiDV() {
		
		 String tenDV=panel.txtTenDV.getText().trim();
		 String giaDV=panel.txtGiaDV.getText().trim();
		 String soLuongDV=panel.txtSoLuongTon.getText().trim();
		 					
		 	 String  mau1 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
	         Pattern chuoi1 = Pattern.compile(mau1);
		 	 Matcher m1 = chuoi1.matcher(tenDV);
		 	 
		 		if (m1.matches() == false) {
		 			if (tenDV.substring(0,1).equals("Đ")) {
		 				return true;
		 			}
		 			JOptionPane.showMessageDialog(null,"Tên Dịch Vụ Viết Hoa Chữ Cái Đầu Có Thể Dùng Số");
		 			return false;
		 		} 
		 		
	 		 String  mau2 = "(^[1-9]+)([0-9])*";
	         Pattern chuoi2 = Pattern.compile(mau2);
		 	 Matcher m2 = chuoi2.matcher(giaDV);
		 	if (m2.matches() == false) {
	 			JOptionPane.showMessageDialog(null,"Giá Dịch Vụ Phải Lớn Hơn 0 Và Chỉ Dùng Số");
	 			
	 			return false;
	 		} 
		 	 	
	 		 String  mau3 = "(^[1-9]+)([0-9])*";
	         Pattern chuoi3 = Pattern.compile(mau3);
		 	 Matcher m3 = chuoi3.matcher(soLuongDV);
		 	if (m3.matches() == false ) {
	 			JOptionPane.showMessageDialog(null,"Số Lượng Phải Lớn Hơn 0 Và Chỉ Dùng Số");
	 			
	 			return false;
	 		} 
		 	
		return true;
	}
}
