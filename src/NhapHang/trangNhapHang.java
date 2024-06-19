package NhapHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Function.functionNecessary;
import content.trangKhongMenu;
import content.DichVu.trangDichVu;
import content.hoa_don.buttonListPhong;
import content.hoa_don.listDichVu;
import content.hoa_don.listKhachHang;
import content.hoa_don.listPhong;
import content.hoa_don.trangHoaDon;

public class trangNhapHang extends trangKhongMenu implements ActionListener{

	private listDV listDichVu;
	private JScrollPane js2;
	private JPanel panelJS2;
	private Box boxLeft;
	private Box boxRight;
	private Box boxTotal;
	private panelNhapHang panelInfo;
	private int sizeListDichVu = 101;
	private buttonListPhong btnDichVu;
	private listKhachHang listPhong;
	private JScrollPane js3;
	private listDVNCC listTam;
	private String nameEmploy;
	public trangNhapHang (Box boxTotal1, trangHoaDon trangHoaDon) {
		listDichVu = new listDV();
		js2 =new JScrollPane(listDichVu, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js2.setBorder(BorderFactory.createEmptyBorder());
		js2.getVerticalScrollBar().setUnitIncrement(6);
		js2.setBackground(Color.white);
		listDichVu.setPreferredSize(new Dimension(520, sizeListDichVu * listDichVu.m));
		if (listDichVu.m <= 7) {
			js2.setPreferredSize(new Dimension(550, sizeListDichVu * listDichVu.m));
		}else {
			js2.setPreferredSize(new Dimension(550, sizeListDichVu * 7));
		} 
		
		panelJS2 = new JPanel();
		panelJS2.setPreferredSize(new Dimension(570,720));
		panelJS2.setBackground(Color.white);
		panelJS2.add(js2);
		
		panelInfo = new panelNhapHang(trangHoaDon);
		btnDichVu = new buttonListPhong("Dịch Vụ", "hinh/button/btn_ListPhong.png", "title","",new listKhachHang(), new listDichVu(), new listPhong(new listDichVu(), listPhong));
		boxLeft = Box.createVerticalBox();
		boxRight = Box.createVerticalBox();
		boxTotal = Box.createHorizontalBox();
		boxLeft.add(Box.createRigidArea(new Dimension(0, 20)));
		add(boxTotal);
		boxTotal.add(boxLeft);
		boxTotal.add(Box.createRigidArea(new Dimension(7,0)));
		boxTotal.add(boxRight);
		JPanel boxtop = new JPanel();
		boxtop.setBackground(null);
		boxtop.setOpaque(false);
		boxtop.setBorder(null);
		boxtop.add(btnDichVu);
		boxtop.setLayout(new GridLayout(1, 0));
		boxtop.add(Box.createRigidArea(new Dimension(1,0)));
		boxtop.add(Box.createRigidArea(new Dimension(1,0)));
		boxLeft.add(boxtop);
		boxLeft.add(panelJS2);
		boxRight.add(panelInfo);
		
		if (panelInfo.title.cboNCC.getActionListeners().length == 1) {
			panelInfo.title.cboNCC.addActionListener(new ActionListener() {
				
				private functionNecessary d;

				@Override
				public void actionPerformed(ActionEvent e) {
					Boolean isNull = false;
					d = new functionNecessary();
					if (panelInfo.table.getRowCount() > 0) {
						int a = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xóa Dữ Liệu Vừa Thêm");
						if (a == JOptionPane.YES_OPTION) {
							panelInfo.table.removeAll();
							panelInfo.reSetSTT();
							panelInfo.title.tongtien = 0;
							panelInfo.title.lbl1.setText("Tổng Tiền : " + d.formatMoney(panelInfo.title.tongtien));
							isNull = true;
						}
					}
					else {
						isNull = true;
					}
					if (isNull == true) {
						if (panelInfo.title.cboNCC.getSelectedItem().toString().equals("Không")) {
							listDichVu = new listDV();
							listDichVu.setM();
							js2 =new JScrollPane(listDichVu,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
							js2.setBorder(BorderFactory.createEmptyBorder());
							js2.getVerticalScrollBar().setUnitIncrement(6);
							js2.setBackground(Color.white);
							listDichVu.setPreferredSize(new Dimension(520, sizeListDichVu * listDichVu.m));
							if (listDichVu.m <= 7) {
								js2.setPreferredSize(new Dimension(550, sizeListDichVu * listDichVu.m));
							}else {
								js2.setPreferredSize(new Dimension(550, sizeListDichVu * 7));
							} 
							panelJS2.removeAll();
							panelJS2.add(js2);
							invalidate();
				        	validate();
				        	repaint();
						} else {
							listTam = new listDVNCC(panelInfo.title.cboNCC.getSelectedItem()+ "");
							listTam.setM();
							js2 =new JScrollPane(listTam,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
							js2.setBorder(BorderFactory.createEmptyBorder());
							js2.getVerticalScrollBar().setUnitIncrement(6);
							js2.setBackground(Color.white);
							listTam.setPreferredSize(new Dimension(520, sizeListDichVu * listTam.m));
							if (listTam.m <= 7) {
								js2.setPreferredSize(new Dimension(550, sizeListDichVu * listTam.m));
							}else {
								js2.setPreferredSize(new Dimension(550, sizeListDichVu * 7));
							} 
							panelJS2.removeAll();
							panelJS2.add(js2);
							invalidate();
				        	validate();
				        	repaint();
				        	addEvent();
						}
					}
				}
			});
		}
		
		for (btnListDV x : listDichVu.listDichVu ) {
			if (x.getActionListeners().length == 0) {
				x.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Vui lòng Chọn Nhà Cung Cấp");
						
					}
					
				});
			}
		}
		
		panelInfo.btnQLDV.addActionListener(new ActionListener() {
			private trangDichVu trangDichVu;
			@Override
			public void actionPerformed(ActionEvent e) {
				boxTotal1.remove(1);
				trangDichVu = new trangDichVu("#5B86E5", "#FC466B", "Quan Li", trangHoaDon, nameEmploy);
				boxTotal1.add(trangDichVu);
	        	boxTotal1.invalidate();
	        	boxTotal1.validate();
	        	boxTotal1.repaint();
			}
		});
		
		
	}
	public void addEvent () {
		for (btnListDV x : listTam.listDichVu ) {
			if (x.getActionListeners().length == 0) {
				x.addActionListener(new ActionListener() {
					private int soLuong = 0;
					private panelSoLuong panelSoLuong;
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame();
						frame.setSize(500, 120);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						panelSoLuong = new panelSoLuong();
						frame.add(panelSoLuong);
						panelSoLuong.btnThem.addActionListener(new ActionListener() {
							private functionNecessary d;

							@Override
							public void actionPerformed(ActionEvent e) {
								d = new functionNecessary();
								if (panelSoLuong.txtSoLuong.getText() != "") {
									frame.setVisible(false);
									panelInfo.table.addRow(new Object[] {panelInfo.table.getRowCount()+ 1,
											x.name , panelSoLuong.txtSoLuong.getText(), d.formatMoney(Integer.parseInt(x.price)),
											d.formatMoney(Integer.parseInt(panelSoLuong.txtSoLuong.getText()) * Integer.parseInt(x.price)) });
									panelInfo.title.tongtien += Integer.parseInt(panelSoLuong.txtSoLuong.getText()) * Integer.parseInt(x.price);
									panelInfo.title.lbl1.setText("Tổng Tiền : " + d.formatMoney(panelInfo.title.tongtien));
								} else {
									JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Số Lượng");
								}
							}
						});
					}
				});
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
