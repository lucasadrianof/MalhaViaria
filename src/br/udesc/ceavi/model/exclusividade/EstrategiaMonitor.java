package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Random;

/**
 * Estratégia para adquirir "lock" utilizando Monitores
 * @author lucas.adriano
 */
public class EstrategiaMonitor extends EstrategiaPadrao {

    @Override
    protected synchronized void setViaVeiculo(@NotNull Veiculo veiculo, @NotNull ModelMovimentoVeiculo movimentoVeiculo) {
        List<Via> vias   = movimentoVeiculo.getProximasVias();
        Random random    = new Random();
        int proximaVia   = random.nextInt(vias.size());
        Via viaNova      = vias.get(proximaVia);
        Coordenada cruzamento  = viaNova.getPontoInicial();
        Coordenada proximaCruz = movimentoVeiculo.getNext(cruzamento, viaNova);

        //Tenta adquirir o lock do cruzamento somente se o cruzamento e a próxima via está liberada
        if (cruzamento.isLiberada() && proximaCruz.isLiberada()) {
            veiculo.setVia(viaNova);
        }
    }

    @Override
    protected synchronized void setCoordenadaVeiculo(Coordenada coordenada, @NotNull Veiculo veiculo) {
        veiculo.setCoordenada(coordenada);
    }
}
