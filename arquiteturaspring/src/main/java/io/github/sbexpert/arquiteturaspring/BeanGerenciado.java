package io.github.sbexpert.arquiteturaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.github.sbexpert.arquiteturaspring.todos.TodoEntity;
import io.github.sbexpert.arquiteturaspring.todos.components.validators.TodoValidator;

// Scope padrão é singleton - Uma única instância é compartilhada entre todas as threads e componentes. Variáveis de instância precisam ser thread-safe.
// Evite manter estado mutável específico de requisição/usuário dentro do bean, pois será compartilhado.
// @Lazy // O bean será inicializado somente quando for solicitado pela primeira vez, economizando recursos na inicialização da aplicação.
@Component
@Scope("singleton") // Uma JVM única compartilha a mesma instância do bean seja um milhao de requisições ou apenas uma
// @Scope("prototype") // Uma nova instância do bean é criada cada vez que ele é solicitado. Útil para beans com estado mutável específico de requisição/usuário.
// @Scope("request") // Uma nova instância do bean é criada para cada requisição HTTP. Útil em aplicações web onde o bean mantém estado específico da requisição.
// @Scope("session") // Uma nova instância do bean é criada para cada sessão HTTP. Útil em aplicações web onde o bean mantém estado específico do usuário durante a sessão.
// @Scope("application") // Uma única instância do bean é criada para toda a aplicação web, compartilhada entre todas as sessões e requisições.
public class BeanGerenciado {
    // Todos funcionanm com injeção de dependência

    // Injeção vai propriedade
    // não é recomendado pelo spring pois não deixa claro a obrigatoriedade da dependência
    @Autowired
    private TodoValidator validator;

    // @Autowired posso ou não colocar no construtor
    // Injeção via construtor
    // recomendação do spring é usar injeção via construtor da uma ideia de obrigatoriedade
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizarValidator() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    // Injeção via setter
    // a menos comum de se utilizar
    // não é obrigatório ter o valiador para utilizalo pois pode setar depois no momento da instanciação
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
