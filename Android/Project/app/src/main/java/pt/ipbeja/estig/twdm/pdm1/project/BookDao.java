package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Query("SELECT * FROM Book WHERE id = :id")
    Book getById(long id);

    @Query("SELECT * FROM Book WHERE category = :id")
    Book getByCategory(String id);

    @Insert
    void add(Book book);

    @Insert
    void add(List<Book> books);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);
}
