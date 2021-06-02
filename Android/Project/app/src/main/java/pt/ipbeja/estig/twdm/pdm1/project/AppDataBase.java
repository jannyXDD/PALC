package pt.ipbeja.estig.twdm.pdm1.project;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Book.class, User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract BookDao getBookDao();
    public abstract UserDao getUserDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "myAppDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber) VALUES ('Cara Senhora Tosoni Os postais da Casabella', " +
                                    "'Este é um livro carregado de ironia, erudição, imagens e violência. Violência da construção, imagens de arquitectura, erudição e ironia do autor que, entre 1982 e 1995, enviou regularmente postais à Senhora Tosoni, a secretária da redacção da revista milanesa Casabella, então dirigida por Vittorio Gregotti.\n" + "\n" + "Os postais foram, ao longo do século XX, uma forma maior da iconografia epistolar. Produzidos industrialmente, em circulação pelo mundo, os postais transportam imagens com indícios de comportamentos sociais e práticas de construção.\n" + "\n" + "Jacques Gubler escalpeliza estas imagens em missivas sintéticas, por vezes herméticas, que reverberam nexos escondidos pelo hábito celebrativo que tantas vezes se confere à história.\n" + "\n" + "A arquitectura, o design industrial, a história do movimento moderno, os autores e os veículos da arte, da pintura, da literatura e do conhecimento são convocados numa interrogação constante ao sentido das imagens do mundo.', " +
                                    "'https://almedinanet.b-cdn.net/media/catalog/product/cache/10f519365b01716ddb90abc57de5a837/9/7/9789898217530_1614333762.jpg'," +
                                    " 'Artes', " +
                                    "'Jacques Gubler', " +
                                    "'2002', " +
                                    "3)");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber) VALUES ('Espectros do Cinema', " +
                                    "'Este livro é uma galeria de retratos de figuras que, como se diz em Benilde, «não são deste mundo», figuras fantasmáticas, prometidas a uma existência liminar, que adquirem uma espécie de inteireza justamente na sua inconsistência ôntica.\n" + "\n" + "A figura do fantasma tem acompanhado a história do cinema desde o século XIX até aos nossos dias, marcando presença numa grande diversidade de géneros fílmicos. Além disso, a própria arte cinematográfica tem sido, repetidas vezes, considerada e descrita como uma coisa espectral em si mesma.\n" + "\n" + "Em 1896, Máximo Gorki qualificou o cinema como um reino de sombras, e, já no século XXI, Jacques Derrida afirmou que a experiência cinematográfica pertence à esfera da espectralidade. Deste modo, ir ao cinema implica necessariamente confraternizar com espectros, ser assombrado, quer os filmes tornem os fantasmas visíveis, quer não.\n" + "\n" + "No contexto português, Manoel de Oliveira e João Pedro Rodrigues surgem como os cineastas que reflectiram sobre a espectralidade do cinema de forma mais consistente. Atentando no funcionamento das suas narrativas de amor, loucura e morte, bem como nos seres que as protagonizam, votados a uma existência liminar, entre o mundo dos mortos e o dos vivos, este livro constrói uma galeria de retratos de figuras fantasmáticas, que, como se diz em Benilde ou a Virgem Mãe, «não pertencem a este mundo».', " +
                                    "'https://img.wook.pt/images/espectros-do-cinema-jose-bertolo/MXwyNDU5MTQyMnwyMDcxMTA5MXwxNjEyMTM3NjAwMDAwfHdlYnA=/502x', " +
                                    "'Romance', " +
                                    "'José Bértolo', " +
                                    "'2005', " +
                                    "2)");
                            db.execSQL("INSERT INTO Book (name, description, cover, category, author, year, reqNumber) VALUES ('Obras-Primas da Arte Portuguesa', " +
                                    "'A colecção OBRAS-PRIMAS DA ARTE PORTUGUESA, procurando dar a conhecer o nosso património artístico mais relevante - Arquitectura, Pintura, Escultura, Ourivesaria e Artes Visuais no Século XX - , destina-se ao grande público . Em cinco volumes amplamente ilustrados, reputados especialistas em História da Arte Portuguesa, nas diversas especialidades, dão-nos a conhecer, através de abordagens originais, acessíveis e com garantido rigor científico, 50 obras-primas que seleccionaram entre tesouros nacionais e as mais notáveis criações contemporâneas. Século XX. Artes Visuais - do auto-retrato de Aurélia de Sousa, de 1900, a João Onofre, através de uma obra de 2000, Delfim Sardo apresenta-nos as obras mais relevantes que neste século se realizaram em Portugal.', " +
                                    "'https://img.wook.pt/images/obras-primas-da-arte-portuguesa-delfim-sardo/MXwxMDk5Njc3MXw2NTY3NDYxfDEzODM1MjMyMDAwMDA=/500x', " +
                                    "'Artes', " +
                                    "'Delfim Sardo', " +
                                    "'2000', " +
                                    "2)");
                            db.execSQL("INSERT INTO User (name, email, password) VALUES ('João Costa', '21143@stu.ipbeja.pt', '123')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
