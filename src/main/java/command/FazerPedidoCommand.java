package command;

import command.PedidoCommand;
import model.Pedido;

public class FazerPedidoCommand implements PedidoCommand {
    private final Pedido pedido;
    private boolean cancelado = false;

    public FazerPedidoCommand(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        if (cancelado) {
            System.out.println("Pedido cancelado anteriormente: " + getClienteNome());
            return;
        }
        pedido.processar();
    }

    public void desfazer() {
        cancelado = true;
        System.out.println("Pedido cancelado: " + getClienteNome());
    }

    public String getDescricao() {
        return getClienteNome() + ": " + pedido.getDescricao();
    }

    public String getClienteNome() {
        return pedido.getClienteNome();
    }
    public Pedido getPedido() {
        return pedido;
    }
}