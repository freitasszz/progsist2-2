class Episodio {
    private String titulo;
    private int duracao; // em minutos

    public Episodio(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }
}