package decorator;

import model.Sorvete;

public class Calda extends SorveteDecorator {
    public Calda(Sorvete sorvete) {
        super(sorvete);
    }

    public String getDescricao() {
        return sorvete.getDescricao() + " com calda";
    }

    public double getPreco() {
        return sorvete.getPreco() + 1.5;
    }
}
