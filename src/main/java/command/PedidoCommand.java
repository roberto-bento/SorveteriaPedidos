package command;

import model.Pedido;

public interface PedidoCommand {
    void executar();
    void desfazer();

    Pedido getPedido();
}