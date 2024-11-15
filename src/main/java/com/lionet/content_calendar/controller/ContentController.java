package com.lionet.content_calendar.controller;

import com.lionet.content_calendar.model.Content;
import com.lionet.content_calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    public Content findSingle(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No content in calendar"));
    }

    @PostMapping("/create")
    public void createContent(@RequestBody Content content){
        repository.save(content);
    }
}
