package state.impl;

import model.Pedido;
import state.EstadoPedido;

public class PedidoRecebido implements EstadoPedido {
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoPreparando());
    }

    public String getStatus() {
        return "Recebido";
    }
}