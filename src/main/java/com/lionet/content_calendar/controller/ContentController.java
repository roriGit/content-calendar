package com.lionet.content_calendar.controller;

import com.lionet.content_calendar.model.Content;
import com.lionet.content_calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No content in calendar"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createContent(@RequestBody Content content){
        repository.save(content);
    }


    @PutMapping("/update/{id}")
    public void updateContent(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.findContentById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        repository.delete(id);
    }

}
