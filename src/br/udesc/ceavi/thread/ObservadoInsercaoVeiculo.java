package br.udesc.ceavi.thread;

import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Observador de inserção de veículos
 * @author lucas.adriano
 */
public interface ObservadoInsercaoVeiculo {

    /**
     * Indica que o veículo foi inserido na malha
     * @param veiculo
     */
    public void veiculoInserido(Veiculo veiculo);

}
