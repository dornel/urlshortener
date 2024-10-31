package com.dorneleduardo.shorturl.repository;


import com.dorneleduardo.shorturl.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UrlRepository extends JpaRepository<UrlModel, Long> {
}
