package br.udesc.ceavi;

import br.udesc.ceavi.controller.ControllerImportacaoMalha;
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

public class Tela extends JPanel{
    
    private int tempPos1 = 0;
    private int tempPos2 = 0;
    
    private ArrayList<Color> cores = new ArrayList<Color>();
    
    private ControllerImportacaoMalha controllerImportacaoMalha = new ControllerImportacaoMalha();
    
    @Override
    public void paintComponent( Graphics a ){
        
        super.paintComponent(a);
        
        Graphics2D g = (Graphics2D) a.create();
        
        inicializaCores();            
            
        try {
            controllerImportacaoMalha.iniciaImportacao();
            //setaDadosMapa(g);
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            //BufferedImage image = ImageIO.read(new File(caminho+"malhas/car.png"));
            
            //BufferedImage resized = resize(image, 30, 30);
            
            //g.drawImage(resized,1*25, 6*23, null);
            //g.drawImage(resized,2*25, 6*23, null);
            
            //g.clearRect(0 * 25, 6 * 25, 7 * 25 , 6 * 25);
            g.dispose();
            
 
    }
    
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    private void drawRect(Graphics2D g, int valor1, int valor2, int valor3, int valor4){
        g.setStroke(new BasicStroke(2));
        g.drawRect(valor1 * 25, valor2 * 25, valor3 * 25, valor4 * 25);
                        
    }
    
    private void drawLine(Graphics2D g, int valor1, int valor2, int valor3, int valor4){
        if (tempPos1 != valor1 || tempPos2 != valor2) {
            g.setColor(getRandomColor());
        }
       
        g.setStroke(new BasicStroke(40));        
        g.drawLine(valor1 * 25, valor2 * 25, valor3 * 25, valor4 * 25);
        
        tempPos1 = valor3;
        tempPos2 = valor4;
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
    }
    
    private Color getRandomColor(){
        Random r = new Random();
        int pos = r.nextInt(cores.size());
        Color cor = cores.remove(pos);

        return cor;
    }
    
    private void setaDadosMapa(Graphics2D g) throws IOException {                
                                    
        //g.setColor(Color.BLACK);
        //drawRect(g, 0, 0, tamanhoHorizontal, tamanhoVertical);
        //drawLine(g, valor1, valor2, valor3, valor4);

    }    
}