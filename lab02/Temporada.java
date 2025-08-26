import java.util.ArrayList;
import java.util.List;

class Temporada {
    private List<Episodio> episodios;

    public Temporada() {
        this.episodios = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        this.episodios.add(episodio);
    }

    public int getDuracaoTotal() {
        int duracaoTotal = 0;
        for (Episodio episodio : episodios) {
            duracaoTotal += episodio.getDuracao();
        }
        return duracaoTotal;
    }
}