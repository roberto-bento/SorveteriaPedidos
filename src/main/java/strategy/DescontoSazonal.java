package strategy;

import strategy.DescontoStrategy;

public class DescontoSazonal implements DescontoStrategy {
    public double aplicarDesconto(double preco) {
        return preco * 0.85;
    }
}
