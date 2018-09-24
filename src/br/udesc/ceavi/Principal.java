package br.udesc.ceavi;

import br.udesc.ceavi.view.Opcoes;
import br.udesc.ceavi.view.Tela;
import java.awt.BorderLayout;
import javax.swing.*;

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
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Malha Viária");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            frame.setVisible( true );
            frame.setSize(1000,700);
            
            Opcoes opcoes = new Opcoes();
            
            Tela tela = new Tela();
            
            tela.setViewOpcoes(opcoes);
            opcoes.setViewTela(tela);
            
            frame.add(opcoes, BorderLayout.SOUTH);
            frame.add(tela);
        });
    }
}
