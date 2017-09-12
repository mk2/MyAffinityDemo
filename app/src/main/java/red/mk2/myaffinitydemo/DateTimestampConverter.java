package red.mk2.myaffinitydemo;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.util.Date;

public class DateTimestampConverter {

    @TypeConverter
    @Nullable
    public static Long dateToTimestamp(@Nullable Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }

    @TypeConverter
    @Nullable
    public static Date timestampToDate(@Nullable Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }
}
