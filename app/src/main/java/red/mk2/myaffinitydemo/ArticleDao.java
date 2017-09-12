package red.mk2.myaffinitydemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM article")
    public List<Article> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void create(Article article);
}
