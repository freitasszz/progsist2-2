public class CriterioPrecoMinimo implements CriterioBusca {
    private double precoMinimo;

    public CriterioPrecoMinimo(double precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    @Override
    public boolean testar(Produto produto) {
        return produto.getPreco() >= this.precoMinimo;
    }
}
