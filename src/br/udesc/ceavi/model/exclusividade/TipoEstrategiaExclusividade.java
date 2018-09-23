package br.udesc.ceavi.model.exclusividade;

/**
 * Tipos de estratégia de exclusividade
 * @author lucas.adriano
 */
public enum TipoEstrategiaExclusividade {

    SEMAFORO(1), MONITOR(2);

    private int tipoEstrategia;

    TipoEstrategiaExclusividade(int tipoEstrategia) {
        this.tipoEstrategia = tipoEstrategia;
    }
}