package decorator;

import model.Sorvete;

public abstract class SorveteDecorator implements Sorvete {
    protected Sorvete sorvete;

    public SorveteDecorator(Sorvete sorvete) {
        this.sorvete = sorvete;
    }
}
