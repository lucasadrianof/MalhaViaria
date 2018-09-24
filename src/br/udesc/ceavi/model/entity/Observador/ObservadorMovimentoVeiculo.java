package br.udesc.ceavi.model.entity.Observador;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Observador da movimentação de determinado veículo
 * @author lucas.adriano
 */
public interface ObservadorMovimentoVeiculo {

    /**
     * Indica que determinado veículo se movimentou
     * @param veiculo Veículo movimentado
     * @param coordenadaAnterior Coordenada anterior a movimentação
     */
    public void veiculoMovimentado(Veiculo veiculo, Coordenada coordenadaAnterior);

    /**
     * Indica que o veículo chegou ao destino
     */
    public void veiculoFinalizado(Veiculo veiculo);

}
