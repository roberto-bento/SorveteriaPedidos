package repository;

import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido salvo no repositório.");
    }

    public List<Pedido> listarTodos() {
        return pedidos;
    }
}