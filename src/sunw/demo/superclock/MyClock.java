package sunw.demo.superclock;
// package sunw.demo

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class MyClock extends JFXPanel {

    java.util.Timer timer = new java.util.Timer();
    MyClockView root;
    public MyClock() {
        root = new MyClockView();
        setScene(new Scene(root));
        setVisible(true);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        repaint();
                    }
                });
            }
        }, 0, 2000);

    }

    public void paint(Graphics g) {
        super.paint(g);
        root.setDayNumber(39);
        root.requestLayout();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and JavaFX");
        frame.add(new MyClock());
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(frame);

    }
}
