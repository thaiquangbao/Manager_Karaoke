package content.hoa_don;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PageAttributes.ColorType;
import Function.functionNecessary;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import com.raven.datechooser.SelectedDate;
import com.raven.datechooser.panelDate;

import content.table;
import content.trangKhongMenu;
import dao.ChiTietHoaDon_DAO;
import dao.DichVu_Dao;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class trangHoaDon extends trangKhongMenu implements ActionListener{
	private JTextField tenphong;
	private JTextField loaiphong;
	private JTextField tinhgio;
	private DefaultTableModel modelchitiethoadon;
	private JTable tablechitiethoadon;
	private JPanel area3;
	private JScrollBar sb;
	private JScrollBar sb_width;
	public listPhong listPhong;
	private buttonListPhong btnPhong;
	private buttonListPhong btnDichVu;
	private table table;
	public listDichVu listDichVu;
	private JPanel panelList2;
	private JScrollPane js1;
	private JScrollPane js2;
	private JScrollPane jsx;
	private JScrollPane jsKH;
	public JScrollPane getJsKH() {
		return jsKH;
	}
	public void setJsKH(JScrollPane jsKH) {
		this.jsKH = jsKH;
	}
	public JScrollPane getJsx() {
		return jsx;
	}
	public void setJsx(JScrollPane jsx) {
		this.jsx = jsx;
	}
	private int tong = 0;
	private functionNecessary d;
	private Box boxLeft;
	private Box boxRight;
	private Box boxTotal;
	private ActionListener action;
	private panelHoaDon panelHoaDon;
	public content.hoa_don.listPhong listPhong1;
	public content.hoa_don.panelHoaDon panelHoaDon1;
	private buttonListPhong btnKhachHang;
	private JScrollPane js3;
	public listKhachHang listKhachHang;
	private content.hoa_don.listPhong listPhongTam;
	private JScrollPane js4;
	public KhachHang kh;
	public String type;
	public String type1;
	private PhieuDatPhong_DAO phieuDatPhong_DAO;
	private buttonListPhong btnPhongDat;
	private JPanel panelPhongDat;
	public content.table tablePDP;
	private buttonTotal btnNhanPhong;
	private ArrayList<PhieuDatPhong> dsPDP;
	private buttonTotal btnXoaNhanPhong;
	private String MANHANVIEN;
	private JPanel panelJS1;
	private int sizeListPhong = 119;
	private int sizeListDichVu = 101;
	private JPanel panelJS2;
	private DichVu_Dao dichVu_dao;
	private ArrayList<DichVu> dvDV;
	public trangHoaDon(String manv) {
		this.MANHANVIEN = manv;
		listDichVu = new listDichVu();
		listPhong = new listPhong(listDichVu, listKhachHang);
		js1 =new JScrollPane(listPhong,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js1.setBorder(BorderFactory.createEmptyBorder());
		js1.getVerticalScrollBar().setUnitIncrement(6);
		js1.setBackground(Color.white);
		panelJS1 = new JPanel();
		panelJS1.setPreferredSize(new Dimension(550,720));
		panelJS1.setBackground(Color.white);
		panelJS1.add(js1);

		js2 =new JScrollPane(listDichVu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js2.setBorder(BorderFactory.createEmptyBorder());
		js2.getVerticalScrollBar().setUnitIncrement(6);
		js2.setBackground(Color.white);
		setJsx(js2);
		panelJS2 = new JPanel();
		panelJS2.setPreferredSize(new Dimension(550,720));
		panelJS2.setBackground(Color.white);
		panelJS2.add(jsx);
		
		
		setHeightListObject ();
		
		
		panelPhongDat = new JPanel();
		panelPhongDat.setPreferredSize(new Dimension(600, 720));
		panelPhongDat.setBackground(Color.white);
		String[] header = {"Mã Phiếu","Khách Hàng" ,"Số Điện Thoại","Phòng", "Thời Gian"} ;
		tablePDP = new table(header);
		tablePDP.setPreferredSize(new Dimension(600, 400));
		tablePDP.setBackground(Color.white);
		panelPhongDat.add(tablePDP);
		btnNhanPhong = new buttonTotal(" Nhận Phòng", "hinh/button/btn_NhanPhong.png");
		btnXoaNhanPhong = new buttonTotal(" Xóa Phòng", "hinh/button/btn_Xoa.png");
		panelPhongDat.add(btnNhanPhong);
		panelPhongDat.add(btnXoaNhanPhong);

		boxLeft = Box.createVerticalBox();
		boxRight = Box.createVerticalBox();
		boxTotal = Box.createHorizontalBox();
		boxLeft.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelList1 = new JPanel();
		panelList1.setLayout(new GridLayout(1, 0));
		panelList1.setBackground(Color.white);
		btnPhong = new buttonListPhong("Phòng", "hinh/button/btn_ListPhong.png", "title","",listKhachHang, listDichVu, listPhong);
		btnDichVu = new buttonListPhong("Dịch Vụ", "hinh/button/btn_ListPhong.png", "title","",listKhachHang, listDichVu, listPhong);
		btnPhongDat = new buttonListPhong("Phòng Đặt", "hinh/button/btn_ListPhong.png", "title","",listKhachHang, listDichVu, listPhong);
		
		btnPhong.setPreferredSize(new Dimension(60, 40));
		panelList1.add(btnPhong);
		panelList1.add(btnDichVu);
		panelList1.add(btnPhongDat);

		panelList2 = new JPanel();
		panelList2.setBackground(Color.white);
		panelList2.add(panelJS1);

		boxLeft.add(panelList1);
		boxLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		boxLeft.add(panelList2);
		boxLeft.add(Box.createRigidArea(new Dimension(50, 0)));

		panelHoaDon = new panelHoaDon("","Rỗng","0", listPhong);
		panelHoaDon1 = panelHoaDon;
		boxRight.add(panelHoaDon1);

		add(boxTotal);
		boxTotal.add(boxLeft);
		boxTotal.add(Box.createRigidArea(new Dimension(7,0)));
		boxTotal.add(boxRight);

		btnPhong.addActionListener(this);
		btnDichVu.addActionListener(this);
		btnPhongDat.addActionListener(this);
		btnNhanPhong.addActionListener(this);
		btnXoaNhanPhong.addActionListener(this);
		

		addEventBTNPhong();

		d = new functionNecessary();
		phieuDatPhong_DAO = new PhieuDatPhong_DAO();
		getALLPhongDat();
		
	}
	public void getALLPhongDat () {
		dsPDP = phieuDatPhong_DAO.getAllPhieuDatPhong();
		for (PhieuDatPhong x : dsPDP) {
			tablePDP.addRow(new Object[] {x.getMaPhieuDatPhong(), x.getKhachHang().getTenKhachHang(), x.getKhachHang().getSoDienThoai(), x.getPhong().getTenPhong(), x.getNgayDat()});
		}
	}
	public void addEventBTNPhong () {
		for (buttonListPhong x : listPhong.listPhong) {
			x.addActionListener(this);
		
			if (x.panelHoaDon.title.btnTimSDT.getActionListeners().length == 0) {
				x.panelHoaDon.title.btnTimSDT.addActionListener(new ActionListener() {
	        		
					private KhachHang_DAO khachHang_dao;
	        	    private ArrayList<KhachHang> dsKH;
	        	    
					@Override
					public void actionPerformed(ActionEvent e) {
						khachHang_dao = new KhachHang_DAO();
						dsKH=khachHang_dao.getAllDSKhachHang();
						int xacnhan = 0;
				        for (KhachHang kh : dsKH) {
				        	if (kh.getSoDienThoai().equals(x.panelHoaDon.title.textSDT.getText())) {
				        		panelHoaDon1.title.title3.remove(1);
				        		panelHoaDon1.title.nameKH = kh.getTenKhachHang();
								panelHoaDon1.title.sdtKH = kh.getSoDienThoai();
				        		panelHoaDon1.title.customer.setText("Khách Hàng : " + kh.getTenKhachHang() + "          Số Điện Thoại : " + kh.getSoDienThoai());
				        		xacnhan = 1;
				        		break;
				        	}
				        }
				        if (xacnhan == 0) {
				        	JOptionPane.showMessageDialog(null, "Không Tìm Thấy Khách Hàng Có SDT : " + x.panelHoaDon.title.textSDT.getText());
				        }
					}
				});
	        }
		}
	}
	
	public void chuyenPhong (String a ,String b) {
		buttonListPhong m = null, n = null;
		int z1 = 0, z2 = 0;
		for (int i = 0; i< listPhong.listPhong.size(); i++) {
			if (listPhong.listPhong.get(i).name.equals(a)) {
				m = listPhong.listPhong.get(i);
				z1 = i;
			}
		}
		for (int i = 0; i< listPhong.listPhong.size(); i++) {
			if (listPhong.listPhong.get(i).name.equals(b)) {
				n = listPhong.listPhong.get(i);
				z2 = i;
			}
		}
		ArrayList<buttonListPhong> listPhongTam2 = new ArrayList<buttonListPhong>();
		for (buttonListPhong k : listPhong.listPhong) {
			if (k.name.equals(a)) {
				listPhongTam2.add(n);
			}
			if(k.name.equals(b)) {
				listPhongTam2.add(m);
			}
			if (k.name != a && k.name != b) {
				listPhongTam2.add(k);
			}
			
		}
		listPhong.listPhong = listPhongTam2;
		listPhong.removeAll();
		listPhong.RenderListPhong();
		listPhong.listPhong.get(z1).name = a;
		listPhong.listPhong.get(z2).name = b;
		listPhong.listPhong.get(z1).label.setText("     " + listPhong.listPhong.get(z1).name);
		listPhong.listPhong.get(z2).label.setText("     " + listPhong.listPhong.get(z2).name);
		listPhong.UpdatePhongDangSuDung();
		listPhong.listPhong.get(z1).panelHoaDon.name = a;
		listPhong.listPhong.get(z2).panelHoaDon.name = b;
		listPhong.listPhong.get(z1).panelHoaDon.setTenPhong();
		listPhong.listPhong.get(z2).panelHoaDon.setTenPhong();
		listPhong.listPhong.get(z2).panelHoaDon.title.time = listPhong.listPhong.get(z1).panelHoaDon.title.time;
		listPhong.repaint();
	}
	public void setHeightListObject () {
		listPhong.m = listPhong.listPhong.size() / 4;
		int n1 = listPhong.listPhong.size() % 4;
		if (n1 > 0) {
			listPhong.m ++;
		}
		listPhong.setPreferredSize(new Dimension(400, listPhong.sizeY * listPhong.m));
		if (listPhong.m <= 6) {
			js1.setPreferredSize(new Dimension(550, sizeListPhong * listPhong.m));
		} else {
			js1.setPreferredSize(new Dimension(550, sizeListPhong * 6));
		}
		
		listDichVu.setPreferredSize(new Dimension(520, sizeListDichVu * listDichVu.m));
		if (listDichVu.m <= 7) {
			js2.setPreferredSize(new Dimension(550, sizeListDichVu * listDichVu.m));
		}else {
			js2.setPreferredSize(new Dimension(550, sizeListDichVu * 7));
		} 

		for (buttonListPhong x : listPhong.listPhong) {
			x.panelHoaDon.listDichVuMini.m = ( x.panelHoaDon.listDichVuMini.listDichVu.size() - x.panelHoaDon.listDichVuMini.kotinh) / 3 ;
			int n2 = ( x.panelHoaDon.listDichVuMini.listDichVu.size() - x.panelHoaDon.listDichVuMini.kotinh) % 3 ;
			if (n2 > 0) {
				x.panelHoaDon.listDichVuMini.m ++;
			}
			
			x.panelHoaDon.listDichVuMini.setPreferredSize(new Dimension(400,x.panelHoaDon.listDichVuMini.sizeY * x.panelHoaDon.listDichVuMini.m));
			if (x.panelHoaDon.listDichVuMini.m <= 7) {
				x.panelHoaDon.js2.setPreferredSize(new Dimension(550, sizeListDichVu * x.panelHoaDon.listDichVuMini.m));
			} else {
				x.panelHoaDon.js2.setPreferredSize(new Dimension(550, sizeListDichVu * 7));
			}
		}
	}
	public void addEventBTNDichVu () {
		for (buttonListDichVu y : panelHoaDon1.listDichVuMini.listDichVu) {
			if (y.getActionListeners().length == 0) {
				y.addActionListener(new ActionListener() {
					private DichVu_Dao dichVu_dao;
					private ArrayList<DichVu> dvDV;

					@Override
					public void actionPerformed(ActionEvent e) {
						if (y.amountTon > 0) {
							Object obj = e.getSource();
							for (int i = 0; i< panelHoaDon1.table1.getRowCount(); i++) {
								if (((buttonListDichVu) obj).getName().equals(panelHoaDon1.table1.table.getModel().getValueAt(i, 1))) {
									panelHoaDon1.table1.removeRow(i);
								}
							}
							((buttonListDichVu) obj).setAmount(((buttonListDichVu) obj).getAmount() +1);
							functionNecessary d = new functionNecessary();
							panelHoaDon1.tong = panelHoaDon1.title.priceTotal;
							panelHoaDon1.tong += Integer.parseInt(((buttonListDichVu) obj).getPrice());
							panelHoaDon1.title.totalMoney.setText("Tổng Cộng : " + d.formatMoney(panelHoaDon1.tong));
							panelHoaDon1.title.priceTotal = panelHoaDon1.tong;
							panelHoaDon1.table1.addRow (new Object[] {panelHoaDon1.table1.getRowCount() + 1, ((buttonListDichVu) obj).getName() , ((buttonListDichVu) obj).getAmount() ,  d.formatMoney(Integer.parseInt(((buttonListDichVu) obj).getPrice())), d.formatMoney(((buttonListDichVu) obj).getAmount() * Integer.parseInt(((buttonListDichVu) obj).getPrice()))});		
							panelHoaDon1.reSetSTT();

							dichVu_dao = new DichVu_Dao();
							dvDV=dichVu_dao.getAllDichVu();
					        for (DichVu dv : dvDV) {
					        	if (dv.getTenDichVu().equals(y.name)) {
					        		dv.setSoLuongTon(dv.getSoLuongTon() - 1);
					        		if(dichVu_dao.update(dv)) {
						    			for (buttonListPhong z : listPhong.listPhong) {
									    	for (buttonListDichVu t : z.panelHoaDon.listDichVuMini.listDichVu) {
									    		if (dv.getTenDichVu().equals(t.name)) {
									    			t.amountTon = dv.getSoLuongTon();
									    			t.Amount.setText("Còn : " + t.amountTon);
									    		}
									    	}
									    }
					        		}
					        		break;
					        	}
					        }
						} else {
							JOptionPane.showMessageDialog(null, "Không Thể Chọn Vì Dịch Vụ Này Đã Hết");
						}
					}
				});
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj.equals(btnPhong)) {
			panelList2.removeAll();
			panelList2.add(panelJS1);
			invalidate();
        	validate();
        	repaint();
		}
		if (obj.equals(btnDichVu)) {
			panelList2.removeAll();
			panelList2.add(panelJS2);
			invalidate();
        	validate();
        	repaint();
		}
		if (obj.equals(btnPhongDat)) {
			panelList2.removeAll();
			panelList2.add(panelPhongDat);
			invalidate();
        	validate();
        	repaint();
		}
		if (obj.equals(btnXoaNhanPhong)) {
			int row = tablePDP.getSelectedRow();
			PhieuDatPhong pp = new PhieuDatPhong((String) tablePDP.table.getModel().getValueAt(row, 0));
			phieuDatPhong_DAO.delete(pp);
			tablePDP.removeAll();
			getALLPhongDat();
		}
		if (obj.equals(btnNhanPhong)) {
			int row = tablePDP.getSelectedRow();
			if (row > -1) {
				for (buttonListPhong x : listPhong.listPhong) {
					if (x.name.equals(tablePDP.table.getModel().getValueAt(row, 3))) {
						x.panelHoaDon.title.time = d.getCurrentTime();
						x.panelHoaDon.title.infoTime.setText("Giờ Hát : " + x.panelHoaDon.title.time);
						x.panelHoaDon.btnLapHoaDon.getLblname().setText(" Lưu Hóa Đơn");
						x.panelHoaDon.btnLapHoaDon.setColor1("#EECDA3");
						x.panelHoaDon.btnLapHoaDon.setColor2("#EF629F");
						x.panelHoaDon.repaint();
						x.panelHoaDon.listPhong.UpdatePhongDangSuDung();
						x.panelHoaDon.title.nameKH = (String) tablePDP.table.getModel().getValueAt(row, 1);
						x.panelHoaDon.title.sdtKH = (String) tablePDP.table.getModel().getValueAt(row, 2);
						x.panelHoaDon.title.customer.setText("Khách Hàng : " + x.panelHoaDon.title.nameKH + "          Số Điện Thoại : " + x.panelHoaDon.title.sdtKH);
					}
				}
				PhieuDatPhong pp = new PhieuDatPhong((String) tablePDP.table.getModel().getValueAt(row, 0));
				phieuDatPhong_DAO.delete(pp);
				tablePDP.removeAll();
				getALLPhongDat();
			} else {
				JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Phòng Nhận");
			}
			
		}
		for (buttonListPhong x : listPhong.listPhong) {
			if (x.equals(obj)) {
				// Xử Lí Event Chuyển Phòng
				if (x.panelHoaDon.btnChuyenBan.getActionListeners().length == 0) {
					x.panelHoaDon.btnChuyenBan.addActionListener(new ActionListener () {
						private content.hoa_don.listPhong listPhongTam1;

						@Override
						public void actionPerformed(ActionEvent arg0) {
							JFrame frame = new JFrame();
							listPhongTam = new listPhong(listDichVu, listKhachHang);
							listPhongTam1 = new listPhong(listDichVu, listKhachHang);
							listPhongTam.removeAll();
							listPhongTam.listPhong.removeAll(listPhongTam.listPhong);
					
							for (buttonListPhong z : listPhongTam1.listPhong) { 
								if (z.type.equals(x.type)) {
									if (! z.name.equals(x.name)) {
										for (buttonListPhong t : listPhong.listPhong) {
											if (z.name.equals(t.name)) {
												if (! t.label.getText().equals(t.name + " (Sử Dụng)")) {
													listPhongTam.listPhong.add(z);
												}
											}
										}
									}
								}
								
							}
							listPhongTam.RenderListPhong();
							js4 =new JScrollPane(listPhongTam,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
							js4.setPreferredSize(new Dimension(550, 720));
							js4.setBorder(BorderFactory.createEmptyBorder());
							js4.getVerticalScrollBar().setUnitIncrement(6);
							js4.setBackground(Color.white);
							frame.setSize(580, 750);
							frame.setTitle("Chuyển Phòng");
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
							frame.add(js4);
							for (buttonListPhong z : listPhongTam.listPhong) {
								if (z != x) {
									z.setColor1("#780206");
									z.setColor2("#061161");
									z.num = 1;
								}
								if (z.getActionListeners().length == 1) {
									z.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent e) {  
											int a=JOptionPane.showConfirmDialog(null,"Xác Nhận Chuyển " + x.name + " Đến " + z.name);
											if(a==JOptionPane.YES_OPTION){  
												for (buttonListPhong t : listPhong.listPhong) {
													if (t.name.equals(z.name)) {
													
														chuyenPhong(t.name, x.name);
														frame.setVisible(false);
													}
												}
											}
										}
									});
								}
							}
						}
		
					});
				}

				// Xử Lí Các Event Khác
				if (panelHoaDon1.table1.getRowCount() > 0) {
					if (panelHoaDon1.btnLapHoaDon.lblname.getText().equals(" Lập Hóa Đơn")){
						int a=JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Hủy Hóa Đơn Vừa Tạo ?");  
							if(a==JOptionPane.YES_OPTION){  
								int oo = panelHoaDon1.table1.getRowCount();
								for (int i = 0; i< oo; i++) {
									String name = (String) panelHoaDon1.table1.table.getModel().getValueAt(0,1);
					                int soLuong = (int) panelHoaDon1.table1.table.getModel().getValueAt(0,2);
					                panelHoaDon1.table1.removeRow(0);
					                for (buttonListDichVu o : panelHoaDon1.listDichVuMini.listDichVu) {
					                    if (o.getName().equals(name)) {
					                        o.setAmount(0);
					                        tong = panelHoaDon1.title.priceTotal;
					                        tong -= soLuong * Integer.parseInt(o.getPrice());
					                        panelHoaDon1.title.totalMoney.setText("Tổng Cộng : " + d.formatMoney(tong));
					                        panelHoaDon1.title.priceTotal = tong;
					                        
					                        dichVu_dao = new DichVu_Dao();
											dvDV=dichVu_dao.getAllDichVu();
									        for (DichVu dv : dvDV) {
									        	 if (dv.getTenDichVu().equals(name)) {
									        		 dv.setSoLuongTon(dv.getSoLuongTon() + soLuong);
									        		 if(dichVu_dao.update(dv)) {
											    			for (buttonListPhong z : listPhong.listPhong) {
														    	for (buttonListDichVu t : z.panelHoaDon.listDichVuMini.listDichVu) {
														    		if (dv.getTenDichVu().equals(t.name)) {
														    			t.amountTon = dv.getSoLuongTon();
														    			t.Amount.setText("Còn : " + t.amountTon);
														    		}
														    	}
														    }
										        		}
									        	 }
									        }
					                    }
					                }
								}
								
								
								
								
								
								panelHoaDon1.table1.removeAll();
								for (buttonListDichVu y : panelHoaDon1.listDichVuMini.listDichVu) {
									y.setAmount(0);
									panelHoaDon1.tong = 0;
									panelHoaDon1.title.totalMoney.setText("Tổng Cộng : " + d.formatMoney(panelHoaDon1.tong));
									panelHoaDon1.title.priceTotal = panelHoaDon1.tong;

									// Xu Li thay doi panelHoaDon moi
									panelHoaDon1 = x.panelHoaDon;
									if (panelHoaDon1.btnLapHoaDon.lblname.getText().equals(" Lập Hóa Đơn")) {
										if (this.kh != null) {
											panelHoaDon1.title.nameKH = kh.getTenKhachHang();
											panelHoaDon1.title.sdtKH = kh.getSoDienThoai();
											panelHoaDon1.title.customer.setText("Khách Hàng : " + kh.getTenKhachHang() + "          Số Điện Thoại : " + kh.getSoDienThoai());
										} else {
											panelHoaDon1.title.customer.setText("Số Điện Thoại Khách Hàng : " );
											panelHoaDon1.title.title3.add(panelHoaDon1.title.boxSDT);
										}
									}
									setJsx(panelHoaDon1.js2);
									panelJS2.removeAll();
									panelJS2.add(jsx);
									x.panelHoaDon.title.textSDT.setText("");
									listPhong.reStartListPhong();
									listPhong.setColorForButton(x);
									boxRight.removeAll();
									boxRight.add(panelHoaDon1);
									panelHoaDon1.type1 = type1;
									panelHoaDon1.setButton();
									addEventBTNDichVu ();
									invalidate();
									validate();
									repaint();
								}
							}  
					} else {
						panelHoaDon1 = x.panelHoaDon;
						if (panelHoaDon1.btnLapHoaDon.lblname.getText().equals(" Lập Hóa Đơn")) {
							if (this.kh != null) {
								panelHoaDon1.title.nameKH = kh.getTenKhachHang();
								panelHoaDon1.title.sdtKH = kh.getSoDienThoai();
								panelHoaDon1.title.customer.setText("Khách Hàng : " + kh.getTenKhachHang() + "          Số Điện Thoại : " + kh.getSoDienThoai());
							} else {
								panelHoaDon1.title.customer.setText("Số Điện Thoại Khách Hàng : " );
								panelHoaDon1.title.title3.add(panelHoaDon1.title.boxSDT);
							}
						}
						setJsx(panelHoaDon1.js2);
						panelJS2.removeAll();
						panelJS2.add(jsx);
						x.panelHoaDon.title.textSDT.setText("");
						boxRight.removeAll();
						boxRight.add(panelHoaDon1);
						panelHoaDon1.type1 = type1;
						panelHoaDon1.setButton();
						addEventBTNDichVu ();
						invalidate();
						validate();
						repaint();
					}

				} else {
					panelHoaDon1 = x.panelHoaDon;
					if (panelHoaDon1.btnLapHoaDon.lblname.getText().equals(" Lập Hóa Đơn")) {
						if (this.kh != null) {
							panelHoaDon1.title.nameKH = kh.getTenKhachHang();
							panelHoaDon1.title.sdtKH = kh.getSoDienThoai();
							panelHoaDon1.title.customer.setText("Khách Hàng : " + kh.getTenKhachHang() + "          Số Điện Thoại : " + kh.getSoDienThoai());
						} else {
							panelHoaDon1.title.customer.setText("Số Điện Thoại Khách Hàng : " );
							panelHoaDon1.title.title3.add(panelHoaDon1.title.boxSDT);
						}
					}
					setJsx(panelHoaDon1.js2);
					panelJS2.removeAll();
					panelJS2.add(jsx);
					x.panelHoaDon.title.textSDT.setText("");
					boxRight.removeAll();
					boxRight.add(panelHoaDon1);
					panelHoaDon1.type1 = type1;
					panelHoaDon1.setButton();
					addEventBTNDichVu ();

					invalidate();
					validate();
					repaint();
				}
				
				// Xu li EVent Dat Phong
				if (x.panelHoaDon.btnDatPhong.getActionListeners().length == 0) {
					x.panelHoaDon.btnDatPhong.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (x.panelHoaDon.title.customer.getText().equals("Khách Hàng : ---") || x.panelHoaDon.title.customer.getText().equals("Số Điện Thoại Khách Hàng : ")) {
				        		JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Khách Hàng Sử Dụng");
				        	} else {
				        		JFrame frame = new JFrame();
				        		frame.setSize(300, 325);
				        		frame.setVisible(true);
				        		frame.setTitle("Đặt Phòng");
				        		frame.setLocationRelativeTo(null);
				        		panelDate panelDate = new panelDate();
				        		frame.add(panelDate);
				        		if (panelDate.btnDat.getActionListeners().length == 0) {
				        			panelDate.btnDat.addActionListener(new ActionListener() {
										private ArrayList<KhachHang> dsKH;
										private KhachHang_DAO khachHang_dao;
										private Phong_DAO phong_dao;
										private ArrayList<Phong> dsP;
										private ArrayList<PhieuDatPhong> dsPDP;

										@Override
										public void actionPerformed(ActionEvent e) {
										
											SelectedDate dateTime = panelDate.date.getSelectedDate();
											String time = d.formatNumber( Integer.parseInt(panelDate.comboGio.getSelectedItem().toString())) + " : " +
													d.formatNumber( Integer.parseInt(panelDate.comboPhut.getSelectedItem().toString())) + " ( " +
													dateTime.getDay()+"/" + dateTime.getMonth() + "/" + dateTime.getYear()+ " )";
											
											String maPDP = "";
											KhachHang KH = null;
											Phong P = null;
											khachHang_dao = new KhachHang_DAO();
											dsKH=khachHang_dao.getAllDSKhachHang();
									       for (KhachHang kh : dsKH) {   
									    	   if (kh.getSoDienThoai().equals(x.panelHoaDon.title.sdtKH)) {
									    		   KH = kh;
									    	   }
									       }
									       phong_dao = new Phong_DAO();
									       dsP=phong_dao.getAllPhong();
									        for (Phong p : dsP) {
									        	if (p.getTenPhong().equals(x.name)) {
									        		P = p;
									        	}
									        }
									        PhieuDatPhong pdp = new PhieuDatPhong(maPDP, P, KH, time);
									        dsPDP = phieuDatPhong_DAO.getAllPhieuDatPhong();
									        phieuDatPhong_DAO.create(pdp);
									        tablePDP.removeAll();
									        getALLPhongDat();
									        frame.setVisible(false);
									        JOptionPane.showMessageDialog(null, "Đặt Phòng Cho " + KH.getTenKhachHang() + " Thành Công !!!" );
										}
									});
				        		}
				        		
				        	}
						}
					});
				}
				
				// Xu Li Event In Hoa Don
				if (x.panelHoaDon.btnInHoaDon.getActionListeners().length == 0) {
					x.panelHoaDon.btnInHoaDon.addActionListener(new ActionListener() {
						private ArrayList<KhachHang> dsKH;
						private KhachHang_DAO khachHang_dao;
						private Phong_DAO phong_dao;
						private ArrayList<Phong> dsP;
						private ArrayList<PhieuDatPhong> dsPDP;
						private HoaDon_DAO hoaDon_DAO;
						private DichVu_Dao dichVu_dao;
						private ArrayList<DichVu> dvDV;
						private ChiTietHoaDon_DAO CTHD_DAO;
						private ArrayList<HoaDon> dsHD;
						@Override
						public void actionPerformed(ActionEvent e) {
							
							if (x.panelHoaDon.btnLapHoaDon.getLblname().getText().equals(" Lưu Hóa Đơn")) {
								JFrame frame = new JFrame();
								frame.setSize(700, 300);
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
								panelInHoaDon panelInHoaDon = new panelInHoaDon();
								frame.add(panelInHoaDon);
								
								if (panelInHoaDon.btnIn.getActionListeners().length == 0) {
									panelInHoaDon.btnIn.addActionListener(new ActionListener() {
										private ChiTietHoaDon_DAO chitietHD_dao;
										@Override
										public void actionPerformed(ActionEvent e) {
											// Viết CODE IN TẠM TÍNH Ở ĐÂY
											frame.setVisible(false);
											int a = JOptionPane.showConfirmDialog(null, "Xác Nhận In Hóa Đơn " + x.name);
											if (a == JOptionPane.YES_OPTION) {
												functionNecessary d = new functionNecessary();
												String ngay = x.panelHoaDon.title.time + "  -  " + d.getCurrentTime();
												KhachHang KH = null;
												NhanVien NV = new NhanVien(MANHANVIEN);
												Phong P = null;
												khachHang_dao = new KhachHang_DAO();
												dsKH=khachHang_dao.getAllDSKhachHang();
												for (KhachHang kh : dsKH) {  
										    	   if (kh.getSoDienThoai().equals(x.panelHoaDon.title.sdtKH)) {
										    		   KH = kh;
										    	   }
												}
												phong_dao = new Phong_DAO();
										       dsP=phong_dao.getAllPhong();
										        for (Phong p : dsP) {
										        	if (p.getTenPhong().equals(x.name)) {
										        		P = p;
										        	}
										        }
										        String tongTien = d.formatMoney(x.panelHoaDon.title.getPriceTotal());

										        hoaDon_DAO = new HoaDon_DAO();
												Boolean isSuccess = false;
												ArrayList<Integer> dsMa = new ArrayList<Integer>();
												
												
												Map<String,String> row_main1=new HashMap<String,String>();
												List<Map<String, ?>> datax1=new ArrayList<Map<String, ?>>();
												

												for (HoaDon x : hoaDon_DAO.getAllHoaDon()) {
													String maTam = "";
													for (int i = x.getMaHoaDon().length() -3 ; i < x.getMaHoaDon().length(); i++) {
														maTam += String.valueOf( x.getMaHoaDon().charAt(i));
													}
													dsMa.add(Integer.parseInt(maTam));
												}
												
												int soTam = 0;
												for (int x : dsMa) {
													if (x > soTam) {
														soTam = x;
													}
												}
												row_main1.put("ma_TamTinh", "HD_" + d.formarMa(soTam + 1));
												row_main1.put("thoiGian_TamTinh", ngay.substring(10, 20));
												row_main1.put("kH_TamTinh", KH.getTenKhachHang());
												row_main1.put("phong_TamTinh", P.getTenPhong());
												row_main1.put("gioVao_TamTinh", ngay.substring(0,7));
												row_main1.put("gioRa_TamTinh", ngay.substring(27,34));
												row_main1.put("tongTien_TamTinh", tongTien);
												
												
												datax1.add(row_main1);
												
												for (int stt1 = 0; stt1 < x.panelHoaDon.table1.getRowCount(); stt1 ++) {
													Map<String,Object> row_x1=new HashMap<String,Object>();
													row_x1.put("dichVu_TamTinh", x.panelHoaDon.table1.table.getModel().getValueAt(stt1, 1).toString());
													row_x1.put("soLuong_TamTinh", x.panelHoaDon.table1.table.getModel().getValueAt(stt1, 2).toString());
													row_x1.put("giaBan_TamTinh", x.panelHoaDon.table1.table.getModel().getValueAt(stt1, 3).toString());
													row_x1.put("thanhTien_TamTinh", x.panelHoaDon.table1.table.getModel().getValueAt(stt1, 4).toString());
													datax1.add(row_x1);
									
												}
												
												JRDataSource jrsource1 = new JRBeanCollectionDataSource(datax1);
									            String sourceName1="src/Report/HoaDonTamTinh.jrxml";
									            
									            try {
									                JasperReport rp=JasperCompileManager.compileReport(sourceName1);
									                JasperPrint filledReport1=JasperFillManager.fillReport(rp, null,jrsource1);
									                JasperViewer jw1=new JasperViewer(filledReport1, false);
									                jw1.setVisible(true);
									                
									            } catch (JRException ex) {
									               ex.printStackTrace(); 
									            }
								        	}
								        }
									});
								}
								
								if (panelInHoaDon.btnIn2.getActionListeners().length == 0) {
									panelInHoaDon.btnIn2.addActionListener(new ActionListener() {

										private ChiTietHoaDon_DAO chitietHD_dao;

										@Override
										public void actionPerformed(ActionEvent e) {
											if (Integer.parseInt(panelInHoaDon.txtTienKhachDua.getText()) >= x.panelHoaDon.title.getPriceTotal()) {
												frame.setVisible(false);
													int a = JOptionPane.showConfirmDialog(null, "Xác Nhận In Hóa Đơn " + x.name);
													if (a == JOptionPane.YES_OPTION) {
													functionNecessary d = new functionNecessary();
													String ngay = x.panelHoaDon.title.time + "  -  " + d.getCurrentTime();
													KhachHang KH = null;
													NhanVien NV = new NhanVien(MANHANVIEN);
													Phong P = null;
													khachHang_dao = new KhachHang_DAO();
													dsKH=khachHang_dao.getAllDSKhachHang();
													for (KhachHang kh : dsKH) {  
											    	   if (kh.getSoDienThoai().equals(x.panelHoaDon.title.sdtKH)) {
											    		   KH = kh;
											    	   }
													}
													phong_dao = new Phong_DAO();
											       dsP=phong_dao.getAllPhong();
											        for (Phong p : dsP) {
											        	if (p.getTenPhong().equals(x.name)) {
											        		P = p;
											        	}
											        }
											        String tongTien = d.formatMoney(x.panelHoaDon.title.getPriceTotal());
											        String tienKhach = d.formatMoney(Integer.parseInt(panelInHoaDon.txtTienKhachDua.getText()));
											        hoaDon_DAO = new HoaDon_DAO();
													Boolean isSuccess = false;
											        if (hoaDon_DAO.create(new HoaDon("", ngay, KH, NV, P, tongTien, tienKhach))) {

														for (int i = 0; i< x.panelHoaDon.table1.getRowCount() ; i++) {
															DichVu dv = null;
															int soLuong = Integer.parseInt(x.panelHoaDon.table1.table.getModel().getValueAt(i, 2).toString());
															dichVu_dao = new DichVu_Dao();
															dvDV=dichVu_dao.getAllDichVu();
													        for (DichVu dv1 : dvDV) {
																if (dv1.getTenDichVu().equals(x.panelHoaDon.table1.table.getModel().getValueAt(i, 1))) {
																	dv = dv1;
																}
													        }
													        HoaDon hd = null;
													        dsHD = hoaDon_DAO.getAllHoaDon();
													        for (HoaDon hdx : dsHD) {
													        	if (hdx.getKhachHang().equals(KH) && hdx.getNhanVien().equals(NV)
													        			&& hdx.getNgayLapHoaDon().equals(ngay)&& hdx.getPhong().equals(P)) {
													        		hd = hdx;
													        	}
													        		
													        }
													        String thanhTien = x.panelHoaDon.table1.table.getModel().getValueAt(i, 4).toString();
															ChiTietHoaDon cthd = new ChiTietHoaDon("", dv, soLuong, hd, thanhTien);
															CTHD_DAO = new ChiTietHoaDon_DAO();
															if (CTHD_DAO.create(cthd)) {
																isSuccess = true;
															}
														}
														if (isSuccess.equals(true)) { 
															for (KhachHang xKH : dsKH) {
																if (xKH.getSoDienThoai().equals(panelHoaDon1.title.sdtKH)) {
																	xKH.setTongTienHoaDon(xKH.getTongTienHoaDon() + x.panelHoaDon.title.getPriceTotal());
																	khachHang_dao.update(xKH);
																	break;
																}
															}
															
															// Viết CODE In Hóa Đơn Ở Đây
															chitietHD_dao = new ChiTietHoaDon_DAO();
															ArrayList<HoaDon> dsHoaDon = hoaDon_DAO.getAllHoaDon();
															ArrayList<ChiTietHoaDon> dsCTHD = chitietHD_dao.getAllChiTietHoaDon();
															
															ArrayList<Integer> dsMa = new ArrayList<Integer>();
															
															
															Map<String,Object> row_main=new HashMap<String,Object>();
															List<Map<String, ?>> datax=new ArrayList<Map<String, ?>>();
															

															for (HoaDon x : hoaDon_DAO.getAllHoaDon()) {
																String maTam = "";
																for (int i = x.getMaHoaDon().length() -3 ; i < x.getMaHoaDon().length(); i++) {
																	maTam += String.valueOf( x.getMaHoaDon().charAt(i));
																}
																dsMa.add(Integer.parseInt(maTam));
															}
															
															int soTam = 0;
															for (int x : dsMa) {
																if (x > soTam) {
																	soTam = x;
																}
															}
															row_main.put("ma_hoa_don", "HD_" + d.formarMa(soTam + 1));
															row_main.put("thoi_gian", ngay.substring(10, 20));
															row_main.put("khach_hang", KH.getTenKhachHang());
															row_main.put("phong", P.getTenPhong());
															row_main.put("gio_vao", ngay.substring(0,7));
															row_main.put("gio_ra", ngay.substring(27,34));
															row_main.put("tong_tien", tongTien);
															row_main.put("tien_khach", tienKhach);
															
															datax.add(row_main);
															
															for (int stt = 0; stt < x.panelHoaDon.table1.getRowCount(); stt ++) {
																Map<String,Object> row_x=new HashMap<String,Object>();
																row_x.put("dich_vu", x.panelHoaDon.table1.table.getModel().getValueAt(stt, 1).toString());
																row_x.put("so_luong", x.panelHoaDon.table1.table.getModel().getValueAt(stt, 2).toString());
																row_x.put("gia_ban", x.panelHoaDon.table1.table.getModel().getValueAt(stt, 3).toString());
																row_x.put("thanh_tien", x.panelHoaDon.table1.table.getModel().getValueAt(stt, 4).toString());
																datax.add(row_x);
												
															}
															
															JRDataSource jrsource = new JRBeanCollectionDataSource(datax);
												            String sourceName="src/Report/HoaDon.jrxml";
												            
												            try {
												                JasperReport rp=JasperCompileManager.compileReport(sourceName);
												                JasperPrint filledReport=JasperFillManager.fillReport(rp, null,jrsource);
												                JasperViewer jw=new JasperViewer(filledReport, false);
												                jw.setVisible(true);
												                
												            } catch (JRException ex) {
												               ex.printStackTrace(); 
												            }
												            
												            

															
															
															
															
															
															// ********************
															
															// Reset Table
															x.panelHoaDon.table1.removeAll();
															
															// Reset Customer
															if (kh != null) {
																panelHoaDon1.title.nameKH = kh.getTenKhachHang();
																panelHoaDon1.title.sdtKH = kh.getSoDienThoai();
																panelHoaDon1.title.customer.setText("Khách Hàng : " + kh.getTenKhachHang() + "          Số Điện Thoại : " + kh.getSoDienThoai());
															} else {
																x.panelHoaDon.title.customer.setText("Số Điện Thoại Khách Hàng : " );
																x.panelHoaDon.title.textSDT.setText("");
																x.panelHoaDon.title.title3.add(panelHoaDon1.title.boxSDT);
															}
															
															// Reset Button 
															x.panelHoaDon.btnLapHoaDon.lblname.setText(" Lập Hóa Đơn");
															x.panelHoaDon.btnLapHoaDon.setColor1("#12c2e9");
															x.panelHoaDon.btnLapHoaDon.setColor2("#c471ed");
															
															// Reset Time
															x.panelHoaDon.title.time = "---";
															x.panelHoaDon.title.infoTime.setText("Giờ Hát : " + x.panelHoaDon.title.time);
															
															// Reset Tính Giờ
															x.panelHoaDon.title.btnBamGio.status = "open";
															x.panelHoaDon.title.btnBamGio.eventclickbuttonanimation();
															x.panelHoaDon.title.t.stop();
															x.panelHoaDon.title.Resettitle ();
															
															// Reset Price
															x.panelHoaDon.thanhTien = 0;
															x.panelHoaDon.title.priceTotal = 0;
															x.panelHoaDon.title.totalMoney.setText("Tổng Cộng : " + d.formatMoney(x.panelHoaDon.title.getPriceTotal()));
															
															listPhong.UpdatePhongDangSuDung();
															x.panelHoaDon.t.stop();
															for (buttonListDichVu tt : x.panelHoaDon.listDichVuMini.listDichVu) {
																tt.setAmount(0);
											                }
															x.panelHoaDon.repaint();
															JOptionPane.showMessageDialog(null, "In Hóa Đơn Thanh Toán Thành Công !!");
															
														}
													}
												}
											} else {
												JOptionPane.showMessageDialog(null,"Tiền Khách Đưa Không Hợp Lệ !!!" );
											}
										}
									});
								}
	
							} else {
								JOptionPane.showMessageDialog(null, "Vui Lòng Lập Hóa Đơn Trước Khi In Hóa Đơn");
							}
							
						}
					});
				}
			}
		}
	}
	public int dem() {
		int i = 0 ;
		for (buttonListPhong t : listPhong.listPhong) {	
			if (t.label.getText().contains("Sử Dụng")) {
				i++;
			}
		}
		return i;
	}

}
