import java.util.ArrayList;
import java.util.List;

class Serie extends Midia {
    private List<Temporada> temporadas;

    public Serie(String titulo) {
        super(titulo, 0); 
        this.temporadas = new ArrayList<>();
    }

    public void adicionarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    @Override
    public int calcularDuracaoTotal() {
        int duracaoTotal = 0;
        for (Temporada temporada : temporadas) {
            duracaoTotal += temporada.getDuracaoTotal();
        }
        return duracaoTotal;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() + " (Série)";
    }
}
