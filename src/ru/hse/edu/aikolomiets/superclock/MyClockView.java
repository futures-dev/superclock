/**
 * Created by Andrei Koomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

/**
 * View of MyClock JavaFX custom control.
 * <p>
 * MyClockView is a Pane containing shapes and text controls. Controller of type {@link MyClockViewController}
 * is created via FXMLLoader, and most of the layout is defined in MyClock.fxml.
 */

public class MyClockView extends Pane {

    /**
     * Reference to the controller
     */
    @FXML
    MyClockViewController myClockViewController;

    /**
     * Control constructor. Loads the view using FXMLLoader and runs initialization.
     */
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

    /**
     * Draws layout components that cannot be drawn in fxml.
     */
    private void InitializeComponents() {
        double r = myClockViewController.getRadius_(); // clock radius

        // small lines

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

        // numbers

        for (int i = 1; i < 13; i++) {
            double angle = Math.toRadians(i * 30);
            Label label = new Label(Integer.toString(i));
            label.setFont(new Font("Bauhaus 93", 25.0));
            label.setTextAlignment(TextAlignment.CENTER);
            label.setLayoutX(243 + r * Math.sin(angle) / 1.27);
            label.setLayoutY(235 - r * Math.cos(angle) / 1.27);
            label.textFillProperty().bind(myClockViewController._currentForeColor);
            getChildren().add(label);
        }
    }

}
