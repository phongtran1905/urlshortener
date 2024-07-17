package com.example.urlshortener.service;

import com.example.urlshortener.entity.URL;
import com.example.urlshortener.repository.URLRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class URLService {
    @Autowired
    private URLRepository urlRepository;

    @Autowired
    private URLConversionService urlConversionService;

    @Transactional
    public String createURL(String longURL){
        return this.urlRepository.findByLongURL(longURL)
                .map(URL::getShortURL)
                .orElseGet(() -> {
                    URL newURL = new URL(longURL);
                    this.urlRepository.save(newURL);
                    newURL.setShortURL(this.urlConversionService.encode(newURL.getId()));
                    return this.urlRepository.save(newURL).getShortURL();
                });
    }

    @Cacheable(value = "url", key = "#shortURL")
    public String getURL(String shortURL) throws NoSuchElementException {
        return this.urlRepository.findByShortURL(shortURL)
                .map(URL::getLongURL)
                .orElseThrow(() -> new NoSuchElementException(String.format("URL with short URL %s not found", shortURL)));
    }
}
