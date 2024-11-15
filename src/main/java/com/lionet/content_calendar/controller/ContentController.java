package com.lionet.content_calendar.controller;

import com.lionet.content_calendar.model.Content;
import com.lionet.content_calendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")

public class ContentController {
    private final ContentCollectionRepository repository;


    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Content> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id){
        return repository.findById(id);
    }

    public Optional<Content> findSingle(Integer id){
        return repository.findById(id);
    }
}
