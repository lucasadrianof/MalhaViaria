package br.udesc.ceavi.model.entity;

import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;
import br.udesc.ceavi.model.entity.Observador.ObservadorMovimentoVeiculo;

import java.util.List;
import java.util.ArrayList;

/**
 * Entidade do Veículo
 * @author lucas.adriano
 */
public class Veiculo implements Runnable {

    private Via via;
    private Coordenada coordenada;
    private EstrategiaExclusividade estrategia;
    private List<ObservadorMovimentoVeiculo> observadores = new ArrayList<>();
    private boolean emMovimento = true;

    public Veiculo(Via via, EstrategiaExclusividade estrategia) {
        this.setVia(via);
        this.estrategia = estrategia;
    }

    public EstrategiaExclusividade getEstrategia() {
        return estrategia;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        if (this.via != null) {
            this.via.removeVeiculo(this);
        }
        this.via = via;
        this.via.adicionaVeiculo(this);
        this.setCoordenada(via.getPontoInicial());
    }

    public Coordenada getCoordenada() {
            return coordenada;
    }

    public boolean isEmMovimento() {
        return emMovimento;
    }

    public void setEmMovimento(boolean emMovimento) {
        this.emMovimento = emMovimento;
    }

    public void setCoordenada(Coordenada coordenada) {
        if (this.coordenada != null) {
            this.coordenada.setVeiculo(null);
        }
        this.coordenada = coordenada;
        this.coordenada.setVeiculo(this);
    }

    /**
     * Adiciona um observador de movimentos do veículo
     * @param observador
     */
    public void adicionaObservador(ObservadorMovimentoVeiculo observador) {
        observadores.add(observador);
    }

    @Override
    public void run() {
        while (isEmMovimento()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Coordenada coordenadaAnterior = this.coordenada;
            estrategia.movimentaVeiculo(this);

            observadores.forEach((observadorMovimento) -> {
                observadorMovimento.veiculoMovimentado(this, coordenadaAnterior);
            });
        }
    }
}
