package br.udesc.ceavi.thread;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.exclusividade.EstrategiaSemaforo;

import java.util.Random;

/**
 *
 */
public class ThreadInsereVeiculo extends Thread {

    private MalhaViaria malhaViaria;

    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    @Override
    public void run() {
        Via[] vias = (Via[]) malhaViaria.getVias().toArray();

        if (vias.length > 0) {
            Random r  = new Random();
            int index = r.nextInt(vias.length);

            Veiculo veiculo  = new Veiculo(vias[index], new EstrategiaSemaforo());
            vias[index].adicionaVeiculo(veiculo);
            Thread thVeiculo = new Thread(veiculo);
            thVeiculo.start();
        }

        try {
            sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
