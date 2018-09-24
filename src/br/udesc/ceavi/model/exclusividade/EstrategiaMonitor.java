package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.Coordenada;

/**
 * Estratégia para adquirir "lock" utilizando Monitores
 * @author lucas.adriano
 */
public class EstrategiaMonitor extends EstrategiaPadrao {

    @Override
    protected synchronized void getAcessoCoordenada(Coordenada coordenada) {
        if (coordenada.isLiberada()) {
            coordenada.setLiberada(false);
        }
    }
}
