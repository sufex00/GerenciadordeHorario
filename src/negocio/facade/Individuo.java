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
import banco.FactoryMetody.FactoryBdProfessor;
import banco.FactoryMetody.FactoryBdResticao;
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
           
        DiaEscolar diaEscolar = new DiaEscolar(numGenes, dia);
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
        //System.out.println(diaEscolar);
        }
                
        geraAptidao();        
    }

    //cria um indivíduo com os genes definidos
    public Individuo(HorarioEscolar genes) {    
        this.genes = genes;
        
        Random r = new Random();
        //se for mutar, cria um gene aleatório
        //if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
            if(true){
            ArrayList<Integer> materias = new ArrayList<Integer>();
            HorarioEscolar geneNovo = new HorarioEscolar(this.genes.getNum());
            int posAleatoria = r.nextInt(genes.getNum());
            for (int i = 0; i < genes.getNum(); i++) {
                if (i==posAleatoria)
                {
                    DiaEscolar novo_dia = this.genes.getDiaEscolar(i);
                    for(int y=0 ; y<novo_dia.getNumMateria();y++)
                    {
                        materias.add(novo_dia.getMateria(y));
                    }
                    for(int a=0 ; a<materias.size();a++)
                    {
                        for(int b=0;b<materias.size();b++)
                        {
                            if(materias.get(a)<materias.get(b))
                            {
                                int temp = materias.get(a);
                                materias.set(a, materias.get(b));
                                materias.set(b, temp);
                            }
                        }
                    }
                    for(int y=0 ; y<materias.size();y++)
                    {
                        //System.out.println(materias.get(y));
                        novo_dia.setMateria(y, materias.get(y));
                    }
                    geneNovo.setDiaEscolar(i, novo_dia);
                }
                else{
                    geneNovo.setDiaEscolar(i, genes.getDiaEscolar(i));
                }
                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }

    //gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
        
        int materia;
        int aptidao=genes.getNum()*5;
        FactoryMetody BdFactory = new FactoryBdProfessor();
        InterfaceDAO objBd = BdFactory.criar_DAO_BD();
        ArrayList<Professor> list = objBd.listar();
        for(int dia=2 ; dia<7 ; dia++)
        {
            BdFactory = new FactoryBdResticao();
            objBd = BdFactory.criar_DAO_BD();
            ArrayList<Restricao> lista = objBd.listar();
            for(int i=0 ; i<genes.getNum() ; i++)
            {
                for(Restricao objRestricao : lista)
                {
                    if(objRestricao.getIdMateria() == genes.getDiaEscolar(dia-2).getMateria(i))
                    {
                        if(objRestricao.getDia() == dia)
                        {
                            
                            if(objRestricao.getHorario() == i)
                            {
                                aptidao--;
                            }
                        }
                    }
                }
                
            }
            
        }
        this.aptidao=aptidao;
        
    }

    public int getAptidao() {
        return aptidao;
    }

    public HorarioEscolar getGenes() {
        return genes;
    }
}
