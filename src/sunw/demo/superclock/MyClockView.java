package sunw.demo.superclock;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Andrei on 22.02.2016.
 */

public class MyClockView extends Pane {
    //region width
    public static final Double DEFAULT_WIDTH = 500.0;
    //region height
    public static final Double DEFAULT_HEIGHT = 500.0;
    //region radius
    public static final Double DEFAULT_RADIUS = 200.0;
    //region backColorPM
    public static final String DEFAULT_BACKCOLORPM = "#FFFF00";
    //region backColorAM
    public static final String DEFAULT_BACKCOLORAM = "#0000FF";
    //region currentBackColor
    public static final String DEFAULT_CURRENTBACKCOLOR = DEFAULT_BACKCOLORAM;
    //endregion
    public static final String DEFAULT_AM_PM = "AM";
    public static final String DEFAULT_city = "Moscow (UTC+03:00)";
    public static final String DEFAULT_dayNumber = "01";
    //region x1
    public static final Double DEFAULT_x1 = .0;
    //endregion
    //region y1
    public static final Double DEFAULT_y1 = -200.0;
    //region x2
    public static final Double DEFAULT_x2 = 150.0;
    //region y2
    public static final Double DEFAULT_y2 = 0.0;
    //region x3
    public static final Double DEFAULT_x3 = -100.0;
    //endregion

    //region backColor
    //region y3
    public static final Double DEFAULT_y3 = .0;
    MyClockController controller = new MyClockController();
    private DoubleProperty _width = new SimpleDoubleProperty(DEFAULT_WIDTH);
    private DoubleProperty _height = new SimpleDoubleProperty(DEFAULT_HEIGHT);
    //endregion
    private DoubleProperty _radius = new SimpleDoubleProperty(DEFAULT_RADIUS);
    private StringProperty _backColorPM = new SimpleStringProperty(DEFAULT_BACKCOLORPM);
    private StringProperty _backColorAM = new SimpleStringProperty(DEFAULT_BACKCOLORAM);
    private StringProperty _currentBackColor = new SimpleStringProperty(DEFAULT_CURRENTBACKCOLOR);
    //endregion
    private StringProperty _AM_PM = new SimpleStringProperty(DEFAULT_AM_PM);
    private StringProperty _city = new SimpleStringProperty(DEFAULT_city);
    private StringProperty _dayNumber = new SimpleStringProperty(DEFAULT_dayNumber);
    private DoubleProperty _x1 = new SimpleDoubleProperty(DEFAULT_x1);
    //endregion

    //endregion

    //region AM_PM
    private DoubleProperty _y1 = new SimpleDoubleProperty(DEFAULT_y1);
    private DoubleProperty _x2 = new SimpleDoubleProperty(DEFAULT_x2);
    private DoubleProperty _y2 = new SimpleDoubleProperty(DEFAULT_y2);
    private DoubleProperty _x3 = new SimpleDoubleProperty(DEFAULT_x3);
    private DoubleProperty _y3 = new SimpleDoubleProperty(DEFAULT_y3);

    //endregion


    //region city

    public MyClockView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "MyClock.fxml"));
        fxmlLoader.getNamespace().put("bind", this);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
        }
        controller.setView(this);
        InitializeComponents();
    }

    public final double getWidth_() {
        return _width.get();
    }

    public final void setWidth_(Double value) {
        _width.set(value);
    }

    public final double getHeight_() {
        return _height.get();
    }

    //endregion

    //region dayNumber

    public final void setHeight_(Double value) {
        _height.set(value);
    }

    public final double getRadius_() {
        return _radius.get();
    }

    public final void setRadius_(Double value) {
        _radius.set(value);
    }

    public final String getBackColorPM() {
        return _backColorPM.get();
    }

    //endregion

    //region Arrows

    public final void setBackColorPM(String value) {
        _backColorPM.set(value);
    }

    public final String getBackColorAM() {
        return _backColorAM.get();
    }

    public final void setBackColor(String value) {
        _backColorAM.set(value);
    }

    public final String getCurrentBackColor() {
        return _currentBackColor.get();
    }
    //endregion

    public final void setCurrentBackColor(String value) {
        _currentBackColor.set(value);
    }

    public final String getAM_PM() {
        return _AM_PM.get();
    }

    public void setAM_PM(int a) {
        setAM_PM(a == 0 ? "AM" : "PM");
    }

    public final void setAM_PM(String value) {
        _AM_PM.set(value);
        if (value.equals("AM")) {
            _currentBackColor.set(_backColorAM.get());
        } else {
            _currentBackColor.set(_backColorPM.get());
        }
    }
    //endregion

    public final String getCity() {
        return _city.get();
    }

    public final void setCity(String value) {
        _city.set(value);
    }

    public final String getDayNumber() {
        return _dayNumber.get();
    }

    public final void setDayNumber(String value) {
        _dayNumber.set(value);
    }

    public final Double getX1() {
        return _x1.get();
    }
    //endregion

    public final void setX1(Double value) {
        _x1.set(value);
    }

    public final Double getY1() {
        return _y1.get();
    }

    public final void setY1(Double value) {
        _y1.set(value);
    }

    public void setLine1(int hour) {
        // hour is [0;36)
        double angle = Math.toRadians(hour * 10);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
    }
    //endregion

    public final Double getX2() {
        return _x2.get();
    }

    public final void setX2(Double value) {
        _x2.set(value);
    }

    public final Double getY2() {
        return _y2.get();
    }

    public final void setY2(Double value) {
        _y2.set(value);
    }

    public void setLine2(int minute) {
        // minute is [0;60)
        double angle = Math.toRadians(minute * 6);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
    }
    //endregion

    public final Double getX3() {
        return _x3.get();
    }

    public final void setX3(Double value) {
        _x3.set(value);
    }

    public final Double getY3() {
        return _y3.get();
    }

    public final void setY3(Double value) {
        _y3.set(value);
    }
    //endregion

    public void setLine3(int second) {
        // second is [0;60)
        double angle = Math.toRadians(second * 6);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
    }

    //endregion


    private void InitializeComponents() {

    }
}
