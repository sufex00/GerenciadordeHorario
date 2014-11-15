/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

/**
 *
 * @author pedro_000
 */
public class DiaEscolar {
     
    public enum PeriodoEscolar {
        MANHA(1), TARDE(2), NOITE(3);
        private int valor;

        private PeriodoEscolar(int valor) {
                this.valor = valor;
        }
    };  

    private PeriodoEscolar horario_escolar;
    private int dia_escolar;
    private Turma classe;
    private int[] materia;
    private int numMateria;
    
    public DiaEscolar(int numMateria, PeriodoEscolar horario_escolar, int dia_escolar)
    {
        this.numMateria=numMateria;
        this.horario_escolar=horario_escolar;
        this.dia_escolar=dia_escolar;
        materia = new int [numMateria];
    }

    public void setMateria(int indice, int idMateria)
    {
        materia[indice]=idMateria;
    }
    public void setMateria(int [] materia)
    {
        this.materia=materia;
    }
    
    public int getNumMateria() {
        return numMateria;
    }

    public PeriodoEscolar getHorario_escolar() {
        return horario_escolar;
    }

    public void setHorario_escolar(PeriodoEscolar horario_escolar) {
        this.horario_escolar = horario_escolar;
    }

    public int getDia_escolar() {
        return dia_escolar;
    }

    public void setDia_escolar(int dia_escolar) {
        this.dia_escolar = dia_escolar;
    }

    public Turma getClasse() {
        return classe;
    }

    @Override
    public String toString() {
        String retorno="";
        for(int i=0 ; i<this.numMateria ; i++)
        {
            retorno = retorno + " - " + this.materia[i];
        }
        return retorno;
    }
    
    

    public void setClasse(Turma classe) {
        this.classe = classe;
    }

    public int[] getMateria() {
        return materia;
    }
    
}
