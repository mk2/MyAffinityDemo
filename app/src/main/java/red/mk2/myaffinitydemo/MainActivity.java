package red.mk2.myaffinitydemo;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = Room.databaseBuilder(
                getApplicationContext(),
                MyDatabase.class,
                "MyDatabase"
        ).build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Article article = new Article();
                article.title = "test title";
                article.content = "test content";
                db.articleDao().create(article);

                List<Article> articles = db.articleDao().getAll();
                Log.v(TAG, Arrays.toString(articles.toArray()));
            }
        }).start();

        setContentView(R.layout.activity_main);
    }
}
