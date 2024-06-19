package content.ThongKe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JOptionPane;

import Function.functionNecessary;
import content.table;
import content.DatPhong.panelDatPhong;
import content.hoa_don.buttonListPhong;
import dao.ChiTietHoaDon_DAO;
import dao.ChucVu_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Phong_DAO;
import entity.ChiTietHoaDon;
import entity.ChucVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class trangTKNV {

	private table pane;
	private nodeThongKe nodeLeft;
	private nodeTongCong nodeRight;
    private NhanVien_DAO nhanVien_dao;
    private ChucVu_DAO chucVu_dao;
	private HoaDon_DAO hoaDon_dao;
	private ChiTietHoaDon_DAO ctHoaDon_dao;
	private ArrayList<HoaDon> dsHoaDon;
	private ArrayList<ChiTietHoaDon> dsCTHoaDon;
	private functionNecessary d;

	void RenderUITKHD (Box totalBox) {
	    nhanVien_dao =new NhanVien_DAO();
        chucVu_dao=new ChucVu_DAO();
		Box boxNode = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 8)));
		totalBox.add(boxNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 13)));
		
		nodeLeft = new nodeThongKe("#FC5C7D", "#6A82FB", "Nhan Vien");
		nodeRight = new nodeTongCong("#FC5C7D", "#6A82FB", "", "Nhan Vien");
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		boxNode.add(nodeLeft);
		boxNode.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNode.add(nodeRight);
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		
		// add table
		String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Số Điện Thoại", "Số Hóa Đơn Đã Lập", "Tổng Tiền Hóa Đơn"} ;
		pane = new table(header);
		pane.setPreferredSize(new Dimension(1200, 500));
		totalBox.add(pane);
		docDuLieuBangNhanVien();
		
		if (nodeLeft.btnXemThongKe.getActionListeners().length == 0) {
        	nodeLeft.btnXemThongKe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date date1 = df.parse(nodeLeft.txtdate1.getText());
						Date date2 = df.parse(nodeLeft.txtdate2.getText());
						int a = date1.compareTo(date2);
						if (a == -1 || a == 0) {
							UpdateThongTinNhanVien();
						} else {
							JOptionPane.showMessageDialog(null, "Ngày Kết Thúc Phải Sau Ngày Bắt Đầu");
						
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
        }
		if (nodeLeft.btnInThongKe.getActionListeners().length == 0) {
        	nodeLeft.btnInThongKe.addActionListener(new ActionListener() {
        		
				@Override
				public void actionPerformed(ActionEvent e) {	
					
				        
								Map<String,Object> row_main1=new HashMap<String,Object>();
								List<Map<String, ?>> datax1=new ArrayList<Map<String, ?>>();
								row_main1.put("tngay_LTK", nodeLeft.txtdate1.getText());
								row_main1.put("dngay_LTK",  nodeLeft.txtdate2.getText());
								row_main1.put("loai_TK", nodeLeft.cboLeft1.getSelectedItem().toString());								 
								row_main1.put("tongSo_NV", nodeRight.label1.getText().toString());
								row_main1.put("tongSo_HD", nodeRight.label2.getText().toString());								
								row_main1.put("tongTien_HD", nodeRight.label3.getText().toString());
								
								
								datax1.add(row_main1);
								
								for (int stt = 0; stt < pane.getRowCount(); stt ++) {
									Map<String,Object> row_x=new HashMap<String,Object>();
									row_x.put("ma_NV", pane.table.getModel().getValueAt(stt, 0).toString());
									row_x.put("ten_NV", pane.table.getModel().getValueAt(stt, 1).toString());
									row_x.put("sDT_NV", pane.table.getModel().getValueAt(stt, 3).toString());
									row_x.put("diaChi_NV", pane.table.getModel().getValueAt(stt, 2).toString());
									row_x.put("soHoaDon", pane.table.getModel().getValueAt(stt, 4).toString());
									row_x.put("tongTien", pane.table.getModel().getValueAt(stt, 5).toString());
									datax1.add(row_x);
					
								}
								
								JRDataSource jrsource1 = new JRBeanCollectionDataSource(datax1);
					            String sourceName1="src/Report/ThongKe_NV.jrxml";
					            
					            try {
					                JasperReport rp=JasperCompileManager.compileReport(sourceName1);
					                JasperPrint filledReport1=JasperFillManager.fillReport(rp, null,jrsource1);
					                JasperViewer jw1=new JasperViewer(filledReport1, false);
					                jw1.setVisible(true);
					                
					            } catch (JRException ex) {
					               ex.printStackTrace(); 
					            }

        				}		
				});
			}
		}
	public void docDuLieuBangNhanVien () {
		hoaDon_dao = new HoaDon_DAO();
		ctHoaDon_dao = new ChiTietHoaDon_DAO();
		dsHoaDon = hoaDon_dao.getAllHoaDon();
		dsCTHoaDon = ctHoaDon_dao.getAllChiTietHoaDon();
        d = new functionNecessary();
        ArrayList<NhanVien> dsNV = nhanVien_dao.getAllNhanVien();
        for (NhanVien nv : dsNV) {
            String ma = null;
            ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
            for (ChucVu cv : dsCV) {
                if (cv.getMaChucVu().equals(nv.getChucVu().getMaChucVu())) {
                    ma = cv.getTenChucVu();
                }
            }
            pane.addRow(new Object[] {nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getDiaChi(), 
                    nv.getSoDienThoai(), nv.getSoHoaDonLap(), nv.getTongTienHoaDon()});
        }
        
        
        for (int i = 0; i < pane.getRowCount() ; i++) {
			int tongTienLap = 0;
			int tongHoaDon = 0;
			for (HoaDon x : dsHoaDon) {
				if (x.getNhanVien().getMaNhanVien().equals(pane.table.getModel().getValueAt(i, 0))) {
					tongHoaDon ++;
					tongTienLap += Integer.parseInt(d.formatString(x.getTongTien()));
				}
			}
			pane.table.getModel().setValueAt(tongHoaDon + "", i, 4);
			pane.table.getModel().setValueAt(d.formatMoney(tongTienLap), i, 5);
		}
        
        int tong1 = 0;
        int tong2 = 0;
        for (int i = 0; i < pane.getRowCount() ; i++) {
        	tong2 += Integer.parseInt((String) pane.table.getModel().getValueAt(i, 4));
        	tong1 += Integer.parseInt(d.formatString((String) pane.table.getModel().getValueAt(i, 5)));
		}
        
        
        nodeRight.lbl1 = "Tổng Số Nhân Viên             : " + pane.getRowCount();
        nodeRight.label1.setText(nodeRight.lbl1);
        nodeRight.lbl2 = "Tổng Số Hóa Đơn Đã Lập   : " + tong2;
        nodeRight.label2.setText(nodeRight.lbl2);
        nodeRight.lbl3 = "Tổng Tiền Hóa Đơn Đã lập  : " + d.formatMoney(tong1);
        nodeRight.label3.setText(nodeRight.lbl3);
        
    }
	public void UpdateThongTinNhanVien () throws ParseException {
		hoaDon_dao = new HoaDon_DAO();
		ctHoaDon_dao = new ChiTietHoaDon_DAO();
		dsHoaDon = hoaDon_dao.getAllHoaDon();
		dsCTHoaDon = ctHoaDon_dao.getAllChiTietHoaDon();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		d = new functionNecessary();
		Date date1 = df.parse(nodeLeft.txtdate1.getText());
		Date date2 = df.parse(nodeLeft.txtdate2.getText());
		
		for (int i = 0; i < pane.getRowCount() ; i++) {
			int tongTienLap = 0;
			int tongHoaDon = 0;
			for (HoaDon x : dsHoaDon) {
				if (x.getNhanVien().getMaNhanVien().equals(pane.table.getModel().getValueAt(i, 0))) {
					Date date3 = df.parse(d.formatTimeForAnalysis(x.getNgayLapHoaDon()).toString().substring(0, 11));
					if (date3.compareTo(date1) == 1 || date3.compareTo(date1) == 0) {
						if (date3.compareTo(date2) == -1 || date3.compareTo(date2) == 0) {
							tongHoaDon ++;
							tongTienLap += Integer.parseInt(d.formatString(x.getTongTien()));
						}
					}
				}
			}
			pane.table.getModel().setValueAt(tongHoaDon + "", i, 4);
			pane.table.getModel().setValueAt(d.formatMoney(tongTienLap), i, 5);
		}
		int tong1 = 0;
        int tong2 = 0;
        for (int i = 0; i < pane.getRowCount() ; i++) {
        	tong2 += Integer.parseInt((String) pane.table.getModel().getValueAt(i, 4));
        	tong1 += Integer.parseInt(d.formatString((String) pane.table.getModel().getValueAt(i, 5)));
		}
        nodeRight.lbl2 = "Tổng Số Hóa Đơn Đã Lập  : " + tong2;
        nodeRight.label2.setText(nodeRight.lbl2);
        nodeRight.lbl3 = "Tổng Tiền Hóa Đơn Đã lập : " + d.formatMoney(tong1);
        nodeRight.label3.setText(nodeRight.lbl3);
	}
}
