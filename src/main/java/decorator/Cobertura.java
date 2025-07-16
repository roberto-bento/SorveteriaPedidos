package decorator;

import model.Sorvete;

public class Cobertura extends SorveteDecorator {
    public Cobertura(Sorvete sorvete) {
        super(sorvete);
    }

    public String getDescricao() {
        return sorvete.getDescricao() + " com cobertura";
    }

    public double getPreco() {
        return sorvete.getPreco() + 2.0;
    }
}
