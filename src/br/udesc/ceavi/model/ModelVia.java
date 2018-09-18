package br.udesc.ceavi.model;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.Via;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de Regras das Vias
 * @author lucas.adriano
 */
public class ModelVia {

    public List<Coordenada> getCruzamentos(Via viaA, Via viaB) {
        return new ArrayList<>();
    }

    public List<Coordenada> getCoordenadas(Via via) {
        switch (via.getDirecao()) {
            case BAIXO_CIMA:
            case CIMA_BAIXO:
            case DIREITA_ESQUERDA:
            case ESQUERDA_DIREITA:
                break;
        }
        return new ArrayList<>();
    }
}
