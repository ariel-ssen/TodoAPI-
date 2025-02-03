package org.example.todoapi.dto;

import org.example.todoapi.entity.Todo;
import java.time.LocalDateTime;

public record TodoDto(Long id, String title, String content, LocalDateTime date) {
    public static TodoDto fromEntity(Todo todo) {
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getContent(), todo.getDate());
    }
}
