package br.udesc.ceavi.controller;

import br.udesc.ceavi.ObservadorTela;
import br.udesc.ceavi.model.entity.MalhaViaria;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller da Manutenção da Tela de Malha Viária
 * @author lucas.adriano
 */
public class ControllerMalhaViaria implements ObservadoControllerMalhaViaria {

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
        notificaObservadoresFinalizar();
    }

    @Override
    public void adicionaObservador(ObservadorTela observador) {
        observadores.add(observador);
    }

    @Override
    public void removeObservador(ObservadorTela observador) {
        observadores.remove(observador);
    }
    
    private void notificaObservadoresMontarVias(){
        malhaViaria.getVias().forEach((via) -> {
            observadores.forEach((observador) -> {
                observador.criaVia(via.getPontoInicial(), via.getPontoFinal());
            });
        });
        
    }

    private void notificaObservadoresMontarMapa() {
        observadores.forEach((observador) -> {
            observador.criaMapa(malhaViaria.getLinhas(),malhaViaria.getColunas());
        });
    }
    
    private void notificaObservadoresFinalizar(){
        observadores.forEach((observador) -> {
            observador.finalizaMontagemTela();
        });
    }
}