package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.Veiculo;
import java.util.concurrent.Semaphore;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo extends EstrategiaPadrao {

    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void movimentaVeiculo(Veiculo veiculo) {
        try {
            semaphore.acquire();
            getAcessoCoordenada(veiculo);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
