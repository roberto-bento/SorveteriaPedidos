package facade;

import model.Pedido;
import model.Sorvete;
import observer.Observer;
import factory.SorveteFactory;
import decorator.*;

public class SorveteriaFacade {
    public Pedido fazerPedido(String tipoSorvete, boolean cobertura, boolean calda, boolean chantilly, Observer cliente) {
        Sorvete sorvete = SorveteFactory.criarSorvete(tipoSorvete);
        if (cobertura) sorvete = new Cobertura(sorvete);
        if (calda) sorvete = new Calda(sorvete);
        if (chantilly) sorvete = new Chantilly(sorvete);

        Pedido pedido = new Pedido(sorvete);
        pedido.adicionarObserver(cliente);
        return pedido;
    }
}