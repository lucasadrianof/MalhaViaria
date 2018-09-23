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

    private Coordenada coordenada;
    private EstrategiaExclusividade estrategia;
    private List<ObservadorMovimento> observadores = new ArrayList<>();

    public Veiculo(Coordenada coordenada, EstrategiaExclusividade estrategia) {
        this.coordenada = coordenada;
        this.coordenada.setVeiculo(this);

        this.estrategia = estrategia;
    }

    public EstrategiaExclusividade getEstrategia() {
        return estrategia;
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

    @Override
    public void run() {

    }
}
