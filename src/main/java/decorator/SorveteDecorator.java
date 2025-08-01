package decorator;

import model.Sorvete;

public abstract class SorveteDecorator extends Sorvete {
    protected Sorvete sorvete;

    public SorveteDecorator(Sorvete sorvete) {
        this.sorvete = sorvete;
    }
}