package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.adapters.BookAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.adapters.FavouriteAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        RecyclerView recyclerView = findViewById(R.id.recyclerView3);
        FavouriteAdapter adapter = new FavouriteAdapter(this, DataSource.getBookList(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }




    public void goToSearchActivity(View view) {
        Intent intent = new Intent(this, FavouriteActivity.class);
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