package io.github.sbexpert.arquiteturaspring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sbexpert.arquiteturaspring.montadora.CarroStatus;
import io.github.sbexpert.arquiteturaspring.montadora.Chave;
import io.github.sbexpert.arquiteturaspring.montadora.HondaHRV;
import io.github.sbexpert.arquiteturaspring.montadora.Motor;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired
    // @Qualifier("motorTurbo")
    @Eletrico
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
