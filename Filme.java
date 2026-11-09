package model;

public class Filme extends Midia {
    private int duracaoMinutos;

    public Filme(int id, String titulo, String genero, int anoLancamento, double avaliacao, int duracaoMinutos) {
        super(id, titulo, genero, anoLancamento, avaliacao);
        setDuracaoMinutos(duracaoMinutos);
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos > 0) {
            this.duracaoMinutos = duracaoMinutos;
        } else {
            System.out.println("[ERRO] A duração deve ser superior a 0 minutos.");
        }
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("   └── [Filme] Duração: " + duracaoMinutos + " min");
    }
}