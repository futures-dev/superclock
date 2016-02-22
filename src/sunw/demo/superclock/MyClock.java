package sunw.demo.superclock;
// package sunw.demo

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import java.awt.*;

public class MyClock extends JFXPanel {

    public MyClock() {
        MyClockView root = new MyClockView();
        setScene(new Scene(root));
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }
}
