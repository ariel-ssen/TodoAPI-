package org.example.todoapi.service;

import org.example.todoapi.dto.TodoDto;
import org.example.todoapi.entity.Todo;
import org.example.todoapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // Todo 생성
    @Transactional
    public TodoDto createTodo(String title, String content) {
        Todo todo = new Todo(title, content, LocalDateTime.now());
        return TodoDto.fromEntity(todoRepository.save(todo));
    }

    // Todo 목록 조회
    @Transactional(readOnly = true)
    public List<TodoDto> getTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 특정 Todo 조회
    @Transactional(readOnly = true)
    public TodoDto getTodoById(Long id) {
        return todoRepository.findById(id)
                .map(TodoDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
    }

    // Todo 수정
    @Transactional
    public TodoDto updateTodo(Long id, String title, String content) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
        todo.update(title, content);
        return TodoDto.fromEntity(todo);
    }

    // Todo 삭제
    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
