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
import java.util.Iterator;
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
import content.form.formNhapNhaCungCap;
import dao.NhaCungCap_DAO;
import entity.NhaCungCap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangNCC implements ActionListener, MouseListener {
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapNhaCungCap panel;
    private NhaCungCap_DAO nhaCungCap_dao;
    private ArrayList<NhaCungCap> dsNCC;

	public void RenderUINhaCungCap (Box totalBox, Font fontBtn) {

		panel = new formNhapNhaCungCap();
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"} ;
		pane = new table(header);
		totalBox.add(pane);
		// pane.table.getModel()
		nhaCungCap_dao=new NhaCungCap_DAO();
		docDuLieuNhaCungCap();
		
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
			if(panel.txtTenNCC.getText().length() != 0 && panel.txtDiaChiNCC.getText().length() != 0 &&  panel.txtSDTNCC.getText().length() != 0) {
				if(validDataNhaCC()) {
			    String maNcc=panel.txtMaNCC.getText();
	            String tenNcc=panel.txtTenNCC.getText();
	            String diaChi=panel.txtDiaChiNCC.getText();
	            String sdt=panel.txtSDTNCC.getText();
	            NhaCungCap ncc=new NhaCungCap(maNcc, tenNcc, diaChi, sdt);
	            if(nhaCungCap_dao.create(ncc, dsNCC.size() + 1)) {
	                pane.removeAll();
	                docDuLieuNhaCungCap();
	                dsNCC=nhaCungCap_dao.getAllNhaCungCap();
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
				if(panel.txtTenNCC.getText().length() != 0 && panel.txtDiaChiNCC.getText().length() != 0 &&  panel.txtSDTNCC.getText().length() != 0) {
					if(validDataNhaCC()) {
						LuuDuLieuSua();
						XoaTrang();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Không Được Để Trống ");
				}	
			} else  {
				JOptionPane.showMessageDialog(null, "Vui lòng Chọn Nhà Cung Cấp Trong Danh Sách");
			}		
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            NhaCungCap ncc=new NhaCungCap(ma);
	            nhaCungCap_dao.delete(ncc);
	            pane.removeRow(r);
	            dsNCC=nhaCungCap_dao.getAllNhaCungCap();
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
					row_x.put("ma_NCC", pane.table.getModel().getValueAt(stt, 0).toString());
					row_x.put("ten_NCC", pane.table.getModel().getValueAt(stt, 1).toString());
					row_x.put("diachi_NCC", pane.table.getModel().getValueAt(stt, 2).toString());
					row_x.put("sdt_NCC", pane.table.getModel().getValueAt(stt, 3).toString());
					
					datax.add(row_x);
				}
				JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
				String sourceName="src/Report/DS_Nha_CC.jrxml";
				
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

	private boolean validDataNhaCC() {
		String tenNCC=panel.txtTenNCC.getText();
        String diaChi=panel.txtDiaChiNCC.getText();
        String sdt=panel.txtSDTNCC.getText();
        
        String  mau1 = "(^[A-Z0-9].*)(\s{1}[A-Z0-9].+)*";
        Pattern chuoi1 = Pattern.compile(mau1);
		Matcher m1 = chuoi1.matcher(tenNCC);
		if (m1.matches() == false) {
			if (tenNCC.substring(0,1).equals("Đ")) {
 				return true;
 			}
			JOptionPane.showMessageDialog(null,"Tên Nhà Cung Cấp Viết Hoa Chữ Cái Đầu Và Có Thể Dùng Số");
			
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
				JOptionPane.showMessageDialog(null,"SĐT Bắt Đầu Bằng 0(10 Số) Và Không Dùng Chữ ");
				
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

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void SuaDuLieu() {
		panel.txtMaNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.txtTenNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.txtDiaChiNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.txtSDTNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row=pane.getSelectedRow();
        String maNcc=panel.txtMaNCC.getText();
        String tenNcc=panel.txtTenNCC.getText();
        String diaChi=panel.txtDiaChiNCC.getText();
        String sdt=panel.txtSDTNCC.getText();
        NhaCungCap ncc=new NhaCungCap(maNcc, tenNcc, diaChi, sdt);
        if(nhaCungCap_dao.update(ncc)) {
            pane.removeAll();
            docDuLieuNhaCungCap();
        }
	}
	public void XoaTrang () {
		panel.txtMaNCC.setText("Hệ Thống Tự Động Thêm");
		panel.txtTenNCC.setText("");
		panel.txtDiaChiNCC.setText("");
		panel.txtSDTNCC.setText("");
	}
	public void docDuLieuNhaCungCap() {
	    dsNCC=nhaCungCap_dao.getAllNhaCungCap();
	        for (NhaCungCap ncc: dsNCC) {
	            pane.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getSoDienThoai()});
            }
	    }
}
