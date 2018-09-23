package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo implements EstrategiaExclusividade {

    private MalhaViaria malhaViaria;

    @Override
    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    @Override
    public void movimentaVeiculo(Veiculo veiculo) {

    }
}
