package org.example.todoapi.controller;

import org.example.todoapi.dto.TodoDto;
import org.example.todoapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 모든 Todo 조회
    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }

    // 특정 Todo 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    // Todo 생성
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestParam String title, @RequestParam String content) {
        return ResponseEntity.ok(todoService.createTodo(title, content));
    }

    // Todo 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id,
                                              @RequestParam String title,
                                              @RequestParam String content) {
        return ResponseEntity.ok(todoService.updateTodo(id, title, content));
    }

    // Todo 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
