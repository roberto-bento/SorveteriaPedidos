package observer;

public class ClienteObserver implements Observer {
    private String nome;

    public ClienteObserver(String nome) {
        this.nome = nome;
    }

    public void atualizar(String status) {
        System.out.println(nome + ", seu pedido está: " + status);
    }
}