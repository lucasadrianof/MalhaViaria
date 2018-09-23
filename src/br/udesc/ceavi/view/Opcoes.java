package br.udesc.ceavi.view;

import br.udesc.ceavi.model.exclusividade.TipoEstrategiaExclusividade;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jessicapeixe
 */
public class Opcoes extends JPanel{
    
    private JLabel txtQtdeVeiculos;
    private JTextField campoQtdeVeiculos;
    private JButton botaoIniciar;
    private JButton botaoEncerrar;
    private JLabel txtEstrategia;
    private JComboBox campoEstrategia;
    
    private final TipoEstrategiaExclusividade[] opcoes = {TipoEstrategiaExclusividade.SEMAFORO, 
                                                          TipoEstrategiaExclusividade.MONITOR};
    
    public Opcoes(){
        adcionaCampos();
    }
    
    private void adcionaCampos(){
        txtQtdeVeiculos = new JLabel("Quantidade Veículos: ");
            
        campoQtdeVeiculos = new JTextField(3);
        campoQtdeVeiculos.setName("campoQtdeVeiculos");
        campoQtdeVeiculos.setText("10");

        botaoIniciar = new JButton("Iniciar");
        botaoIniciar.setName("btnIniciar");

        botaoEncerrar = new JButton("Encerrar");
        botaoEncerrar.setName("btnEncerrar");

        txtEstrategia = new JLabel("Estratégia: ");

        campoEstrategia = new JComboBox(opcoes);
        campoEstrategia.setName("campoEstrategia");
        
        add(txtQtdeVeiculos);
        add(campoQtdeVeiculos);
        add(txtEstrategia);
        add(campoEstrategia);
        add(botaoIniciar);
        add(botaoEncerrar);
    }
}