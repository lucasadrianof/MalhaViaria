package br.udesc.ceavi.model.exclusividade;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Veiculo;
import java.util.concurrent.Semaphore;

/**
 * Estratégia para adquirir "lock" utilizando Semáforos
 * @author lucas.adriano
 */
public class EstrategiaSemaforo extends EstrategiaPadrao {

    private Semaphore semaphore = new Semaphore(1);

    @Override
    protected void getAcessoCoordenada(Coordenada coordenada) {
        try {
            semaphore.acquire();

            if (!coordenada.isLiberada()) {
                coordenada.setLiberada(false);
            }

            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
