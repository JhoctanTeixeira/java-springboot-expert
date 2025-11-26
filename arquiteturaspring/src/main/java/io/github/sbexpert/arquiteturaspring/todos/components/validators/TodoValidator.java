package io.github.sbexpert.arquiteturaspring.todos.components.validators;

import org.springframework.stereotype.Component;

import io.github.sbexpert.arquiteturaspring.todos.TodoEntity;
import io.github.sbexpert.arquiteturaspring.todos.repository.TodoRepository;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo) {
        if (existeTodoComDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com a mesma descrição.");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }

}
