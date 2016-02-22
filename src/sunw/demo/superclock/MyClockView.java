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
    public MyClockView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "MyClock.fxml"));
        fxmlLoader.getNamespace().put("bind",this);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
        }
        InitializeComponents();
    }

    public static final double DEFAULT_WIDTH = 200;
    private DoubleProperty _width = new SimpleDoubleProperty(DEFAULT_WIDTH);

    public final double getWidth_() {
        return _width.get();
    }

    public static final double DEFAULT_HEIGHT = 200;
    private DoubleProperty _height = new SimpleDoubleProperty(DEFAULT_HEIGHT);

    public final double getHeight_() {
        return _height.get();
    }

    public static final String DEFAULT_BACKCOLOR = "#FF0000";
    private StringProperty _backcolor = new SimpleStringProperty(DEFAULT_BACKCOLOR);

    public final String getBackColor() {
        return _backcolor.get();
    }


    private void InitializeComponents() {

    }
}
