package br.udesc.ceavi;

import br.udesc.ceavi.model.entity.Coordenada;
import java.io.IOException;

/**
 *
 * @author jessicapeixe
 */
public interface ObservadorTela {
    
    public void criaVia(Coordenada inicio, Coordenada fim);

    public void criaMapa(int linhas, int colunas);
    
    public void finalizaMontagemTela();
    
    public void adicionaCarroMalha(Coordenada coordenada);
    
    public void movimentaCarro(Coordenada coordenadaAnterior, Coordenada coordenadaAtual);
}
