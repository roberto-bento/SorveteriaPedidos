package service;

import command.PedidoCommand;
import command.FazerPedidoCommand;
import decorator.Chantilly;
import decorator.Cobertura;
import factory.SorveteFactory;
import model.Pedido;
import model.Sorvete;
import observer.Cliente;
import repository.PedidoRepository;
import singleton.FilaPedidos;
import strategy.DescontoStrategy;
import strategy.DescontoCliente;
import strategy.DescontoSazonal;

import java.util.Scanner;

public class GerenciadorPedidos {
    private final Scanner scanner = new Scanner(System.in);



    public void realizarPedido() {
        System.out.print("Nome do cliente: ");
        Cliente cliente = new Cliente(scanner.nextLine());

        System.out.print("Tipo (massa, milkshake, picole): ");
        String tipo = scanner.nextLine();
        Sorvete sorvete = SorveteFactory.criarSorvete(tipo);

        System.out.print("Escolha o sabor: ");
        String saborBase = scanner.nextLine();
        sorvete.setSabor(saborBase);

        if (!tipo.equalsIgnoreCase("picole")) {
            System.out.print("Adicionar cobertura (s/n)? ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.print("Sabor da cobertura: ");
                String saborCobertura = scanner.nextLine();
                sorvete = new Cobertura(sorvete, saborCobertura);
            }

            System.out.print("Adicionar chantilly (s/n)? ");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                sorvete = new Chantilly(sorvete);
            }
        }

        System.out.print("Desconto (nenhum, cliente, sazonal): ");
        String desc = scanner.nextLine();
        DescontoStrategy desconto = switch (desc) {
            case "cliente" -> new DescontoCliente();
            case "sazonal" -> new DescontoSazonal();
            default -> preco -> preco;
        };

        Pedido pedido = new Pedido(sorvete, desconto, cliente);
        PedidoRepository.salvar(pedido);
        FilaPedidos.getInstancia().adicionar(new FazerPedidoCommand(pedido));
    }

    public void verFila() {
        FilaPedidos.getInstancia().mostrarFila();
    }

    public void processarFila() {
        FilaPedidos.getInstancia().processarPedidos();
    }

    public void editarOuCancelarPedido() {
        System.out.print("Nome do cliente do pedido a editar/cancelar: ");
        String nome = scanner.nextLine();
        if (!FilaPedidos.getInstancia().existePedido(nome)) {
            System.out.println("Pedido não encontrado.");
            return;
        }
        System.out.println("1. Cancelar Pedido\n2. Editar Pedido");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) {
            PedidoCommand cmd = FilaPedidos.getInstancia().obterPedidoPorNome(nome);
            cmd.desfazer();
            FilaPedidos.getInstancia().removerPorNomeCliente(nome);
        } else if (op == 2) {
            FilaPedidos.getInstancia().removerPorNomeCliente(nome);
            realizarPedido();
        }
    }
}
