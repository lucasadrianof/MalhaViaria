package br.udesc.ceavi.model.entity;

/**
 * Via da Malha
 * @author lucas.adriano
 */
public class Via {

    private Coordenada pontoInicial;
    private Coordenada pontoFinal;
    private DirecaoVia direcao;

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

    @Override
    public String toString() {
        String format = "Via: %s Posição Inicial: %s Posiçao Final: %s Direção: %s";
        return String.format(format, Integer.toHexString(hashCode()),
                                     this.getPontoInicial().toString(),
                                     this.getPontoFinal().toString(),
                                     this.getDirecao());
    }
}