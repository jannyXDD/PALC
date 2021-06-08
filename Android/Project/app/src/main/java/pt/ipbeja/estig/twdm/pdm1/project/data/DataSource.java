package pt.ipbeja.estig.twdm.pdm1.project.data;

import android.content.Context;

import java.util.List;

import pt.ipbeja.estig.twdm.pdm1.project.models.Book;
import pt.ipbeja.estig.twdm.pdm1.project.models.User;

public class DataSource {

    private static List<Book> bookList;
    private static List<User> userList;

    private DataSource() {

    }

    public static List<Book> getBookList(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getAll();
    }

    public static List<Book> getBookListArt(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getByArt();
    }

    public static List<Book> getBookListRomantic(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getByRomantic();
    }

    public static List<Book> getBookListPopular(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getByPopular();
    }

    public static List<Book> getBookListComedy(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getByComedy();
    }

    public static Book getBook(Context context, long id) {
        return AppDataBase.getInstance(context).getBookDao().getById(id);
    }

    public static List<User> getUserList(Context context) {
        return AppDataBase.getInstance(context).getUserDao().getAll();

    }

    public static User getUser(Context context, long id) {
        return AppDataBase.getInstance(context).getUserDao().getById(id);
    }
}
