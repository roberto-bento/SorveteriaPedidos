package decorator;

import decorator.SorveteDecorator;
import model.Sorvete;

public class Chantilly extends SorveteDecorator {
    public Chantilly(Sorvete sorvete) {
        super(sorvete);
    }

    public double getPreco() {
        return sorvete.getPreco() + 1.5;
    }

    public String getDescricao() {
        return sorvete.getDescricao() + " e chantilly";
    }
}