package br.udesc.ceavi.controller;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Via;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Controller de Importação da Malha Viária
 * @author lucas.adriano
 */
public class ControllerImportacaoMalha {
    
    private MalhaViaria malhaViaria;
        
    private final String caminho = "/Users/jessicapeixe/NetBeansProjects/MalhaViaria/";
    
    public void iniciaImportacao() throws IOException {
        
        String arquivo = caminho+"malhas/malha-exemplo-"+getCodigoArquivo()+".txt";
        
        int iCont = 0;
        
        try (FileReader arq = new FileReader(arquivo)) {
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            
            int linhas  = 0;
            int colunas = 0;

            while (linha != null) {
                iCont++;

                switch (iCont) {
                    case 1:
                        linhas = Integer.parseInt(linha.split("\t")[0]);
                        break;
                    case 2:
                        colunas = Integer.parseInt(linha.split("\t")[0]);
                        break;
                    default:
                        criaMalhaViaria(linhas, colunas);
                        
                        String[] dados = linha.split("\t");
                        
                        adicionaVia(
                            Integer.parseInt(dados[0]),
                            Integer.parseInt(dados[1]),
                            Integer.parseInt(dados[2]),
                            Integer.parseInt(dados[0])
                        );
                }
                
                linha = lerArq.readLine();
            }
        } 
        catch (FileNotFoundException ex) {}
    }
    
    private void criaMalhaViaria(int linhas, int colunas){
        if (malhaViaria == null) {
            malhaViaria = new MalhaViaria(linhas, colunas);
        }                
    }
    
    private void adicionaVia(int valor1, int valor2, int valor3, int valor4){
        
        Coordenada pontoInicial = new Coordenada(valor1, valor2);
        Coordenada pontoFinal = new Coordenada(valor3, valor4);

        Via via = new Via(pontoInicial, pontoFinal);

        malhaViaria.adicionaVia(via);
    }

    private int getCodigoArquivo(){
        Random r = new Random();
        int pos = 0;
        while(pos == 0){
            pos = r.nextInt(3);
        }
        return pos;
    }
}
