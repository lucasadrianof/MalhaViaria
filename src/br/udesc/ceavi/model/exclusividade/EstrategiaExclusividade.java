package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Estratégia de Exclusividade:
 *
 * Define como determinado veículo irá adquirir o "lock" do recurso
 * @author lucas.adriano
 */
public interface EstrategiaExclusividade {

    /**
     * Define a malha viária sobre a qual o veículo irá se movimentar
     * @param malhaViaria
     */
    public void setMalhaViaria(MalhaViaria malhaViaria);

    /**
     * Realiza a movimentação do veículo
     * @param veiculo
     */
    public void movimentaVeiculo(Veiculo veiculo);

}
