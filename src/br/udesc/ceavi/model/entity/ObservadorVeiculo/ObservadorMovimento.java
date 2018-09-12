package br.udesc.ceavi.model.entity.ObservadorVeiculo;

import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Observador da movimentação de determinado veículo
 * @author lucas.adriano
 */
public interface ObservadorMovimento {

    /**
     * Indica que determinado veículo se movimentou
     * @param veiculo Veículo movimentado
     */
    public void veiculoMovimentado(Veiculo veiculo);
}
