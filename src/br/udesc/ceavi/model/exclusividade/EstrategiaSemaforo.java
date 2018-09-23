package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;

import java.util.List;
import java.util.Random;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo implements EstrategiaExclusividade {

    public void avancaVeiculo(Veiculo veiculo, Via via, MalhaViaria malhaViaria) {
        ModelMovimentoVeiculo movimentoVeiculo = new ModelMovimentoVeiculo(via, veiculo, malhaViaria);

        Coordenada coordenada = movimentoVeiculo.getNext(veiculo.getCoordenada(), via);

        //Caso o veículo tenha chegado ao final da via e esta via não seja uma de saída
        if (coordenada == null && !malhaViaria.getViasSaida().contains(via)) {
            List<Via> vias   = movimentoVeiculo.getProximasVias();
            Random random    = new Random();
            int proximaVia   = random.nextInt(vias.size());
            Via viaNova      = vias.get(proximaVia);
            Coordenada coor  = viaNova.getPontoInicial();
            Coordenada coor2 = movimentoVeiculo.getNext(coor, viaNova);

            //Tenta adquirir o lock do cruzamento somente se o cruzamento e a próxima via está liberada
            if (coor.isLiberada() && coor2.isLiberada()) {
                veiculo.getCoordenada().setVeiculo(null);
                setCoordenadaVeiculo(coor2, veiculo);
                setCoordenadaVeiculo(coor, veiculo);
            }
        }
        else if (coordenada.isLiberada()) {
            veiculo.getCoordenada().setVeiculo(null);
            setCoordenadaVeiculo(coordenada, veiculo);
        }
    }

    public synchronized void setCoordenadaVeiculo(Coordenada coordenada, Veiculo veiculo) {
        coordenada.setVeiculo(veiculo);
    }
}
