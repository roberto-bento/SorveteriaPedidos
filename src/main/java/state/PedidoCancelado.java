package state;

import model.Pedido;

public class PedidoCancelado implements EstadoPedido {
    @Override
    public void proximo(Pedido pedido) {
        System.out.println("Pedido cancelado. Não é possível avançar estado.");
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
