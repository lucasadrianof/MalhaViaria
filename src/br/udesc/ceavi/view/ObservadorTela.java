package br.udesc.ceavi.view;

import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;

/**
 *
 * @author jessicapeixe
 */
public interface ObservadorTela {
    
    public void criaVia(Via via);

    public void criaMapa(MalhaViaria malhaViaria);
    
    public void adicionaCarroMalha(Veiculo veiculo);
    
    public void movimentaCarro(Veiculo veiculo);

    public void removeCarro(Veiculo veiculo);
}
