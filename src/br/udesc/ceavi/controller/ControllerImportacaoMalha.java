package br.udesc.ceavi.controller;

import br.udesc.ceavi.model.entity.Coordenada;
import br.udesc.ceavi.model.entity.MalhaViaria;
import br.udesc.ceavi.model.entity.Via;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Controller de Importação da Malha Viária
 * @author lucas.adriano
 */
public class ControllerImportacaoMalha {
    
    private MalhaViaria malhaViaria;

    private HashMap<Pair<Integer, Integer>, Coordenada> coordenadas = new HashMap<>();
    private final String caminho = System.getProperty("user.dir") + "/";
    
    public void iniciaImportacao(int mapa) throws IOException {
        
        String arquivo = caminho+"malhas/malha-exemplo-"+mapa+".txt";
        
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
                            Integer.parseInt(dados[3])
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
        Coordenada pontoInicial = getCoordenada(valor1, valor2);
        Coordenada pontoFinal = getCoordenada(valor3, valor4);

        Via via = new Via(pontoInicial, pontoFinal);

        malhaViaria.adicionaVia(via);
    }

    /**
     * Retorna a coordenada informada, validando se a mesma já existe
     * @param posicaoX
     * @param posicaoY
     * @return
     */
    private Coordenada getCoordenada(int posicaoX, int posicaoY) {
        Pair pair = new Pair(posicaoX, posicaoY);
        Coordenada coordenada = coordenadas.get(pair);

        if (coordenada == null) {
            coordenada = new Coordenada(posicaoX, posicaoY);
            coordenadas.put(pair, coordenada);
        }

        return coordenada;
    }
    
    public MalhaViaria getMalhaViaria(){
        return this.malhaViaria;
    }
}
