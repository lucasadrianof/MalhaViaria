package br.udesc.ceavi.model.entity.Observador;

import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.entity.Veiculo;

/**
 *  Observador da via
 * @author lucas.adriano
 */
public interface ObservadorVia {

    /**
     * Notifica sobre um veículo adicionado a via
     * @param via
     * @param veiculo
     */
    public void veiculoAdicionado(Via via, Veiculo veiculo);
}
