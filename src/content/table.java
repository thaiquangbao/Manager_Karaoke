package content;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Vector;
import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import swing.TableDark;



public class table extends JScrollPane{
	private DefaultTableModel model;
	public TableDark table;



	public table (String[] header) {
		model = new DefaultTableModel(header,0);
		table = new TableDark();
		table.setModel(model);
		getViewport().add(table);
		setPreferredSize(new Dimension(1200, 450));
		setBorder(null);
//		addRow (new Object[] {"1", "VuTienDuc", "PhungAnhMinh", "Love You", "1212", "25/05"});
//		addRow (new Object[] {"1", "abc", "PhungAnhMinh", "xyz", "1212", "25/05"});
//		addRow (new Object[] {"1", "abc", "PhungAnhMinh1", "xyz1", "1212", "25/05"});
	}
	
	public void addRow (Object[] ds) {
		model.addRow(ds);
	}
	public int getRowCount () {
		return table.getRowCount();
	}
	public int getSelectedRow () {
		return table.getSelectedRow();
	}
	public void removeRow (int row) {
		model.removeRow(row);
	}
	public void removeAll () {
		int row = table.getRowCount(); 
		for (int i = 0; i< row; i++) {
			model.removeRow(0);
		}
	}
	public void insertRow (int i, Object[] ds) {
		model.insertRow(i, ds);
	}
}
