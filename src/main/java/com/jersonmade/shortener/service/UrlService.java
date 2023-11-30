package com.jersonmade.shortener.service;

import com.jersonmade.shortener.entity.UrlEntity;
import com.jersonmade.shortener.repo.UrlRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
     private final UrlRepo urlRepo;

     public String shortenUrl(String originalUrl) {
          Optional<UrlEntity> existingUrl = urlRepo.findByOriginalUrl(originalUrl);

          if(existingUrl.isPresent()) {
               return existingUrl.get().getShortUrl();
          } else {
               String shortCode = Base64
                       .getUrlEncoder()
                       .encodeToString(originalUrl.getBytes())
                       .substring(0, 6);

               UrlEntity newUrl = new UrlEntity();
               newUrl.setOriginalUrl(originalUrl);
               newUrl.setShortUrl(shortCode);

               urlRepo.save(newUrl);

               return shortCode;
          }
     }

     public String getOriginalUrl(String shortUrl) {
          Optional<UrlEntity> url = urlRepo.findByShortUrl(shortUrl);

          if (url.isPresent()) {
               return url.get().getOriginalUrl();
          } else {
               return "Url not found";
          }
     }
}
