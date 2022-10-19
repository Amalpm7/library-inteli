package com.example.librarybackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libraries")
public class LibraryModel {

    @Id
    @GeneratedValue
    private int Id;
    private String book_name;
    private String author;
    private String date;
    private String volume;

    public LibraryModel(int id, String book_name, String author, String date, String volume) {
        Id = id;
        this.book_name = book_name;
        this.author = author;
        this.date = date;
        this.volume = volume;
    }

    public LibraryModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
