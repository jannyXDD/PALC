package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import pt.ipbeja.estig.twdm.pdm1.project.data.AppDataBase;
import pt.ipbeja.estig.twdm.pdm1.project.data.BookDao;
import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;
import pt.ipbeja.estig.twdm.pdm1.project.data.UserDao;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;
import pt.ipbeja.estig.twdm.pdm1.project.models.User;

public class DetailsActivity extends AppCompatActivity {

    public static void startActivity(Context context, long id){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_BOOKPOSITION, id);
        context.startActivity(intent);
    }

    private static final String KEY_BOOKPOSITION = "BOOKPOSITION";
    private static final String TAG = "DetailsActivity";

    private ImageView imageViewCover;
    private TextView textViewName;
    private TextView textViewDesc;
    private TextView textViewAuthor;
    private TextView textViewYear;
    private Button button;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.imageViewCover = findViewById(R.id.imageView);
        this.textViewName = findViewById(R.id.textViewName);
        this.textViewDesc = findViewById(R.id.textViewDescription);
        this.textViewAuthor = findViewById(R.id.textViewAuthor);
        this.textViewYear = findViewById(R.id.textView7);
        this.button = findViewById(R.id.button3);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            long id = bundle.getLong(KEY_BOOKPOSITION, -1);
            if (id == -1){
                Log.e(TAG, "Invalid id found!");
                finish();
            }
            this.book = DataSource.getBook(this, id);

            Glide.with(this).load(book.getCover()).into(this.imageViewCover);
            this.textViewName.setText(book.getName());
            this.textViewDesc.setText(book.getDesc());
            this.textViewAuthor.setText(book.getAuthor());
            this.textViewYear.setText(book.getYear());
        } else{
            Log.e(TAG, "No position specified!");
            finish();
        }

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AppDataBase bookDataBase = AppDataBase.getInstance(getApplicationContext());
                    BookDao bookDao = bookDataBase.getBookDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Book book = bookDao.checkReq(userEmail);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        book.setWasReq(true);
                                        bookDataBase.getInstance(DetailsActivity.this).getBookDao().update(book);
                                    }
                                });
                                startActivity(new Intent(DetailsActivity.this, MainActivity.class));
                        }
                    }).start();
                }
        });
    }
}