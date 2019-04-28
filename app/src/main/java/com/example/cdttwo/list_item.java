package com.example.cdttwo;

public class list_item {
    private int list_img;
    private String list_title;
    private String list_place;
    private String list_content;

    public list_item(int list_img, String list_title, String list_place, String list_content) {
        this.list_img = list_img;
        this.list_title = list_title;
        this.list_place = list_place;
        this.list_content = list_content;
    }

    public int getList_img() {
        return list_img;
    }

    public void setList_img(int list_img) {
        this.list_img = list_img;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }

    public String getList_place() {
        return list_place;
    }

    public void setList_place(String list_place) {
        this.list_place = list_place;
    }

    public String getList_content() {
        return list_content;
    }

    public void setList_content(String list_content) {
        this.list_content = list_content;
    }
}
