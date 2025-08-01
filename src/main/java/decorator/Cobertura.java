package decorator.impl;

import decorator.SorveteDecorator;
import model.Sorvete;

public class Cobertura extends SorveteDecorator {
    private final String saborCobertura;

    public Cobertura(Sorvete sorvete, String sabor) {
        super(sorvete);
        this.saborCobertura = sabor;
    }

    public double getPreco() {
        return sorvete.getPreco() + 2.0;
    }

    public String getDescricao() {
        return sorvete.getDescricao() + ", com cobertura de " + saborCobertura;
    }
}
