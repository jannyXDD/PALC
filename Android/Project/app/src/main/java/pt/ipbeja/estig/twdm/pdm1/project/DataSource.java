package pt.ipbeja.estig.twdm.pdm1.project;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Book> bookList;
    private static List<User> userList;

    private DataSource() {

    }

    public static List<Book> getBookList(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getAll();

    }

    public static Book getBook(Context context, long id) {
        return AppDataBase.getInstance(context).getBookDao().getById(id);
    }

    public static List<User> getUserList(Context context) {
        return UserDataBase.getInstance(context).getUserDao().getAll();

    }

    public static User getUser(Context context, long id) {
        return UserDataBase.getInstance(context).getUserDao().getById(id);
    }
}
