package br.udesc.ceavi.model.entity;

import br.udesc.ceavi.model.entity.Observador.ObservadorVia;

import java.util.ArrayList;
import java.util.List;

/**
 * Via da Malha
 * @author lucas.adriano
 */
public class Via {

    private Coordenada pontoInicial;
    private Coordenada pontoFinal;
    private DirecaoVia direcao;

    private List<Veiculo> veiculos = new ArrayList<>();
    private List<ObservadorVia> observadores = new ArrayList<>();

    public Via(Coordenada pontoInicial, Coordenada pontoFinal) {
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.setDirecao(descobreDirecao());
    }

    public Coordenada getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(Coordenada pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public Coordenada getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Coordenada pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public DirecaoVia getDirecao() {
        return direcao;
    }

    public void setDirecao(DirecaoVia direcao) {
        this.direcao = direcao;
    }

    /**
     * Adiciona um observador à via
     * @param observadorVia
     */
    public void adicionaObservador(ObservadorVia observadorVia) {
        observadores.add(observadorVia);
    }

    /**
     * Adiciona um veículo a via
     * @param veiculo
     */
    public void adicionaVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        observadores.forEach((observador) -> observador.veiculoAdicionado(this, veiculo));
    }

    /**
     * Remove um veículo da via
     * @param veiculo
     * @return True indicando caso o veículo estava na via e foi removido, false caso contrário
     */
    public boolean removeVeiculo(Veiculo veiculo) {
        return veiculos.remove(veiculo);
    }

    /**
     * Descobre a direção da via baseado em suas coordenadas
     * @return A direção da via
     */
    private DirecaoVia descobreDirecao() {
        //Se a via é vertical
        if (pontoInicial.getPosicaoX() == pontoFinal.getPosicaoX()) {
            if (pontoInicial.getPosicaoY() < pontoFinal.getPosicaoY()) {
                return DirecaoVia.CIMA_BAIXO;
            }
            return DirecaoVia.BAIXO_CIMA;
        }
        else { //horizontal
            if (pontoInicial.getPosicaoX() < pontoFinal.getPosicaoX()) {
                return DirecaoVia.ESQUERDA_DIREITA;
            }
            return DirecaoVia.DIREITA_ESQUERDA;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Via) {
            return ((Via) obj).getPontoInicial().equals(this.getPontoInicial()) &&
                    ((Via) obj).getPontoFinal().equals(this.getPontoFinal());
        }
        return false;
    }
}