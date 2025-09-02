public class CriterioPrecoMaximo implements CriterioBusca {
    private double precoMaximo;

    public CriterioPrecoMaximo(double precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    @Override
    public boolean testar(Produto produto) {
        return produto.getPreco() <= this.precoMaximo;
    }
}
