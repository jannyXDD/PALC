package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BookAdapter adapter = new BookAdapter(this, getBooks());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private static List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Cara Senhora Tosoni Os Postais de Casabella", "Livro por xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "https://static.fnac-static.com/multimedia/Images/PT/NR/d4/46/68/6833876/1540-1.jpg"));
        bookList.add(new Book("Espectros do Cinema", "Livro por xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", null));
        bookList.add(new Book("Imitações da Vida", "Livro por xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", null));
        bookList.add(new Book("Obras-Primas da Arte Portuguesa", "Livro por xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", null));

        return bookList;
    }
}