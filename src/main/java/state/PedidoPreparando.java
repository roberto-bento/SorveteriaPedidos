package state;

import model.Pedido;

public class PedidoPreparando implements EstadoPedido {
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }
    public String getEstado() {
        return "Preparando";
    }
}