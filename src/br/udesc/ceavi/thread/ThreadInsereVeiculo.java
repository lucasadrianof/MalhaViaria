package br.udesc.ceavi.thread;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Observador.ObservadorMovimentoVeiculo;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;
import br.udesc.ceavi.model.exclusividade.EstrategiaMonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Thread de inserção de veículos na malha
 * @author lucas.adriano
 */
public class ThreadInsereVeiculo extends Thread {

    private MalhaViaria malhaViaria;
    private EstrategiaExclusividade exclusividade;
    private List<ObservadoInsercaoVeiculo> observadoresInsercaoVeiculos = new ArrayList<>();

    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    public void setExclusividade(EstrategiaExclusividade exclusividade) {
        this.exclusividade = exclusividade;
    }

    public void addObservador(ObservadoInsercaoVeiculo observadoInsercaoVeiculo) {
        observadoresInsercaoVeiculos.add(observadoInsercaoVeiculo);
    }

    @Override
    public void run() {
        int quantidade = 3;
        List<Thread> threads = new ArrayList<>();

        while (threads.size() < quantidade) {
            EstrategiaExclusividade estrategia = new EstrategiaMonitor();
            estrategia.setMalhaViaria(this.malhaViaria);

            Via[] vias = new Via[malhaViaria.getViasEntrada().size()];
            vias = malhaViaria.getViasEntrada().toArray(vias);

            if (vias.length > 0) {
                Random r  = new Random();
                int index = r.nextInt(vias.length);

                if (vias[index].getPontoInicial().isLiberada()) {
                    Veiculo veiculo  = new Veiculo(vias[index], estrategia);
                    observadoresInsercaoVeiculos.forEach((observador) -> observador.veiculoJnserido(veiculo));

                    Thread thVeiculo = new Thread(veiculo);
                    thVeiculo.start();

                    threads.add(thVeiculo);
                }
            }

            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
