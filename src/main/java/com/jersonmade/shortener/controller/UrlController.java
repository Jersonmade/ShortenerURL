package com.jersonmade.shortener.controller;

import com.jersonmade.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shortener")
public class UrlController {
    private final UrlService urlService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String shortenUrl(@RequestBody String originalUrl) {
        return urlService.shortenUrl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.OK)
    public String getOriginalUrl(@PathVariable String shortUrl) {
        return urlService.getOriginalUrl(shortUrl);
    }
}
