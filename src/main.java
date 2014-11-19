import negocio.facade.Algoritimo;
import negocio.facade.Individuo;
import negocio.facade.Populacao;
import objeto.DiaEscolar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro_000
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
         */

            //Define a solução
            Algoritimo.setSolucao(25);

            //taxa de crossover de 60%
            Algoritimo.setTaxaDeCrossover(0.6);
            //taxa de mutação de 3%
            Algoritimo.setTaxaDeMutacao(0.3);
            //elitismo
            boolean eltismo = true;
            //tamanho da população
            int tamPop = 30;
            //numero máximo de gerações
            int numMaxGeracoes = 10000;

            //define o número de genes do indivíduo baseado na solução
            int numGenes = 5;

            //cria a primeira população aleatérioa
            Populacao populacao = new Populacao(numGenes, tamPop);

            boolean temSolucao = false;
            int geracao = 0;

            System.out.println("Iniciando... Aptidão da solução: " + Algoritimo.getSolucao());

            //loop até o critério de parada
            while (!temSolucao && geracao < numMaxGeracoes) {
                geracao++;

                //cria nova populacao
                populacao = Algoritimo.novaGeracao(populacao, eltismo);

                System.out.println("Geração " + geracao + " | Aptidão: " + populacao.getIndivduo(0).getAptidao() + " | Melhor: " + populacao.getIndivduo(0).getGenes());

                //verifica se tem a solucao
                temSolucao = populacao.temSolocao(Algoritimo.getSolucao());
            }

            if (geracao == numMaxGeracoes) {
                System.out.println("Número Maximo de Gerações | " + populacao.getIndivduo(0).getGenes() + " " + populacao.getIndivduo(0).getAptidao());
            }

            if (temSolucao) {
                System.out.println("Encontrado resultado na geração " + geracao + " | " + populacao.getIndivduo(0).getGenes() + " (Aptidão: " + populacao.getIndivduo(0).getAptidao() + ")");
            }
        }
    }