package sunw.demo.superclock;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Andrei on 22.02.2016.
 */

public class MyClockView extends Pane {

    @FXML
    private MyClockViewController myClockViewController;

    @FXML
    private TextField dayText;

    public MyClockView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "MyClock.fxml"));
        fxmlLoader.getNamespace().put("bind", this);
        fxmlLoader.setRoot(this);
        //fxmlLoader.setController(myClockViewController);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
        }
        dayNumberProperty.setValue("33");
        InitializeComponents();
    }

    //region width
    public static final Double DEFAULT_WIDTH = 500.0;
    private DoubleProperty widthProperty = new SimpleDoubleProperty(DEFAULT_WIDTH);

    public final double getWidth_() {
        return widthProperty.get();
    }

    public final void setWidth_(Double value) {
        widthProperty.set(value);
    }
    //endregion

    //region height
    public static final Double DEFAULT_HEIGHT = 500.0;
    private DoubleProperty heightProperty = new SimpleDoubleProperty(DEFAULT_HEIGHT);

    public final double getHeight_() {
        return heightProperty.get();
    }

    public final void setHeight_(Double value) {
        heightProperty.set(value);
    }
    //endregion

    //region radius
    public static final Double DEFAULT_RADIUS = 200.0;
    private DoubleProperty radiusProperty = new SimpleDoubleProperty(DEFAULT_RADIUS);

    public final double getRadius_() {
        return radiusProperty.get();
    }

    public final void setRadius_(Double value) {
        radiusProperty.set(value);
    }
    //endregion

    //region backColor

    //region backColorPM
    public static final String DEFAULT_BACK_COLOR_PM = "#FFFF00";
    private StringProperty backColorPMProperty = new SimpleStringProperty(DEFAULT_BACK_COLOR_PM);

    public final String getBackColorPM() {
        return backColorPMProperty.get();
    }

    public final void setBackColorPM(String value) {
        backColorPMProperty.set(value);
    }
    //endregion

    //region backColorAM
    public static final String DEFAULT_BACK_COLOR_AM = "#0000FF";
    private StringProperty backColorAMProperty = new SimpleStringProperty(DEFAULT_BACK_COLOR_AM);

    public final String getBackColorAM() {
        return backColorAMProperty.get();
    }

    public final void setBackColorAM(String value) {
        backColorAMProperty.set(value);
    }
    //endregion

    //region currentBackColor
    public static final String DEFAULT_CURRENTBACKCOLOR = DEFAULT_BACK_COLOR_AM;
    private StringProperty currentBackColorProperty = new SimpleStringProperty(DEFAULT_CURRENTBACKCOLOR);

    public final String getCurrentBackColor() {
        return currentBackColorProperty.get();
    }

    public final void setCurrentBackColor(String value) {
        currentBackColorProperty.set(value);
    }
    //endregion

    //endregion

    //region AM_PM

    public static final String DEFAULT_AM_PM = "AM";
    private StringProperty AM_PMProperty = new SimpleStringProperty(DEFAULT_AM_PM);

    public final String getAM_PM() {
        return AM_PMProperty.get();
    }

    public final void setAM_PM(String value) {
        AM_PMProperty.set(value);
        if (value.equals("AM")) {
            currentBackColorProperty.set(backColorAMProperty.get());
        } else {
            currentBackColorProperty.set(backColorPMProperty.get());
        }
    }

    public void setAM_PM(int a) {
        setAM_PM(a == 0 ? "AM" : "PM");
    }

    //endregion


    //region city

    public static final String DEFAULT_city = "Moscow (UTC+03:00)";
    private StringProperty cityProperty = new SimpleStringProperty(DEFAULT_city);

    public final String getCity() {
        return cityProperty.get();
    }

    public final void setCity(String value) {
        cityProperty.set(value);
    }

    //endregion

    //region dayNumber

    public static final String DEFAULT_dayNumber = "01";
    public StringProperty dayNumberProperty = new SimpleStringProperty(DEFAULT_dayNumber);

    public final String getDayNumber() {
        return dayNumberProperty.get();
    }

    public final void setDayNumber(String value) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                dayNumberProperty.set(value);
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
    private DoubleProperty x1Property = new SimpleDoubleProperty(DEFAULT_x1);

    public final Double getX1() {
        return x1Property.get();
    }

    public final void setX1(Double value) {
        x1Property.set(value);
    }
    //endregion

    //region y1
    public static final Double DEFAULT_y1 = -200.0;
    private DoubleProperty y1Property = new SimpleDoubleProperty(DEFAULT_y1);

    public final Double getY1() {
        return y1Property.get();
    }

    public final void setY1(Double value) {
        y1Property.set(value);
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
    private DoubleProperty x2Property = new SimpleDoubleProperty(DEFAULT_x2);

    public final Double getX2() {
        return x2Property.get();
    }

    public final void setX2(Double value) {
        x2Property.set(value);
    }
    //endregion

    //region y2
    public static final Double DEFAULT_y2 = 0.0;
    private DoubleProperty y2Property = new SimpleDoubleProperty(DEFAULT_y2);

    public final Double getY2() {
        return y2Property.get();
    }

    public final void setY2(Double value) {
        y2Property.set(value);
    }
    //endregion

    public void setLine2(int minute) {
        // minute is [0;60)
        double angle = Math.toRadians(minute * 6);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
    }

    //region x3
    public static final Double DEFAULT_x3 = -100.0;
    private DoubleProperty x3Property = new SimpleDoubleProperty(DEFAULT_x3);

    public final Double getX3() {
        return x3Property.get();
    }

    public final void setX3(Double value) {
        x3Property.set(value);
    }
    //endregion

    //region y3
    public static final Double DEFAULT_y3 = .0;
    private DoubleProperty y3Property = new SimpleDoubleProperty(DEFAULT_y3);

    public final Double getY3() {
        return y3Property.get();
    }

    public final void setY3(Double value) {
        y3Property.set(value);
    }
    //endregion

    public void setLine3(int second) {
        setCurrentBackColor("#FFFF00");
        // second is [0;60)
        double angle = Math.toRadians(second * 6);
        setX1(getRadius_() * Math.sin(angle));
        setY1(-getRadius_() * Math.cos(angle));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updateBounds();
                requestLayout();
            }
        });
    }

    //endregion


    private void InitializeComponents() {
    }
}
