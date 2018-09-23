package br.udesc.ceavi.view;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Via;

/**
     *
 * @author jessicapeixe
 */
public interface ObservadorTela {
    
    public void criaVia(Via via);

    public void criaMapa(MalhaViaria malhaViaria);
    
    public void adicionaCarroMalha(Coordenada coordenada);
    
    public void movimentaCarro(Coordenada coordenadaAnterior, Coordenada coordenadaAtual);
}
