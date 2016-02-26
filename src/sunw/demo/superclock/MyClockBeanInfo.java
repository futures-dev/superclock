package sunw.demo.superclock;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Computer on 26.02.2016.
 */
public class MyClockBeanInfo extends SimpleBeanInfo {

    public java.awt.Image getIcon(int iconKind) {
        if (iconKind == BeanInfo.ICON_COLOR_16x16) {
            java.awt.Image img = loadImage("icon.gif");
            return img;
        }
        return null;
    }

    enum Property {
        foreColorPM,
        foreColorAM,
        backColorPM,
        backColorAM,
        currentTime,
        stopped,
        timeZone
    }


    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor[] properties = new PropertyDescriptor[Property.values().length];
        try {
            properties[Property.timeZone.ordinal()] = new PropertyDescriptor("Time Zone", MyClock.class, "getTimeZone", "setTimeZone");
            properties[Property.timeZone.ordinal()].setPropertyEditorClass(TimeZonePropertyEditor.class);
            properties[Property.timeZone.ordinal()].setBound(true);
            properties[Property.stopped.ordinal()] = new PropertyDescriptor("Stop", MyClock.class, "isStopped", "setStopped");
            properties[Property.currentTime.ordinal()] = new PropertyDescriptor("Set Time", MyClock.class, "getCurrentTime", "setCurrentTime");
            properties[Property.backColorAM.ordinal()] = new PropertyDescriptor("Background color AM", MyClock.class, "getBackColorAM", "setBackColorAM");
            properties[Property.backColorPM.ordinal()] = new PropertyDescriptor("Background color PM", MyClock.class, "getBackColorPM", "setBackColorPM");
            properties[Property.foreColorAM.ordinal()] = new PropertyDescriptor("Foreground color AM", MyClock.class, "getForeColorAM", "setForeColorAM");
            properties[Property.foreColorPM.ordinal()] = new PropertyDescriptor("Foreground color PM", MyClock.class, "getForeColorPM", "setForeColorPM");

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

