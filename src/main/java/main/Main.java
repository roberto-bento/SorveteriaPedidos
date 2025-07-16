package main;

import facade.SorveteriaFacade;
import model.Pedido;
import observer.ClienteObserver;
import repository.PedidoRepository;

public class Main {
    public static void main(String[] args) {
        SorveteriaFacade facade = new SorveteriaFacade();
        ClienteObserver cliente = new ClienteObserver("João");

        Pedido pedido = facade.fazerPedido("massa", true, true, false, cliente);
        pedido.proximoEstado(); // Preparando
        pedido.proximoEstado(); // Entregue

        PedidoRepository repo = new PedidoRepository();
        repo.salvar(pedido);
    }
}