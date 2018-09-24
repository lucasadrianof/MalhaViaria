package br.udesc.ceavi.model.entity;

/**
 * Coordenada (Composição de uma posição "X" e uma posição "Y")
 * @author lucas.adriano
 */
public class Coordenada {

    private int posicaoX;
    private int posicaoY;
    private boolean liberada = true;

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

    public boolean isLiberada() {
        return liberada;
    }

    public void setLiberada(boolean liberada) {
        this.liberada = liberada;
    }

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

    @Override
    public String toString() {
        return String.format("Coordenada: X-Y: %s-%s", this.getPosicaoX(), this.getPosicaoY());
    }
}