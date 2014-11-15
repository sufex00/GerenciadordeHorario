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


import java.util.ArrayList;
import java.util.Random;
import objeto.*;
import banco.*;
import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryBdMateria;
import banco.FactoryMetody.FactoryMetody;

public class Individuo {

    private HorarioEscolar genes ;
    private int aptidao = 0;
    
    private FactoryMetody BdBanco = new FactoryBdMateria();
    private InterfaceDAO objBdBanco = BdBanco.criar_DAO_BD();

    //gera um indivíduo aleatório
    public Individuo(int numGenes) {
        genes = new HorarioEscolar(numGenes);
        Random r = new Random();
        ArrayList<Materia> materias = objBdBanco.listar();
        
        for(int dia=2 ; dia<7 ; dia++)
        {
           
        DiaEscolar diaEscolar = new DiaEscolar(numGenes, DiaEscolar.PeriodoEscolar.MANHA, dia);
        for(int i = 0 ; i < numGenes ; i++)
        {
            int idMateria=r.nextInt(materias.size());
            Materia materia=materias.get(idMateria);
            if(i<numGenes-1)
            {
                if(materia.getCargahoraria()==2)
                {
                    diaEscolar.setMateria(i, materia.getId());
                    diaEscolar.setMateria(i+1, materia.getId());
                    materia.setCargahoraria(materia.getCargahoraria()-2);
                    i++;
                }
                else
                {
                    diaEscolar.setMateria(i, materia.getId());
                    materias.get(idMateria).setCargahoraria(materia.getCargahoraria()-1);
                }
            }else
            {
                diaEscolar.setMateria(i, materia.getId());
                materias.get(idMateria).setCargahoraria(materia.getCargahoraria()-1);
            }
            ArrayList<Materia> remove = new ArrayList<Materia>();
            for(Materia obj_materia: materias)
            {
                if(obj_materia.getCargahoraria()==0)
                {
                    remove.add(obj_materia);
                    
                }
            }
            materias.removeAll(remove);
            remove.clear();
        }
        this.genes.setDiaEscolar(dia-2, diaEscolar);
        }
                
        geraAptidao();        
    }

    //cria um indivíduo com os genes definidos
//    public Individuo(HorarioEscolar genes) {    
//        this.genes = genes;
//        
//        Random r = new Random();
//        //se for mutar, cria um gene aleatório
//        if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
//            ArrayList<Materia> materias = objBdBanco.listar();
//            String geneNovo="";
//            int posAleatoria = r.nextInt(genes.length());
//            for (int i = 0; i < genes.length(); i++) {
//                if (i==posAleatoria){
//                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
//                }else{
//                    geneNovo += genes.charAt(i);
//                }
//                
//            }
//            this.genes = geneNovo;   
//        }
//        geraAptidao();
//    }

    //gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
        String solucao = Algoritimo.getSolucao();
//        for (int i = 0; i < solucao.length(); i++) {
//            if (solucao.charAt(i) == genes.charAt(i)) {
//                aptidao++;
//            }
//        }
        
    }

    public int getAptidao() {
        return aptidao;
    }

    public HorarioEscolar getGenes() {
        return genes;
    }
}
