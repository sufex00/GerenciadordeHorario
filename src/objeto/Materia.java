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
public class Materia {
    
    private int id;
    private String nome;
    private String descricao;
    private int cargahoraria;
    private int idTurma;

    public Materia(int id, String nome, String descricao, int cargahoraria, int idTurma) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargahoraria = cargahoraria;
        this.idTurma=idTurma;
    }
    
    public Materia (int id)
    {
        this.id=id;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    @Override
    public String toString()
    {
        return this.getNome();
    }
    
    
    
}
