/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.facade;

/**
 *
 * @author pedro_000
 */
import java.util.Random;
import objeto.HorarioEscolar;

public class Algoritimo {

    private static int solucao;
    private static double taxaDeCrossover = 0.6;
    private static double taxaDeMutacao = 0.3;
    
    public static Populacao novaGeracao(Populacao populacao, boolean elitismo) {
        Random r = new Random();
        //nova população do mesmo tamanho da antiga
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        //se tiver elitismo, mantém o melhor indivíduo da geração atual
        if (elitismo) {
            novaPopulacao.setIndividuo(populacao.getIndivduo(0));
        }

        //insere novos indivíduos na nova população, até atingir o tamanho máximo
        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
            //seleciona os 2 pais por torneio
            Individuo[] pais = selecaoTorneio(populacao);

            Individuo[] filhos = new Individuo[2];

            //verifica a taxa de crossover, se sim realiza o crossover, se não, mantém os pais selecionados para a próxima geração
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = crossover(pais[1], pais[0]);
            } else {
                filhos[0] = new Individuo(pais[0].getGenes());
                filhos[1] = new Individuo(pais[1].getGenes());
            }

            //adiciona os filhos na nova geração
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }

        //ordena a nova população
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }

    public static Individuo[] crossover(Individuo individuo1, Individuo individuo2) {
        Random r = new Random();

        //sorteia o ponto de corte
        int pontoCorte1 = r.nextInt((individuo1.getGenes().getNum()/2) -1) + 1;
        int pontoCorte2 = r.nextInt((individuo1.getGenes().getNum()/2) -1) + individuo1.getGenes().getNum()/2;

        Individuo[] filhos = new Individuo[2];

        //pega os genes dos pais
        HorarioEscolar genePai1 = individuo1.getGenes();
        HorarioEscolar genePai2 = individuo2.getGenes();

        HorarioEscolar geneFilho1 = new HorarioEscolar(genePai1.getNum());
        HorarioEscolar geneFilho2 = new HorarioEscolar(genePai2.getNum());

        //realiza o corte, 
        for(int i=0 ; i <pontoCorte1 ; i++)
        {
            geneFilho1.setDiaEscolar(i, genePai1.getDiaEscolar(i));
        }
        for(int i=pontoCorte1 ; i<pontoCorte2 ; i++)
        {
            geneFilho1.setDiaEscolar(i, genePai2.getDiaEscolar(i));
        }
        for(int i=pontoCorte2 ; i<genePai1.getNum() ; i++)
        {
            geneFilho1.setDiaEscolar(i, genePai1.getDiaEscolar(i));
        }
        
        for(int i=0 ; i <pontoCorte1 ; i++)
        {
            geneFilho2.setDiaEscolar(i, genePai2.getDiaEscolar(i));
        }
        for(int i=pontoCorte1 ; i<pontoCorte2 ; i++)
        {
            geneFilho2.setDiaEscolar(i, genePai1.getDiaEscolar(i));
        }
        for(int i=pontoCorte2 ; i<genePai1.getNum() ; i++)
        {
            geneFilho2.setDiaEscolar(i, genePai2.getDiaEscolar(i));
        }
        //cria o novo indivíduo com os genes dos pais
        filhos[0] = new Individuo(geneFilho1);
        filhos[1] = new Individuo(geneFilho2);

        return filhos;
    }
    
    public static Individuo[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(3);

        //seleciona 3 indivíduos aleatóriamente na população
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));

        //ordena a população
        populacaoIntermediaria.ordenaPopulacao();

        Individuo[] pais = new Individuo[2];

        //seleciona os 2 melhores deste população
        pais[0] = populacaoIntermediaria.getIndivduo(0);
        pais[1] = populacaoIntermediaria.getIndivduo(1);

        return pais;
    }
    
    public static int getSolucao() {
        return solucao;
    }

    public static void setSolucao(int solucao) {
        Algoritimo.solucao = solucao;
    }

    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }
    
    public static void setTaxaDeCrossover(double taxaDeCrossover) {
        Algoritimo.taxaDeCrossover = taxaDeCrossover;
    }

    static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }
   
    public static void setTaxaDeMutacao(double taxaDeMutacao) {
        Algoritimo.taxaDeMutacao = taxaDeMutacao;
    }
}
