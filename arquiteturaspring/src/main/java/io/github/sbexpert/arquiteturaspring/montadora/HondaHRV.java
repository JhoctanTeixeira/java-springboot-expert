package io.github.sbexpert.arquiteturaspring.montadora;

public class HondaHRV extends Carro {

    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("Honda HRV");
        setCor("Prata");
        setMontadora(Montadora.HONDA);
    }

}
