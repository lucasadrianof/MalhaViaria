package br.udesc.ceavi.model.entity;

import br.udesc.ceavi.model.bo.ModelVia;

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
    private List<Veiculo> veiculos = new ArrayList<>();

    public MalhaViaria(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
    }

    /**
     * Adiciona uma nova via na lista
     * @param via Via a ser adicionada
     */
    public void adicionaVia(Via via) {
        //verificaCruzamentos(via);
        vias.add(via);
    }

    /**
     * Verifica se a nova via possui algum cruzamento com os existentes e já os adiciona na lista
     * @param via
     */
    private void verificaCruzamentos(Via via) {
        ModelVia modelVia = new ModelVia();

        for (Via viaExistente : vias) {

        }
    }

    /**
     * Retorna as vias da malha
     * @return Um List das malhas da via
     */
    public List<Via> getVias() {
        return vias;
    }

    /**
     * Retorna as vias disponíveis para entrada
     * @return As vias de entrada disponíveis
     */
    public List<Via> getViasEntrada() {
        List<Via> vias = new ArrayList<>();

        for (Via via : this.vias) {
            Coordenada entrada = via.getPontoInicial();

            if (entrada.getPosicaoX() == 0 || entrada.getPosicaoX() == (linhas - 1) ||
                entrada.getPosicaoY() == 0 || entrada.getPosicaoY() == (colunas - 1))
            {
                vias.add(via);
            }
        }

        return vias;
    }

    /**
     *
     * @return
     */
    public int getLinhas(){
        return this.linhas;
    }
    
    public int getColunas(){
        return this.colunas;
    }
}