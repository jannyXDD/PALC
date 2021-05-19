package pt.ipbeja.estig.twdm.pdm1.project;

public class Book {

    private String name;
    private String desc;
    private String cover;

    public Book(String name, String desc, String cover){
        this.name = name;
        this.desc = desc;
        this.cover = cover;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getCover() {
        return cover;
    }
}
