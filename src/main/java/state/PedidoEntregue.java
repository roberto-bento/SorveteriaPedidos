package state;

import model.Pedido;

public class PedidoEntregue implements EstadoPedido {
    public void proximo(Pedido pedido) {
        System.out.println("Pedido já foi entregue.");
    }
    public String getEstado() {
        return "Entregue";
    }
}