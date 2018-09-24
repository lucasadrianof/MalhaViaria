package br.udesc.ceavi.thread;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.exclusividade.EstrategiaExclusividade;
import br.udesc.ceavi.model.exclusividade.EstrategiaMonitor;
import br.udesc.ceavi.model.exclusividade.TipoEstrategiaExclusividade;

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
    private List<ObservadorInsercaoVeiculo> observadoresInsercaoVeiculos = new ArrayList<>();
    private int qtdeVeiculos;
    private TipoEstrategiaExclusividade estrategia;

    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    public void setExclusividade(EstrategiaExclusividade exclusividade) {
        this.exclusividade = exclusividade;
    }
    
    public void setQuantidade(int qtde) {
        this.qtdeVeiculos = qtde;
    }

    public void setEstrategia(TipoEstrategiaExclusividade estrategia) {
        this.estrategia = estrategia;
    }

    public void addObservador(ObservadorInsercaoVeiculo observadorInsercaoVeiculo) {
        observadoresInsercaoVeiculos.add(observadorInsercaoVeiculo);
    }

    @Override
    public void run() {
        List<Thread> threads = new ArrayList<>();

        while (threads.size() < this.qtdeVeiculos) {
            EstrategiaExclusividade estrategia = new EstrategiaMonitor();
            estrategia.setMalhaViaria(this.malhaViaria);

            Via[] vias = new Via[malhaViaria.getViasEntrada().size()];
            vias = malhaViaria.getViasEntrada().toArray(vias);

            if (vias.length > 0) {
                Random r  = new Random();
                int index = r.nextInt(vias.length);

                if (vias[index].getPontoInicial().isLiberada()) {
                    Veiculo veiculo  = new Veiculo(vias[index], estrategia);
                    observadoresInsercaoVeiculos.forEach((observador) -> observador.veiculoInserido(veiculo));

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
