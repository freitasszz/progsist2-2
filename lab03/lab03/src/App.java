import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Produto> produtos;
    private Scanner entrada;

    public App() {
        this.produtos = new ArrayList<>();
        this.entrada = new Scanner(System.in);
        
        produtos.add(new Produto("Notebook Core i5", "Dell", 3500.00));
        produtos.add(new Produto("Mouse sem fio", "Logitech", 89.90));
        produtos.add(new Produto("Teclado mecânico", "Redragon", 300.00));
        produtos.add(new Produto("Monitor 27 polegadas", "LG", 1200.00));
        produtos.add(new Produto("Webcam Full HD", "Logitech", 150.00));
        produtos.add(new Produto("Notebook Core i7", "Dell", 5000.00));
    }

    private void menu() {
        int opcao;
        do {
            System.out.println("\n--- MENU DE OPÇÕES ---");
            System.out.println("(1) Listar produtos");
            System.out.println("(2) Pesquisar descrição");
            System.out.println("(3) Pesquisar marca");
            System.out.println("(4) Pesquisar pelo preço máximo");
            System.out.println("(5) Pesquisar pelo preço mínimo");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = this.entrada.nextInt();
            this.entrada.nextLine(); 

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    pesquisarPorDescricao();
                    break;
                case 3:
                    pesquisarPorMarca();
                    break;
                case 4:
                    pesquisarPorPrecoMaximo();
                    break;
                case 5:
                    pesquisarPorPrecoMinimo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarProdutos() {
        System.out.println("\n--- TODOS OS PRODUTOS ---");
        for (Produto p : this.produtos) {
            System.out.println(p);
        }
    }

    private void pesquisarPorDescricao() {
        System.out.print("Informe a descrição para pesquisa: ");
        String termo = this.entrada.nextLine();
        CriterioDescricao criterio = new CriterioDescricao(termo);
        List<Produto> resultados = pesquisar(criterio);
        exibirResultados(resultados);
    }

    private void pesquisarPorMarca() {
        System.out.print("Informe a marca para pesquisa: ");
        String termo = this.entrada.nextLine();
        CriterioMarca criterio = new CriterioMarca(termo);
        List<Produto> resultados = pesquisar(criterio);
        exibirResultados(resultados);
    }

    private void pesquisarPorPrecoMaximo() {
        System.out.print("Informe o preço máximo para pesquisa: R$");
        double preco = this.entrada.nextDouble();
        this.entrada.nextLine();
        CriterioPrecoMaximo criterio = new CriterioPrecoMaximo(preco);
        List<Produto> resultados = pesquisar(criterio);
        exibirResultados(resultados);
    }

    private void pesquisarPorPrecoMinimo() {
        System.out.print("Informe o preço mínimo para pesquisa: R$");
        double preco = this.entrada.nextDouble();
        this.entrada.nextLine();
        CriterioPrecoMinimo criterio = new CriterioPrecoMinimo(preco);
        List<Produto> resultados = pesquisar(criterio);
        exibirResultados(resultados);
    }

    private List<Produto> pesquisar(CriterioBusca criterio) {
        List<Produto> resultados = new ArrayList<>();
        for (Produto p : this.produtos) {
            if (criterio.testar(p)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    private void exibirResultados(List<Produto> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com o critério informado.");
        } else {
            System.out.println("\n--- RESULTADOS DA PESQUISA ---");
            for (Produto p : resultados) {
                System.out.println(p);
            }
        }
    }

    private class CriterioDescricao implements CriterioBusca {
        private String descricao;
        public CriterioDescricao(String descricao) { this.descricao = descricao; }
        @Override
        public boolean testar(Produto produto) { return produto.getDescricao().toLowerCase().contains(this.descricao.toLowerCase()); }
    }

    private class CriterioMarca implements CriterioBusca {
        private String marca;
        public CriterioMarca(String marca) { this.marca = marca; }
        @Override
        public boolean testar(Produto produto) { return produto.getMarca().toLowerCase().contains(this.marca.toLowerCase()); }
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
}

