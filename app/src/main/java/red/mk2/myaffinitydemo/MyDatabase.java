package red.mk2.myaffinitydemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {Article.class}, exportSchema = false, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}
