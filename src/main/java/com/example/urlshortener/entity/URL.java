package com.example.urlshortener.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String shortURL;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String longURL;

    public URL(){}

    public URL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public Long getId() {
        return id;
    }
}
