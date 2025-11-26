package io.github.sbexpert.arquiteturaspring;

import java.sql.Connection;

import javax.swing.text.html.parser.Entity;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import io.github.sbexpert.arquiteturaspring.todos.TodoEntity;
import io.github.sbexpert.arquiteturaspring.todos.components.MailSender;
import io.github.sbexpert.arquiteturaspring.todos.components.validators.TodoValidator;
import io.github.sbexpert.arquiteturaspring.todos.repository.TodoRepository;
import io.github.sbexpert.arquiteturaspring.todos.service.TodoService;
import jakarta.persistence.EntityManager;

public class ExemploInjecaoDependencia {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); // Suponha que este seja o DataSource obtido
                                                                            // via injeção de dependência
        dataSource.setUsername("usuario");
        dataSource.setPassword("senha");
        dataSource.setUrl("jdbc:mysql://localhost:3306/meubanco");

        Connection connection = null; // dataSource.getConnection();

        EntityManager entityManager = null; // Suponha que este seja o EntityManager obtido via injeção de dependência

        TodoRepository todoRepository = null;// new SimpleJpaRepository<TodoEntity, Integer>();(entityManager,
                                             // TodoEntity.class);
        TodoValidator todoValidator = new TodoValidator(todoRepository);
        MailSender mailSender = new MailSender();

        TodoService todoService = new TodoService(todoRepository, todoValidator, mailSender);
    }
}
