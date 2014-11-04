/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.*;

/**
 *
 * @author pedro_000
 */
public class BdProfessor {

    public boolean InserirProfessor(Professor objProfessor){
        Conexao conexao = new Conexao();
        String sql="INSERT INTO professor (nome, cpf, email,  idmateria"
                + ") VALUES (?, ?, ?,  ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, objProfessor.getNome());
            pc.setString(2, objProfessor.getCpf());
            pc.setString(3, objProfessor.getEmail());
            pc.setInt(4, objProfessor.getIdMateria());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<Professor> SelecionarListProfessor(){
        Conexao conexao = new Conexao();
        String sql="SELECT * FROM professor;";
        ArrayList<Professor> listProfessor = new ArrayList<>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                String cpf = objResultSet.getString("cpf");
                String nome = objResultSet.getString("nome");
                String email = objResultSet.getString("email");
                int idMateria = objResultSet.getInt("idmateria");
                Professor objProfessor = new Professor(nome, email, cpf, idMateria);
                listProfessor.add(objProfessor);
            }
            conexao.getConnection().close();
            return listProfessor;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }
    public boolean Excluir(String Cpf)
    {
        Conexao conexao = new Conexao();
        String sql="DELETE FROM professor WHERE cpf=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, Cpf);
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }
}
