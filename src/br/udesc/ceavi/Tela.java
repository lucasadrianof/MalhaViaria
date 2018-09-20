package br.udesc.ceavi;

import br.udesc.ceavi.controller.ControllerMalhaViaria;
import br.udesc.ceavi.model.entity.Coordenada;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Tela extends JPanel implements ObservadorTela {
    
    private int tempPos = 0;
    
    private ArrayList<Color> cores = new ArrayList<Color>();
    
    private Graphics2D g;
    
    private ControllerMalhaViaria controllerMalhaViaria;

    @Override
    public void paintComponent( Graphics a ){
        
        super.paintComponent(a);
        
        g = (Graphics2D) a.create();
        
        inicializaCores();
        
        try {
            controllerMalhaViaria = new ControllerMalhaViaria();
            controllerMalhaViaria.adicionaObservador(this);
            controllerMalhaViaria.iniciaMalhaViaria();
            
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //BufferedImage image = ImageIO.read(new File(caminho+"malhas/car.png"));

        //BufferedImage resized = resize(image, 30, 30);

        //g.drawImage(resized,1*25, 6*23, null);
        //g.drawImage(resized,2*25, 6*23, null);

        //g.clearRect(0 * 25, 6 * 25, 7 * 25 , 6 * 25);
        
    }
    
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    private void inicializaCores(){
        cores.add(Color.yellow);
        cores.add(Color.red);
        cores.add(Color.blue);
        cores.add(Color.orange);
        cores.add(Color.pink);
        cores.add(Color.magenta);
        cores.add(Color.cyan);
        cores.add(Color.gray);
        cores.add(Color.lightGray);
        cores.add(Color.darkGray);
    }
    
    private Color getRandomColor(){
        Random r = new Random();
        int pos = r.nextInt(cores.size());
        Color cor = cores.remove(pos);

        if (cores.size() == 0) {
            inicializaCores();
        }
        return cor;
    } 

    @Override
    public void criaVia(Coordenada inicio, Coordenada fim) {
        g.setColor(Color.gray);
        g.setStroke(new BasicStroke(30)); 
        g.drawLine(inicio.getPosicaoX() * 25, inicio.getPosicaoY() * 25, fim.getPosicaoX() * 25, fim.getPosicaoY() * 25);
    }

    @Override
    public void criaMapa(int linhas, int colunas) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawRect(0, 0, colunas * 25, linhas * 25);
    }

    @Override
    public void finalizaMontagemTela() {
        g.dispose();
    }
}