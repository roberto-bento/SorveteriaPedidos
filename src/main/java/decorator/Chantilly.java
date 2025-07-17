package decorator;

import model.Sorvete;

public class Chantilly extends SorveteDecorator {
    private String sabor;

    public Chantilly(Sorvete sorvete, String sabor) {
        super(sorvete);
        this.sabor = sabor;
    }

    @Override
    public String getDescricao() {
        return sorvete.getDescricao() + " com chantilly sabor " + sabor;
    }

    @Override
    public double getPreco() {
        return sorvete.getPreco() + 1.0;
    }
}