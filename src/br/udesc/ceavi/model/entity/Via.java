package br.udesc.ceavi.model.entity;

/**
 * Via da Malha
 * @author lucas.adriano
 */
public class Via {

    private Coordenada pontoInicial;
    private Coordenada pontoFinal;

    public Via(Coordenada pontoInicial, Coordenada pontoFinal) {
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
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
}