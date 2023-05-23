package com.example.library.domain;

public class Book {
    private Long id;

    private String name;

    private String author;

    private Integer price;

    private Integer amount;

    private String genre;

    private String publisher;

    public Book(){}

    public Book(Long id, String name, String author, Integer price, Integer amount, String genre, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Book(String name, String author, Integer price, Integer amount, String genre, String publisher) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
