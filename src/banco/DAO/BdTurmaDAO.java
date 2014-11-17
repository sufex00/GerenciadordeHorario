/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import banco.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.Materia;
import objeto.Turma;

/**
 *
 * @author pedro_000
 */
public class BdTurmaDAO implements InterfaceDAO<Turma>{

    @Override
    public boolean salvar(Turma objeto) {
        Conexao conexao = new Conexao();
        String sql="INSERT INTO turma (id, nome, descricao, horario) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, objeto.getId());
            pc.setString(2, objeto.getNome());
            pc.setString(3, objeto.getDescricao());
            pc.setString(4, objeto.getHorario_escolar().toString());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletar(Turma id) {
         Conexao conexao = new Conexao();
        String sql="DELETE FROM turma WHERE id=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, id.getId());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Turma> listar() {
        Conexao conexao = new Conexao();
        String sql="SELECT * FROM turma;";
        ArrayList<Turma> listMateria = new ArrayList<Turma>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("id");
                String nome = objResultSet.getString("nome");
                String descricao = objResultSet.getString("descricao");
                String horario = objResultSet.getString("horario");
                Turma objeto= new Turma (nome, id, Turma.PeriodoEscolar.valueOf(nome), descricao);
                listMateria.add(objeto);
            }
            conexao.getConnection().close();
            return listMateria;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Turma procurar(Turma objeto) {
        ArrayList<Turma> list = this.listar();
        Turma obj_retorno = null;
        for(Turma obj_materia : list)
        {
            if(obj_materia.getId()==objeto.getId())
            {
                obj_retorno = objeto;
            }
        }
        return obj_retorno;
    }

    @Override
    public void trocar(Turma objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
