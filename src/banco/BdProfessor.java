/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import objeto.*;

/**
 *
 * @author pedro_000
 */
public class BdProfessor {

    public boolean InserirCliente(Professor objProfessor){
        Conexao conexao = new Conexao();
        String sql="INSERT INTO professor (nome, cpf, email, cargahoraria, idmateria"
                + ") VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, objProfessor.getNome());
            pc.setInt(2, objProfessor.getCpf());
            pc.setString(3, objProfessor.getEmail());
            pc.setInt(4, objProfessor.getCargaHoraria());
            pc.setInt(5, objProfessor.getIdMateria());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    } 
}
