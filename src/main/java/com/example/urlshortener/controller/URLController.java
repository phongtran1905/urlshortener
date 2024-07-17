package com.example.urlshortener.controller;

import com.example.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @GetMapping("/{shortURL}")
    public ResponseEntity<String> getURL(@PathVariable("shortURL") String shortURL) {
        return ResponseEntity
                .status(200)
                .body(this.urlService.getURL(shortURL));
                //.location(URI.create(this.urlService.getURL(shortURL)))
    }
}
