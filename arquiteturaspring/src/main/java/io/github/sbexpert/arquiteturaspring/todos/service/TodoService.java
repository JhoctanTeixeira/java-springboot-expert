package io.github.sbexpert.arquiteturaspring.todos.service;

import org.springframework.stereotype.Service;

import io.github.sbexpert.arquiteturaspring.todos.TodoEntity;
import io.github.sbexpert.arquiteturaspring.todos.components.MailSender;
import io.github.sbexpert.arquiteturaspring.todos.components.validators.TodoValidator;
import io.github.sbexpert.arquiteturaspring.todos.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);

    }

    public void atualizarStatus(TodoEntity todo) {
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Pendente";
        mailSender.enviar("TODO " + todo.getDescricao() + " foi atualizado para " + status + ".");
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
