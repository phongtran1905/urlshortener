package com.example.urlshortener.service;

import org.springframework.stereotype.Component;

@Component
public class URLConversionService {
    private static final String allowedString
            = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Integer allowedStringLength = allowedString.length();

    public String encode(Long id){
        StringBuilder result = new StringBuilder();
        do {
            result.insert(0, allowedString.charAt((int) (id % allowedStringLength)));
            id = id / allowedStringLength;
        } while (id > 0);
        return result.toString();
    }
}
