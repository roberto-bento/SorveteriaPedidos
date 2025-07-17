package decorator;

import model.Sorvete;

public class Calda extends SorveteDecorator {
    private String sabor;

    public Calda(Sorvete sorvete, String sabor) {
        super(sorvete);
        this.sabor = sabor;
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + " com calda de " + sabor;
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 1.5;
    }
}