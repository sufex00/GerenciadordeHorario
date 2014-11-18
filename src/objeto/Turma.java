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
public class Turma {
    private String nome;
    private int id;
        public enum PeriodoEscolar {
        MANHA(1), TARDE(2), NOITE(3);
        private int valor;

        private PeriodoEscolar(int valor) {
                this.valor = valor;
        }
    };  

    private PeriodoEscolar horario_escolar;
    private String descricao;

    public Turma(String nome, int id, PeriodoEscolar horario, String Descricao) {
        this.nome = nome;
        this.id = id;
        this.horario_escolar=horario;
        this.descricao=Descricao;
    }
    public Turma (int id)
    {
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PeriodoEscolar getHorario_escolar() {
        return horario_escolar;
    }

    public void setHorario_escolar(PeriodoEscolar horario_escolar) {
        this.horario_escolar = horario_escolar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return  nome ;
    }
    
    
}
