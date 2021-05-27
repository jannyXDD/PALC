package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//falta o ano do livro
//falta tambem o numero de requisiçoes
@Entity
public class Book {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private String cover;
    private String category;
    private String author;

    public Book(long id, String name, String description, String cover, String category, String author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cover = cover;
        this.category = category;
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}
