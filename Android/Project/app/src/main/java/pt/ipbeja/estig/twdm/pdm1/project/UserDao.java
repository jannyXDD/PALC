package pt.ipbeja.estig.twdm.pdm1.project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE id = :id")
    User getById(long id);

    @Query("SELECT * FROM User WHERE email = :email")
    User getByEmail(String email);

    @Insert
    void add(User user);

    @Insert
    void add(List<User> users);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
