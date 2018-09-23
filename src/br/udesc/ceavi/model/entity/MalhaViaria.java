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
    private List<Via> viasEntrada = new ArrayList<>();
    private List<Via> viasSaida = new ArrayList<>();

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
        verificaViaEntrada(via);
        verificaViaSaida(via);
        vias.add(via);
    }

    /**
     * Verifica se a via informada é uma via de entrada
     * @param via
     */
    private void verificaViaEntrada(Via via) {
        if (isCoordenadaEntradaSaida(via.getPontoInicial())) {
            viasEntrada.add(via);
        }
    }

    /**
     * Verifica se a via informada é uma via de entrada
     * @param via
     */
    private void verificaViaSaida(Via via) {
        if (isCoordenadaEntradaSaida(via.getPontoInicial())) {
            viasSaida.add(via);
        }
    }

    /**
     * Indica se a coordenada informada é uma coordenada de entrada/saída
     * @param coordenada
     * @return Booleano indicando se a coordenada é de saída ou entrada
     */
    private boolean isCoordenadaEntradaSaida(Coordenada coordenada) {
        return coordenada.getPosicaoX() == 0 || coordenada.getPosicaoX() == (linhas - 1) ||
                coordenada.getPosicaoY() == 0 || coordenada.getPosicaoY() == (colunas - 1);
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
        return viasEntrada;
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