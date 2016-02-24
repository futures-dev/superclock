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


    MyClockView view;

    //region consts

    private final int PERIOD = 2000;

    //endregion

    Timer secondTimer;

    Calendar calendar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // timers
        secondTimer = new Timer("second");
        calendar = new GregorianCalendar();
        secondTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                calendar.setTimeInMillis(System.currentTimeMillis());
                view.setLine3(calendar.get(Calendar.SECOND));
                view.setLine2(calendar.get(Calendar.MINUTE));
                view.setLine1(3 * calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) / 20);
                view.setDayNumber(calendar.get(Calendar.DAY_OF_MONTH));
                view.setAM_PM(calendar.get(Calendar.AM_PM));
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


}
