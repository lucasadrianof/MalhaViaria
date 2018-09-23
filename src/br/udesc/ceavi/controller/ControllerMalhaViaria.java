package br.udesc.ceavi.controller;

import br.udesc.ceavi.ObservadorTela;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Observador.ObservadorVia;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.thread.ThreadInsereVeiculo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller da Manutenção da Tela de Malha Viária
 * @author lucas.adriano
 */
public class ControllerMalhaViaria implements ObservadoControllerMalhaViaria, ObservadorVia {

    private MalhaViaria malhaViaria;
    
    private ControllerImportacaoMalha controllerImportacaoMalha;
    
    private ArrayList<ObservadorTela> observadores = new ArrayList<ObservadorTela>();

    public ControllerMalhaViaria() {
        this.controllerImportacaoMalha = new ControllerImportacaoMalha();
    }
    
    public void iniciaMalhaViaria() throws IOException {
        this.controllerImportacaoMalha.iniciaImportacao();
        this.malhaViaria = this.controllerImportacaoMalha.getMalhaViaria();

        notificaObservadoresMontarMapa();
        notificaObservadoresMontarVias();

        ThreadInsereVeiculo threadInsereVeiculo = new ThreadInsereVeiculo();
        threadInsereVeiculo.setMalhaViaria(this.malhaViaria);
        threadInsereVeiculo.start();
    }

    @Override
    public void adicionaObservador(ObservadorTela observador) {
        observadores.add(observador);
    }

    @Override
    public void removeObservador(ObservadorTela observador) {
        observadores.remove(observador);
    }
    
    @Override
    public void notificaObservadoresMontarVias(){
        malhaViaria.getVias().forEach((via) -> {
            via.adicionaObservador(this);
            observadores.forEach((observador) -> {
                observador.criaVia(via);
            });
        });
        
    }

    @Override
    public void notificaObservadoresMontarMapa() {
        observadores.forEach((observador) -> observador.criaMapa(malhaViaria));
    }

    @Override
    public void veiculoAdicionado(Via via, Veiculo veiculo) {
        observadores.forEach((observador) -> {
            observador.adicionaCarroMalha(via.getPontoInicial());
        });
    }
}