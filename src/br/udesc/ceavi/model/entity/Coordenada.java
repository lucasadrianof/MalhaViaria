package br.udesc.ceavi.model.entity;

/**
 * Coordenada (Composição de uma posição "X" e uma posição "Y")
 * @author lucas.adriano
 */
public class Coordenada {

    private int posicaoX;
    private int posicaoY;

    private Veiculo veiculo;

    public Coordenada(int posicaoX, int posicaoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * Indica se a coordenada atual está liberada, ou seja, se não possui nenhum veículo
     * @return
     */
    public boolean isLiberada() {
        return veiculo == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Coordenada) {
            return ((Coordenada) obj).getPosicaoX() == this.getPosicaoX() &&
                    ((Coordenada) obj).getPosicaoY() == this.getPosicaoY();
        }
        return false;
    }
}