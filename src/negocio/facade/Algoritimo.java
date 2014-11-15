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

public class Algoritimo {

    private static String solucao;
    private static double taxaDeCrossover = 0.6;
    private static double taxaDeMutacao = 0.3;
    private static String caracteres;

    public static String getSolucao() {
        return solucao;
    }

    public static void setSolucao(String solucao) {
        Algoritimo.solucao = solucao;
    }

    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }

    static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }
    
}
