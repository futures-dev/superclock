package sunw.demo.superclock;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andrei on 22.02.2016.
 */
public class MyClockViewController {

    MyClockView view;

    private final int PERIOD = 2000;

    Timer secondTimer = new Timer("second");

    Calendar calendar = new GregorianCalendar();

    public MyClockViewController() {
        secondTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (view != null) {
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    view.setLine3(calendar.get(Calendar.SECOND));
                    view.setLine2(calendar.get(Calendar.MINUTE));
                    view.setLine1(3 * calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) / 20);
                    view.setDayNumber(calendar.get(Calendar.DAY_OF_MONTH));
                    view.setAM_PM(calendar.get(Calendar.AM_PM));
                }
            }
        }, 0, PERIOD);
    }

    public void setView(MyClockView view) {
        this.view = view;
    }

    public void setTimeZone(String timeZone) {

    }

    public void mouseEntered(MouseEvent e){
        System.out.println("mouse");
    }

}