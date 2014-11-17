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
public class Restricao {
    
    private int IdMateria;
    private String cpf;
    private int horario;
    private int dia;

    public Restricao(int IdMateria, String cpf, int horario, int dia) {
        this.IdMateria = IdMateria;
        this.cpf = cpf;
        this.horario = horario;
        this.dia=dia;
    }
    
    public Restricao(int IdMateria)
    {
        this.IdMateria = IdMateria;
    }

    public int getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(int IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
     
}
