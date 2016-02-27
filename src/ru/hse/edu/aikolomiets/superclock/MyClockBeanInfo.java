/**
 * Created by Andrei Kolomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Provides information on properties of MyClock java bean.
 */
public class MyClockBeanInfo extends SimpleBeanInfo {

    /**
     * Returns an Image used as bean icon in the toolbox.
     *
     * @param iconKind icon size and color preference
     * @return gif icon as Image or null if no suitable image found
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        return loadImage("icon.gif");
    }

    /**
     * Returns array of available java bean properties desrciptors.
     *
     * @return {@inheritDoc}
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor[] properties = new PropertyDescriptor[Property.values().length];
        try {
            properties[Property.timeZone.ordinal()] = new PropertyDescriptor("Time Zone", MyClock.class, "getTimeZone", "setTimeZone");
            properties[Property.timeZone.ordinal()].setPropertyEditorClass(TimeZonePropertyEditor.class);
            properties[Property.stopped.ordinal()] = new PropertyDescriptor("Stop", MyClock.class, "isStopped", "setStopped");
            properties[Property.stopped.ordinal()].setBound(true);
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


    /**
     * MyClock properties enumeration. Order is reversed in beanbox.
     */
    enum Property {
        foreColorPM,
        foreColorAM,
        backColorPM,
        backColorAM,
        currentTime,
        stopped,
        timeZone
    }
}

