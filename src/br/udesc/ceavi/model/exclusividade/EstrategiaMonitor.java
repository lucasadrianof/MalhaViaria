package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Random;

/**
 * Estratégia para adquirir "lock" utilizando Monitores
 * @author lucas.adriano
 */
public class EstrategiaMonitor implements EstrategiaExclusividade {

    private MalhaViaria malhaViaria;

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
                List<Via> vias   = movimentoVeiculo.getProximasVias();
                Random random    = new Random();
                int proximaVia   = random.nextInt(vias.size());
                Via viaNova      = vias.get(proximaVia);
                Coordenada coor  = viaNova.getPontoInicial();
                Coordenada coor2 = movimentoVeiculo.getNext(coor, viaNova);

                //Tenta adquirir o lock do cruzamento somente se o cruzamento e a próxima via está liberada
                if (coor.isLiberada() && coor2.isLiberada()) {
                    setViaVeiculo(viaNova, veiculo);
                }
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
     * @param via
     * @param veiculo
     */
    private synchronized void setViaVeiculo(Via via, @NotNull Veiculo veiculo) {
        veiculo.setVia(via);
    }

    /**
     * Atualiza a coordenada do veículo
     * @param coordenada
     * @param veiculo
     */
    private synchronized void setCoordenadaVeiculo(Coordenada coordenada, @NotNull Veiculo veiculo) {
        veiculo.setCoordenada(coordenada);
    }
}
