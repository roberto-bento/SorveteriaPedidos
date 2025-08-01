package singleton;

import command.PedidoCommand;
import command.impl.FazerPedidoCommand;
import model.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos {
    private static FilaPedidos instancia;
    private final Queue<FazerPedidoCommand> fila = new LinkedList<>();
    private final Queue<Pedido> historico = new LinkedList<>();

    private FilaPedidos() {}

    public static FilaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new FilaPedidos();
        }
        return instancia;
    }

    public void adicionar(FazerPedidoCommand pedido) {
        fila.add(pedido);
        System.out.println("Pedido adicionado à fila.");
    }

    public void mostrarFila() {
        System.out.println("Pedidos na fila: " + fila.size());
        for (FazerPedidoCommand cmd : fila) {
            System.out.println(cmd.getPedido().getDescricao());
        }
    }

    public void avancarPedido(String nome) {
        for (FazerPedidoCommand cmd : fila) {
            if (cmd.getPedido().getClienteNome().equalsIgnoreCase(nome) && !cmd.getPedido().isCancelado()) {
                cmd.getPedido().avancarEstado();
                if (cmd.getPedido().isEntregue()) {
                    historico.add(cmd.getPedido());
                    fila.remove(cmd);
                }
                return;
            }
        }
        System.out.println("Pedido não encontrado ou já foi cancelado/entregue.");
    }

    public void processarPedidos() {
        System.out.println("--- Histórico de Pedidos Processados ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhum pedido processado ainda.");
        } else {
            for (Pedido pedido : historico) {
                System.out.println(pedido.getDescricao());
            }
        }
    }

    public void removerPorNomeCliente(String nome) {
        FazerPedidoCommand encontrado = null;
        for (FazerPedidoCommand cmd : fila) {
            if (cmd.getPedido().getClienteNome().equalsIgnoreCase(nome) && !cmd.getPedido().isCancelado() && !cmd.getPedido().isEntregue()) {
                encontrado = cmd;
                break;
            }
        }
        if (encontrado != null) {
            encontrado.getPedido().cancelar();
            historico.add(encontrado.getPedido());
            fila.remove(encontrado);
            System.out.println("Pedido cancelado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado ou já entregue.");
        }
    }

    public boolean existePedido(String nome) {
        return fila.stream().anyMatch(cmd -> cmd.getPedido().getClienteNome().equalsIgnoreCase(nome) && !cmd.getPedido().isCancelado());
    }

    public FazerPedidoCommand obterPedidoPorNome(String nome) {
        return fila.stream()
                .filter(cmd -> cmd.getPedido().getClienteNome().equalsIgnoreCase(nome) && !cmd.getPedido().isCancelado())
                .findFirst()
                .orElse(null);
    }

    public void adicionarHistorico(Pedido pedido) {
        historico.add(pedido);
    }
}
