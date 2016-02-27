/**
 * Created by Andrei Kolomiets on 26.02.2016
 */

package ru.hse.edu.aikolomiets.superclock;

import java.util.HashMap;
import java.util.TimeZone;

/**
 * Auxiliary class for supplying info about Time Zones
 */
public class TimeZoneManager {

    /**
     * Maps string representations to corresponding TimeZone objects
     */
    public static final HashMap<String, TimeZone> TIME_ZONES = new HashMap<String, TimeZone>() {{
        put("Baker Island (GMT-12:00)", TimeZone.getTimeZone("GMT-12"));
        put("Midway Islands (GMT-11:00)", TimeZone.getTimeZone("GMT-11"));
        put("Hawaii (GMT-10:00)", TimeZone.getTimeZone("GMT-10"));
        put("Alaska (GMT-09:00)", TimeZone.getTimeZone("GMT-9"));
        put("Pacific Time Zone (GMT-08:00)", TimeZone.getTimeZone("GMT-8"));
        put("Arizona (GMT-07:00)", TimeZone.getTimeZone("GMT-7"));
        put("Costa Rica (GMT-06:00)", TimeZone.getTimeZone("GMT-6"));
        put("Peru (GMT-05:00)", TimeZone.getTimeZone("GMT-5"));
        put("Puerto Rico (GMT-04:00)", TimeZone.getTimeZone("GMT-4"));
        put("Argentina (GMT-03:00)", TimeZone.getTimeZone("GMT-3"));
        put("South Georgia (GMT-02:00)", TimeZone.getTimeZone("GMT-2"));
        put("Cape Verde Islands (GMT-01:00)", TimeZone.getTimeZone("GMT-1"));
        put("London (GMT)", TimeZone.getTimeZone("GMT"));
        put("Madrid (GMT+01:00)", TimeZone.getTimeZone("GMT+1"));
        put("Kaliningrad (GMT+02:00)", TimeZone.getTimeZone("GMT+2"));
        put("Moscow (GMT+03:00)", TimeZone.getTimeZone("GMT+3"));
        put("Samara (GMT+04:00)", TimeZone.getTimeZone("GMT+4"));
        put("Ekaterinburg (GMT+05:00)", TimeZone.getTimeZone("GMT+5"));
        put("Novosibirsk (GMT+06:00)", TimeZone.getTimeZone("GMT+6"));
        put("Krasnoyarsk (GMT+07:00)", TimeZone.getTimeZone("GMT+7"));
        put("Izhevsk (GMT+08:00)", TimeZone.getTimeZone("GMT+8"));
        put("Yakutsk (GMT+09:00)", TimeZone.getTimeZone("GMT+9"));
        put("Vladivostok (GMT+10:00)", TimeZone.getTimeZone("GMT+10"));
        put("Solomon Islands (GMT+11:00)", TimeZone.getTimeZone("GMT+11"));
        put("Fiji (GMT+12:00)", TimeZone.getTimeZone("GMT+12"));
        put("Samoa (GMT+13:00)", TimeZone.getTimeZone("GMT+13"));
        put("Kiribati (GMT+14:00)", TimeZone.getTimeZone("GMT+14"));
    }};
    public static final String DEFAULT_TIMEZONE_STRING = "Moscow (GMT+03:00)";
    public static final TimeZone DEFAULT_TIMEZONE = TimeZoneManager.TIME_ZONES.get(DEFAULT_TIMEZONE_STRING);

    /**
     * Converts a TimeZone instance to its String representation
     *
     * @param timeZone TimeZone to convert
     * @return String representation from TIME_ZONES
     */
    public static String TimeZoneToStringConvert(TimeZone timeZone) {
        final String[] found = new String[]{DEFAULT_TIMEZONE_STRING};
        TimeZoneManager.TIME_ZONES.entrySet().forEach(stringTimeZoneEntry -> {
            if (stringTimeZoneEntry.getValue().equals(timeZone)) {
                found[0] = stringTimeZoneEntry.getKey();
            }
        });
        return found[0];
    }

    /**
     * Returns TimeZone given its String representation
     *
     * @param val String representation to convert
     * @return Corresponding TimeZone object
     */
    public static TimeZone StringToTimeZoneConvert(String val) {

        return TimeZoneManager.TIME_ZONES.getOrDefault(val, DEFAULT_TIMEZONE);
    }
}
