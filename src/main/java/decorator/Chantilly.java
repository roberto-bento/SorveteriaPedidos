package decorator;

import model.Sorvete;

public class Chantilly extends SorveteDecorator {
    public Chantilly(Sorvete sorvete) {
        super(sorvete);
    }

    public String getDescricao() {
        return sorvete.getDescricao() + " com chantilly";
    }

    public double getPreco() {
        return sorvete.getPreco() + 1.0;
    }
}
