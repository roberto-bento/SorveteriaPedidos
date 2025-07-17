package decorator;

import model.Sorvete;

public class Cobertura extends SorveteDecorator {
    private String sabor;

    public Cobertura(Sorvete sorvete, String sabor) {
        super(sorvete);
        this.sabor = sabor;
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + " com cobertura de " + sabor;
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 2.0;
    }
}