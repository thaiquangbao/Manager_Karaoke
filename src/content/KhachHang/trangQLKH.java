package content.KhachHang;

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
import content.form.formNhapKhachHang;
import content.hoa_don.buttonListPhong;
import content.hoa_don.trangHoaDon;
import dao.KhachHang_DAO;
import entity.KhachHang;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class trangQLKH implements MouseListener{
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private table pane;
	private JFrame frame;
	private formNhapKhachHang panel;
	private KhachHang_DAO khachHang_dao;
    private ArrayList<KhachHang> dsKH;
    private trangHoaDon trangHoaDon;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn, trangHoaDon trangHoaDon) {
		this.trangHoaDon = trangHoaDon;
		panel = new formNhapKhachHang("QLKH");
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		khachHang_dao=new KhachHang_DAO();
		docDuLieuLoaiDichVu();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if(panel.tfTenKH.getText().length() !=0  && panel.tfDiaChiKH.getText().length() !=0 && panel.tfSDTKH.getText().length() !=0) {
				if(validDataQuanLiKH()) {
				    String maKH=panel.tfMaKH.getText();
		            String tenKH=panel.tfTenKH.getText();
		            String diaChi=panel.tfDiaChiKH.getText();
		            String sdt=panel.tfSDTKH.getText();
		            KhachHang kh=new KhachHang(maKH, tenKH, sdt, diaChi, 0);
		            if(khachHang_dao.create(kh, dsKH.size() + 1)) {
		                pane.removeAll();
		                docDuLieuLoaiDichVu();
		                dsKH=khachHang_dao.getAllDSKhachHang();
		                XoaTrang();
		             }   
				}
			}
			else {
		        JOptionPane.showMessageDialog(null,"Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
		    }  
		}
		if (obj.equals(panel.btnSua)) {
			if (pane.table.getSelectedRow() > -1) {
				if(panel.tfTenKH.getText().length() !=0  && panel.tfDiaChiKH.getText().length() !=0 && panel.tfSDTKH.getText().length() !=0) {
					if(validDataQuanLiKH()) {
						LuuDuLieuSua();
						XoaTrang();
					}
				}else {
					        JOptionPane.showMessageDialog(null,"Không Được Để Trống Và Chọn Dữ Liệu Phù Hợp");
					    }  					
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Khách Hàng Trong Danh Sách");
			}
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            KhachHang kh=new KhachHang(ma);
	            khachHang_dao.delete(kh);
	            pane.removeRow(r);
	            dsKH=khachHang_dao.getAllDSKhachHang();
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
				row_x.put("ma_KH", pane.table.getModel().getValueAt(stt, 0).toString());
				row_x.put("ten_KH", pane.table.getModel().getValueAt(stt, 1).toString());
				row_x.put("diachi_KH", pane.table.getModel().getValueAt(stt, 2).toString());
				row_x.put("sdt_KH", pane.table.getModel().getValueAt(stt, 3).toString());
				
				datax.add(row_x);
			}
			JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
			String sourceName="src/Report/DS_KhachHang.jrxml";
			
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

	private boolean validDataQuanLiKH() {
		String ten=panel.tfTenKH.getText().trim();
		String diaChi=panel.tfDiaChiKH.getText().trim();
        String sdt=panel.tfSDTKH.getText().trim();
        
        String  mau1 = "(^[A-ÁÂZĐ][a-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+\s?)([A-ÁZĐ][a-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+\s?)+";
        Pattern chuoi1 = Pattern.compile(mau1);
		Matcher m1 = chuoi1.matcher(ten);
		if (m1.matches() == false) {
			if (ten.substring(0,1).equals("Đ")) {
 				return true;
 			}
			JOptionPane.showMessageDialog(null,"Họ Và Tên Khách Hàng Viết Hoa Chữ Cái Đầu Và Không Dùng Số");
			
			return false;
		} 
		
		String  mau2 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
        Pattern chuoi2 = Pattern.compile(mau2);
		Matcher m2 = chuoi2.matcher(diaChi);
		if (m2.matches() == false) {
			if (diaChi.substring(0,1).equals("Đ")) {
 				return true;
 			}
			JOptionPane.showMessageDialog(null,"Địa Chỉ Viết Hoa Chữ Đầu Có Thể Dùng Số");
			
			return false;
		} 
		
		 String  mau3 = "(^(0)[0-9]{9})";
	        Pattern chuoi3 = Pattern.compile(mau3);
			Matcher m3 = chuoi3.matcher(sdt);
			if (m3.matches() == false) {
				JOptionPane.showMessageDialog(null,"SĐT Bắt Đầu Bằng Số 0 (10 Số) Và Không Dùng Chữ ");
				
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
	public void SuaDuLieu() {
		panel.tfMaKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfDiaChiKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.tfSDTKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row = pane.getSelectedRow();
        pane.removeRow(row);
        
        String maKH=panel.tfMaKH.getText();
        String tenKH=panel.tfTenKH.getText();
        String diaChi=panel.tfDiaChiKH.getText();
        String sdt=panel.tfSDTKH.getText();
        
        ArrayList<KhachHang> dsKH=khachHang_dao.getAllDSKhachHang();
        int tongtien = 0;
        for (KhachHang kh : dsKH) {
            if (kh.getMaKhachHang().equals(maKH)) {
                tongtien = kh.getTongTienHoaDon();
            }
        }
        
        KhachHang kh=new KhachHang(maKH, tenKH, sdt, diaChi, tongtien);
        if(khachHang_dao.update(kh)) {
            pane.removeAll();
            docDuLieuLoaiDichVu();
                XoaTrang();
        }
	}
	public void XoaTrang () {
		panel.tfMaKH.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenKH.setText("");
		panel.tfDiaChiKH.setText("");
		panel.tfSDTKH.setText("");
	}
	public void docDuLieuLoaiDichVu() {
         dsKH=khachHang_dao.getAllDSKhachHang();
        for (KhachHang kh : dsKH) {
            pane.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getDiaChi(),kh.getSoDienThoai()});
        }
        
    }
}

