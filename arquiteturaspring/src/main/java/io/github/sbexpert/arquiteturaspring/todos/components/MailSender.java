package io.github.sbexpert.arquiteturaspring.todos.components;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem) {
        System.out.println("Enviando email com a mensagem: " + mensagem);
    }
}
