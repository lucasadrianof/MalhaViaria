package br.udesc.ceavi;

import javax.swing.JFrame;

/**
 * Classe principal da aplicação
 * @author lucas.adriano
 */
public class Principal {

    /**
     * Inicia a aplicação
     * @param args
     */
    public static void main(String[] args) {
        Tela panel  = new Tela();
        JFrame frame= new JFrame("Malha Viária");

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
        frame.setSize(1000,700);
        
        frame.add(panel);
    }
}
