/**
 * Created by Andrei Kolomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;

/**
 * Swing-compatible java bean presenting a clock.
 */
public class MyClock extends JFXPanel {
    /**
     * Time Zone names to be used as tags in beanbox.
     */
    public static final String[] TIME_ZONE_NAMES_ARRAY = TimeZoneManager.TIME_ZONES.keySet().toArray(new String[TimeZoneManager.TIME_ZONES.size()]);

    /**
     * JavaFX component to be presented
     */
    private MyClockView root;

    /**
     * Constructs an instance of MyClock component
     */
    public MyClock() {
        root = new MyClockView();
        setScene(new Scene(root));
        setVisible(true);
        Dimension dim = new Dimension((int) root.getWidth(), (int) root.getHeight());
        setMinimumSize(dim);
        setMaximumSize(dim);
    }

    /**
     * Entry point for debugging stand-alone
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and JavaFX");
        frame.add(new MyClock());
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Converts Color object to HEX representation
     *
     * @param color Color to convert
     * @return String of format "#%02x%02x%02x"
     */
    public static String ColorToHexConvert(Color color) {
        return String.format("#%02x%02x%02x", (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    //region bean Properties

    public String getBackColorPM() {
        return ColorToHexConvert(root.myClockViewController.getBackColorPM());
    }

    public void setBackColorPM(String val) {
        root.myClockViewController.setBackColorPM(Color.valueOf(val));
    }

    public String getBackColorAM() {
        return ColorToHexConvert(root.myClockViewController.getBackColorAM());
    }

    public void setBackColorAM(String val) {
        root.myClockViewController.setBackColorAM(Color.valueOf(val));
    }

    public String getForeColorAM() {
        return ColorToHexConvert(root.myClockViewController.getForeColorAM());
    }

    public void setForeColorAM(String val) {
        root.myClockViewController.setForeColorAM(Color.valueOf(val));
    }

    public String getForeColorPM() {
        return ColorToHexConvert(root.myClockViewController.getForeColorPM());
    }

    public void setForeColorPM(String val) {
        root.myClockViewController.setForeColorPM(Color.valueOf(val));
    }

    public String getTimeZone() {
        return TimeZoneManager.TimeZoneToStringConvert(root.myClockViewController.getTimeZone());
    }

    public void setTimeZone(String val) {
        root.myClockViewController.setTimeZone(TimeZoneManager.StringToTimeZoneConvert(val));
    }

    public boolean isStopped() {
        return root.myClockViewController.isStopped();
    }

    public void setStopped(boolean val) {
        root.myClockViewController.setStopped(val);
    }

    public String getCurrentTime() {
        return "xx:xx:xx";
    }

    public void setCurrentTime(String val) {
        root.myClockViewController.setCurrentTime(val);
    }

    //endregion
}
