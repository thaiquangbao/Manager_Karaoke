package content.hoa_don;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class button extends JButton {
    public button (String name, Color backGround, Color color, Font font, String icon) {
        setPreferredSize(new Dimension(250, 50));
        setBackground(backGround);
        setForeground(color);
        setText(name);
        setFont(font);
        // setIcon(new ImageIcon(icon));
    }
    
}