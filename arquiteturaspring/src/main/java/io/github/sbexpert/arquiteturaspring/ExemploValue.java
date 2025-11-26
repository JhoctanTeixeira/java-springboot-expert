package io.github.sbexpert.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

  @Value("${app.config.varivel}")
  private String valor;

  public void imprimirVariavel() {
    System.out.println("Variavel: " + valor);
  }
}
