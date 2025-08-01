package observer.impl;

import observer.ClienteObserver;

public class Cliente implements ClienteObserver {
    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void atualizar(String status) {
        System.out.println("Cliente " + nome + " foi notificado: " + status);
    }

    public String getNome() {
        return nome;
    }
}
