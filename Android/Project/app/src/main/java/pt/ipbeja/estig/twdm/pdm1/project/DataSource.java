package pt.ipbeja.estig.twdm.pdm1.project;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Book> bookList;

    private DataSource() {

    }

    public static List<Book> getBookList(Context context) {
        return AppDataBase.getInstance(context).getBookDao().getAll();
        //if (bookList == null) {
        //    bookList = new ArrayList<>();
        //    bookList.add(new Book("Cara Senhora Tosoni Os Postais de Casabella", "Descrição", "https://static.fnac-static.com/multimedia/Images/PT/NR/d4/46/68/6833876/1540-1.jpg"));
        //    bookList.add(new Book("Espectros do Cinema", "Descrição", "https://img.wook.pt/images/espectros-do-cinema-jose-bertolo/MXwyNDU5MTQyMnwyMDcxMTA5MXwxNjEyMTM3NjAwMDAw/500x"));
        //bookList.add(new Book("Imitações da Vida", "Descrição", "https://img.wook.pt/images/imitacoes-da-vida-jose-bertolo/MXwyNDU5Mjk4OXwyMDcxNjU1NHwxNjEyMzk2ODAwMDAw/500x"));
        //   bookList.add(new Book("Obras-Primas da Arte Portuguesa", "Descrição", "https://img.wook.pt/images/obras-primas-da-arte-portuguesa-delfim-sardo/MXwxMDk5Njc3MXw2NTY3NDYxfDEzODM1MjMyMDAwMDA=
        //}
    }

    public static Book getBook(Context context, long id) {
        return AppDataBase.getInstance(context).getBookDao().getById(id);
    }
}
