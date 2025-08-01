package state.impl;

import model.Pedido;
import state.EstadoPedido;

public class PedidoEntregue implements EstadoPedido {
    public void proximoEstado(Pedido pedido) {
        System.out.println("Pedido já foi entregue.");
    }

    public String getStatus() {
        return "Entregue";
    }
}