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
public class Professor {
    
    private String nome;
    private String email;
    private String cpf;
    private int idMateria;

    public Professor(String nome, String email, String cpf, int idMateria) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idMateria = idMateria;
    }
    public Professor (String cpf)
    {
        this.cpf=cpf;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

     public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    
}