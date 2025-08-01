package model;

import model.Sorvete;

public class Picole extends Sorvete {
    public double getPreco() {
        return 8.0;
    }

    public String getDescricao() {
        return "picole sabor " + sabor;
    }
}
