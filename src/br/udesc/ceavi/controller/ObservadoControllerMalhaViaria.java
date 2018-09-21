package br.udesc.ceavi.controller;

import br.udesc.ceavi.ObservadorTela;

/**
 *
 * @author jessicapeixe
 */
interface ObservadoControllerMalhaViaria {
    
    public void adicionaObservador(ObservadorTela observador);
    
    public void removeObservador(ObservadorTela observador);
    
    public void notificaObservadoresMontarVias();
    
    public void notificaObservadoresMontarMapa();
    
    public void notificaObservadoresFinalizar();
}