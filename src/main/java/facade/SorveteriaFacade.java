package facade;

import service.GerenciadorPedidos;

import java.util.Scanner;

public class SorveteriaFacade {
    private final GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        while (true) {
            System.out.println("1. Novo Pedido\n2. Ver Fila\n3. Processar Fila\n4. Editar Pedido\n5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> gerenciadorPedidos.realizarPedido();
                case 2 -> gerenciadorPedidos.verFila();
                case 3 -> gerenciadorPedidos.processarFila();
                case 4 -> gerenciadorPedidos.editarOuCancelarPedido();
                case 5 -> System.exit(0);
            }
        }
    }
}