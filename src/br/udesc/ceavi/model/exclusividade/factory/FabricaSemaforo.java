package br.udesc.ceavi.model.exclusividade.factory;

import br.udesc.ceavi.model.exclusividade.EstrategiaSemaforo;
import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;

/**
 * Fábrica de Exclusividade utilizando Semáforos
 */
public class FabricaSemaforo implements FabricaExclusividade {

    @Override
    public EstrategiaExclusividade criaEstrategia() {
        return new EstrategiaSemaforo();
    }
}
