package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
// 22 pakage , 126 class
public class formDangNhap extends JFrame {
	private JPanel panel;
	public formDangNhap () throws IOException {
		setSize(470,450);
		setLocationRelativeTo(null);
		setUndecorated(true);
		panel = new panelDangNhap("#ED4264","#FFEDBC", this);
		add(panel);
		
	}
	public static void main(String[] args) throws IOException {
		new formDangNhap().setVisible(true);
	}

}
