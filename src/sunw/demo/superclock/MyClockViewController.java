package sunw.demo.superclock;


import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.*;

/**
 * Created by Andrei on 22.02.2016.
 */
public class MyClockViewController implements Initializable{

    //region FXML

    @FXML
    private TextField dayNumberTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField AM_PMTextField;

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    //endregion

    MyClockView view;

    //region consts

    private final int PERIOD = 500;

    //endregion

    Timer secondTimer;

    Calendar calendar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // bindings

        dayNumberTextField.textProperty().bind(_dayNumber);
        cityTextField.textProperty().bind(_city);
        AM_PMTextField.textProperty().bind(_AM_PM);
        line1.endXProperty().bind(_x1);
        line1.endYProperty().bind(_y1);
        line2.endXProperty().bind(_x2);
        line2.endYProperty().bind(_y2);
        line3.endXProperty().bind(_x3);
        line3.endYProperty().bind(_y3);

        // timers
        secondTimer = new Timer("second");
        calendar = new GregorianCalendar();
        secondTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                calendar.setTimeInMillis(System.currentTimeMillis());
                setLine3(calendar.get(Calendar.SECOND));
                setLine2(calendar.get(Calendar.MINUTE));
                setLine1(3 * calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) / 20);
                setDayNumber(calendar.get(Calendar.DAY_OF_MONTH));
                setAM_PM(calendar.get(Calendar.AM_PM));
            }
        }, 0, PERIOD);
    }
    public MyClockViewController(MyClockView view) {
        this.view = view;
        System.out.println("con");
    }

    public void setTimeZone(String timeZone) {

    }

    public void mouseEntered(MouseEvent e){
        System.out.println("mouse");
    }


    //region properties

    //region width
    public static final Double DEFAULT_WIDTH = 500.0;
    private DoubleProperty _width = new SimpleDoubleProperty(DEFAULT_WIDTH);

    public final double getWidth_() {
        return _width.get();
    }

    public final void setWidth_(Double value) {
        _width.set(value);
    }
    //endregion

    //region height
    public static final Double DEFAULT_HEIGHT = 500.0;
    private DoubleProperty _height = new SimpleDoubleProperty(DEFAULT_HEIGHT);

    public final double getHeight_() {
        return _height.get();
    }

    public final void setHeight_(Double value) {
        _height.set(value);
    }
    //endregion

    //region radius
    public static final Double DEFAULT_RADIUS = 200.0;
    private DoubleProperty _radius = new SimpleDoubleProperty(DEFAULT_RADIUS);

    public final double getRadius_() {
        return _radius.get();
    }

    public final void setRadius_(Double value) {
        _radius.set(value);
    }
    //endregion

    //region backColor

    //region backColorPM
    public static final String DEFAULT_BACK_COLOR_PM = "#FFFF00";
    private StringProperty _backColorPM = new SimpleStringProperty(DEFAULT_BACK_COLOR_PM);

    public final String getBackColorPM() {
        return _backColorPM.get();
    }

    public final void setBackColorPM(String value) {
        _backColorPM.set(value);
    }
    //endregion

    //region backColorAM
    public static final String DEFAULT_BACK_COLOR_AM = "#0000FF";
    private StringProperty _backColorAM = new SimpleStringProperty(DEFAULT_BACK_COLOR_AM);

    public final String getBackColorAM() {
        return _backColorAM.get();
    }

    public final void setBackColorAM(String value) {
        _backColorAM.set(value);
    }
    //endregion

    //region currentBackColor
    public static final String DEFAULT_CURRENTBACKCOLOR = DEFAULT_BACK_COLOR_AM;
    private StringProperty _currentBackColorAM = new SimpleStringProperty(DEFAULT_CURRENTBACKCOLOR);

    public final String getCurrentBackColor() {
        return _currentBackColorAM.get();
    }

    public final void setCurrentBackColor(String value) {
        _currentBackColorAM.set(value);
    }
    //endregion

    //endregion

    //region AM_PM

    public static final String DEFAULT_AM_PM = "AM";
    private StringProperty _AM_PM = new SimpleStringProperty(DEFAULT_AM_PM);

    public final String getAM_PM() {
        return _AM_PM.get();
    }

    public final void setAM_PM(String value) {
        _AM_PM.set(value);
        if (value.equals("AM")) {
            _currentBackColorAM.set(_backColorAM.get());
        } else {
            _currentBackColorAM.set(_backColorPM.get());
        }
    }

    public void setAM_PM(int a) {
        setAM_PM(a == 0 ? "AM" : "PM");
    }

    //endregion


    //region city

    public static final String DEFAULT_city = "Moscow (UTC+03:00)";
    private StringProperty _city = new SimpleStringProperty(DEFAULT_city);

    public final String getCity() {
        return _city.get();
    }

    public final void setCity(String value) {
        _city.set(value);
    }

    //endregion

    //region dayNumber

    public static final String DEFAULT_dayNumber = "01";
    public StringProperty _dayNumber = new SimpleStringProperty(DEFAULT_dayNumber);

    public final String getDayNumber() {
        return _dayNumber.get();
    }

    public final void setDayNumber(String value) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                _dayNumber.set(value);
            }
        });
    }

    public void setDayNumber(int value) {
        setDayNumber(String.format("%02d", value));
    }

    //endregion

    //region Arrows

    //region x1
    public static final Double DEFAULT_x1 = .0;
    private DoubleProperty _x1 = new SimpleDoubleProperty(DEFAULT_x1);

    public final Double getX1() {
        return _x1.get();
    }

    public final void setX1(Double value) {
        _x1.set(value);
    }
    //endregion

    //region y1
    public static final Double DEFAULT_y1 = -200.0;
    private DoubleProperty _y1 = new SimpleDoubleProperty(DEFAULT_y1);

    public final Double getY1() {
        return _y1.get();
    }

    public final void setY1(Double value) {
        _y1.set(value);
    }
    //endregion

    public void setLine1(int hour) {
        // hour is [0;36)
        double angle = Math.toRadians(hour * 10);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
    }

    //region x2
    public static final Double DEFAULT_x2 = 150.0;
    private DoubleProperty _x2 = new SimpleDoubleProperty(DEFAULT_x2);

    public final Double getX2() {
        return _x2.get();
    }

    public final void setX2(Double value) {
        _x2.set(value);
    }
    //endregion

    //region y2
    public static final Double DEFAULT_y2 = 0.0;
    private DoubleProperty _y2 = new SimpleDoubleProperty(DEFAULT_y2);

    public final Double getY2() {
        return _y2.get();
    }

    public final void setY2(Double value) {
        _y2.set(value);
    }
    //endregion

    public void setLine2(int minute) {
        // minute is [0;60)
        double angle = Math.toRadians(minute * 6);
        setX2(getRadius_() * Math.sin(angle));
        setY2(-getRadius_() * Math.cos(angle));
    }

    //region x3
    public static final Double DEFAULT_x3 = -100.0;
    private DoubleProperty _x3 = new SimpleDoubleProperty(DEFAULT_x3);

    public final Double getX3() {
        return _x3.get();
    }

    public final void setX3(Double value) {
        _x3.set(value);
    }
    //endregion

    //region y3
    public static final Double DEFAULT_y3 = .0;
    private DoubleProperty _y3 = new SimpleDoubleProperty(DEFAULT_y3);

    public final Double getY3() {
        return _y3.get();
    }

    public final void setY3(Double value) {
        _y3.set(value);
    }
    //endregion

    public void setLine3(int second) {
        setCurrentBackColor("#FFFF00");
        // second is [0;60)
        double angle = Math.toRadians(second * 6);
        setX3(getRadius_() * Math.sin(angle));
        setY3(-getRadius_() * Math.cos(angle));
    }

    //endregion
    //endregion
}
