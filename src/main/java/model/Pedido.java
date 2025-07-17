package model;

import observer.PedidoObservable;
import observer.Observer;
import state.EstadoPedido;
import state.PedidoRecebido;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Sorvete sorvete;
    private EstadoPedido estado;
    private PedidoObservable notificacoes;
    private List<String> historicoEstados = new ArrayList<>();

    public Pedido(Sorvete sorvete) {
        this.sorvete = sorvete;
        this.estado = new PedidoRecebido();
        this.notificacoes = new PedidoObservable();
        historicoEstados.add(estado.getEstado());
        notificacoes.notificar(estado.getEstado());
    }

    public void setSorvete(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        historicoEstados.add(estado.getEstado());
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

    public List<String> getHistoricoEstados() {
        return historicoEstados;
    }
}