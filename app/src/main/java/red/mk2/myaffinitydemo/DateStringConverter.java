package red.mk2.myaffinitydemo;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateStringConverter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.US);

    @TypeConverter
    @Nullable
    public static String dateToString(@Nullable Date date) {
        if (date == null) {
            return null;
        } else {
            return android.text.format.DateFormat.format(DATE_FORMAT, date).toString();
        }
    }

    @TypeConverter
    @Nullable
    public static Date stringToDate(@Nullable String dateString) {
        if (dateString == null) {
            return null;
        } else {
            try {
                return format.parse(dateString);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
