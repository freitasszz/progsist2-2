import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStreaming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Midia> midias = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- Menu do App de Streaming ---");
            System.out.println("(1) Adicionar novo Filme.");
            System.out.println("(2) Adicionar nova Série.");
            System.out.println("(3) Listar todas as mídias.");
            System.out.println("(4) Sair.");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarFilme(scanner, midias);
                    break;
                case 2:
                    adicionarSerie(scanner, midias);
                    break;
                case 3:
                    listarMidias(midias);
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    private static void adicionarFilme(Scanner scanner, List<Midia> midias) {
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a duração do filme em minutos: ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Filme novoFilme = new Filme(titulo, duracao);
        midias.add(novoFilme);
        System.out.println("Filme '" + titulo + "' adicionado com sucesso!");
    }

    private static void adicionarSerie(Scanner scanner, List<Midia> midias) {
        System.out.print("Digite o título da série: ");
        String tituloSerie = scanner.nextLine();
        Serie novaSerie = new Serie(tituloSerie);

        for (int i = 1; i <= 2; i++) {
            Temporada novaTemporada = new Temporada();
            System.out.println("Adicionando episódios para a temporada " + i + "...");
            for (int j = 1; j <= 2; j++) {
                System.out.print("  Digite o título do episódio " + j + ": ");
                String tituloEpisodio = scanner.nextLine();
                System.out.print("  Digite a duração do episódio " + j + " em minutos: ");
                int duracaoEpisodio = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                Episodio novoEpisodio = new Episodio(tituloEpisodio, duracaoEpisodio);
                novaTemporada.adicionarEpisodio(novoEpisodio);
            }
            novaSerie.adicionarTemporada(novaTemporada);
        }

        midias.add(novaSerie);
        System.out.println("Série '" + tituloSerie + "' adicionada com sucesso com 2 temporadas e 2 episódios cada.");
    }

    private static void listarMidias(List<Midia> midias) {
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia cadastrada.");
            return;
        }

        System.out.println("\n--- Lista de Mídias Cadastradas ---");
        for (Midia midia : midias) {
            System.out.print(midia.getTitulo() + " (Duração total: " + midia.calcularDuracaoTotal() + " minutos)");
            System.out.println();
        }
    }
}
