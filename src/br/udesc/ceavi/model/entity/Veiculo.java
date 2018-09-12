package br.udesc.ceavi.model.entity;

import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;
import br.udesc.ceavi.model.entity.ObservadorVeiculo.ObservadorMovimento;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe de Veículo
 * @author lucas.adriano
 */
public class Veiculo implements Runnable {

    private EstrategiaExclusividade estrategia;
    private List<ObservadorMovimento> observadores = new ArrayList<>();

    public Veiculo(EstrategiaExclusividade estrategia) {
        this.estrategia = estrategia;
    }

    public EstrategiaExclusividade getEstrategia() {
        return estrategia;
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
