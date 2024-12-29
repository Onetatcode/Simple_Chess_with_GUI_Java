package Main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel {

    public static final int Width = 1100;
    public static final int Height = 800;

    public GamePanel(){
        setPreferredSize(new Dimension(Width,Height));
        setBackground(Color.BLACK);
    }
}
