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
import javafx.scene.shape.Line;

import java.io.IOException;

/**
 * Created by Andrei on 22.02.2016.
 */

public class MyClockView extends Pane {


    @FXML
    MyClockViewController myClockViewController;

    public MyClockView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "MyClock.fxml"));
        fxmlLoader.setRoot(this);
        myClockViewController = new MyClockViewController(this);
        fxmlLoader.setController(myClockViewController);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //throw new RuntimeException(exception);
        }
        InitializeComponents();
    }





    private void InitializeComponents() {
        System.out.println("initView");

    }



}
