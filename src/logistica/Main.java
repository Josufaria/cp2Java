package logistica;

import logistica.models.*;
import logistica.services.GerenciadorEntregas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEntregas gerenciador = new GerenciadorEntregas();
        int incrementadorEntrega = 1;

        System.out.println("=========================================");
        System.out.println("  SISTEMA DE LOGÍSTICA - E-COMMERCE FIAP ");
        System.out.println("=========================================");

        boolean executando = true;
        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Entregador");
            System.out.println("2. Criar Entrega");
            System.out.println("3. Listar Entregas");
            System.out.println("4. Listar Entregadores");
            System.out.println("5. Atribuir Entrega a um Entregador");
            System.out.println("6. Atualizar Status de uma Entrega");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n-- Cadastrando Entregador --");
                    System.out.print("ID do Entregador: ");
                    int idEnt = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome do Entregador: ");
                    String nome = scanner.nextLine();
                    System.out.print("Capacidade de carga (kg): ");
                    double cap = Double.parseDouble(scanner.nextLine());

                    System.out.println("Tipo (1-Moto, 2-Bicicleta, 3-Carro): ");
                    String tipo = scanner.nextLine();

                    Entregador entregador = null;
                    if (tipo.equals("1")) {
                        entregador = new EntregadorMoto(idEnt, nome, cap);
                    } else if (tipo.equals("2")) {
                        entregador = new EntregadorBicicleta(idEnt, nome, cap);
                    } else if (tipo.equals("3")) {
                        entregador = new EntregadorCarro(idEnt, nome, cap);
                    }

                    if (entregador != null) {
                        gerenciador.cadastrarEntregador(entregador);
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case "2":
                    System.out.println("\n-- Criando Entrega --");
                    System.out.print("Endereço de Destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Distância Estimada (em KM): ");
                    double distancia = Double.parseDouble(scanner.nextLine());

                    Entrega novaEntrega = new Entrega(incrementadorEntrega++, destino, distancia);
                    gerenciador.criarEntrega(novaEntrega);
                    System.out.println("ID gerado: " + novaEntrega.getId());
                    break;

                case "3":
                    System.out.println("\n-- Lista de Entregas --");
                    for (Entrega e : gerenciador.listarEntregas()) {
                        System.out.println(e.exibirDetalhes());
                        System.out.println("-------------------------");
                    }
                    break;

                case "4":
                    System.out.println("\n-- Lista de Entregadores --");
                    for (Entregador e : gerenciador.listarEntregadores()) {
                        System.out.println(e.toString());
                    }
                    break;

                case "5":
                    System.out.println("\n-- Atribuir Entrega --");
                    System.out.print("ID da Entrega: ");
                    int idEntr = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID do Entregador: ");
                    int idEntreg = Integer.parseInt(scanner.nextLine());

                    gerenciador.atribuirEntrega(idEntr, idEntreg);
                    break;

                case "6":
                    System.out.println("\n-- Atualizar Status --");
                    System.out.print("ID da Entrega: ");
                    int idStatus = Integer.parseInt(scanner.nextLine());
                    System.out.println("Novos status disponíveis:");
                    System.out.println("1 - PENDENTE | 2 - EM_ROTA | 3 - ENTREGUE | 4 - CANCELADA");
                    System.out.print("Escolha o nº do status: ");
                    String numStatus = scanner.nextLine();
                    
                    StatusEntrega novoStatus = null;
                    if(numStatus.equals("1")) novoStatus = StatusEntrega.PENDENTE;
                    else if(numStatus.equals("2")) novoStatus = StatusEntrega.EM_ROTA;
                    else if(numStatus.equals("3")) novoStatus = StatusEntrega.ENTREGUE;
                    else if(numStatus.equals("4")) novoStatus = StatusEntrega.CANCELADA;

                    if(novoStatus != null) {
                        System.out.print("Deseja inserir alguma observação? (Deixe em branco para nenhuma): ");
                        String obs = scanner.nextLine();
                        gerenciador.atualizarStatusEntrega(idStatus, novoStatus, obs);
                    } else {
                        System.out.println("Status inválido!");
                    }
                    break;

                case "0":
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
