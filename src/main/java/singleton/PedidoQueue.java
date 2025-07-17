package singleton;

import model.Pedido;
import java.util.LinkedList;
import java.util.Queue;

public class PedidoQueue {
    private static PedidoQueue instancia;
    private Queue<Pedido> fila = new LinkedList<>();

    private PedidoQueue() {}

    public static PedidoQueue getInstancia() {
        if (instancia == null) {
            instancia = new PedidoQueue();
        }
        return instancia;
    }

    public void removerPedido(Pedido pedido) {
        fila.remove(pedido);
    }

    public void adicionarPedido(Pedido pedido) {

        fila.add(pedido);
    }

    public Pedido proximoPedido() {
        return fila.poll();
    }
}
