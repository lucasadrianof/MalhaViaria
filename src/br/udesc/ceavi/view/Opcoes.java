package br.udesc.ceavi.view;

import br.udesc.ceavi.model.exclusividade.TipoEstrategiaExclusividade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JComboBox campoMapa;
    private JLabel txtMapa;
    
    private final TipoEstrategiaExclusividade[] opcoesEstrategia = {TipoEstrategiaExclusividade.SEMAFORO, 
                                                                    TipoEstrategiaExclusividade.MONITOR};
    
    private final String[] opcoesMapa = {"1","2","3","4"};
    private Tela tela;

    public JTextField getCampoQtdeVeiculos() {
        return campoQtdeVeiculos;
    }

    public JButton getBotaoIniciar() {
        return botaoIniciar;
    }

    public JButton getBotaoEncerrar() {
        return botaoEncerrar;
    }

    public JComboBox getCampoEstrategia() {
        return campoEstrategia;
    }

    public JComboBox getCampoMapa() {
        return campoMapa;
    }
    
    public Opcoes(){
        adicionaCampos();
    }
    
    private void adicionaCampos(){
        txtQtdeVeiculos   = new JLabel("Quantidade Veículos: ");
        txtEstrategia     = new JLabel("Estratégia: ");
        txtMapa           = new JLabel("Mapa: ");
        campoQtdeVeiculos = new JTextField("10",3);
        campoEstrategia   = new JComboBox(opcoesEstrategia);
        campoMapa         = new JComboBox(opcoesMapa);
        botaoIniciar      = new JButton("Iniciar");
        botaoEncerrar     = new JButton("Encerrar");
        
        botaoIniciar.addActionListener((ActionEvent e) -> {
            tela.iniciaMalhaViaria();
        });
        
        botaoEncerrar.addActionListener((ActionEvent e) -> {
            tela.encerraBruscamente();
        });
        
        add(txtQtdeVeiculos);
        add(campoQtdeVeiculos);
        add(txtEstrategia);
        add(campoEstrategia);
        add(txtMapa);
        add(campoMapa);
        add(botaoIniciar);
        add(botaoEncerrar);
    }

    public void setViewTela(Tela tela) {
        this.tela = tela;
    }
}