package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.bo.ModelMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Classe padrão de estratégias de exclusividade
 * @author lucas.adriano
 */
abstract public class EstrategiaPadrao implements EstrategiaExclusividade {

    protected MalhaViaria malhaViaria;
    protected HashMap<String, Via> viasVeiculo = new HashMap<>();

    @Override
    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    /**
     * Adquire o acesso exclusivo da coordenada para o veículo
     * @param veiculo
     */
    protected void getAcessoCoordenada(Veiculo veiculo) {
        Via via = veiculo.getVia();
        ModelMovimentoVeiculo movimentoVeiculo = new ModelMovimentoVeiculo(veiculo, malhaViaria);
        Coordenada proxima = movimentoVeiculo.getNext(veiculo.getCoordenada(), via);
        boolean isViaSaida = malhaViaria.getViasSaida().contains(via);
        String hashVeiculo = Integer.toHexString(veiculo.hashCode());

        if (proxima != null) {
            if (proxima.isLiberada()) {
                boolean proximoIsUltimo = proxima.equals(via.getPontoFinal());

                Coordenada anterior = veiculo.getCoordenada();
                anterior.setLiberada(true);

                proxima.setLiberada(false);
                veiculo.setCoordenada(proxima);

                if (proximoIsUltimo && !isViaSaida) {
                    List<Via> vias   = movimentoVeiculo.getProximasVias();
                    Random random    = new Random();
                    int proximaVia   = random.nextInt(vias.size());
                    Via viaNova      = vias.get(proximaVia);
                    Coordenada proximaOutra = movimentoVeiculo.getNext(proxima, viaNova);

                    if (proximaOutra.isLiberada()) {
                        proximaOutra.setLiberada(false);
                        viasVeiculo.put(hashVeiculo, viaNova);
                    }
                    else {
                        anterior.setLiberada(false);
                        proxima.setLiberada(true);
                        veiculo.setCoordenada(anterior);
                    }
                }
            }
        }
        else {
            if (!isViaSaida) {
                Via novaVia = viasVeiculo.get(hashVeiculo);
                proxima = movimentoVeiculo.getNext(veiculo.getCoordenada(), novaVia);

                veiculo.setVia(novaVia);
                veiculo.getCoordenada().setLiberada(true);
                veiculo.setCoordenada(proxima);

                viasVeiculo.remove(hashVeiculo);
            }
            else {
                veiculo.setEmMovimento(false);
            }
        }
    }
}