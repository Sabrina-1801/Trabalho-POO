package service;

import model.Midia;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Midia> catalogo;
    private int proximoId;

    public Catalogo() {
        this.catalogo = new ArrayList<>();
        this.proximoId = 1;
    }

    public int getProximoId() {
        return proximoId++;
    }

    public void adicionarMidia(Midia midia) {
        catalogo.add(midia);
        System.out.println(" Título adicionado ao catálogo com sucesso!");
    }

    public void listarMidias() {
        if (catalogo.isEmpty()) {
            System.out.println("\n Nenhum filme ou série registado no catálogo.");
            return;
        }
        System.out.println("CATÁLOGO DE SÉRIES E FILMES");
        for (Midia m : catalogo) {
            m.exibirDetalhes();
        }
    }

    public Midia buscarPorId(int id) {
        for (Midia m : catalogo) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void removerMidia(int id) {
        Midia m = buscarPorId(id);
        if (m != null) {
            catalogo.remove(m);
            System.out.println(" Item ID " + id + " removido do catálogo com sucesso!");
        } else {
            System.out.println(" Item não encontrado com o ID: " + id);
        }
    }
}