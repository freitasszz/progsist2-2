class Filme extends Midia {
    public Filme(String titulo, int duracao) {
        super(titulo, duracao);
    }

    @Override
    public int calcularDuracaoTotal() {
        return getDuracao();
    }
}
