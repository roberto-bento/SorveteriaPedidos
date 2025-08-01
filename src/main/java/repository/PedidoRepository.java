package repository;

import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private static final List<Pedido> pedidos = new ArrayList<>();

    public static void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static List<Pedido> listar() {
        return pedidos;
    }
}