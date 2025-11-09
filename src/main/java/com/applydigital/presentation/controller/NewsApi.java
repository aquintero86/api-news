package com.applydigital.presentation.controller;

import com.applydigital.application.model.NewsGetResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RequestMapping(value = "/api/v1/news")


public interface NewsApi {


    @GetMapping
    ResponseEntity<List<NewsGetResponseDTO>> getAllNews(
            @RequestParam(name = "author", required = false) String author,
            @RequestParam(name = "tags", required = false) List<String> tags,
            @RequestParam(name = "storytitle", required = false) String storyTitle,
            @RequestParam(name = "month", required = false) Month month
    );

    @GetMapping("/{objectId}")
    ResponseEntity<NewsGetResponseDTO> getNewsByObjectId(@PathVariable String objectId);

    @DeleteMapping("/{objectId}")
    ResponseEntity<Void> deleteNewsById(@PathVariable String objectId);
}