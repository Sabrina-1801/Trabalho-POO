import model.Filme;
import model.Midia;
import model.Serie;
import service.GerenciadorCatalogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorCatalogo gerenciador = new GerenciadorCatalogo();

        int opcao = -1;

        System.out.println("CATÁLOGO DE SÉRIES E FILMES (CLI)");
      

        while (opcao != 0) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Por favor, digite um número.");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarMidia(scanner, gerenciador);
                    break;
                case 2:
                    gerenciador.listarMidias();
                    break;
                case 3:
                    atualizarMidia(scanner, gerenciador);
                    break;
                case 4:
                    removerMidia(scanner, gerenciador);
                    break;
                case 0:
                    System.out.println("\nA encerrar o sistema... Até breve!");
                    break;
                default:
                    System.out.println(" Opção inválida. Escolha uma opção do menu.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - Adicionar Filme ou Série");
        System.out.println("2 - Listar Catálogo");
        System.out.println("3 - Atualizar Item");
        System.out.println("4 - Remover Item");
        System.out.println("0 - Sair");
    }

    private static void cadastrarMidia(Scanner scanner, GerenciadorCatalogo gerenciador) {
        System.out.println("ADICIONAR AO CATÁLOGO");
        System.out.println("1 - Filme");
        System.out.println("2 - Série");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo != 1 && tipo != 2) {
            System.out.println(" Tipo inválido. Operação cancelada.");
            return;
        }

        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o género: ");
        String genero = scanner.nextLine();

        System.out.print("Digite o ano de lançamento: ");
        int ano = scanner.nextInt();

        System.out.print("Digite a avaliação (0.0 a 10.0): ");
        double avaliacao = scanner.nextDouble();
        scanner.nextLine();

        int id = gerenciador.getProximoId();

        if (tipo == 1) {
            System.out.print("Digite a duração (em minutos): ");
            int duracao = scanner.nextInt();
            scanner.nextLine();
            gerenciador.adicionarMidia(new Filme(id, titulo, genero, ano, avaliacao, duracao));
        } else {
            System.out.print("Digite o número de temporadas: ");
            int temporadas = scanner.nextInt();
            scanner.nextLine();
            gerenciador.adicionarMidia(new Serie(id, titulo, genero, ano, avaliacao, temporadas));
        }
    }

    private static void atualizarMidia(Scanner scanner, GerenciadorCatalogo gerenciador) {
        System.out.print("\nDigite o ID do item que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Midia midia = gerenciador.buscarPorId(id);
        if (midia == null) {
            System.out.println(" Item não encontrado.");
            return;
        }

        System.out.print("Novo título (Atual: " + midia.getTitulo() + "): ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.trim().isEmpty()) {
            midia.setTitulo(novoTitulo);
        }

        System.out.print("Novo género (Atual: " + midia.getGenero() + "): ");
        String novoGenero = scanner.nextLine();
        if (!novoGenero.trim().isEmpty()) {
            midia.setGenero(novoGenero);
        }

        System.out.print("Nova avaliação (Atual: " + midia.getAvaliacao() + "): ");
        double novaAvaliacao = scanner.nextDouble();
        scanner.nextLine();
        midia.setAvaliacao(novaAvaliacao);

        System.out.println("Item atualizado com sucesso!");
    }

    private static void removerMidia(Scanner scanner, GerenciadorCatalogo gerenciador) {
        System.out.print("\nDigite o ID do item que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        gerenciador.removerMidia(id);
    }
}