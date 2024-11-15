package com.lionet.content_calendar.repository;

import com.lionet.content_calendar.model.ContType;
import com.lionet.content_calendar.model.Content;
import com.lionet.content_calendar.model.Status;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    public void init(){
        Content cont = new Content(
                1,
                "Rori",
                "Lorem",
                "http://www.",
                Status.IN_PROGRESS, //enum
                ContType.ARTICLE, //enum
                LocalDateTime.now(),
                null
        );

        content.add(cont);
    }
}
