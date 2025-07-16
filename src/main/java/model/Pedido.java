package model;

import observer.PedidoObservable;
import observer.Observer;
import state.EstadoPedido;
import state.PedidoRecebido;

public class Pedido {
    private Sorvete sorvete;
    private EstadoPedido estado;
    private PedidoObservable notificacoes;

    public Pedido(Sorvete sorvete) {
        this.sorvete = sorvete;
        this.estado = new PedidoRecebido();
        this.notificacoes = new PedidoObservable();
        notificacoes.notificar(estado.getEstado());
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        notificacoes.notificar(estado.getEstado());
    }

    public void proximoEstado() {
        estado.proximo(this);
    }

    public void adicionarObserver(Observer obs) {
        notificacoes.adicionarObserver(obs);
    }

    public Sorvete getSorvete() {
        return sorvete;
    }

    public String getEstadoAtual() {
        return estado.getEstado();
    }
}