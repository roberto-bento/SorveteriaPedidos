package model;

import observer.ClienteObserver;
import state.EstadoPedido;
import state.impl.PedidoRecebido;
import strategy.DescontoStrategy;

public class Pedido {
    private final Sorvete sorvete;
    private final DescontoStrategy desconto;
    private final ClienteObserver cliente;
    private EstadoPedido estado;
    private boolean cancelado = false;
    private boolean entregue = false;

    public Pedido(Sorvete sorvete, DescontoStrategy desconto, ClienteObserver cliente) {
        this.sorvete = sorvete;
        this.desconto = desconto;
        this.cliente = cliente;
        this.estado = new PedidoRecebido();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void avancarEstado() {
        if (!cancelado && !entregue) {
            estado.proximoEstado(this);
            cliente.atualizar(estado.getStatus());
            if (estado.getStatus().equals("Entregue")) {
                entregue = true;
            }
        }
    }

    public void cancelar() {
        cancelado = true;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public String getDescricao() {
        if (cancelado) {
            return cliente.getNome() + ": Pedido CANCELADO.";
        }
        return cliente.getNome() + ": " + sorvete.getDescricao() + " - Preço: R$" + String.format("%.2f", desconto.aplicarDesconto(sorvete.getPreco()));
    }

    public String getClienteNome() {
        return cliente.getNome();
    }

    public void processar() {
    }
} 