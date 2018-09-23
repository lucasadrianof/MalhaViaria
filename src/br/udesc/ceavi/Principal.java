package br.udesc.ceavi;

import br.udesc.ceavi.view.Tela;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
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
            
            JLabel txtQtdeVeiculos = new JLabel("Quantidade Veículos: ");
            
            JTextField campoQtdeVeiculos = new JTextField(3);
            campoQtdeVeiculos.setName("campoQtdeVeiculos");
            campoQtdeVeiculos.setText("10");
            
            JButton botaoIniciar = new JButton("Iniciar");
            botaoIniciar.setName("btnIniciar");
            
            JButton botaoEncerrar = new JButton("Encerrar");
            botaoEncerrar.setName("btnEncerrar");

            String[] opcoes = { "Semáforo", "Monitor" };

            JLabel txtEstrategia = new JLabel("Estratégia: ");
             
            JComboBox campoEstrategia = new JComboBox(opcoes);
            campoEstrategia.setName("campoEstrategia");
            
            JPanel jPanel = new JPanel();
            jPanel.add(txtQtdeVeiculos);
            jPanel.add(campoQtdeVeiculos);
            jPanel.add(txtEstrategia);
            jPanel.add(campoEstrategia);
            jPanel.add(botaoIniciar);
            jPanel.add(botaoEncerrar);
            
            frame.add(jPanel, BorderLayout.SOUTH);
            frame.add(new Tela());
        });
    }
}
