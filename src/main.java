
import negocio.facade.Individuo;
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
        Individuo pedro = new Individuo (5);
        DiaEscolar[] p = pedro.getGenes().getDiaEscolar();
        System.out.println(p[0]);
    }
    
}
