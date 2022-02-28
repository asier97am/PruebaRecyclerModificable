package com.example.pruebarecyclermodificable;

public class President {
    private int id;
    private String name;
    private int date;
    private String img;

    public President() {
    }

    public President(int id, String name, int date, String img) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.img = img;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", img='" + img + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
