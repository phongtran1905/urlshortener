package com.example.urlshortener.controller;

import com.example.urlshortener.dto.LongURLDto;
import com.example.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataURLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<LongURLDto> createURL(@RequestBody LongURLDto longURLDto){
        return ResponseEntity
                .status(200)
                .body(new LongURLDto(this.urlService.createURL(longURLDto.longURL())));
    }
}
