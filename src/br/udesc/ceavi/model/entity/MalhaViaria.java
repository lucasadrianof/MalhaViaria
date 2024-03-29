package br.udesc.ceavi.model.entity;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Malha Viária
 * @author lucas.adriano
 */
public class MalhaViaria {

    private int linhas;
    private int colunas;

    private HashMap<Pair<Integer, Integer>, Coordenada> coordenadas = new HashMap<>();

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
        verificaViaEntrada(via);
        verificaViaSaida(via);
        vias.add(via);
    }

    /**
     * Adiciona uma coordenada na malha viária
     * @param coordenada
     */
    public void adicionaCoordenada(Coordenada coordenada) {
        Pair pair = new Pair(coordenada.getPosicaoX(), coordenada.getPosicaoY());
        coordenadas.put(pair, coordenada);
    }

    /**
     * Retorna a coordenada de posição X e Y
     * @param posicaoX
     * @param posicaoY
     * @return
     */
    public Coordenada getCoordenada(int posicaoX, int posicaoY) {
        Pair pair = new Pair(posicaoX, posicaoY);
        Coordenada coordenada = coordenadas.get(pair);

        if (coordenada == null) {
            coordenada = new Coordenada(posicaoX, posicaoY);
            coordenadas.put(pair, coordenada);
        }

        return coordenada;
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
        if (via.getPontoFinal().getPosicaoX() == 24 && via.getPontoFinal().getPosicaoY() == 2) {
            int x = 1;
        }
        if (isCoordenadaEntradaSaida(via.getPontoFinal())) {
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
     * Retorna as vias de saída
     * @return As vias de saída da malha
     */
    public List<Via> getViasSaida() {
        return viasSaida;
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