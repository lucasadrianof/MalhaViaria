package br.udesc.ceavi.model.entity;

import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;
import br.udesc.ceavi.model.entity.Observador.ObservadorMovimento;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe de Veículo
 * @author lucas.adriano
 */
public class Veiculo implements Runnable {

    private Via via;
    private Coordenada coordenada;
    private EstrategiaExclusividade estrategia;
    private List<ObservadorMovimento> observadores = new ArrayList<>();

    public Veiculo(Via via, EstrategiaExclusividade estrategia) {
        this.via = via;
        this.coordenada = via.getPontoInicial();
        this.estrategia = estrategia;
    }

    public EstrategiaExclusividade getEstrategia() {
        return estrategia;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    /**
     * Adiciona um observador de movimentos do veículo
     * @param observador
     */
    public void adicionaObservador(ObservadorMovimento observador) {
        observadores.add(observador);
    }

    /**
     * Remove um observador do veículo
     * @param observadorMovimento
     * @return Booleano, indicando se removeu o observador da lista
     */
    public boolean removeObservador(ObservadorMovimento observadorMovimento) {
        return observadores.remove(observadorMovimento);
    }

    @Override
    public void run() {

    }
}
