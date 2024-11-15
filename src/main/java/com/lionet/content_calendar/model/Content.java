package com.lionet.content_calendar.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String name,
        String desc,
        String url,
        Status status, //enum
        ContType type, //enum
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated) {
}
