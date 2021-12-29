package com.home;

import java.util.Date;

public class Files {
    @Id
    private int id;
    private String name;
    private Long size;
    private String date;

    public Files() {
    }

    public Files(String name, Long size, String date) {
        this.name = name;
        this.size = size;
        this.date = date;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", date=" + date +
                '}';
    }
}
