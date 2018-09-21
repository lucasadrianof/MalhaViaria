package br.udesc.ceavi.model.bo;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Via;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de Regras das Vias (Business Object)
 * @author lucas.adriano
 */
public class ModelVia {

    public Coordenada getCruzamentos(Via viaA, Via viaB) {

        return null;
    }

    /**
     * Retorna uma lista com todas as coordenadas da via
     * @param via
     * @return Lista com todas as coordenadas da via
     */
    public List<Coordenada> getCoordenadas(Via via) {
        List<Coordenada> coordenadas = new ArrayList<>();
        Coordenada coordenada        = via.getPontoInicial();

        while (coordenada != null) {
            coordenadas.add(coordenada);
            coordenada = getNext(coordenada, via);
        }

        coordenadas.add(via.getPontoFinal());

        return coordenadas;
    }

    /**
     * Retorna a próxima coordenada, baseado na direção da via
     * @param coordenada Coordenada atual
     * @param via Via
     * @return Próxima coordenada, ou null quando chegou ao final da via
     */
    private Coordenada getNext(Coordenada coordenada, Via via) {
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

            case BAIXO_CIMA:
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
