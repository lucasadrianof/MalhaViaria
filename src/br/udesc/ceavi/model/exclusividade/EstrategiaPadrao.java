package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;

import java.util.HashMap;

/**
 * Classe padrão de estratégias de exclusividade
 * @author lucas.adriano
 */
abstract public class EstrategiaPadrao implements EstrategiaExclusividade {

    protected MalhaViaria malhaViaria;

    @Override
    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    @Override
    public void movimentaVeiculo(Veiculo veiculo) {
        Via via = veiculo.getVia();
        ModelMovimentoVeiculo movimentoVeiculo = new ModelMovimentoVeiculo(veiculo, malhaViaria);

        Coordenada coordenada = movimentoVeiculo.getNext(veiculo.getCoordenada(), via);

        //Caso o veículo tenha chegado ao final da via e esta via não seja uma de saída
        if (coordenada == null) {
            if (!malhaViaria.getViasSaida().contains(via)) {
                setViaVeiculo(veiculo, movimentoVeiculo);
            }
            else {
                veiculo.setEmMovimento(false);
            }
        }
        else if (coordenada.isLiberada()) {
            setCoordenadaVeiculo(coordenada, veiculo);
        }
    }

    /**
     * Atualiza a via do veículo
     * @param veiculo
     * @param movimentoVeiculo
     */
    protected abstract void setViaVeiculo(Veiculo veiculo, ModelMovimentoVeiculo movimentoVeiculo);

    /**
     * Atualiza a coordenada do veículo
     * @param coordenada
     * @param veiculo
     */
    protected abstract void setCoordenadaVeiculo(Coordenada coordenada, Veiculo veiculo);
}
