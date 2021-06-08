package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;
import pt.ipbeja.estig.twdm.pdm1.project.models.Book;

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
    }
}