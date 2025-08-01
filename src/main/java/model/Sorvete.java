package model;

public abstract class Sorvete {
    protected String sabor = "";
    public abstract double getPreco();
    public abstract String getDescricao();
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public String getSabor() {
        return sabor;
    }
}