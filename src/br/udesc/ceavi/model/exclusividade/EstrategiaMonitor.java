package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Estratégia para adquirir "lock" utilizando Monitores
 * @author lucas.adriano
 */
public class EstrategiaMonitor extends EstrategiaPadrao {

    @Override
    public synchronized void movimentaVeiculo(Veiculo veiculo) {
        getAcessoCoordenada(veiculo);
    }
}