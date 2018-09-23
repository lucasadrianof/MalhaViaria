package br.udesc.ceavi.view;

import br.udesc.ceavi.controller.ControllerMalhaViaria;
import br.udesc.ceavi.model.entity.DirecaoVia;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Veiculo;
import br.udesc.ceavi.model.entity.Via;
import br.udesc.ceavi.model.exclusividade.TipoEstrategiaExclusividade;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Tela extends JPanel implements ObservadorTela {
    
    private Graphics2D g;

    private MalhaViaria malhaViaria;
    private ControllerMalhaViaria controllerMalhaViaria;

    private List<Via> vias = new ArrayList<>();
    private List<Veiculo> carros = Collections.synchronizedList(new ArrayList<>());
    private final String caminho =  System.getProperty("user.dir") + "/";
    
    private Opcoes opcoes;

    public Tela(Opcoes opcoes) {
        controllerMalhaViaria = new ControllerMalhaViaria();
        controllerMalhaViaria.adicionaObservador(this);
        try {
            controllerMalhaViaria.iniciaMalhaViaria();
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciaMalhaViaria(){
        int qtde = Integer.parseInt(opcoes.getCampoQtdeVeiculos().getText());
        int mapa = Integer.parseInt(opcoes.getCampoMapa().getSelectedItem().toString());
        TipoEstrategiaExclusividade estrategia = (TipoEstrategiaExclusividade)opcoes.getCampoEstrategia().getSelectedItem();
        
        try {
            controllerMalhaViaria.iniciaMalhaViaria();
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public synchronized void paintComponent(Graphics a) {
        super.paintComponent(a);
        g = (Graphics2D) a.create();

        desenhaVia();
        desenhaMalhaViaria();
        desenhaCarros();
    }
    
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    private BufferedImage getCarro(Veiculo veiculo) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(caminho + "malhas/"+getImagemCarro(veiculo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resize(image, 30, 30);
    }
    
    private String getImagemCarro(Veiculo veiculo){
        DirecaoVia direcao = veiculo.getVia().getDirecao();
        
        if (direcao == DirecaoVia.CIMA_BAIXO) {
            return "car_down.png";
        }
        if (direcao == DirecaoVia.BAIXO_CIMA) {
            return "car_up.png";
        }
        if (direcao == DirecaoVia.ESQUERDA_DIREITA) {
            return "car_left.png";
        }
        return "car_rigth.png";
    }
    
    @Override
    public void criaVia(Via via) {
        vias.add(via);
    }

    /**
     * Desenha a via na tela
     */
    private void desenhaVia() {
        g.setColor(Color.gray);
        g.setStroke(new BasicStroke(30));

        vias.forEach((via) -> {
            g.drawLine(via.getPontoInicial().getPosicaoX() * 25,
                       via.getPontoInicial().getPosicaoY() * 25,
                       via.getPontoFinal().getPosicaoX() * 25,
                       via.getPontoFinal().getPosicaoY() * 25
            );
        });
    }

    @Override
    public void criaMapa(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    private void desenhaMalhaViaria() {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawRect(0, 0, malhaViaria.getColunas() * 25, malhaViaria.getLinhas() * 25);
    }

    @Override
    public void adicionaCarroMalha(Veiculo veiculo) {
        carros.add(veiculo);
        repaint();

    }

    private synchronized void desenhaCarros() {
        synchronized (this.carros) {
            carros.forEach((veiculo) -> {
                g.drawImage(
                    getCarro(veiculo),
                    veiculo.getCoordenada().getPosicaoX() * 25, 
                    veiculo.getCoordenada().getPosicaoY() * 23, 
                    null
                );
            });
        }
    }
    
    @Override
    public void movimentaCarro(Veiculo veiculo) {
        carros.remove(veiculo);
        carros.add(veiculo);
        repaint();
    }
}