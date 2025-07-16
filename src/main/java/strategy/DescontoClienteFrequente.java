package strategy;

public class DescontoClienteFrequente implements DescontoStrategy {
    public double aplicarDesconto(double valor) {
        return valor * 0.9;
    }
}
