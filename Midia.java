package model;

public class Midia {
    private int id;
    private String titulo;
    private String genero;
    private int anoLancamento;
    private double avaliacao; 
    public Midia(int id, String titulo, String genero, int anoLancamento, double avaliacao) {
        this.id = id;
        setTitulo(titulo);
        this.genero = genero;
        setAnoLancamento(anoLancamento);
        setAvaliacao(avaliacao);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("[ERRO] O título não pode ser vazio.");
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento >= 1888) { 
            this.anoLancamento = anoLancamento;
        } else {
            System.out.println("[ERRO] Ano de lançamento inválido.");
        }
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        if (avaliacao >= 0.0 && avaliacao <= 10.0) {
            this.avaliacao = avaliacao;
        } else {
            System.out.println("[ERRO] A avaliação deve ser entre 0.0 e 10.0.");
        }
    }

    public void exibirDetalhes() {
        System.out.println("ID: " + id + " | Título: " + titulo + " | Género: " + genero + 
                           " | Ano: " + anoLancamento + " | Avaliação: " + avaliacao + "/10");
    }
}