package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPopular();
        recyclerViewRomantic();
        recyclerViewArt();
        recyclerViewComedy();


    }
    public void recyclerViewPopular(){
          RecyclerView recyclerView = findViewById(R.id.recyclerView);
          BookAdapter adapter = new BookAdapter(this, DataSource.getBookListPopular(this));
          recyclerView.setAdapter(adapter);
          LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
          recyclerView.setLayoutManager(layoutManager);
    }

    public void recyclerViewRomantic(){
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        BookAdapter adapter2 = new BookAdapter(this, DataSource.getBookListRomantic(this));
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(layoutManager2);
    }

    public void recyclerViewArt(){
        RecyclerView recyclerView3 = findViewById(R.id.recyclerView4);
        BookAdapter adapter3 = new BookAdapter(this, DataSource.getBookListArt(this));
        recyclerView3.setAdapter(adapter3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setLayoutManager(layoutManager3);
    }

    public void recyclerViewComedy(){
        RecyclerView recyclerView4 = findViewById(R.id.recyclerView3);
        BookAdapter adapter4 = new BookAdapter(this, DataSource.getBookListComedy(this));
        recyclerView4.setAdapter(adapter4);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        recyclerView4.setLayoutManager(layoutManager4);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


}