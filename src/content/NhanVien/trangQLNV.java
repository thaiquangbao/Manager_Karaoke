package content.NhanVien;

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

import content.customButton;
import content.table;
import content.form.formNhapNhanVien;
import content.menuPage.menuPage;
import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.NhanVien;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangQLNV implements MouseListener {
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private table pane;
	private JFrame frame;
	private formNhapNhanVien panel;
	private menuPage menuPage;
	private NhanVien_DAO nhanVien_dao;
	private ChucVu_DAO chucVu_dao;
    private String cv;
    private String cv1;
    private ArrayList<NhanVien> dsNV;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn) {
	    nhanVien_dao =new NhanVien_DAO();
	    chucVu_dao=new ChucVu_DAO();
		 panel = new formNhapNhanVien("QLNV");
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Số Điện Thoại", "Chức Vụ"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		
		docDuLieuBangNhanVien ();
		docDuLieucboChucVu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if(panel.txtTenNV.getText().length() !=0  && panel.txtDiaChiNV.getText().length() !=0 && panel.txtSDTNV.getText().length() !=0
        			&& panel.cboCVNV.getSelectedItem().toString() != "Không") {
			if(validDataQuanLiNV()) {
			    
			        String maNV=panel.txtMaNV.getText();
	                String tenNV=panel.txtTenNV.getText();
	                String diaChi=panel.txtDiaChiNV.getText();
	                String sdt=panel.txtSDTNV.getText();
	                
	                ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
	                for (ChucVu cv : dsCV) {
	                    if (cv.getTenChucVu().equals(panel.cboCVNV.getSelectedItem().toString())) {
	                        cv1= cv.getMaChucVu();
	                    }
	                }
	               
	                ChucVu cvb=new ChucVu(cv1);
	                NhanVien nv=new NhanVien(maNV, tenNV,diaChi, sdt,0, 0,  cvb);
	                if(nhanVien_dao.create(nv, dsNV.size() + 1)) {
	                    pane.removeAll();
	                    docDuLieuBangNhanVien();
	                    dsNV = nhanVien_dao.getAllNhanVien();
	                    XoaTrang();
	                }
			    } 
			}else {
			        JOptionPane.showMessageDialog(null,"Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
			    }   
		}
		if (obj.equals(panel.btnSua)) {
			if (pane.table.getSelectedRow() > -1) {
				if(panel.txtTenNV.getText().length() !=0  && panel.txtDiaChiNV.getText().length() !=0 && panel.txtSDTNV.getText().length() !=0
	        			&& panel.cboCVNV.getSelectedItem().toString() != "Không") {
					if(validDataQuanLiNV()) {
						LuuDuLieuSua();
						XoaTrang();
					}
				}else {
			        JOptionPane.showMessageDialog(null,"Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
			    }   		
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Dịch Vụ Trong Danh Sách");
			}	
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            NhanVien nv=new NhanVien(ma);
	            nhanVien_dao.delete(nv);
	            pane.removeRow(r);
	            dsNV = nhanVien_dao.getAllNhanVien();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
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
					row_x.put("ma_NV", pane.table.getModel().getValueAt(stt, 0).toString());
					row_x.put("ten_NV", pane.table.getModel().getValueAt(stt, 1).toString());
					row_x.put("diachi_NV", pane.table.getModel().getValueAt(stt, 2).toString());
					row_x.put("sdt_NV", pane.table.getModel().getValueAt(stt, 3).toString());
					row_x.put("chucvu_NV", pane.table.getModel().getValueAt(stt, 4).toString());
					datax.add(row_x);
				}
				JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
				String sourceName="src/Report/DS_Nhan_Vien.jrxml";
				
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

	private boolean validDataQuanLiNV() {
		String ten=panel.txtTenNV.getText().trim();
		String diaChi=panel.txtDiaChiNV.getText().trim();
        String sdt=panel.txtSDTNV.getText().trim();

        String  mau1 = "(^[A-ZĐ][a-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+\s?)([A-ZĐ][a-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+\s?)+";
        Pattern chuoi1 = Pattern.compile(mau1);
		Matcher m1 = chuoi1.matcher(ten);
		if (m1.matches() == false) {
			if (ten.substring(0,1).equals("Đ")) {
 				return true;
 			}
			JOptionPane.showMessageDialog(null,"Họ Và Tên Nhân Viên Viết Hoa Chữ Cái Đầu Và Không Dùng Số");
			
			return false;
		} 
		
		String  mau2 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
        Pattern chuoi2 = Pattern.compile(mau2);
		Matcher m2 = chuoi2.matcher(diaChi);
		if (m2.matches() == false) {
			if (diaChi.substring(0,1).equals("Đ")) {
 				return true;
 			}
			JOptionPane.showMessageDialog(null,"Địa Chỉ Viết Hoa Chữ Đầu Có thể dùng số");
			
			return false;
		} 
		
		 String  mau3 = "(^(0)[0-9]{9})";
	        Pattern chuoi3 = Pattern.compile(mau3);
			Matcher m3 = chuoi3.matcher(sdt);
			if (m3.matches() == false) {
				JOptionPane.showMessageDialog(null,"SĐT bắt đầu bằng 0  số phía sau và không dùng chữ ");
				
				return false;
			} 
		
		return true;
	}

	private void XoaTrang() {
		panel.txtMaNV.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenNV.setText("");
		panel.txtDiaChiNV.setText("");
		panel.txtSDTNV.setText("");
		panel.cboCVNV.setSelectedIndex(0);
		
	
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
		panel.txtMaNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.txtTenNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.txtDiaChiNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.txtSDTNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
		panel.cboCVNV.setSelectedItem((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 4));
	}
	public void LuuDuLieuSua () {
	    if (panel.cboCVNV.getSelectedItem().toString() != "Không") {
    	    int row = pane.getSelectedRow();
            String maNV=panel.txtMaNV.getText();
            String tenNV=panel.txtTenNV.getText();
            String diaChi=panel.txtDiaChiNV.getText();
            String sdt=panel.txtSDTNV.getText();
            String ma = null;
            ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
            for (ChucVu cv : dsCV) {
                if (cv.getTenChucVu().equals(panel.cboCVNV.getSelectedItem().toString())) {
                    ma = cv.getMaChucVu();
                }
            }
            ChucVu cvb=new ChucVu(ma);
            int soDon = 0, TongTien = 0;
            ArrayList<NhanVien> dsNV = nhanVien_dao.getAllNhanVien();
            for (NhanVien nv : dsNV) {
                if (nv.getMaNhanVien().equals(maNV)) {
                    soDon = nv.getSoHoaDonLap();
                    TongTien = nv.getTongTienHoaDon();
                }
            }
            
            NhanVien nv=new NhanVien(maNV, tenNV, diaChi, sdt,soDon, TongTien, cvb);
            if(nhanVien_dao.update(nv)) {
                pane.removeAll();
                docDuLieuBangNhanVien();
            }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Chức Vụ");
	    }
	}
	public void docDuLieucboChucVu() {
        ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
        for (ChucVu cv : dsCV) {
            panel.cboCVNV.addItem(cv.getTenChucVu());
        }
    }
	public void docDuLieuBangNhanVien () {
	    dsNV = nhanVien_dao.getAllNhanVien();
	    for (NhanVien nv : dsNV) {
	        String ma = null;
	        ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
	        for (ChucVu cv : dsCV) {
	            if (cv.getMaChucVu().equals(nv.getChucVu().getMaChucVu())) {
	                ma = cv.getTenChucVu();
	            }
	        }
	        pane.addRow(new Object[] {nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getDiaChi(), 
	                nv.getSoDienThoai(), ma});
	    }
	}
}
