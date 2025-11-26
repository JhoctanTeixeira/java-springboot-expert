package io.github.sbexpert.arquiteturaspring;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.bannerMode(Mode.OFF);
		builder.profiles("producao");

		// builder.lazyInitialization(true);

		builder.run(args);

		// Contexto já inicializado
		ConfigurableApplicationContext context = builder.context();
		// var produtoRepository = context.getBean("produtoRepository");

		ConfigurableEnvironment environment = context.getEnvironment();
		String appName = environment.getProperty("spring.application.name");
		System.out.println("Application Name: " + appName);

		ExemploValue value = context.getBean(ExemploValue.class);
		value.imprimirVariavel();

		AppProperties appProperties = context.getBean(AppProperties.class);
		System.out.println("App Config Variavel: " + appProperties.getValor1());
	}

}
