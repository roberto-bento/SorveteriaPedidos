package command;

import model.Pedido;
import singleton.PedidoQueue;

public class FazerPedido implements Comando {
    private Pedido pedido;
    public FazerPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public void executar() {
        PedidoQueue.getInstancia().adicionarPedido(pedido);
    }
    public void desfazer() {
        System.out.println("Pedido removido da fila (simulação de cancelamento).\n");
    }
}