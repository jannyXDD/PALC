package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private static final String KEY_BOOKPOSITION = "BOOKPOSITION";
    private static final String TAG = "DetailsActivity";

    private ImageView imageViewCover;
    private TextView textViewName;
    private TextView textViewDesc;
    private Book book;

    public static void startActivity(Context context, int position){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_BOOKPOSITION, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.imageViewCover = findViewById(R.id.imageView);
        this.textViewName = findViewById(R.id.textViewName);
        this.textViewDesc = findViewById(R.id.textViewDescription);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int position = bundle.getInt(KEY_BOOKPOSITION, -1);
            if (position == -1){
                Log.e(TAG, "Invalid position found!");
                finish();
            }
            this.book = DataSource.getBook(position);

            Glide.with(this).load(book.getCover()).into(this.imageViewCover);
            this.textViewName.setText(book.getName());
        } else{
            Log.e(TAG, "No position specified!");
            finish();
        }
    }
}