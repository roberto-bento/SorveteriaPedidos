package observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoObservable {
    private List<Observer> observadores = new ArrayList<>();

    public void adicionarObserver(Observer obs) {
        observadores.add(obs);
    }

    public void notificar(String status) {
        for (Observer obs : observadores) {
            obs.atualizar(status);
        }
    }
}
