package br.udesc.ceavi.model.entity;

/**
 * Coordenada (Composição de uma posição "X" e uma posição "Y")
 * @author lucas.adriano
 */
public class Coordenada {

    private int posicaoX;
    private int posicaoY;

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
}