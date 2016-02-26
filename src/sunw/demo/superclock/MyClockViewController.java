package sunw.demo.superclock;


import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Andrei on 22.02.2016.
 */
public class MyClockViewController implements Initializable {

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

    @FXML
    private Circle circle;

    @FXML
    private Pane myClockView;

    //endregion

    private MyClockView view;

    //region consts

    private final int PERIOD = 500;

    //endregion

    private Calendar calendar;
    private boolean ticking = true;
    private long delay = 0;
    private long stopTime = 0;

    @FXML
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
        circle.strokeProperty().bind(_currentForeColor);
        circle.fillProperty().bind(_currentBackColor);

        // timers
        calendar = new GregorianCalendar();
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (ticking) {
                    calendar.setTimeInMillis(System.currentTimeMillis() - delay);
                    setLine3(calendar.get(Calendar.SECOND));
                    setLine2(calendar.get(Calendar.MINUTE));
                    setLine1(3 * calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) / 20);
                    setDayNumber(calendar.get(Calendar.DAY_OF_MONTH));
                    setAM_PM(calendar.get(Calendar.AM_PM));
                }
            }
        }, 0, PERIOD, TimeUnit.MILLISECONDS);
    }

    public MyClockViewController(MyClockView view) {
        this.view = view;
    }

    //region properties

    //region width
    public static final Double DEFAULT_WIDTH_ = 500.0;
    DoubleProperty _width_ = new SimpleDoubleProperty(DEFAULT_WIDTH_);

    public final double getWidth_() {
        return _width_.get();
    }

    public final void setWidth_(Double value) {
        _width_.set(value);
    }
    //endregion

    //region height
    public static final Double DEFAULT_HEIGHT_ = 500.0;
    DoubleProperty _height_ = new SimpleDoubleProperty(DEFAULT_HEIGHT_);

    public final double getHeight_() {
        return _height_.get();
    }

    public final void setHeight_(Double value) {
        _height_.set(value);
    }
    //endregion

    //region radius
    public static final Double DEFAULT_RADIUS = 200.0;
    DoubleProperty _radius = new SimpleDoubleProperty(DEFAULT_RADIUS);

    public final double getRadius_() {
        return _radius.get();
    }

    public final void setRadius_(Double value) {
        _radius.set(value);
    }
    //endregion

    //region backColor

    //region backColorPM
    public static final Color DEFAULT_BACK_COLOR_PM = Color.valueOf("#1f4037");
    Property<Color> _backColorPM = new SimpleObjectProperty<>(DEFAULT_BACK_COLOR_PM);

    public final Color getBackColorPM() {
        return _backColorPM.getValue();
    }

    public final void setBackColorPM(Color value) {
        _backColorPM.setValue(value);
    }
    //endregion

    //region backColorAM
    public static final Color DEFAULT_BACK_COLOR_AM = Color.valueOf("#79553d");
    Property<Color> _backColorAM = new SimpleObjectProperty<>(DEFAULT_BACK_COLOR_AM);

    public final Color getBackColorAM() {
        return _backColorAM.getValue();
    }

    public final void setBackColorAM(Color value) {
        _backColorAM.setValue(value);
    }
    //endregion

    //region currentBackColor
    public static final Color DEFAULT_CURRENTBACKCOLOR = DEFAULT_BACK_COLOR_AM;
    Property<Color> _currentBackColor = new SimpleObjectProperty<>(DEFAULT_CURRENTBACKCOLOR);

    public final Color getCurrentBackColor() {
        return _currentBackColor.getValue();
    }

    public final void setCurrentBackColor(Color value) {
        _currentBackColor.setValue(value);
    }
    //endregion

    //endregion

    //region foreColor

    //region foreColorPM
    public static final Color DEFAULT_FORE_COLOR_PM = Color.valueOf("#cf919c");
    Property<Color> _foreColorPM = new SimpleObjectProperty<>(DEFAULT_FORE_COLOR_PM);

    public final Color getForeColorPM() {
        return _foreColorPM.getValue();
    }

    public final void setForeColorPM(Color value) {
        _foreColorPM.setValue(value);
    }
    //endregion

    //region foreColorAM
    public static final Color DEFAULT_FORE_COLOR_AM = Color.valueOf("#ad4c5e");
    Property<Color> _foreColorAM = new SimpleObjectProperty<>(DEFAULT_FORE_COLOR_AM);

    public final Color getForeColorAM() {
        return _foreColorAM.getValue();
    }

    public final void setForeColorAM(Color value) {
        _foreColorAM.setValue(value);
    }
    //endregion

    //region currentForeColor
    public static final Color DEFAULT_CURRENTFORECOLOR = DEFAULT_FORE_COLOR_AM;
    Property<Color> _currentForeColor = new SimpleObjectProperty<>(DEFAULT_CURRENTFORECOLOR);

    public final Color getCurrentForeColor() {
        return _currentForeColor.getValue();
    }

    public final void setCurrentForeColor(Color value) {
        _currentForeColor.setValue(value);
    }
    //endregion

    //endregion


    //region AM_PM

    public static final String DEFAULT_AM_PM = "AM";
    StringProperty _AM_PM = new SimpleStringProperty(DEFAULT_AM_PM);

    public final String getAM_PM() {
        return _AM_PM.get();
    }

    public final void setAM_PM(String value) {
        _AM_PM.set(value);
        if (value.equals("AM")) {
            _currentBackColor.setValue(_backColorAM.getValue());
            _currentForeColor.setValue(_foreColorAM.getValue());
        } else {
            _currentBackColor.setValue(_backColorPM.getValue());
            _currentForeColor.setValue(_foreColorPM.getValue());
        }
    }

    public void setAM_PM(int a) {
        setAM_PM(a == 0 ? "AM" : "PM");
    }

    //endregion

    //region currentTime

    public void setCurrentTime(String val) {
        try {

            delay = System.currentTimeMillis() - Time.valueOf(val).getTime();
        } catch (Exception e) {
            // bad input format}
        }
    }

    //endregion

    //region city

    public static final String DEFAULT_city = TimeZoneManager.DEFAULT_TIMEZONE_STRING;
    StringProperty _city = new SimpleStringProperty(DEFAULT_city);

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

    //region timeZone

    public TimeZone getTimeZone() {
        return calendar.getTimeZone();
    }

    public void setTimeZone(TimeZone timeZone) {
        calendar.setTimeZone(timeZone);
        setCity(TimeZoneManager.TimeZoneToStringConvert(timeZone));
    }

    //endregion

    //region Arrows

    //region x1
    public static final Double DEFAULT_x1 = .0;
    DoubleProperty _x1 = new SimpleDoubleProperty(DEFAULT_x1);

    public final Double getX1() {
        return _x1.get();
    }

    public final void setX1(Double value) {
        _x1.set(value);
    }
    //endregion

    //region y1
    public static final Double DEFAULT_y1 = -200.0;
    DoubleProperty _y1 = new SimpleDoubleProperty(DEFAULT_y1);

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
        setX1(getRadius_() * Math.sin(angle) / 1.8);
        setY1(-getRadius_() * Math.cos(angle) / 1.8);
    }

    //region x2
    public static final Double DEFAULT_x2 = 150.0;
    DoubleProperty _x2 = new SimpleDoubleProperty(DEFAULT_x2);

    public final Double getX2() {
        return _x2.get();
    }

    public final void setX2(Double value) {
        _x2.set(value);
    }
    //endregion

    //region y2
    public static final Double DEFAULT_y2 = 0.0;
    DoubleProperty _y2 = new SimpleDoubleProperty(DEFAULT_y2);

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
        setX2(getRadius_() * Math.sin(angle) / 1.4);
        setY2(-getRadius_() * Math.cos(angle) / 1.4);
    }

    //region x3
    public static final Double DEFAULT_x3 = -100.0;
    DoubleProperty _x3 = new SimpleDoubleProperty(DEFAULT_x3);

    public final Double getX3() {
        return _x3.get();
    }

    public final void setX3(Double value) {
        _x3.set(value);
    }
    //endregion

    //region y3
    public static final Double DEFAULT_y3 = .0;
    DoubleProperty _y3 = new SimpleDoubleProperty(DEFAULT_y3);

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
        setX3(getRadius_() * Math.sin(angle) / 1.1);
        setY3(-getRadius_() * Math.cos(angle) / 1.1);
    }

    //endregion
    //endregion

    public void setStopped(boolean s) {
        if (s == ticking) {
            if (s) {
                stopTime = System.currentTimeMillis();
            } else {
                delay += System.currentTimeMillis() - stopTime;
            }
            ticking = !s;
        }
    }

    public boolean isStopped() {
        return !ticking;
    }
}
