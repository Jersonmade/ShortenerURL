package com.jersonmade.shortener.repo;

import com.jersonmade.shortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByOriginalUrl(String originalUrl);
    Optional<UrlEntity> findByShortUrl(String shortUrl);
}
