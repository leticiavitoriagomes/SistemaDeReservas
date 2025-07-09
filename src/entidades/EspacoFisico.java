package entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class EspacoFisico {
    private String localizacao, tipo;
    private int capacidade;
    private List<Equipamento> equipamentos = new ArrayList<>();
    public EspacoFisico(String localizacao, int capacidade, String tipo) {
        this.localizacao = localizacao.trim();
        this.capacidade = capacidade;
        this.tipo = tipo.trim();
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public String getTipo() {
        return tipo;
    }
    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }
    public void adicionarEquipamento(Equipamento e) {
        equipamentos.add(e);
    }
}