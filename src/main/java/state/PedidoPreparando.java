package state.impl;

import model.Pedido;
import state.EstadoPedido;

public class PedidoPreparando implements EstadoPedido {
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    public String getStatus() {
        return "Preparando";
    }
}
