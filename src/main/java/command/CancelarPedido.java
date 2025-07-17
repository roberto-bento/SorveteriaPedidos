package command;

import model.Pedido;
import singleton.PedidoQueue;

public class CancelarPedido implements Comando {
    private Pedido pedido;
    public CancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public void executar() {
        PedidoQueue.getInstancia().removerPedido(pedido);
        System.out.println("Pedido cancelado.\n");
    }
    public void desfazer() {
        PedidoQueue.getInstancia().adicionarPedido(pedido);
        System.out.println("Cancelamento desfeito: pedido adicionado novamente.\n");
    }
}