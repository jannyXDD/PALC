package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import pt.ipbeja.estig.twdm.pdm1.project.adapters.FavouriteAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.adapters.HistoricalAdapter;
import pt.ipbeja.estig.twdm.pdm1.project.data.DataSource;

public class HistoricalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical);
        RecyclerView recyclerView = findViewById(R.id.recyclerView111);
        HistoricalAdapter adapter = new HistoricalAdapter(this, DataSource.getBookReq(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);

    }
}