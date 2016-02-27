/**
 * Created by Andrei Kolomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import java.beans.PropertyEditorSupport;

/**
 * Auxiliary class for supplying extra beanbox property information
 */
public class TimeZonePropertyEditor extends PropertyEditorSupport {

    /**
     * {@inheritDoc}
     * <p>
     * {@link MyClock} TIME_ZONE_NAMES_ARRAY is used as tags supplier.
     *
     * @return {@inheritDoc}
     */
    @Override
    public String[] getTags() {
        return MyClock.TIME_ZONE_NAMES_ARRAY;
    }
}
