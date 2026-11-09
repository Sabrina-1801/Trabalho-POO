package model;

public class Serie extends Midia {
    private int numeroTemporadas;

    public Serie(int id, String titulo, String genero, int anoLancamento, double avaliacao, int numeroTemporadas) {
        super(id, titulo, genero, anoLancamento, avaliacao);
        setNumeroTemporadas(numeroTemporadas);
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        if (numeroTemporadas > 0) {
            this.numeroTemporadas = numeroTemporadas;
        } else {
            System.out.println("[ERRO] O número de temporadas deve ser maior que 0.");
        }
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("   └── [Série] Temporadas: " + numeroTemporadas);
    }
}