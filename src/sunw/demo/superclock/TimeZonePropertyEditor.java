package sunw.demo.superclock;

import java.beans.PropertyEditorSupport;

/**
 * Created by Computer on 26.02.2016.
 */
public class TimeZonePropertyEditor extends PropertyEditorSupport {
    @Override
    public String[] getTags() {
        return MyClock.TIME_ZONE_NAMES_ARRAY;
    }
}
