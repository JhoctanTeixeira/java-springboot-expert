# java-springboot-expert

Repositório de estudos avançados em Spring Boot contendo dois projetos separados que exploram conceitos distintos:

- **arquiteturaspring**: foco em configuração avançada, perfis, injeção de dependências, `@ConfigurationProperties`, uso de environment e ciclo de inicialização do contexto.
- **produtosapi**: API REST de produtos com CRUD, persistência em banco H2 e carga inicial via `data.sql`.

## Visão Geral

Todos os módulos utilizam **Java 21** e **Spring Boot** (arquiteturaspring 3.5.8 / produtosapi 3.4.12). Cada projeto possui seu próprio `pom.xml` e pode ser executado de forma independente usando o wrapper Maven (`mvnw`).

## Projeto: arquiteturaspring

**Objetivo**: Demonstrar recursos do container do Spring: construção manual via `SpringApplicationBuilder`, desligar banner, ativar perfil, acessar `Environment`, beans gerenciados e valores externos.

**Principais pontos do código**:

- Classe principal `Application` usa `SpringApplicationBuilder` com `bannerMode(OFF)` e perfil `producao`.
- Leitura de propriedades com `@ConfigurationProperties` (`AppProperties`).
- Injecção de valores com `@Value` (classe `ExemploValue`).
- Demonstração de obtenção de beans do contexto após inicialização.

**Dependências principais**:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- Banco em memória: `h2`
- DevTools para hot reload

**Execução**:

```bash
cd arquiteturaspring
./mvnw spring-boot:run
```

Opcional: ajustar perfil via `--spring.profiles.active=dev` (o código força `producao`, se quiser outro perfil remova/ajuste no builder).

## Projeto: produtosapi

**Objetivo**: Implementar uma API REST simples de produtos (CRUD) com persistência JPA e inicialização de dados.

**Principais pontos**:

- Classe principal `ProdutosApiApplication` com inicialização padrão do Spring Boot.
- Pacotes esperados: `controller`, `model`, `repository` (arquitetura típica REST + JPA).
- Carga inicial de dados em `src/main/resources/data.sql`.

**Dependências principais**:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- Banco em memória: `h2`
- `lombok` (anotações e geração de código via annotation processor)
- Testes: `spring-boot-starter-test`

**Execução**:

```bash
cd produtosapi
./mvnw spring-boot:run
```

Após subir, acessar console H2 (se configurado) ou testar endpoints (ex.: `GET /produtos`).

## Requisitos

- Java 21 instalado (`java -version` deve mostrar 21).
- Permissão de execução para wrappers: `chmod +x */mvnw` se necessário.

## Execução Rápida de Ambos

Em dois terminais separados ou usando subshells:

```bash
cd arquiteturaspring && ./mvnw spring-boot:run
# Em outro terminal
cd produtosapi && ./mvnw spring-boot:run
```

## Estrutura Simplificada

```
arquiteturaspring/
	src/main/java/.../Application.java
	src/main/resources/application.yml
produtosapi/
	src/main/java/.../ProdutosApiApplication.java
	src/main/resources/application.properties
	src/main/resources/data.sql
```

## Próximos Passos Sugestões

- Adicionar documentação de endpoints da API (`produtosapi`) via OpenAPI/Swagger.
- Criar exemplos de testes de integração.
- Explorar múltiplos perfis com diferentes configs (`application-dev.yml`, etc.).

---

Qualquer melhoria ou ajuste adicional: abra uma issue ou contribua diretamente.
