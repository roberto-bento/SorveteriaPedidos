package strategy;

import strategy.DescontoStrategy;

public class DescontoCliente implements DescontoStrategy {
    public double aplicarDesconto(double preco) {
        return preco * 0.9;
    }
}