package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);
    }

    public void goToSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void goToCategoryActivity(View view) {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToScheduleActivity(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    public void goToHistoryActivity(View view) {
        Intent intent = new Intent(this, HistoricalActivity.class);
        startActivity(intent);
    }
}