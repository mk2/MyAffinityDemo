package red.mk2.myaffinitydemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "article")
public class Article {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id = 0;

    @ColumnInfo(name = "title")
    public String title = "";

    @ColumnInfo(name = "content")
    public String content = "";

    @ColumnInfo(name = "created_at", typeAffinity = ColumnInfo.INTEGER)
    @TypeConverters({DateTimestampConverter.class})
    public Date createdAt = DateTimestampConverter.timestampToDate(System.currentTimeMillis());

    @ColumnInfo(name = "created_when", typeAffinity = ColumnInfo.TEXT)
    @TypeConverters({DateStringConverter.class})
    public Date createdWhen = DateTimestampConverter.timestampToDate(System.currentTimeMillis());

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", createdWhen=" + createdWhen +
                '}';
    }
}
