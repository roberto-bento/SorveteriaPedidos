package main;

import facade.SorveteriaFacade;
import model.Pedido;
import observer.ClienteObserver;
import repository.PedidoRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SorveteriaFacade facade = new SorveteriaFacade();
        PedidoRepository repo = new PedidoRepository();

        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();
        ClienteObserver cliente = new ClienteObserver(nomeCliente);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu Sorveteria ---");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Avançar Estado do Pedido");
            System.out.println("3. Ver Histórico de Pedidos");
            System.out.println("4. Editar Pedido");
            System.out.println("5. Cancelar Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Tipo de sorvete (picolé, massa, milkshake): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Sabor do sorvete: ");
                    String sabor = scanner.nextLine();

                    System.out.print("Adicionar cobertura (s/n)? ");
                    boolean cobertura = scanner.nextLine().equalsIgnoreCase("s");
                    String saborCobertura = "";
                    if (cobertura) {
                        System.out.print("Sabor da cobertura: ");
                        saborCobertura = scanner.nextLine();
                    }

                    System.out.print("Adicionar calda (s/n)? ");
                    boolean calda = scanner.nextLine().equalsIgnoreCase("s");
                    String saborCalda = "";
                    if (calda) {
                        System.out.print("Sabor da calda: ");
                        saborCalda = scanner.nextLine();
                    }

                    System.out.print("Adicionar chantilly (s/n)? ");
                    boolean chantilly = scanner.nextLine().equalsIgnoreCase("s");
                    String saborChantilly = "";
                    if (chantilly) {
                        System.out.print("Sabor do chantilly: ");
                        saborChantilly = scanner.nextLine();
                    }

                    Pedido pedido = facade.fazerPedido(tipo, sabor, cobertura, saborCobertura, calda, saborCalda, chantilly, saborChantilly, cliente);
                    repo.salvar(pedido);
                    System.out.println("\nPedido criado com sucesso: " + pedido.getSorvete().getDescricao() +
                            " | Preço: R$ " + pedido.getSorvete().getPreco());
                }
                case 2 -> {
                    var pedidos = repo.listarTodos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado.");
                        break;
                    }
                    System.out.println("Pedidos disponíveis:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(i + ". " + pedidos.get(i).getSorvete().getDescricao() +
                                " | Estado: " + pedidos.get(i).getEstadoAtual());
                    }
                    System.out.print("Escolha o índice do pedido para avançar o estado: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice >= 0 && indice < pedidos.size()) {
                        pedidos.get(indice).proximoEstado();
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 3 -> {
                    System.out.println("\n--- Histórico de Pedidos ---");
                    for (Pedido p : repo.listarTodos()) {
                        System.out.println(p.getSorvete().getDescricao() +
                                " | Preço: R$ " + p.getSorvete().getPreco() +
                                " | Estado: " + p.getEstadoAtual());
                    }
                }
                case 4 -> {
                    var pedidos = repo.listarTodos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado.");
                        break;
                    }
                    System.out.println("Pedidos disponíveis para edição:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(i + ". " + pedidos.get(i).getSorvete().getDescricao());
                    }
                    System.out.print("Escolha o índice do pedido para editar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice >= 0 && indice < pedidos.size()) {
                        Pedido antigo = pedidos.get(indice);

                        System.out.print("Novo tipo de sorvete: ");
                        String novoTipo = scanner.nextLine();

                        System.out.print("Novo sabor do sorvete: ");
                        String novoSabor = scanner.nextLine();

                        System.out.print("Adicionar cobertura (s/n)? ");
                        boolean cobertura = scanner.nextLine().equalsIgnoreCase("s");
                        String saborCobertura = "";
                        if (cobertura) {
                            System.out.print("Sabor da cobertura: ");
                            saborCobertura = scanner.nextLine();
                        }

                        System.out.print("Adicionar calda (s/n)? ");
                        boolean calda = scanner.nextLine().equalsIgnoreCase("s");
                        String saborCalda = "";
                        if (calda) {
                            System.out.print("Sabor da calda: ");
                            saborCalda = scanner.nextLine();
                        }

                        System.out.print("Adicionar chantilly (s/n)? ");
                        boolean chantilly = scanner.nextLine().equalsIgnoreCase("s");
                        String saborChantilly = "";
                        if (chantilly) {
                            System.out.print("Sabor do chantilly: ");
                            saborChantilly = scanner.nextLine();
                        }

                        facade.editarPedido(antigo, novoTipo, novoSabor, cobertura, saborCobertura, calda, saborCalda, chantilly, saborChantilly);
                        System.out.println("Pedido editado com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 5 -> {
                    var pedidos = repo.listarTodos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido para cancelar.");
                        break;
                    }
                    System.out.println("Pedidos disponíveis:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println(i + ". " + pedidos.get(i).getSorvete().getDescricao() +
                                " | Estado: " + pedidos.get(i).getEstadoAtual());
                    }
                    System.out.print("Escolha o índice do pedido para cancelar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice >= 0 && indice < pedidos.size()) {
                        facade.cancelarPedido(pedidos.get(indice));
                        System.out.println("Pedido cancelado com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 0 -> {
                    continuar = false;
                    System.out.println("Saindo... Obrigado por usar a sorveteria!");
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}