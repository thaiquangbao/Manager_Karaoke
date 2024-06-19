package content.TongQuan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Function.functionNecessary;
import content.trangKhongMenu;
import content.ThongKe.trangTKHD;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuPage;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;



public class trangTongQuan extends trangKhongMenu{

	private nodeTongQuan node1;
	private nodeTongQuan node2;
	private nodeTongQuan node3;
	private nodeTongQuan node4;
	private chart chart;
	private nodeTongQuan node5;
	private nodeTongQuan node6;
	private nodeTongQuan node7;
	private nodeTongQuan node8;

	private NhanVien_DAO nhanVien_dao;
    private ArrayList<NhanVien> dsNV;
    private KhachHang_DAO khachhang_dao;
    private ArrayList<KhachHang> dsKH;
    private HoaDon_DAO hoadon_dao;
    private ArrayList<HoaDon> dsHD;
    private PhieuDatPhong_DAO phieudatphong_dao;
    private ArrayList<PhieuDatPhong> dsPDP;
	private functionNecessary d;
	public trangTongQuan (trangHoaDon tranghoadon) {
		
		hoadon_dao=new HoaDon_DAO();
		dsHD=hoadon_dao.getAllHoaDon();
		int demhd=dsHD.size();
		 
		nhanVien_dao=new NhanVien_DAO();
		dsNV=nhanVien_dao.getAllNhanVien();
		int demnv=dsNV.size();
		
		phieudatphong_dao=new PhieuDatPhong_DAO();
		dsPDP=phieudatphong_dao.getAllPhieuDatPhong();
		int dempdp=dsPDP.size();
		
		khachhang_dao=new KhachHang_DAO();
		dsKH=khachhang_dao.getAllDSKhachHang();
		int demkh=dsKH.size();
		
		d = new functionNecessary(); 
		trangTKHD tkhd =new trangTKHD();
		
		int demPSD=tranghoadon.dem();
		
		
		
		
		setBackground(Color.white);
		Box totalBox = Box.createVerticalBox();
		Box rowNode1 = Box.createHorizontalBox();
		Box rowNode2 = Box.createHorizontalBox();
		Box rowChart = Box.createHorizontalBox();
		add(totalBox);
		Font fontNode = new Font("Arial", Font.BOLD , 19);
		
		node1 = new nodeTongQuan("Đơn Hàng", demhd+"", "hinh/node/node_DonHang.png",
				"#642B73", "#ff00cc", fontNode);
		node2 = new nodeTongQuan("Lợi Nhuận",d.formatMoney(tkhd.tinhdoanhthu()-tkhd.tinhkhchi())+"", "hinh/node/node_DoanhThu.png",
				"#2980B9", "#6DD5FA", fontNode);
		node3 = new nodeTongQuan("Khoảng Thu", d.formatMoney(tkhd.tinhdoanhthu())+"", "hinh/node/node_DichVu.png",
				"#F37335", "#FDC830", fontNode);
		node4 = new nodeTongQuan("Khoảng Chi", d.formatMoney(tkhd.tinhkhchi())+"", "hinh/node/node_YKien.png",
				"#1D976C", "#93F9B9", fontNode);
		node5 = new nodeTongQuan("Phòng Đã Đặt", dempdp+"", "hinh/node/node_PhongDaDat.png",
				"#544a7d", "#ffd452", fontNode);
		node6 = new nodeTongQuan("Phòng Sử Dụng", demPSD+"/" + tranghoadon.listPhong.listPhong.size(), "hinh/node/node_Phong.png",
				"#CF8BF3", "#FDB99B", fontNode);
		node7 = new nodeTongQuan("Số Khách Hàng",demkh + "", "hinh/node/node_KhachHang.png",
				"#3494E6", "#EC6EAD", fontNode);
		node8 = new nodeTongQuan("Số Nhân Viên", demnv + "", "hinh/node/node_NhanVien.png",
				"#304352", "#d7d2cc", fontNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 5)));
		totalBox.add(rowNode1);
		rowNode1.add(node1);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node2);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node3);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node4);
		
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 7)));
		totalBox.add(rowNode2);
		rowNode2.add(node5);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node6);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node7);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node8);
		
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
		totalBox.add(rowChart); 
		rowChart.add(new chart());
	}
}
