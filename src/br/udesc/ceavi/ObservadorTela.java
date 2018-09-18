package br.udesc.ceavi;

import br.udesc.ceavi.model.entity.Coordenada;

/**
 *
 * @author jessicapeixe
 */
public interface ObservadorTela {
    
    public void criaVia(Coordenada inicio, Coordenada fim);

    public void criaMapa(int linhas, int colunas);
    
}
