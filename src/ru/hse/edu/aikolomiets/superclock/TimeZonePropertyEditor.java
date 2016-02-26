/**
 * Created by Andrei Koomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import java.beans.PropertyEditorSupport;

/**
 * Created by Andrei Kolomiets on 26.02.2016.
 */
public class TimeZonePropertyEditor extends PropertyEditorSupport {
    @Override
    public String[] getTags() {
        return MyClock.TIME_ZONE_NAMES_ARRAY;
    }
}
