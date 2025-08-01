package model;

import model.Sorvete;

public class Massa extends Sorvete {
    public double getPreco() {
        return 10.0;
    }

    public String getDescricao() {
        return "massa sabor " + sabor;
    }
}