package com.example.urlshortener.repository;

import com.example.urlshortener.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface URLRepository extends JpaRepository<URL, Long> {
    Optional<URL> findByLongURL(String longURL);
    Optional<URL> findByShortURL(String shortURL);
}
