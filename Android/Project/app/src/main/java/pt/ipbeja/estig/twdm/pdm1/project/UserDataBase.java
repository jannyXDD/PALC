package pt.ipbeja.estig.twdm.pdm1.project;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();

    private static UserDataBase INSTANCE;

    public static synchronized UserDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    UserDataBase.class,
                    "userDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO User (name, email, password) VALUES ('João Costa', '21143@stu.ipbeja.pt', '123')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

}
