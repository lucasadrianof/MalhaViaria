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
        this.setCoordenada(via.getPontoInicial());
        this.getCoordenada().setLiberada(false);
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

    public boolean isEmMovimento() {
        return emMovimento;
    }

    public void setEmMovimento(boolean emMovimento) {
        this.emMovimento = emMovimento;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
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
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                observadores.forEach((observador) -> observador.veiculoFinalizadoBruscamente(this));
                this.setEmMovimento(false);
                break;
            }

            Coordenada coordenadaAnterior = this.coordenada;
            estrategia.movimentaVeiculo(this);

            observadores.forEach((observadorMovimento) -> {
                observadorMovimento.veiculoMovimentado(this, coordenadaAnterior);
            });
        }
        observadores.forEach((observador) -> observador.veiculoFinalizado(this));
    }

    @Override
    public String toString() {
        String format = "Veículo: %s %s %s";
        return String.format(format, Integer.toHexString(hashCode()), this.getVia(), this.getCoordenada());
    }
}
