package content.TongQuan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Function.functionNecessary;
import dao.HoaDon_DAO;
import dao.PhieuNhapHang_DAO;
import entity.HoaDon;
import entity.PhieuNhapHang;
import swing.BarChart;
import swing.ModelChart;

 
public class chart extends BarChart {
	private HoaDon_DAO hoadon_dao;
	private PhieuNhapHang_DAO phieuNhapHang_dao;
	public chart () { 
		setPreferredSize(new Dimension(0, 500));
		setTitle("\nThống Kê Tổng Quan");
		setTitleFont(new Font("", Font.BOLD, 20));
		setTitleColor(Color.black);
		addLegend("Đơn Hàng", Color.decode("#f5af19"), Color.decode("#f12711"));
		addLegend("Khoảng Thu", Color.decode("#a044ff"), Color.decode("#6a3093"));
		addLegend("Khoảng Chi      ", Color.decode("#FFF94C"), Color.decode("#FFF94C"));
		
		
		hoadon_dao=new HoaDon_DAO();
		phieuNhapHang_dao = new PhieuNhapHang_DAO();
		functionNecessary d = new functionNecessary();
		
		for (int i =1 ; i<= 12; i++) {
			int soHoaDon = 0;
			int KhoangThu = 0;
			int KhoangChi = 0;
			for (HoaDon x : hoadon_dao.getAllHoaDon()) {
				if (Integer.parseInt(x.getNgayLapHoaDon().substring(13,15)) == i) {
					soHoaDon ++;
					KhoangThu += Integer.parseInt(d.formatString(x.getTongTien()));
				}
			}
			for (PhieuNhapHang y : phieuNhapHang_dao.getAllPhieuNhapHang()) {
				if (Integer.parseInt(y.getThoiGian().substring(13,15)) == i) {
					KhoangChi += Integer.parseInt(d.formatString(y.getTongTien()));
				}
			}
			int sizeHoaDon = 1000 * ((soHoaDon * 100) / 100) / 100 ;
			int sizeKhoangThu = 1000 * (KhoangThu/1500000)/100 ;
			int sizeKhoangChi = 1000 * (KhoangChi/1500000)/100 ;
			if (sizeHoaDon == 0) {
				sizeHoaDon += 12; 
			}
			if (sizeKhoangThu == 0) {
				sizeKhoangThu += 12; 
			}
			if (sizeKhoangChi == 0) {
				sizeKhoangChi += 12; 
			}
			addData(new ModelChart("Tháng " + i, new double[]{sizeHoaDon, sizeKhoangThu, sizeKhoangChi}));
		}

		start(); 
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#74ebd5"), w, h, Color.decode("#ACB6E5"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
