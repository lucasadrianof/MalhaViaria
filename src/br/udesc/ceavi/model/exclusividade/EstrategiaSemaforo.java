package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;

import java.util.concurrent.Semaphore;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo extends EstrategiaPadrao {

    private Semaphore semaphore = new Semaphore(1);

    @Override
    protected void setViaVeiculo(Veiculo veiculo, ModelMovimentoVeiculo movimentoVeiculo) {

    }

    @Override
    protected void setCoordenadaVeiculo(Coordenada coordenada, Veiculo veiculo) {

    }
}
