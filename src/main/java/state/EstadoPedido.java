package state;

import model.Pedido;

public interface EstadoPedido {
    void proximo(Pedido pedido);
    String getEstado();
}