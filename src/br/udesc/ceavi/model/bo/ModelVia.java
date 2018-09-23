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
            //coordenada = getNext(coordenada, via);
        }

        coordenadas.add(via.getPontoFinal());

        return coordenadas;
    }
}
