package strategy;

public class DescontoSazonal implements DescontoStrategy {
    public double aplicarDesconto(double valor) {
        return valor * 0.8;
    }
}