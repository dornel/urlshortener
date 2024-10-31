package com.dorneleduardo.shorturl.controller;


import com.dorneleduardo.shorturl.dto.UrlDto;
import com.dorneleduardo.shorturl.model.UrlModel;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dorneleduardo.shorturl.repository.UrlRepository;
import jakarta.servlet.http.HttpServletResponse.*;

import java.io.IOException;
import java.net.URI;



@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class UrlController {


    @Autowired
    UrlRepository urlRepository;
    UrlModel urlModel;


    @PostMapping("/url")
    ResponseEntity<?> shortUrl (@RequestBody UrlDto urlDto){


        var url1 = new UrlModel();
        BeanUtils.copyProperties(urlDto,url1);
        urlRepository.save(url1);


        return ResponseEntity.status(HttpStatus.OK).body("localhost:8080/url/"+url1.getId());


    }

    @GetMapping("/url/{id}")
    ResponseEntity<?> getUrl(@PathVariable Long id){

       var url1 = urlRepository.findById(id);

        HttpHeaders headers = new HttpHeaders();
        
        headers.setLocation(URI.create(url1.get().getUrl()));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }




}
