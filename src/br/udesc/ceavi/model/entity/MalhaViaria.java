package br.udesc.ceavi.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Malha Viária
 * @author lucas.adriano
 */
public class MalhaViaria {

    private int linhas;
    private int colunas;

    private List<Via> vias = new ArrayList<>();
    private List<Coordenada> cruzamentos = new ArrayList<>();

    public MalhaViaria(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
    }

    /**
     * Adiciona uma nova via na lista
     * @param via Via a ser adicionada
     */
    public void adicionaVia(Via via) {
        for (Via viaExistente : vias) {

        }
        vias.add(via);
    }

    /**
     * Retorna as vias da malha
     * @return Um List das malhas da via
     */
    public List<Via> getVias() {
        return vias;
    }
    
    public int getLinhas(){
        return this.linhas;
    }
    
    public int getColunas(){
        return this.colunas;
    }
}