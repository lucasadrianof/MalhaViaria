package br.udesc.ceavi.model.exclusividade.factory;

import br.udesc.ceavi.model.exclusividade.EstrategiaMonitor;
import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;

/**
 * Fábrica de estratégia utilizando Monitor
 * @author lucas.adriano
 */
public class FabricaMonitor implements FabricaExclusividade {

    @Override
    public EstrategiaExclusividade criaEstrategia() {
        return new EstrategiaMonitor();
    }
}
