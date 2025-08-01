package model.impl;

import model.Sorvete;

public class Milkshake extends Sorvete {
    public double getPreco() {
        return 12.0;
    }

    public String getDescricao() {
        return "milkshake sabor " + sabor;
    }
}