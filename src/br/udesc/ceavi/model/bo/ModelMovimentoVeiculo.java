package br.udesc.ceavi.model.bo;

import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de regras de movimentação do veículo
 * @author lucas.adriano
 */
public class ModelMovimentoVeiculo {

    private Via via;
    private Veiculo veiculo;
    private MalhaViaria malhaViaria;

    public ModelMovimentoVeiculo(Via via, Veiculo veiculo, MalhaViaria malhaViaria) {
        this.via = via;
        this.veiculo = veiculo;
        this.malhaViaria = malhaViaria;
    }

    /**
     * Retorna a próxima coordenada para o veículo se mover, ou null caso ele tenha chegado ao final da malha
     * @return A próxima coordenada da posição
     */
    public Coordenada getProximaPosicao() {
        return null;
    }

    /**
     * Retorna as próximas vias disponíveis para o veículo se movimentar
     * @return
     */
    public List<Via> getProximasVias() {
        List<Via> vias = new ArrayList<>();

        for (Via via : malhaViaria.getVias()) {
            if (this.via.getPontoFinal().equals(via.getPontoInicial())) {
                vias.add(via);
            }
        }

        return vias;
    }

    /**
     * Retorna a próxima coordenada, baseado na direção da via
     * @param coordenada Coordenada atual
     * @param via Via
     * @return Próxima coordenada, ou null quando chegou ao final da via
     */
    public Coordenada getNext(Coordenada coordenada, Via via) {
        int x = -1, y  = -1;

        switch (via.getDirecao()) {
            case ESQUERDA_DIREITA:
                if (coordenada.getPosicaoY() < via.getPontoFinal().getPosicaoY()) {
                    x = coordenada.getPosicaoX();
                    y = coordenada.getPosicaoY() + 1;
                }
                break;

            case DIREITA_ESQUERDA:
                if (coordenada.getPosicaoY() > via.getPontoFinal().getPosicaoY()) {
                    x = coordenada.getPosicaoX();
                    y = coordenada.getPosicaoY() - 1;
                }
                break;

            case CIMA_BAIXO:
                if (coordenada.getPosicaoX() < via.getPontoFinal().getPosicaoX()) {
                    x = coordenada.getPosicaoX() + 1;
                    y = coordenada.getPosicaoY();
                }
                break;

            default:
                if (coordenada.getPosicaoX() > via.getPontoFinal().getPosicaoX()) {
                    x = coordenada.getPosicaoX() - 1;
                    y = coordenada.getPosicaoY();
                }
                break;
        }

        if (x >= 0 && y >= 0) {
            return new Coordenada(x, y);
        }
        return null;
    }
}
