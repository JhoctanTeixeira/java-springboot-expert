package io.github.sbexpert.arquiteturaspring.todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sbexpert.arquiteturaspring.todos.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
}
