package br.udesc.ceavi.model.exclusividade.factory;

import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;

/**
 * Fábrica de Estratégias de Exclusividade
 * @author lucas.adriano
 */
public interface FabricaExclusividade {

    /**
     * Cria e retorna uma nova estratégia de exclusividade de "lock"
     * @return A nova estratégia criada
     */
    public EstrategiaExclusividade criaEstrategia();

}
