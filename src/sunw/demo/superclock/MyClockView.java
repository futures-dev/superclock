package sunw.demo.superclock;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        // small lines

        double r = myClockViewController.getRadius_();
        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6);
            double endX = r * Math.sin(angle) / 1.05;
            double endY = -r * Math.cos(angle) / 1.05;
            double lenCoef = i % 5 == 0 ? 1.1 : 1.05;
            Line line = new Line(endX / lenCoef, endY / lenCoef, endX, endY);
            line.setLayoutX(250);
            line.setLayoutY(250);
            getChildren().add(line);
        }
    }


}
