package facade;

import command.CancelarPedido;
import command.FazerPedido;
import decorator.Calda;
import decorator.Chantilly;
import decorator.Cobertura;
import factory.SorveteFactory;
import model.Pedido;
import model.Sorvete;
import observer.Observer;
import state.PedidoCancelado;

public class SorveteriaFacade {

    public Pedido fazerPedido(
            String tipo,
            String saborSorvete,
            boolean cobertura, String saborCobertura,
            boolean calda, String saborCalda,
            boolean chantilly, String saborChantilly,
            Observer cliente
    ) {
        Sorvete sorveteBase = SorveteFactory.criarSorvete(tipo, saborSorvete);

        if (cobertura) sorveteBase = new Cobertura(sorveteBase, saborCobertura);
        if (calda)     sorveteBase = new Calda(sorveteBase, saborCalda);
        if (chantilly) sorveteBase = new Chantilly(sorveteBase, saborChantilly);

        Pedido pedido = new Pedido(sorveteBase);
        pedido.adicionarObserver(cliente);

        new FazerPedido(pedido).executar();

        return pedido;
    }

    public void editarPedido(
            Pedido pedido,
            String tipo,
            String saborSorvete,
            boolean cobertura, String saborCobertura,
            boolean calda, String saborCalda,
            boolean chantilly, String saborChantilly
    ) {
        Sorvete novoSorvete = SorveteFactory.criarSorvete(tipo, saborSorvete);

        if (cobertura) novoSorvete = new Cobertura(novoSorvete, saborCobertura);
        if (calda)     novoSorvete = new Calda(novoSorvete, saborCalda);
        if (chantilly) novoSorvete = new Chantilly(novoSorvete, saborChantilly);

        pedido.setSorvete(novoSorvete);
    }

    public void cancelarPedido(Pedido pedido) {
        new CancelarPedido(pedido).executar();
        pedido.setEstado(new PedidoCancelado());
    }
}
