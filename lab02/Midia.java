abstract class Midia {
    private String titulo;
    private int duracao; 

    public Midia(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public abstract int calcularDuracaoTotal();

    @Override
    public String toString() {
        return "Título: " + titulo;
    }
}