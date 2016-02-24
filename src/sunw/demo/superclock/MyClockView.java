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
    private MyClockViewController myClockViewController  = new MyClockViewController();

    public MyClockView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "MyClock.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(myClockViewController);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
        }
        InitializeComponents();
    }



    private void InitializeComponents() {
        myClockViewController.initialize(null,null);
    }
}
