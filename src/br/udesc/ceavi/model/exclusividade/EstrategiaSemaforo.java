package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo extends EstrategiaPadrao {

    private Semaphore semaphore = new Semaphore(1);

    @Override
    protected void setViaVeiculo(Veiculo veiculo, ModelMovimentoVeiculo movimentoVeiculo) {
        List<Via> vias   = movimentoVeiculo.getProximasVias();
        Random random    = new Random();
        int proximaVia   = random.nextInt(vias.size());
        Via viaNova      = vias.get(proximaVia);
        Coordenada cruzamento  = viaNova.getPontoInicial();
        Coordenada proximaCruz = movimentoVeiculo.getNext(cruzamento, viaNova);

        //Tenta adquirir o lock do cruzamento somente se o cruzamento e a próxima via está liberada
        if (cruzamento.isLiberada() && proximaCruz.isLiberada()) {
            setCoordenadaVeiculo(viaNova.getPontoInicial(), veiculo);
            veiculo.setVia(viaNova);
        }
    }

    @Override
    protected void setCoordenadaVeiculo(Coordenada coordenada, Veiculo veiculo) {
        try {
            semaphore.acquire();

            veiculo.getCoordenada().setLiberada(true);
            veiculo.setCoordenada(coordenada);
            veiculo.getCoordenada().setLiberada(false);

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
