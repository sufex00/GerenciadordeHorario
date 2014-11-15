/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import banco.Conexao;
import banco.DAO.InterfaceDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.*;

/**
 *
 * @author pedro_000
 */
public class BdProfessorDAO implements InterfaceDAO<Professor>{

    @Override
    public boolean salvar(Professor objProfessor){
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
    public ArrayList<Professor> listar(){
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
    public boolean deletar(Professor obj_professor)
    {
        Conexao conexao = new Conexao();
        String sql="DELETE FROM professor WHERE cpf=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, obj_professor.getCpf());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }
    @Override
    public Professor procurar(Professor cpf) {
        ArrayList<Professor> list = this.listar();
        Professor obj_retorno = null;
        for(Professor obj_professor : list)
        {
            if(obj_professor.getCpf().equals(cpf.getCpf()))
            {
                obj_retorno = obj_professor;
            }
        }
        return obj_retorno;
    }
    public void trocar(Professor obj_professor)
    {
        Conexao conexao = new Conexao();
        String sql="UPDATE professor set nome = ?, email=?, idmateria=? WHERE cpf=?;";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, obj_professor.getNome());
            pc.setString(2, obj_professor.getEmail());     
            pc.setInt(3, obj_professor.getIdMateria());
            pc.setString(4, obj_professor.getCpf());
            pc.execute();
            conexao.getConnection().close();
        }catch(SQLException ex) {
           ex.printStackTrace();
        }
    }

}
