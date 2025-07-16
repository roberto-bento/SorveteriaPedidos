package state;

import model.Pedido;

public class PedidoRecebido implements EstadoPedido {
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoPreparando());
    }

    public String getEstado() {
        return "Recebido";
    }
}